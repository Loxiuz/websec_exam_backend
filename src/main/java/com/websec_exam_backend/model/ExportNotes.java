package com.websec_exam_backend.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;

import java.time.LocalDateTime;
import java.util.UUID;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class ExportNotes {
    @Id
    private UUID id;
    @ManyToOne
    private ExportRequest exportRequest;
    @ManyToOne
    private Employee employee;
    private String notes;
    @CreationTimestamp
    private LocalDateTime creationDate;
}
