INSERT INTO airport (city, country) VALUES
                                        ('Copenhagen', 'Denmark'),
                                        ('London', 'United Kingdom'),
                                        ('Berlin', 'Germany');

INSERT INTO employee (email, name) VALUES
                                       ('anna.hansen@airline.com', 'Anna Hansen'),
                                       ('michael.smith@airline.com', 'Michael Smith');

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
