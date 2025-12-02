package com.websec_exam_backend.booking;


import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookingService {

    BookingRepository bookingRepository;

    public BookingService(BookingRepository bookingRepository) {
        this.bookingRepository = bookingRepository;
    }

    public List<BookingDTO> getBookings() {
        return bookingRepository.findAll().stream()
                .map(this::toDto)
                .collect(Collectors.toList());
    }

    public List<BookingDTO> getFilteredBookings(List<JsonObject> filters) {
        System.out.println("Filters: " + filters);
        List<BookingDTO> bookings = getBookings();

        for(JsonObject filter : filters) {
            JsonObject field = filter.getAsJsonObject("field");
            JsonObject value = filter.getAsJsonObject("value");

            if(field != null && value != null) {
                String fieldStr = field.getAsString();
                String valueStr = value.getAsString();
                System.out.println("Field: " + fieldStr + ", Value: " + valueStr);

                if (fieldStr.equals("flightNumber")) {
                    bookings = bookings.stream().filter(
                                    booking -> booking.flightNumber().equalsIgnoreCase(valueStr))
                            .collect(Collectors.toList());
                }
                if (fieldStr.equals("status")) {
                    bookings = bookings.stream()
                            .filter(booking -> booking.status().equalsIgnoreCase(valueStr))
                            .collect(Collectors.toList());
                }
                if(fieldStr.equals("passengerId")) {
                    bookings = bookings.stream()
                            .filter(booking -> booking.passengerId().equalsIgnoreCase(valueStr))
                            .collect(Collectors.toList());
                }
            }
        }

        return bookings;
    }

    private BookingDTO toDto(Booking booking) {
        return new BookingDTO(
               String.valueOf(booking.getPassenger().getId()),
                booking.getFlight().getFlightNumber(),
                booking.getBookingNumber(),
                booking.getSeatNumber(),
                booking.getStatus()
        );
    }
}
