package com.websec_exam_backend.repository;

import com.websec_exam_backend.model.Airport;
import com.websec_exam_backend.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FlightRepository extends JpaRepository<Flight, Integer> {
    Flight[] findFlightByAirportDestination(Airport airportDestination);
}
