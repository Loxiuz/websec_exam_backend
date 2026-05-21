package com.websec_exam_backend.repository;

import com.websec_exam_backend.model.ExportRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExportRequestRepository extends JpaRepository<ExportRequest, Integer> {
}
