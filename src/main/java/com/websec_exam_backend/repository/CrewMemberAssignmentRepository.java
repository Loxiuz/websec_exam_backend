package com.websec_exam_backend.repository;

import com.websec_exam_backend.model.CrewMemberAssignment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrewMemberAssignmentRepository extends JpaRepository<CrewMemberAssignment, Integer> {
}
