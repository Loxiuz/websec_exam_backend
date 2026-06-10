package com.websec_exam_backend.dto;

import java.util.UUID;
public record AdminUserEmployeeDTO (String name, String username, String email, String role, UUID employeeId) {
}
