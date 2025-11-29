package com.websec_exam_backend.booking;

import com.websec_exam_backend.flight.Flight;
import com.websec_exam_backend.passenger.Passenger;

public record BookingDTO(String passengerId, String flightNumber, String bookingNumber, String seatNumber, String status) {
}
