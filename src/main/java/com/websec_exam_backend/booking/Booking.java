package com.websec_exam_backend.booking;

import com.websec_exam_backend.flight.Flight;
import com.websec_exam_backend.passenger.Passenger;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private Passenger passenger;

    @ManyToOne
    private Flight flight;

    private String bookingNumber;

    private String seatNumber;

    private String status;

}
