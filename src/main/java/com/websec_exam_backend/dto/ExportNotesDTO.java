package com.websec_exam_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

import java.util.UUID;

public record ExportNotesDTO (
		UUID id,
		@NotNull(message = "exportRequestId is required") UUID exportRequestId,
		@NotNull(message = "employeeId is required") UUID employeeId,
		@NotBlank(message = "notes is required")
		@Size(max = 1000, message = "notes must be at most 1000 characters")
		String notes,
		String creationDate) {
}
