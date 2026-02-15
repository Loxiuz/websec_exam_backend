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
INSERT INTO `users` VALUES
                        (1,UUID_TO_BIN('a197665b-5fa9-4bf7-8344-2cc303a15f09'),'$2a$12$VcTGnkiGTDuFrE/BT8mR4uUpmoKvO/yFWJzbqE.Wzu1J1jKkj3gBi','ramesh'),
                        (2,UUID_TO_BIN('62d7d583-9809-4a1a-a803-a44e3156595b'),'$2a$12$UjaMRw0tknm8BeXbD8MVp.g42jcWFKYy3L0dQdds3BIf4zlnR2Dvm','admin');

INSERT INTO `roles` VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER');

INSERT INTO `users_roles` VALUES (2,1),(1,2);

INSERT INTO export_request values
                            (DATE('2025-08-12'),UUID_TO_BIN('62d7d583-9809-4a1a-a803-a44e3156595b'),1,'csv', 'exported_flight_data.csv', '', 'flight, booking', 'COMPLETED' , ''),
                            (DATE('2025-08-13'),UUID_TO_BIN('a197665b-5fa9-4bf7-8344-2cc303a15f09'),2,'csv', 'exported_passenger_data.csv', '', 'passenger, booking', 'COMPLETED' , ''),
                            (DATE('2025-08-14'),UUID_TO_BIN('62d7d583-9809-4a1a-a803-a44e3156595b'),3,'csv', 'exported_crew_data.csv', '', 'crew_member, crew_member_assignment', 'FAILED' , ''),
                            (DATE('2025-08-15'),UUID_TO_BIN('a197665b-5fa9-4bf7-8344-2cc303a15f09'),4,'csv', 'exported_airport_data.csv', '', 'booking', 'COMPLETED' , ''),
                            (DATE('2025-08-16'),UUID_TO_BIN('62d7d583-9809-4a1a-a803-a44e3156595b'),5,'csv', 'exported_employee_data.csv', '', 'crew_member', 'COMPLETED' , '');
