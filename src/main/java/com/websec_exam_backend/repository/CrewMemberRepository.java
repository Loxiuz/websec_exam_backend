package com.websec_exam_backend.repository;

import com.websec_exam_backend.model.CrewMember;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CrewMemberRepository extends JpaRepository<CrewMember, Integer> {
}
