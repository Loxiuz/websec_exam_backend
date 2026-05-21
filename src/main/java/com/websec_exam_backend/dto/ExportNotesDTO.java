package com.websec_exam_backend.dto;

import java.util.UUID;

public record ExportNotesDTO (UUID id, UUID exportRequestId, UUID employeeId, String notes) {
}
