package com.websec_exam_backend.booking;

import com.websec_exam_backend.flight.Flight;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    Booking[] findAllByFlight(Flight flight);
}
