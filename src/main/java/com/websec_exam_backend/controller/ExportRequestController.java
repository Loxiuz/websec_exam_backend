package com.websec_exam_backend.controller;
import com.websec_exam_backend.dto.ExportNotesDTO;
import com.websec_exam_backend.dto.ExportRequestDTO;
import com.websec_exam_backend.service.ExportRequestService;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

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
        System.out.println(exportRequestDTO.appliedFilters().toString());
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

    @GetMapping("/notes/all")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<ExportNotesDTO[]> getAllExportRequestNotes() {
        ExportNotesDTO[] notes = exportRequestService.getAllExportNotes();
        if (notes != null && notes.length > 0) {
            return new ResponseEntity<>(notes, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/all-requests")
    @PreAuthorize("hasAnyRole('ADMIN', 'USER')")
    public ResponseEntity<ExportRequestDTO[]> getAllExportRequests() {
        ExportRequestDTO[] exportRequests = exportRequestService.getAllExportRequests();
        if (exportRequests != null && exportRequests.length > 0) {
            return new ResponseEntity<>(exportRequests, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
}
