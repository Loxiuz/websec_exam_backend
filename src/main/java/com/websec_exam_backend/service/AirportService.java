package com.websec_exam_backend.service;

import com.websec_exam_backend.repository.AiportRepository;
import org.springframework.stereotype.Service;

@Service
public class AirportService {

    AiportRepository aiportRepository;

    public AirportService(AiportRepository aiportRepository) {
        this.aiportRepository = aiportRepository;
    }


}
