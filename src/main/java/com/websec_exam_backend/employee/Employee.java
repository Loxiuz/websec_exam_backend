package com.websec_exam_backend.employee;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

import java.util.UUID;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @NonNull
    private UUID id;

    private String name;

    private String email;

    @Lob
    @Column(columnDefinition = "MEDIUMBLOB")
    private byte[] image;

}
