package com.websec_exam_backend.flight;

import com.websec_exam_backend.airport.Airport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Flight[] findFlightByAirportDestination(Airport airportDestination);
}
