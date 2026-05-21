package com.websec_exam_backend.dto;

import com.websec_exam_backend.model.Airport;

public record FlightDTO(int id, Airport airportOrigin, Airport airportDestination, String flightNumber, String departureTime, String arrivalTime) {
}
