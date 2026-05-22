INSERT INTO airport (city, country) VALUES
                                        ('Copenhagen', 'Denmark'),
                                        ('London', 'United Kingdom'),
                                        ('Berlin', 'Germany');

INSERT INTO employee (id, email, name) VALUES
                                       (UUID_TO_BIN('62d7d583-9809-4a1a-a803-a44e3156595b'),'anna.hansen@airline.com', 'Anna Hansen'),
                                       (UUID_TO_BIN('a197665b-5fa9-4bf7-8344-2cc303a15f09'),'michael.smith@airline.com', 'Michael Smith');

INSERT INTO crew_member (email, name, phone_number) VALUES
                                                        ('pilot.john@airline.com', 'John Peterson', '+4511122233'),
                                                        ('copilot.emma@airline.com', 'Emma Brown', '+4512345678'),
                                                        ('attendant.lars@airline.com', 'Lars Jensen', '+4599988877');

INSERT INTO flight (airport_origin_id, airport_destination_id, arrival_time, departure_time, flight_number) VALUES
                                                                                                                (1, 2, '12:30', '10:00', 'SK123'),
                                                                                                                (2, 3, '18:15', '16:00', 'BA456'),
                                                                                                                (1, 3, '20:45', '18:00', 'SK789');

INSERT INTO crew_member_assignment (crew_member_id, flight_id, role) VALUES
                                                                         (1, 1, 'Pilot'),
                                                                         (2, 1, 'Co-pilot'),
                                                                         (3, 1, 'Cabin Crew');

INSERT INTO passenger (birthdate, name, nationality) VALUES
                                                         ('1990-04-12', 'Sarah Johnson', 'Danish'),
                                                         ('1985-09-03', 'Mark Williams', 'British'),
                                                         ('2001-01-20', 'Julia Schmidt', 'German');

INSERT INTO booking (flight_id, passenger_id, booking_number, seat_number, status) VALUES
                                                                                       (1, 1, 'BK001', '12A', 'Confirmed'),
                                                                                       (1, 2, 'BK002', '14B', 'Cancelled'),
                                                                                       (2, 3, 'BK003', '7C', 'Confirmed');
INSERT INTO `users` (id, password, username, employee_id) VALUES
                        (1,'$2a$12$VcTGnkiGTDuFrE/BT8mR4uUpmoKvO/yFWJzbqE.Wzu1J1jKkj3gBi','ramesh',UUID_TO_BIN('a197665b-5fa9-4bf7-8344-2cc303a15f09')),
                        (2,'$2a$12$UjaMRw0tknm8BeXbD8MVp.g42jcWFKYy3L0dQdds3BIf4zlnR2Dvm','admin',UUID_TO_BIN('62d7d583-9809-4a1a-a803-a44e3156595b'));

INSERT INTO `roles` (id, name) VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');

INSERT INTO `users_roles` (role_id, user_id) VALUES (2,1),(1,2);

INSERT INTO export_request (export_creation, employee_id, id, export_format, file_name, selected_entities, status, applied_filters_json) values
                            (DATE('2025-08-12'),UUID_TO_BIN('62d7d583-9809-4a1a-a803-a44e3156595b'),UUID_TO_BIN('c901c2e9-1fc3-450f-a608-7044f95f37e3'),'csv', 'exported_flight_data.csv', 'flight, booking', 'COMPLETED' , '[{"flight":{"field":"","value":""}},{"booking":{"field":"","value":""}}]'),
                            (DATE('2025-08-13'),UUID_TO_BIN('a197665b-5fa9-4bf7-8344-2cc303a15f09'),UUID_TO_BIN('1a1e9504-2fa8-4102-80c0-35b44bde515e'),'csv', 'exported_passenger_data.csv', 'passenger, booking', 'COMPLETED' , '[{"passenger":{"field":"","value":""}},{"booking":{"field":"","value":""}}]'),
                            (DATE('2025-08-14'),UUID_TO_BIN('62d7d583-9809-4a1a-a803-a44e3156595b'),UUID_TO_BIN('7a231494-2f2f-43b7-a56c-0cad209b9d65'),'csv', 'exported_crew_data.csv', 'crew_member, crew_member_assignment', 'FAILED' , '[{"crew_member":{"field":"","value":""}},{"crew_member_assignment":{"field":"","value":""}}]'),
                            (DATE('2025-08-15'),UUID_TO_BIN('a197665b-5fa9-4bf7-8344-2cc303a15f09'),UUID_TO_BIN('6b343128-bccc-46af-a165-2c2552b900b6'),'csv', 'exported_airport_data.csv', 'booking', 'COMPLETED' , '[{"booking":{"field":"","value":""}}]'),
                            (DATE('2025-08-16'),UUID_TO_BIN('62d7d583-9809-4a1a-a803-a44e3156595b'),UUID_TO_BIN('699710d1-fa9d-41d4-850a-f2ac31929e08'),'csv', 'exported_employee_data.csv', 'crew_member', 'COMPLETED' , '[{"crew_member":{"field":"","value":""}}]');

INSERT INTO export_notes (employee_id, export_request_id, id, notes, creation_date) VALUES
                            (UUID_TO_BIN('62d7d583-9809-4a1a-a803-a44e3156595b'), UUID_TO_BIN('c901c2e9-1fc3-450f-a608-7044f95f37e3'), UUID_TO_BIN('53f62481-68dc-4fc1-858e-a48e31f39d10') ,'There are some missing values in the flight data export, please check the source data for completeness.', DATE('2025-08-13 20:00:00')),
                            (UUID_TO_BIN('a197665b-5fa9-4bf7-8344-2cc303a15f09'), UUID_TO_BIN('699710d1-fa9d-41d4-850a-f2ac31929e08'), UUID_TO_BIN('6b40e801-55ce-4f67-9bcf-14a8c40b2d8f'), 'The passenger data export looks good, but there are some inconsistencies in the booking data that need to be addressed.', DATE('2025-08-14 15:30:00')),
                            (UUID_TO_BIN('62d7d583-9809-4a1a-a803-a44e3156595b'), UUID_TO_BIN('7a231494-2f2f-43b7-a56c-0cad209b9d65'), UUID_TO_BIN('d9e8c2b4-3f1a-4e59-9c8e-2a1b5f6c7d8e'), 'The crew data export failed due to a database connection issue. Please investigate the server logs for more details and try exporting again.', DATE('2025-08-15 10:45:00')),
                            (UUID_TO_BIN('a197665b-5fa9-4bf7-8344-2cc303a15f09'), UUID_TO_BIN('6b343128-bccc-46af-a165-2c2552b900b6'), UUID_TO_BIN('f8e9c2d1-4a5b-4c6d-98ee-1a2b3c4d5e6f'), 'The airport data export completed successfully, but there are some discrepancies in the booking data that need to be reviewed and corrected.', DATE('2025-08-16 12:00:00')),
                            (UUID_TO_BIN('62d7d583-9809-4a1a-a803-a44e3156595b'), UUID_TO_BIN('699710d1-fa9d-41d4-850a-f2ac31929e08'), UUID_TO_BIN('e7f8c2a3-5b6d-4e7f-9a8b-12c3d4e5f6a7'), 'The employee data export looks good, but there are some missing values in the crew member data that need to be filled in for completeness.', DATE('2025-08-17 09:15:00'));