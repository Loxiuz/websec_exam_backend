package com.websec_exam_backend.dto;

import jakarta.validation.constraints.NotNull;

public record ExportNoteHiddenDTO(@NotNull(message = "isHidden is required") Boolean isHidden) {

}
