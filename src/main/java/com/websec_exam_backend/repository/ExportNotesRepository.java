package com.websec_exam_backend.repository;

import com.websec_exam_backend.model.ExportNotes;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface ExportNotesRepository extends JpaRepository<ExportNotes, Integer> {

    ExportNotes findById(UUID id);
}
