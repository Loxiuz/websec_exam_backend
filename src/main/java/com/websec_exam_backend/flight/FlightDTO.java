package com.websec_exam_backend.flight;

import com.websec_exam_backend.airport.Airport;

public record FlightDTO(int id, Airport airportOrigin, Airport airportDestination, String flightNumber, String departureTime, String arrivalTime) {
}
