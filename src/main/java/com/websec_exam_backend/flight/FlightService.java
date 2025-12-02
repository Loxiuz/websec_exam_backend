package com.websec_exam_backend.flight;

import com.google.gson.JsonObject;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class FlightService {

    FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<FlightDTO> getAllFlights() {
    return flightRepository.findAll()
            .stream()
            .map(flight -> new FlightDTO(
                    flight.getId(),
                    flight.getAirportOrigin(),
                    flight.getAirportDestination(),
                    flight.getFlightNumber(),
                    flight.getDepartureTime(),
                    flight.getArrivalTime()))
            .toList();
    }

    public List<FlightDTO> getFilteredFlights(List<JsonObject> filters) {
        System.out.println("Filters: " + filters);
        List<FlightDTO> flights = getAllFlights();

        for (JsonObject filter : filters) {
            JsonObject field = filter.getAsJsonObject("field");
            JsonObject value = filter.getAsJsonObject("value");

            if (field != null && value != null) {
                String fieldStr = field.getAsString();
                String valueStr = value.getAsString();
                System.out.println(fieldStr + ": " + valueStr);
                System.out.println("Field: " + fieldStr + ", Value: " + valueStr);

                if (fieldStr.equals("flightNumber")) {
                    flights = flights.stream()
                            .filter(flight -> flight.flightNumber().equalsIgnoreCase(valueStr))
                            .toList();
                }
                if (fieldStr.equals("departureTime")) {
                    flights = flights.stream()
                            .filter(flight -> flight.departureTime().equalsIgnoreCase(valueStr))
                            .toList();
                }
                if (fieldStr.equals("arrivalTime")) {
                    flights = flights.stream()
                            .filter(flight -> flight.arrivalTime().equalsIgnoreCase(valueStr))
                            .toList();
                }
            }
        }

        return flights;
    }
}
