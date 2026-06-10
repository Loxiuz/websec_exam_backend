package com.websec_exam_backend.dto;

import java.util.List;
import java.util.UUID;

public record AuthorizationDTO(String role, String username, UUID employeeId, List<String> permissions) {
}
