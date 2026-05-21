package com.websec_exam_backend.repository;

import com.websec_exam_backend.model.Booking;
import com.websec_exam_backend.model.Flight;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookingRepository extends JpaRepository<Booking, Integer> {
    Booking[] findAllByFlight(Flight flight);
}
