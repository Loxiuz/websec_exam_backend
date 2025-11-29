package com.websec_exam_backend.airport;

import org.springframework.stereotype.Service;

@Service
public class AirportService {

    AiportRepository aiportRepository;

    public AirportService(AiportRepository aiportRepository) {
        this.aiportRepository = aiportRepository;
    }


}
