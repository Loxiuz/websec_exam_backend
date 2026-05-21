package com.websec_exam_backend.repository;

import com.websec_exam_backend.model.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AiportRepository extends JpaRepository<Airport, Integer> {
}
