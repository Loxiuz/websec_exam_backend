package com.websec_exam_backend.service;

import com.websec_exam_backend.dto.PassengerDTO;
import com.websec_exam_backend.repository.PassengerRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PassengerService {

    PassengerRepository passengerRepository;

    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public List<PassengerDTO> getAllPassengers() {
        return passengerRepository.findAll().stream().map(
                passenger -> new PassengerDTO(
                        String.valueOf(passenger.getId()),
                        passenger.getNationality()
                )
        ).toList();
    }
}
