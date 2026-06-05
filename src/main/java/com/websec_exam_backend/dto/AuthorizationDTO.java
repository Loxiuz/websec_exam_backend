package com.websec_exam_backend.dto;

import java.util.List;

public record AuthorizationDTO(String role, List<String> permissions) {
}
