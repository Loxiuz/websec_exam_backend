package com.websec_exam_backend.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record FilterDTO (
		@NotBlank(message = "field is required")
		@Pattern(regexp = "^[a-zA-Z0-9_]+$", message = "field may only contain letters, numbers, and underscore")
		String field,
		@Size(max = 100, message = "value must be at most 100 characters")
		String value) {
}
