package com.websec_exam_backend.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import java.util.List;
import java.util.Map;
import java.util.UUID;

public record ExportRequestDTO(
		UUID id,
		@NotNull(message = "employeeId is required") UUID employeeId,
		@NotBlank(message = "exportFormat is required")
		@Pattern(regexp = "(?i)csv|json", message = "exportFormat must be either csv or json")
		String exportFormat,
		String exportCreation,
		@NotBlank(message = "selectedEntities is required")
		@Size(max = 200, message = "selectedEntities must be at most 200 characters")
		String selectedEntities,
		@NotNull(message = "appliedFilters is required")
		@Size(max = 20, message = "At most 20 filters are allowed")
		List<Map<String, FilterDTO>> appliedFilters,
		@NotBlank(message = "fileName is required")
		@Pattern(regexp = "^[a-zA-Z0-9._-]{1,100}$", message = "fileName may only contain letters, numbers, dot, underscore, and hyphen")
		String fileName,
		String status,
		String fileSize) {
}
