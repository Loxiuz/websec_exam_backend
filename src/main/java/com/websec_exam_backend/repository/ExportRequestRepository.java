package com.websec_exam_backend.repository;

import com.websec_exam_backend.model.ExportRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExportRequestRepository extends JpaRepository<ExportRequest, UUID> {
}
