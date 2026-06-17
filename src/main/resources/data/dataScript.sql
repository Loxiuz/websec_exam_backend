INSERT INTO airport (city, country) VALUES
                                        ('Copenhagen', 'Denmark'),
                                        ('London', 'United Kingdom'),
                                        ('Berlin', 'Germany'),
                                        ('Oslo', 'Norway'),
                                        ('Stockholm', 'Sweden'),
                                        ('Paris', 'France'),
                                        ('Madrid', 'Spain'),
                                        ('Rome', 'Italy'),
                                        ('Amsterdam', 'Netherlands'),
                                        ('Helsinki', 'Finland'),
                                        ('Dublin', 'Ireland'),
                                        ('Lisbon', 'Portugal'),
                                        ('Vienna', 'Austria'),
                                        ('Prague', 'Czech Republic'),
                                        ('Warsaw', 'Poland'),
                                        ('Athens', 'Greece'),
                                        ('Zurich', 'Switzerland'),
                                        ('Brussels', 'Belgium'),
                                        ('Reykjavik', 'Iceland'),
                                        ('Tallinn', 'Estonia');

INSERT INTO employee (id, email, name) VALUES
                                       (UUID_TO_BIN('62d7d583-9809-4a1a-a803-a44e3156595b'), 'anna.hansen@airline.com', 'Anna Hansen'),
                                       (UUID_TO_BIN('a197665b-5fa9-4bf7-8344-2cc303a15f09'), 'michael.smith@airline.com', 'Michael Smith'),
                                       (UUID_TO_BIN('3f1c4d70-0c22-4d5d-9f8d-cad3d1b8e101'), 'sofia.nielsen@airline.com', 'Sofia Nielsen'),
                                       (UUID_TO_BIN('9a35f0de-c2d2-4fd0-a9a2-8d00f9b8c202'), 'liam.andersen@airline.com', 'Liam Andersen'),
                                       (UUID_TO_BIN('d4b9d4a7-7b11-4ac7-a2f4-7ee38ad9c303'), 'eva.martin@airline.com', 'Eva Martin'),
                                       (UUID_TO_BIN('5f10d8fe-80e8-4ce8-98cf-1d8f3f17d404'), 'noah.larsen@airline.com', 'Noah Larsen'),
                                       (UUID_TO_BIN('b6f13ab0-9d6f-4ad9-b01c-3f7f90f9e505'), 'oliver.berg@airline.com', 'Oliver Berg'),
                                       (UUID_TO_BIN('c8ac9a5e-3ebd-4a8f-a845-9c0f5f41f606'), 'freja.pedersen@airline.com', 'Freja Pedersen'),
                                       (UUID_TO_BIN('2b3ee6a2-6f97-4981-8f4a-e9025b0ae707'), 'ida.madsen@airline.com', 'Ida Madsen'),
                                       (UUID_TO_BIN('7e518f73-2a4d-4e30-9d5f-1bc838dcf808'), 'william.jensen@airline.com', 'William Jensen'),
                                       (UUID_TO_BIN('1a2b3c4d-5e6f-4701-8a9b-0c1d2e3f4001'), 'emil.thomsen@airline.com', 'Emil Thomsen'),
                                       (UUID_TO_BIN('1a2b3c4d-5e6f-4702-8a9b-0c1d2e3f4002'), 'nanna.iversen@airline.com', 'Nanna Iversen'),
                                       (UUID_TO_BIN('1a2b3c4d-5e6f-4703-8a9b-0c1d2e3f4003'), 'kasper.dahl@airline.com', 'Kasper Dahl'),
                                       (UUID_TO_BIN('1a2b3c4d-5e6f-4704-8a9b-0c1d2e3f4004'), 'aline.sorensen@airline.com', 'Aline Sorensen'),
                                       (UUID_TO_BIN('1a2b3c4d-5e6f-4705-8a9b-0c1d2e3f4005'), 'jonas.holm@airline.com', 'Jonas Holm'),
                                       (UUID_TO_BIN('1a2b3c4d-5e6f-4706-8a9b-0c1d2e3f4006'), 'mathilde.poulsen@airline.com', 'Mathilde Poulsen'),
                                       (UUID_TO_BIN('1a2b3c4d-5e6f-4707-8a9b-0c1d2e3f4007'), 'viktor.riis@airline.com', 'Viktor Riis'),
                                       (UUID_TO_BIN('1a2b3c4d-5e6f-4708-8a9b-0c1d2e3f4008'), 'laura.koch@airline.com', 'Laura Koch'),
                                       (UUID_TO_BIN('1a2b3c4d-5e6f-4709-8a9b-0c1d2e3f4009'), 'simon.frost@airline.com', 'Simon Frost'),
                                       (UUID_TO_BIN('1a2b3c4d-5e6f-4710-8a9b-0c1d2e3f4010'), 'camilla.bach@airline.com', 'Camilla Bach'),
                                       (UUID_TO_BIN('f434581c-abe5-4a1b-8a7c-b7b1240193e3'), 'guest@guest.com', 'Guest User');

INSERT INTO crew_member (email, name, phone_number) VALUES
                                                        ('pilot.john@airline.com', 'John Peterson', '+4511122233'),
                                                        ('copilot.emma@airline.com', 'Emma Brown', '+4512345678'),
                                                        ('attendant.lars@airline.com', 'Lars Jensen', '+4599988877'),
                                                        ('pilot.clara@airline.com', 'Clara Olsen', '+4511111111'),
                                                        ('copilot.erik@airline.com', 'Erik Holm', '+4522222222'),
                                                        ('attendant.mia@airline.com', 'Mia Kristensen', '+4533333333'),
                                                        ('attendant.tobias@airline.com', 'Tobias Moller', '+4544444444'),
                                                        ('pilot.nora@airline.com', 'Nora Svendsen', '+4555555555'),
                                                        ('copilot.august@airline.com', 'August Friis', '+4566666666'),
                                                        ('attendant.lea@airline.com', 'Lea Rasmussen', '+4577777777'),
                                                        ('pilot.elias@airline.com', 'Elias Bjerre', '+4581111111'),
                                                        ('copilot.sara@airline.com', 'Sara Munk', '+4582222222'),
                                                        ('attendant.karl@airline.com', 'Karl Nygaard', '+4583333333'),
                                                        ('pilot.helene@airline.com', 'Helene Winther', '+4584444444'),
                                                        ('copilot.mads@airline.com', 'Mads Kjeldsen', '+4585555555'),
                                                        ('attendant.runa@airline.com', 'Runa Birk', '+4586666666'),
                                                        ('pilot.storm@airline.com', 'Storm Aagaard', '+4587777777'),
                                                        ('copilot.alma@airline.com', 'Alma Sejer', '+4588888888'),
                                                        ('attendant.otto@airline.com', 'Otto Gade', '+4589999999'),
                                                        ('attendant.marie@airline.com', 'Marie Voss', '+4581010101');

INSERT INTO flight (airport_origin_id, airport_destination_id, arrival_time, departure_time, flight_number) VALUES
                                                                                                                (1, 2, '12:30', '10:00', 'SK123'),
                                                                                                                (2, 3, '18:15', '16:00', 'BA456'),
                                                                                                                (1, 3, '20:45', '18:00', 'SK789'),
                                                                                                                (4, 5, '09:40', '08:00', 'DY210'),
                                                                                                                (6, 7, '14:20', '12:10', 'AF330'),
                                                                                                                (8, 9, '17:50', '15:30', 'AZ440'),
                                                                                                                (10, 1, '11:25', '09:30', 'AY550'),
                                                                                                                (3, 6, '16:35', '14:20', 'LH660'),
                                                                                                                (7, 8, '22:10', '20:00', 'IB770'),
                                                                                                                (5, 10, '07:55', '06:10', 'SK880'),
                                                                                                                (11, 12, '10:20', '08:15', 'EI901'),
                                                                                                                (13, 14, '13:10', '11:00', 'OS902'),
                                                                                                                (15, 16, '16:45', '14:30', 'LO903'),
                                                                                                                (17, 18, '19:55', '17:40', 'LX904'),
                                                                                                                (19, 20, '22:25', '20:10', 'BT905'),
                                                                                                                (12, 11, '09:50', '07:45', 'TP906'),
                                                                                                                (14, 13, '12:30', '10:20', 'OK907'),
                                                                                                                (16, 15, '15:15', '13:05', 'A3908'),
                                                                                                                (18, 17, '18:40', '16:30', 'SN909'),
                                                                                                                (20, 19, '21:35', '19:20', 'FI910');

INSERT INTO crew_member_assignment (crew_member_id, flight_id, role) VALUES
                                                                         (1, 1, 'Pilot'),
                                                                         (2, 1, 'Co-pilot'),
                                                                         (3, 1, 'Cabin Crew'),
                                                                         (4, 2, 'Pilot'),
                                                                         (5, 2, 'Co-pilot'),
                                                                         (6, 2, 'Cabin Crew'),
                                                                         (7, 3, 'Cabin Crew'),
                                                                         (8, 4, 'Pilot'),
                                                                         (9, 5, 'Co-pilot'),
                                                                         (10, 6, 'Cabin Crew'),
                                                                         (11, 7, 'Pilot'),
                                                                         (12, 8, 'Co-pilot'),
                                                                         (13, 9, 'Cabin Crew'),
                                                                         (14, 10, 'Pilot'),
                                                                         (15, 11, 'Co-pilot'),
                                                                         (16, 12, 'Cabin Crew'),
                                                                         (17, 13, 'Pilot'),
                                                                         (18, 14, 'Co-pilot'),
                                                                         (19, 15, 'Cabin Crew'),
                                                                         (20, 16, 'Cabin Crew');

INSERT INTO passenger (birthdate, name, nationality) VALUES
                                                         ('1990-04-12', 'Sarah Johnson', 'Danish'),
                                                         ('1985-09-03', 'Mark Williams', 'British'),
                                                         ('2001-01-20', 'Julia Schmidt', 'German'),
                                                         ('1993-11-08', 'Lucas Hansen', 'Norwegian'),
                                                         ('1988-06-15', 'Emma Rossi', 'Italian'),
                                                         ('1997-02-28', 'Carlos Diaz', 'Spanish'),
                                                         ('1995-12-19', 'Sophie Dubois', 'French'),
                                                         ('1982-07-04', 'Mikael Lund', 'Swedish'),
                                                         ('2000-10-10', 'Aino Korhonen', 'Finnish'),
                                                         ('1991-03-23', 'David de Vries', 'Dutch'),
                                                         ('1994-05-01', 'Oliver Murphy', 'Irish'),
                                                         ('1989-08-17', 'Beatriz Silva', 'Portuguese'),
                                                         ('1992-02-11', 'Lukas Gruber', 'Austrian'),
                                                         ('1998-09-27', 'Petra Novak', 'Czech'),
                                                         ('1986-01-05', 'Jakub Kowalski', 'Polish'),
                                                         ('1999-12-30', 'Eleni Papadopoulos', 'Greek'),
                                                         ('1991-07-14', 'Jonas Meier', 'Swiss'),
                                                         ('1987-03-22', 'Claire Dubreuil', 'Belgian'),
                                                         ('2002-11-19', 'Aron Sigurdsson', 'Icelandic'),
                                                         ('1996-06-09', 'Kati Saar', 'Estonian');

INSERT INTO booking (flight_id, passenger_id, booking_number, seat_number, status) VALUES
                                                                                       (1, 1, 'BK001', '12A', 'Confirmed'),
                                                                                       (1, 2, 'BK002', '14B', 'Cancelled'),
                                                                                       (2, 3, 'BK003', '7C', 'Confirmed'),
                                                                                       (3, 4, 'BK004', '9D', 'Confirmed'),
                                                                                       (4, 5, 'BK005', '3A', 'Confirmed'),
                                                                                       (5, 6, 'BK006', '18F', 'Cancelled'),
                                                                                       (6, 7, 'BK007', '2C', 'Confirmed'),
                                                                                       (7, 8, 'BK008', '15E', 'Pending'),
                                                                                       (8, 9, 'BK009', '21B', 'Confirmed'),
                                                                                       (9, 10, 'BK010', '11D', 'Pending'),
                                                                                       (10, 11, 'BK011', '10A', 'Confirmed'),
                                                                                       (11, 12, 'BK012', '6B', 'Confirmed'),
                                                                                       (12, 13, 'BK013', '8C', 'Pending'),
                                                                                       (13, 14, 'BK014', '4D', 'Cancelled'),
                                                                                       (14, 15, 'BK015', '16E', 'Confirmed'),
                                                                                       (15, 16, 'BK016', '5F', 'Pending'),
                                                                                       (16, 17, 'BK017', '1A', 'Confirmed'),
                                                                                       (17, 18, 'BK018', '13C', 'Confirmed'),
                                                                                       (18, 19, 'BK019', '19D', 'Cancelled'),
                                                                                       (19, 20, 'BK020', '22B', 'Confirmed');

INSERT INTO `roles` (id, role_name) VALUES (1,'ROLE_ADMIN'),(2,'ROLE_USER'),(3,'ROLE_GUEST');

INSERT INTO `users` (id, password, username, employee_id, role_id) VALUES
                        (1,'$2a$12$UjaMRw0tknm8BeXbD8MVp.g42jcWFKYy3L0dQdds3BIf4zlnR2Dvm','admin',UUID_TO_BIN('62d7d583-9809-4a1a-a803-a44e3156595b'), 1),
                        (2, '$2a$10$c5sFL9MazveNcJZr2o9Kgu5Y15.bsEqIKeMZoizENJqWZ/hMTfBd6', 'freja', UUID_TO_BIN('c8ac9a5e-3ebd-4a8f-a845-9c0f5f41f606'), 2),
                        (3, '$2a$10$/m2nbAxuRRpJg7KmnD.C9uTluItaYXitxhV8ifDAUtdntFySempbG', 'kasper', UUID_TO_BIN('1a2b3c4d-5e6f-4703-8a9b-0c1d2e3f4003'), 2),
                        (4, '$2a$10$dtzZfcfdYJn/EViDXlexmeThrPkUA831QY3wqjm7C0eRwtsAaGYCK', 'emil', UUID_TO_BIN('1a2b3c4d-5e6f-4701-8a9b-0c1d2e3f4001'), 2),
                        (5, '$2a$10$IqXGFRTTQTy/W/QDGJ3L7ur4Ndxb1g//k6Xa.XrJb4/5E0PsfglRy', 'ida', UUID_TO_BIN('2b3ee6a2-6f97-4981-8f4a-e9025b0ae707'), 2),
                        (6, '$2a$10$wui.9DLIzJQZcauEtxdN5eMrqBUDGQOEGjH9DESQwoM0uf6s5a9NC', 'sofia', UUID_TO_BIN('3f1c4d70-0c22-4d5d-9f8d-cad3d1b8e101'), 2),
                        (7, '$2a$10$.E8rgx.XOamGBbaRmzo2I.pU4lJelc/N9rGfOvnHBRsNN9ewvbxNK', 'viktor', UUID_TO_BIN('1a2b3c4d-5e6f-4707-8a9b-0c1d2e3f4007'), 2),
                        (9, '$2a$10$9nIPLpdCFPgVw66pVgzgEuUjlz8fhZeCVO8MTt9AITAz7d/gRsami', 'laura', UUID_TO_BIN('1a2b3c4d-5e6f-4708-8a9b-0c1d2e3f4008'), 2),
                        (10, '$2a$10$iHVuOsR4mET10q3daHbjbe/5cuAKUemrjk.T.E/Lvn9basp9QJPjS', 'eva', UUID_TO_BIN('d4b9d4a7-7b11-4ac7-a2f4-7ee38ad9c303'), 2),
                        (11, '$2a$10$0shQft2wy4r7sRVjPoMGoOXM1ZB9NAKYaABowlnvLbskHIKx0hSFy', 'jonas', UUID_TO_BIN('1a2b3c4d-5e6f-4705-8a9b-0c1d2e3f4005'), 2),
                        (12, '$2a$10$uWpLgAf63Ci3ui.hhE77POLlLETzNrWYcVziLJK6NGzh/IOJxHPky', 'simon', UUID_TO_BIN('1a2b3c4d-5e6f-4709-8a9b-0c1d2e3f4009'), 2),
                        (13, '$2a$10$VuaUozMZZvsd3Q9j.APkieD5Ii5PkS5nK84NsFthzamIpIA90y2rW', 'william', UUID_TO_BIN('7e518f73-2a4d-4e30-9d5f-1bc838dcf808'), 2),
                        (15, '$2a$10$WguuAcZmz4.HdvB7hwfAOeTxNsP8UUKSDJ8Vp3OyoIXQeFbRcimTa', 'mathilde', UUID_TO_BIN('1a2b3c4d-5e6f-4706-8a9b-0c1d2e3f4006'), 2),
                        (16, '$2a$10$1sRCVqcMksi.D7Og7.NcN.J093AjFI.mauzQuq0bpNDot89fXw3Ei', 'oliver', UUID_TO_BIN('b6f13ab0-9d6f-4ad9-b01c-3f7f90f9e505'), 2),
                        (17, '$2a$10$rDWYldYicWpjFAz1hM3ySe.CYe/p7viYNdBj0FFxqFEIjvbb7QVmK', 'liam', UUID_TO_BIN('9a35f0de-c2d2-4fd0-a9a2-8d00f9b8c202'), 2),
                        (18, '$2a$10$wJFtxOV9x8ZshjPHwzJHSeMVUXhQM1dfWpFgLxurSD/WHEnQT5ChW', 'noah', UUID_TO_BIN('5f10d8fe-80e8-4ce8-98cf-1d8f3f17d404'), 2),
                        (19, '$2a$10$D2nXCmXcCUCxZT.TF/Xq9.RlhmlafyjKrPxP6F90w68DGQfTKaSyy', 'aline', UUID_TO_BIN('1a2b3c4d-5e6f-4704-8a9b-0c1d2e3f4004'), 2),
                        (20, '$2a$12$ab0Cj4uzWBzCJVfEKF.QCO2WdRBkcvWxW9jwcYGMTHp/NSgIVCOKO', 'guest', UUID_TO_BIN('f434581c-abe5-4a1b-8a7c-b7b1240193e3'), 3);


    INSERT INTO export_request (export_creation, employee_id, id, export_format, file_name, selected_entities, status, applied_filters_json) VALUES
                            (DATE('2025-08-12'),UUID_TO_BIN('62d7d583-9809-4a1a-a803-a44e3156595b'),UUID_TO_BIN('c901c2e9-1fc3-450f-a608-7044f95f37e3'),'csv','exported_flight_data.csv','flight, booking','COMPLETED','[{"flight":{"field":"","value":""}},{"booking":{"field":"","value":""}}]'),
                            (DATE('2025-08-13'),UUID_TO_BIN('a197665b-5fa9-4bf7-8344-2cc303a15f09'),UUID_TO_BIN('1a1e9504-2fa8-4102-80c0-35b44bde515e'),'csv','exported_passenger_data.csv','passenger, booking','COMPLETED','[{"passenger":{"field":"","value":""}},{"booking":{"field":"","value":""}}]'),
                            (DATE('2025-08-14'),UUID_TO_BIN('3f1c4d70-0c22-4d5d-9f8d-cad3d1b8e101'),UUID_TO_BIN('7a231494-2f2f-43b7-a56c-0cad209b9d65'),'csv','exported_crew_data.csv','crew_member, crew_member_assignment','FAILED','[{"crew_member":{"field":"","value":""}}]'),
                            (DATE('2025-08-15'),UUID_TO_BIN('9a35f0de-c2d2-4fd0-a9a2-8d00f9b8c202'),UUID_TO_BIN('6b343128-bccc-46af-a165-2c2552b900b6'),'csv','exported_airport_data.csv','booking','COMPLETED','[{"booking":{"field":"","value":""}}]'),
                            (DATE('2025-08-16'),UUID_TO_BIN('d4b9d4a7-7b11-4ac7-a2f4-7ee38ad9c303'),UUID_TO_BIN('699710d1-fa9d-41d4-850a-f2ac31929e08'),'csv','exported_employee_data.csv','crew_member','COMPLETED','[{"crew_member":{"field":"","value":""}}]'),
                            (DATE('2025-08-17'),UUID_TO_BIN('5f10d8fe-80e8-4ce8-98cf-1d8f3f17d404'),UUID_TO_BIN('98d3a4f0-1463-4f67-9f2a-a31ac4a1b111'),'json','exported_booking_data.json','booking, passenger','COMPLETED','[{"booking":{"field":"status","value":"Confirmed"}}]'),
                            (DATE('2025-08-18'),UUID_TO_BIN('b6f13ab0-9d6f-4ad9-b01c-3f7f90f9e505'),UUID_TO_BIN('a5d7d1ea-908f-4f1d-9340-894fc1b6c222'),'csv','exported_airport_report.csv','airport','COMPLETED','[{"airport":{"field":"country","value":"Denmark"}}]'),
                            (DATE('2025-08-19'),UUID_TO_BIN('c8ac9a5e-3ebd-4a8f-a845-9c0f5f41f606'),UUID_TO_BIN('b1a0c3d4-e5f6-47a8-90ab-cdef1234d333'),'json','exported_flights.json','flight','FAILED','[{"flight":{"field":"flight_number","value":"SK"}}]'),
                            (DATE('2025-08-20'),UUID_TO_BIN('2b3ee6a2-6f97-4981-8f4a-e9025b0ae707'),UUID_TO_BIN('c2b3d4e5-f6a7-48b9-91bc-def01234e444'),'csv','exported_user_audit.csv','employee, export_request','COMPLETED','[{"employee":{"field":"name","value":""}}]'),
                            (DATE('2025-08-21'),UUID_TO_BIN('7e518f73-2a4d-4e30-9d5f-1bc838dcf808'),UUID_TO_BIN('d3c4e5f6-a7b8-49ca-a2cd-ef123456f555'),'csv','exported_notes_data.csv','export_notes','COMPLETED','[{"export_notes":{"field":"is_hidden","value":"false"}}]'),
                            (DATE('2025-08-22'),UUID_TO_BIN('1a2b3c4d-5e6f-4701-8a9b-0c1d2e3f4001'),UUID_TO_BIN('e1111111-1111-4111-8111-111111111111'),'csv','exported_flight_data_2.csv','flight, booking','COMPLETED','[{"flight":{"field":"","value":""}}]'),
                            (DATE('2025-08-23'),UUID_TO_BIN('1a2b3c4d-5e6f-4702-8a9b-0c1d2e3f4002'),UUID_TO_BIN('e2222222-2222-4222-8222-222222222222'),'json','exported_passenger_data_2.json','passenger','COMPLETED','[{"passenger":{"field":"nationality","value":"Irish"}}]'),
                            (DATE('2025-08-24'),UUID_TO_BIN('1a2b3c4d-5e6f-4703-8a9b-0c1d2e3f4003'),UUID_TO_BIN('e3333333-3333-4333-8333-333333333333'),'csv','exported_airport_data_2.csv','airport','COMPLETED','[{"airport":{"field":"country","value":"Portugal"}}]'),
                            (DATE('2025-08-25'),UUID_TO_BIN('1a2b3c4d-5e6f-4704-8a9b-0c1d2e3f4004'),UUID_TO_BIN('e4444444-4444-4444-8444-444444444444'),'csv','exported_crew_data_2.csv','crew_member','FAILED','[{"crew_member":{"field":"name","value":""}}]'),
                            (DATE('2025-08-26'),UUID_TO_BIN('1a2b3c4d-5e6f-4705-8a9b-0c1d2e3f4005'),UUID_TO_BIN('e5555555-5555-4555-8555-555555555555'),'json','exported_booking_data_2.json','booking','COMPLETED','[{"booking":{"field":"status","value":"Pending"}}]'),
                            (DATE('2025-08-27'),UUID_TO_BIN('1a2b3c4d-5e6f-4706-8a9b-0c1d2e3f4006'),UUID_TO_BIN('e6666666-6666-4666-8666-666666666666'),'csv','exported_employee_data_2.csv','employee','COMPLETED','[{"employee":{"field":"email","value":"@airline.com"}}]'),
                            (DATE('2025-08-28'),UUID_TO_BIN('1a2b3c4d-5e6f-4707-8a9b-0c1d2e3f4007'),UUID_TO_BIN('e7777777-7777-4777-8777-777777777777'),'csv','exported_route_data.csv','flight, airport','COMPLETED','[{"flight":{"field":"flight_number","value":"9"}}]'),
                            (DATE('2025-08-29'),UUID_TO_BIN('1a2b3c4d-5e6f-4708-8a9b-0c1d2e3f4008'),UUID_TO_BIN('e8888888-8888-4888-8888-888888888888'),'json','exported_compliance_data.json','users, roles','FAILED','[{"users":{"field":"role_id","value":"2"}}]'),
                            (DATE('2025-08-30'),UUID_TO_BIN('1a2b3c4d-5e6f-4709-8a9b-0c1d2e3f4009'),UUID_TO_BIN('e9999999-9999-4999-8999-999999999999'),'csv','exported_ops_data.csv','crew_member_assignment','COMPLETED','[{"crew_member_assignment":{"field":"role","value":"Pilot"}}]'),
                            (DATE('2025-08-31'),UUID_TO_BIN('1a2b3c4d-5e6f-4710-8a9b-0c1d2e3f4010'),UUID_TO_BIN('ea000000-0000-4a00-8a00-000000000000'),'csv','exported_weekly_digest.csv','export_request, export_notes','COMPLETED','[{"export_notes":{"field":"is_hidden","value":"false"}}]'),
                            (DATE('2025-08-31'),UUID_TO_BIN('1a2b3c4d-5e6f-4710-8a9b-0c1d2e3f4010'),UUID_TO_BIN('ea000000-0000-4a00-8a00-000000000012'),'csv','exported_weekly_digest.csv','export_request, export_notes','COMPLETED','[{"export_notes":{"field":"is_hidden","value":"false"}}]');


INSERT INTO export_notes (employee_id, export_request_id, id, notes, creation_date, is_hidden) VALUES
                            (UUID_TO_BIN('62d7d583-9809-4a1a-a803-a44e3156595b'), UUID_TO_BIN('c901c2e9-1fc3-450f-a608-7044f95f37e3'), UUID_TO_BIN('53f62481-68dc-4fc1-858e-a48e31f39d10'), 'There are some missing values in the flight data export, please check the source data for completeness.', DATE('2025-08-13 20:00:00'), true),
                            (UUID_TO_BIN('a197665b-5fa9-4bf7-8344-2cc303a15f09'), UUID_TO_BIN('1a1e9504-2fa8-4102-80c0-35b44bde515e'), UUID_TO_BIN('6b40e801-55ce-4f67-9bcf-14a8c40b2d8f'), 'Passenger data export looks good, but booking inconsistencies should be addressed.', DATE('2025-08-14 15:30:00'), false),
                            (UUID_TO_BIN('3f1c4d70-0c22-4d5d-9f8d-cad3d1b8e101'), UUID_TO_BIN('7a231494-2f2f-43b7-a56c-0cad209b9d65'), UUID_TO_BIN('d9e8c2b4-3f1a-4e59-9c8e-2a1b5f6c7d8e'), 'Crew export failed due to temporary database connectivity issues.', DATE('2025-08-15 10:45:00'), false),
                            (UUID_TO_BIN('9a35f0de-c2d2-4fd0-a9a2-8d00f9b8c202'), UUID_TO_BIN('6b343128-bccc-46af-a165-2c2552b900b6'), UUID_TO_BIN('f8e9c2d1-4a5b-4c6d-98ee-1a2b3c4d5e6f'), 'Airport export completed; booking anomalies detected for review.', DATE('2025-08-16 12:00:00'), false),
                            (UUID_TO_BIN('d4b9d4a7-7b11-4ac7-a2f4-7ee38ad9c303'), UUID_TO_BIN('699710d1-fa9d-41d4-850a-f2ac31929e08'), UUID_TO_BIN('e7f8c2a3-5b6d-4e7f-9a8b-12c3d4e5f6a7'), 'Missing crew member values should be filled before publication.', DATE('2025-08-17 09:15:00'), true),
                            (UUID_TO_BIN('5f10d8fe-80e8-4ce8-98cf-1d8f3f17d404'), UUID_TO_BIN('98d3a4f0-1463-4f67-9f2a-a31ac4a1b111'), UUID_TO_BIN('1f2e3d4c-5b6a-47c8-9d0e-1a2b3c4d5e66'), 'Booking export completed and passed schema validation.', DATE('2025-08-18 11:10:00'), false),
                            (UUID_TO_BIN('b6f13ab0-9d6f-4ad9-b01c-3f7f90f9e505'), UUID_TO_BIN('a5d7d1ea-908f-4f1d-9340-894fc1b6c222'), UUID_TO_BIN('2a3b4c5d-6e7f-48a9-b0c1-2d3e4f5a6b77'), 'Airport report generated for Denmark routes only.', DATE('2025-08-19 08:40:00'), false),
                            (UUID_TO_BIN('c8ac9a5e-3ebd-4a8f-a845-9c0f5f41f606'), UUID_TO_BIN('b1a0c3d4-e5f6-47a8-90ab-cdef1234d333'), UUID_TO_BIN('3b4c5d6e-7f80-49ba-c1d2-3e4f5a6b7c88'), 'Flight export failed due to timeout while fetching metadata.', DATE('2025-08-20 13:25:00'), false),
                            (UUID_TO_BIN('2b3ee6a2-6f97-4981-8f4a-e9025b0ae707'), UUID_TO_BIN('c2b3d4e5-f6a7-48b9-91bc-def01234e444'), UUID_TO_BIN('4c5d6e7f-8091-4acb-d2e3-4f5a6b7c8d99'), 'User audit export finished successfully with no anomalies.', DATE('2025-08-21 17:05:00'), true),
                            (UUID_TO_BIN('7e518f73-2a4d-4e30-9d5f-1bc838dcf808'), UUID_TO_BIN('d3c4e5f6-a7b8-49ca-a2cd-ef123456f555'), UUID_TO_BIN('5d6e7f80-91a2-4bdc-e3f4-5a6b7c8d9ea0'), 'Notes data export completed and shared with reporting.', DATE('2025-08-22 09:50:00'), false),
                            (UUID_TO_BIN('1a2b3c4d-5e6f-4701-8a9b-0c1d2e3f4001'), UUID_TO_BIN('e1111111-1111-4111-8111-111111111111'), UUID_TO_BIN('b1111111-1111-4111-8111-111111111111'), 'Second flight export batch completed without schema issues.', DATE('2025-08-22 10:10:00'), false),
                            (UUID_TO_BIN('1a2b3c4d-5e6f-4702-8a9b-0c1d2e3f4002'), UUID_TO_BIN('e2222222-2222-4222-8222-222222222222'), UUID_TO_BIN('b2222222-2222-4222-8222-222222222222'), 'Passenger export includes extra nationality filters for QA.', DATE('2025-08-23 11:00:00'), true),
                            (UUID_TO_BIN('1a2b3c4d-5e6f-4703-8a9b-0c1d2e3f4003'), UUID_TO_BIN('e3333333-3333-4333-8333-333333333333'), UUID_TO_BIN('b3333333-3333-4333-8333-333333333333'), 'Airport export validated successfully against current data.', DATE('2025-08-24 09:45:00'), false),
                            (UUID_TO_BIN('1a2b3c4d-5e6f-4704-8a9b-0c1d2e3f4004'), UUID_TO_BIN('e4444444-4444-4444-8444-444444444444'), UUID_TO_BIN('b4444444-4444-4444-8444-444444444444'), 'Crew export failed after upstream timeout; retry planned.', DATE('2025-08-25 16:20:00'), false),
                            (UUID_TO_BIN('1a2b3c4d-5e6f-4705-8a9b-0c1d2e3f4005'), UUID_TO_BIN('e5555555-5555-4555-8555-555555555555'), UUID_TO_BIN('b5555555-5555-4555-8555-555555555555'), 'Booking export completed with pending reservations highlighted.', DATE('2025-08-26 12:30:00'), true),
                            (UUID_TO_BIN('1a2b3c4d-5e6f-4706-8a9b-0c1d2e3f4006'), UUID_TO_BIN('e6666666-6666-4666-8666-666666666666'), UUID_TO_BIN('b6666666-6666-4666-8666-666666666666'), 'Employee export passed internal data quality checks.', DATE('2025-08-27 14:15:00'), true),
                            (UUID_TO_BIN('1a2b3c4d-5e6f-4707-8a9b-0c1d2e3f4007'), UUID_TO_BIN('e7777777-7777-4777-8777-777777777777'), UUID_TO_BIN('b7777777-7777-4777-8777-777777777777'), 'Route export completed and sent to planning team.', DATE('2025-08-28 08:55:00'), false),
                            (UUID_TO_BIN('1a2b3c4d-5e6f-4708-8a9b-0c1d2e3f4008'), UUID_TO_BIN('e8888888-8888-4888-8888-888888888888'), UUID_TO_BIN('b8888888-8888-4888-8888-888888888888'), 'Compliance export failed due to role mapping mismatch.', DATE('2025-08-29 18:05:00'), false),
                            (UUID_TO_BIN('1a2b3c4d-5e6f-4709-8a9b-0c1d2e3f4009'), UUID_TO_BIN('e9999999-9999-4999-8999-999999999999'), UUID_TO_BIN('b9999999-9999-4999-8999-999999999999'), 'Operations export generated successfully for pilot assignments.', DATE('2025-08-30 07:35:00'), false),
                            (UUID_TO_BIN('1a2b3c4d-5e6f-4710-8a9b-0c1d2e3f4010'), UUID_TO_BIN('ea000000-0000-4a00-8a00-000000000000'), UUID_TO_BIN('ba000000-0000-4a00-8a00-000000000000'), 'Weekly digest export completed and archived.', DATE('2025-08-31 19:25:00'), true);

INSERT INTO permission(id, permission_name) VALUES
                            (UUID_TO_BIN('de660928-ecf9-478c-acc6-59194ad49e83'), 'CREATE_EXPORT'),
                            (UUID_TO_BIN('4290c25a-27b1-4ca0-b1f9-e4ca6a4e1e8d'), 'VIEW_EXPORTS'),
                            (UUID_TO_BIN('cf820035-92e9-4611-80e3-72cc65c4b273'), 'VIEW_NOTES'),
                            (UUID_TO_BIN('e781626c-9c15-4bf8-8d9e-7e954e42c886'), 'CREATE_NOTES'),
                            (UUID_TO_BIN('066febe8-ecca-4887-9a62-58a313829844'), 'MANAGE_USERS');

INSERT INTO roles_permissions (role_id, permission_id) VALUES
                                (1, UUID_TO_BIN('de660928-ecf9-478c-acc6-59194ad49e83')), -- CREATE_EXPORT
                                (1, UUID_TO_BIN('4290c25a-27b1-4ca0-b1f9-e4ca6a4e1e8d')), -- VIEW_EXPORTS
                                (1, UUID_TO_BIN('cf820035-92e9-4611-80e3-72cc65c4b273')), -- VIEW_NOTES
                                (1, UUID_TO_BIN('e781626c-9c15-4bf8-8d9e-7e954e42c886')), -- CREATE_NOTES
                                (1, UUID_TO_BIN('066febe8-ecca-4887-9a62-58a313829844')), -- MANAGE_USERS
                                (2, UUID_TO_BIN('de660928-ecf9-478c-acc6-59194ad49e83')), -- CREATE_EXPORT
                                (2, UUID_TO_BIN('4290c25a-27b1-4ca0-b1f9-e4ca6a4e1e8d')), -- VIEW_EXPORTS
                                (2, UUID_TO_BIN('cf820035-92e9-4611-80e3-72cc65c4b273')), -- VIEW_NOTES
                                (2, UUID_TO_BIN('e781626c-9c15-4bf8-8d9e-7e954e42c886')), -- CREATE_NOTES
                                (3, UUID_TO_BIN('4290c25a-27b1-4ca0-b1f9-e4ca6a4e1e8d')), -- VIEW_EXPORTS
                                (3, UUID_TO_BIN('cf820035-92e9-4611-80e3-72cc65c4b273')); -- VIEW_NOTES
