package com.websec_exam_backend.controller;
import com.websec_exam_backend.dto.ExportNotesDTO;
import com.websec_exam_backend.dto.ExportRequestDTO;
import com.websec_exam_backend.dto.SetExportNoteHiddenDTO;
import com.websec_exam_backend.service.ExportRequestService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/export")
public class ExportRequestController {

    ExportRequestService exportRequestService;

    public ExportRequestController(ExportRequestService exportRequestService) {
        this.exportRequestService = exportRequestService;
    }

    @PostMapping
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<byte[]> exportDataFromEntities(@RequestBody ExportRequestDTO exportRequestDTO){
        byte[] fileBytes = exportRequestService.handleExportRequest(exportRequestDTO);

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.TEXT_PLAIN);
        headers.setContentDisposition(ContentDisposition.attachment().filename(exportRequestDTO.fileName()).build());

        if (fileBytes != null) {
            headers.setContentLength(fileBytes.length);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(fileBytes, headers, HttpStatus.OK);
    }

    @GetMapping("/all-requests")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER', 'GUEST')")
    public ResponseEntity<ExportRequestDTO[]> getAllExportRequests() {
        ExportRequestDTO[] exportRequests = exportRequestService.getAllExportRequests();
        if (exportRequests != null && exportRequests.length > 0) {
            return new ResponseEntity<>(exportRequests, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }

    @GetMapping("/notes/all")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER', 'GUEST')")
    public ResponseEntity<ExportNotesDTO[]> getAllExportNotes(HttpServletRequest request) {
        ExportNotesDTO[] notes = exportRequestService.getAllExportNotes(request);
        if (notes != null && notes.length > 0) {
            return new ResponseEntity<>(notes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/{exportRequestId}/notes")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER', 'GUEST')")
    public ResponseEntity<ExportNotesDTO[]> getAllExportNotesFromRequestId(@PathVariable UUID exportRequestId, HttpServletRequest request) {
        ExportNotesDTO[] notes = exportRequestService.getAllExportNotesFromRequestId(exportRequestId, request);
        if (notes != null && notes.length > 0) {
            return new ResponseEntity<>(notes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/notes/create")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<UUID> createExportNotes(@RequestBody ExportNotesDTO exportNotesDTO) {
        UUID createdNotesId = exportRequestService.createExportRequestNotes(exportNotesDTO);
        if (createdNotesId != null) {
            return new ResponseEntity<>(createdNotesId, HttpStatus.CREATED);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/notes/{exportNotesId}/hidden")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<Void> setExportNotesHidden(@PathVariable UUID exportNotesId, @RequestBody SetExportNoteHiddenDTO hiddenDto) {

        if(exportRequestService.setNoteHidden(exportNotesId, hiddenDto.isHidden())) {
            return new ResponseEntity<>(HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }
}
