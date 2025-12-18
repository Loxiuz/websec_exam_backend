package com.websec_exam_backend.export_request;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public record ExportRequestDTO(UUID id, UUID employeeId, String exportFormat, String exportCreation, String selectedEntities, List<Map<String, FilterDTO>> appliedFilters, String fileName, String status, String fileSize) {
}
