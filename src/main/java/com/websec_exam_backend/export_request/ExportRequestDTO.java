package com.websec_exam_backend.export_request;
import java.util.List;
import java.util.Map;

public record ExportRequestDTO(int id, int employeeId, String exportFormat, String exportCreation, String selectedEntities, List<Map<String, FilterDTO>> appliedFilters, String fileName, String status, String fileSize) {
}
