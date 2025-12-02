package com.websec_exam_backend.export;

import com.google.gson.JsonObject;
import com.websec_exam_backend.booking.BookingDTO;
import com.websec_exam_backend.booking.BookingService;
import com.websec_exam_backend.crew_member.CrewMemberDTO;
import com.websec_exam_backend.crew_member.CrewMemberService;
import com.websec_exam_backend.crew_member_assignment.CrewMemberAssignmentDTO;
import com.websec_exam_backend.crew_member_assignment.CrewMemberAssignmentService;
import com.websec_exam_backend.export_request.ExportRequest;
import com.websec_exam_backend.export_request.FilterDTO;
import com.websec_exam_backend.flight.FlightDTO;
import com.websec_exam_backend.flight.FlightService;
import com.websec_exam_backend.passenger.PassengerDTO;
import com.websec_exam_backend.passenger.PassengerService;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

@Service
public class ExportService {

    private final CrewMemberAssignmentService crewMemberAssignmentService;
    FlightService flightService;
    PassengerService passengerService;
    CrewMemberService crewMemberService;
    BookingService bookingService;

    public ExportService(FlightService flightService, PassengerService passengerService, CrewMemberService crewMemberService, BookingService bookingService, CrewMemberAssignmentService crewMemberAssignmentService) {
        this.flightService = flightService;
        this.passengerService = passengerService;
        this.crewMemberService = crewMemberService;
        this.bookingService = bookingService;
        this.crewMemberAssignmentService = crewMemberAssignmentService;
    }

    public byte[] processExportRequest(ExportRequest exportRequest){
        List<String> selectedEntities = Arrays.asList(exportRequest.getSelectedEntities().split(","));
        if(selectedEntities.isEmpty() || selectedEntities.get(0).isEmpty() ){
            throw new IllegalArgumentException("Selected entities cannot be empty");
        }

        List<JsonObject> appliedFilters = exportRequest.getAppliedFilters().stream().map(filter -> {
            JsonObject filterObj = new JsonObject();
            JsonObject fieldAndValue = new JsonObject();
            String entity = "";

            Optional<String> optKey = filter.keySet().stream().findFirst();
            if(optKey.isPresent()){
                entity = optKey.get();
            }

            Optional<FilterDTO> filterMapValues = filter.values().stream().findFirst();
            if(filterMapValues.isPresent()){
                FilterDTO filterDTO = filterMapValues.get();
                fieldAndValue.addProperty("field", filterDTO.field());
                fieldAndValue.addProperty("value", filterDTO.value());
            }

            filterObj.add(entity, fieldAndValue);

            return filterObj;
        }
        ).toList();

        System.out.println("Applied filters: " + appliedFilters);

        String exportFormat = exportRequest.getExportFormat();
        return createExport(selectedEntities, appliedFilters, exportFormat);
    }

    private byte[] createExport(List<String> selectedEntities, List<JsonObject> appliedFilters, String exportFormat){
        if(exportFormat.equalsIgnoreCase("csv")){
            return exportToCsv(selectedEntities, appliedFilters, exportFormat);
        } else if (exportFormat.equalsIgnoreCase("json")) {
            return exportToJson(selectedEntities, appliedFilters, exportFormat);
        }
        else {
            throw new UnsupportedOperationException("Invalid export format: " + exportFormat);
        }
    }

    private byte[] exportToCsv(List<String> selectedEntities, List<JsonObject> appliedFilters, String exportFormat) {
        StringBuilder builder = new StringBuilder();

        for (String selectedEntity : selectedEntities) {
            builder.append("=== ").append(selectedEntity.toUpperCase()).append(" ===").append("\n");
            ExportStructure structure = buildExportStructureForEntity(selectedEntity, appliedFilters, exportFormat);
            if(structure != null){
                builder.append(structure.buildData()).append("\n");
            }
        }

        return builder.toString().getBytes();
    }

    private byte[] exportToJson(List<String> selectedEntities, List<JsonObject> appliedFilters, String exportFormat) {
        StringBuilder builder = new StringBuilder();
        builder.append("[\n");

        for (int i = 0; i < selectedEntities.size(); i++) {
            String selectedEntity = selectedEntities.get(i);
            builder.append("    {\n");
            builder.append("        \"").append(selectedEntity.toLowerCase()).append("\": [\n");
            ExportStructure structure = buildExportStructureForEntity(selectedEntity, appliedFilters, exportFormat);
            if(structure != null){
                builder.append(structure.buildData());
            }
            builder.append("        ]\n");
            builder.append("    }");
            if (i < selectedEntities.size() - 1) {
                builder.append(",");
            }
            builder.append("\n");
        }

        builder.append("]");
        return builder.toString().getBytes();
    }

    private ExportStructure buildExportStructureForEntity(String selectedEntity, List<JsonObject> appliedFilters, String exportFormat) {
        return switch (selectedEntity.toLowerCase()) {
            case "flight" -> {
                List<FlightDTO> flights = flightService.getFilteredFlights(
                        appliedFilters.stream().filter(
                                filter -> filter.has("flight")
                        ).toList());
                if(exportFormat.equalsIgnoreCase("csv")){
                    yield new CsvExportStructure<>(
                            flights,
                            List.of("flightNumber", "departure", "arrival"),
                            flightData -> List.of(
                                    flightData.flightNumber(),
                                    flightData.departureTime(),
                                    flightData.arrivalTime()
                            )
                    );
                } else if (exportFormat.equalsIgnoreCase("json")) {
                    yield new JsonExportStructure<>(
                            flights,
                            List.of("flightNumber", "departure", "arrival"),
                            flightData -> List.of(
                                    flightData.flightNumber(),
                                    flightData.departureTime(),
                                    flightData.arrivalTime()
                            )
                    );
                } else {
                    yield null;
                }
            }
            case "passenger" -> {
                List<PassengerDTO> passengers = passengerService.getAllPassengers();
                if(exportFormat.equalsIgnoreCase("csv")){
                    yield new CsvExportStructure<>(
                            passengers,
                            List.of("passengerId", "nationality"),
                            passengerData -> List.of(
                                    passengerData.id(),
                                    passengerData.nationality()
                            )
                    );
                } else if (exportFormat.equalsIgnoreCase("json")) {
                    yield new JsonExportStructure<>(
                            passengers,
                            List.of("passengerId", "nationality"),
                            passengerData -> List.of(
                                    passengerData.id(),
                                    passengerData.nationality()
                            )
                    );
                } else {
                    yield null;
                }
            }
            case "crew_member" -> {
                List<CrewMemberDTO> crewMembers = crewMemberService.getFilteredCrewMembers(
                        appliedFilters.stream().filter(
                                filter -> filter.has("crew_member")
                        ).toList()
                );
                if(exportFormat.equalsIgnoreCase("csv")){
                    yield new CsvExportStructure<>(
                            crewMembers,
                            List.of("crewMemberId", "name", "email"),
                            crewMemberData -> List.of(
                                    crewMemberData.id(),
                                    crewMemberData.name(),
                                    crewMemberData.email()
                            )
                    );
                } else if (exportFormat.equalsIgnoreCase("json")) {
                    yield new JsonExportStructure<>(
                            crewMembers,
                            List.of("crewMemberId", "name", "email"),
                            crewMemberData -> List.of(
                                    crewMemberData.id(),
                                    crewMemberData.name(),
                                    crewMemberData.email()
                            )
                    );
                } else {
                    yield null;
                }
            }
            case "crew_member_assignment" -> {
                List<CrewMemberAssignmentDTO> crewMemberAssignments = crewMemberAssignmentService.getFilteredCrewMemberAssignments(
                        appliedFilters.stream().filter(
                                filter -> filter.has("crew_member")
                        ).toList());
                if (exportFormat.equalsIgnoreCase("csv")) {
                    yield new CsvExportStructure<>(
                            crewMemberAssignments,
                            List.of("crewMemberId", "role", "flightNumber"),
                            crewMemberData -> List.of(
                                    crewMemberData.crewMemberId(),
                                    crewMemberData.role(),
                                    crewMemberData.flightNumber()
                            )
                    );
                } else if (exportFormat.equalsIgnoreCase("json")) {
                    yield new JsonExportStructure<>(
                            crewMemberAssignments,
                            List.of("crewMemberId", "role", "flightNumber"),
                            crewMemberData -> List.of(
                                    crewMemberData.crewMemberId(),
                                    crewMemberData.role(),
                                    crewMemberData.flightNumber()
                            )
                    );
                } else {
                    yield null;
                }
            }
            case "booking" -> {
                List<BookingDTO> bookings = bookingService.getFilteredBookings(
                       appliedFilters.stream().filter(
                                filter -> filter.has("booking")
                       ).toList());
                if(exportFormat.equalsIgnoreCase("csv")){
                    yield new CsvExportStructure<>(
                            bookings,
                            List.of("flightNumber","bookingNumber", "seatNumber", "status", "passengerId"),
                            bookingData -> List.of(
                                    bookingData.flightNumber(),
                                    bookingData.bookingNumber(),
                                    bookingData.seatNumber(),
                                    bookingData.status(),
                                    bookingData.passengerId()
                            )
                    );
                } else if (exportFormat.equalsIgnoreCase("json")) {
                    yield new JsonExportStructure<>(
                            bookings,
                            List.of("flightNumber","bookingNumber", "seatNumber", "status", "passengerId"),
                            bookingData -> List.of(
                                    bookingData.flightNumber(),
                                    bookingData.bookingNumber(),
                                    bookingData.seatNumber(),
                                    bookingData.status(),
                                    bookingData.passengerId()
                            )
                    );
                } else {
                    yield null;
                }
            }
            default -> null;
        };
    }
}
