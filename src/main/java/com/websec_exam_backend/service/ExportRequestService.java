package com.websec_exam_backend.service;

import com.websec_exam_backend.dto.ExportNotesDTO;
import com.websec_exam_backend.dto.ExportRequestDTO;
import com.websec_exam_backend.model.Employee;
import com.websec_exam_backend.model.ExportNotes;
import com.websec_exam_backend.model.ExportRequest;
import com.websec_exam_backend.model.User;
import com.websec_exam_backend.repository.ExportNotesRepository;
import com.websec_exam_backend.repository.ExportRequestRepository;
import com.websec_exam_backend.repository.UserRepository;
import com.websec_exam_backend.security.JwtAuthenticationFilter;
import com.websec_exam_backend.security.JwtTokenProvider;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.UUID;

@Service
public class ExportRequestService {

    private final ExportRequestRepository exportRequestRepository;
    private final ExportNotesRepository exportNotesRepository;
    private final UserRepository userRepository;
    private final ExportService exportService;
    private final EmployeeService employeeService;
    private final JwtTokenProvider jwtTokenProvider;
    private final JwtAuthenticationFilter jwtAuthenticationFilter;


    public ExportRequestService(ExportRequestRepository exportRequestRepository, ExportNotesRepository exportNotesRepository, UserRepository userRepository, ExportService exportService, EmployeeService employeeService, JwtTokenProvider jwtTokenProvider, JwtAuthenticationFilter jwtAuthenticationFilter) {
        this.exportRequestRepository = exportRequestRepository;
        this.exportNotesRepository = exportNotesRepository;
        this.userRepository = userRepository;
        this.exportService = exportService;
        this.employeeService = employeeService;
        this.jwtTokenProvider = jwtTokenProvider;
        this.jwtAuthenticationFilter = jwtAuthenticationFilter;
    }

    public ExportRequestDTO[] getAllExportRequests() {
        return exportRequestRepository.findAll().stream()
                .map(this::toDTO)
                .toArray(ExportRequestDTO[]::new);
    }

    public ExportNotesDTO[] getAllExportNotes(HttpServletRequest request) {
        String token = jwtAuthenticationFilter.getTokenFromRequest(request);
        User user = userRepository.findByUsername(jwtTokenProvider.getUsername(token))
                .orElseThrow(() -> new IllegalArgumentException("User from token not found"));
        if(Objects.equals(user.getRole().getRoleName(), "ROLE_ADMIN")){
            return exportNotesRepository.findAll().stream()
                    .map(this::toDTO)
                    .toArray(ExportNotesDTO[]::new);
        } else {
            return exportNotesRepository.findAll().stream()
                    .filter(note -> {
                        if(user.getEmployee() != null) {
                           return !note.getIsHidden() || note.getEmployee().getId().equals(user.getEmployee().getId());
                        }
                        return !note.getIsHidden();
                    })
                    .map(this::toDTO)
                    .toArray(ExportNotesDTO[]::new);
        }
    }

    public ExportNotesDTO[] getAllExportNotesFromRequestId(UUID exportRequestId, HttpServletRequest request) {
        String token = jwtAuthenticationFilter.getTokenFromRequest(request);
        if (token == null || !jwtTokenProvider.validateToken(token)) {
            request.setAttribute("error", "Invalid Token");
        }
        User user = userRepository.findByUsername(jwtTokenProvider.getUsername(token))
                .orElseThrow(() -> new IllegalArgumentException("User from token not found"));
        if(Objects.equals(user.getRole().getRoleName(), "ROLE_ADMIN")){
            return exportNotesRepository.findAll().stream()
                    .filter(note -> note.getExportRequest().getId().equals(exportRequestId))
                    .map(this::toDTO)
                    .toArray(ExportNotesDTO[]::new);
        } else {
            return exportNotesRepository.findAll().stream()
                    .filter(note -> note.getExportRequest().getId().equals(exportRequestId))
                    .filter(note -> {
                        if(user.getEmployee() != null) {
                            return !note.getIsHidden() || note.getEmployee().getId().equals(user.getEmployee().getId());
                        }
                        return !note.getIsHidden();
                    })
                    .map(this::toDTO)
                    .toArray(ExportNotesDTO[]::new);
        }
    }

    public byte[] handleExportRequest(ExportRequestDTO exportRequestDTO) {
        ExportRequest exportRequestFromDto = fromDTO(exportRequestDTO);
        exportRequestFromDto.setStatus("PENDING"); // Overvej om det skal være enum
        //Håndter fejl ved tom selectedEntities (og opdater test)
        if (exportRequestFromDto.getSelectedEntities() == null || exportRequestFromDto.getSelectedEntities().isEmpty()) {
            throw new IllegalArgumentException("Selected entities cannot be null or empty");
        } else {
            exportRequestFromDto.setId(UUID.randomUUID());
            exportRequestRepository.save(exportRequestFromDto);

            byte[] exportOutput = exportService.processExportRequest(exportRequestFromDto);

           if(exportOutput != null && exportOutput.length > 0) {
               String fileSize = String.valueOf(exportOutput.length);
               exportRequestFromDto.setFileSize(fileSize);
                exportRequestFromDto.setStatus("COMPLETED");
               exportRequestRepository.save(exportRequestFromDto); //Muligvis forbedre opdatering af felt

               return exportOutput;
           }
              else {
                exportRequestFromDto.setStatus("FAILED");
                exportRequestRepository.save(exportRequestFromDto);
                throw new RuntimeException("Export failed");
              }
        }
    }

    public UUID createExportRequestNotes(ExportNotesDTO exportNotesDTO) {
        ExportNotes notes = fromDTO(exportNotesDTO);
        notes.setId(UUID.randomUUID());
        notes.setIsHidden(false);
        exportNotesRepository.save(notes);
        return notes.getId();
    }

    public Boolean setNoteHidden(UUID exportNoteId, boolean hidden) {
        ExportNotes note = exportNotesRepository.findById(exportNoteId);
        if(note == null) {
            return false;
        }
        note.setIsHidden(hidden);
        exportNotesRepository.save(note);
        return true;
    }

    private ExportRequest fromDTO(ExportRequestDTO exportRequestDTO) {
        ExportRequest exportRequest = new ExportRequest();
        Employee employee = employeeService.getEmployee(exportRequestDTO.employeeId());
        if(employee == null) {
            throw new IllegalArgumentException("Employee from ExportRequestDTO not found");
        }
        exportRequest.setEmployee(employee);
        exportRequest.setExportFormat(exportRequestDTO.exportFormat());
        exportRequest.setSelectedEntities(exportRequestDTO.selectedEntities());
        exportRequest.setAppliedFilters(exportRequestDTO.appliedFilters());
        exportRequest.setFileName(exportRequestDTO.fileName());

        return exportRequest;
    }


    private ExportRequestDTO toDTO(ExportRequest exportRequest) {
        return new ExportRequestDTO(
                exportRequest.getId(),
                exportRequest.getEmployee().getId(),
                exportRequest.getExportFormat(),
                exportRequest.getExportCreation().toString(),
                exportRequest.getSelectedEntities(),
                exportRequest.getAppliedFilters(),
                exportRequest.getFileName(),
                exportRequest.getStatus(),
                exportRequest.getFileSize()
        );
    }

    private ExportNotes fromDTO(ExportNotesDTO exportNotesDTO) {
        ExportNotes exportNotes = new ExportNotes();
        Employee employee = employeeService.getEmployee(exportNotesDTO.employeeId());
        if (employee == null) {
            throw new IllegalArgumentException("Employee from ExportNotesDTO not found");
        }
        exportNotes.setEmployee(employee);

        ExportRequest exportRequest = exportRequestRepository.findById(
                exportNotesDTO.exportRequestId()).orElseThrow(
                        () -> new IllegalArgumentException("ExportRequest from ExportNotesDTO not found")
        );

        exportNotes.setExportRequest(exportRequest);
        exportNotes.setNotes(exportNotesDTO.notes());

        return exportNotes;
    }

    private ExportNotesDTO toDTO(ExportNotes exportNotes) {
        return new ExportNotesDTO(
                exportNotes.getId(),
                exportNotes.getExportRequest().getId(),
                exportNotes.getEmployee().getId(),
                exportNotes.getNotes(),
                exportNotes.getCreationDate().toString()
        );
    }


}
