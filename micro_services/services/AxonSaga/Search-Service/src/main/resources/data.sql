INSERT INTO users.manufacturer_search_service (name)
VALUES ("Porshe"),
       ("Mercedes-Benz"),
       ("Audi"),
       ("BMW"),
       ("VW");

INSERT INTO users.transmission_search_service (name)
VALUES ("Manual gearbox"),
       ("Semi-automatic"),
       ("Automatic transmission");

INSERT INTO users.vehicle_type_search_service (type)
VALUES ("Cabriolet"),
       ("Estate car"),
       ("Saloon"),
       ("Small car"),
       ("Sports car"),
       ("SUV");

INSERT INTO users.fuel_type_search_service (type)
VALUES ("Petrol"),
       ("Diesel"),
       ("Electric"),
       ("Hybrid (petrol/electric)"),
       ("Hybrid (diesel / electric)"),
       ("LPG");


INSERT INTO users.model_search_service (name, manufacturer_id)
VALUES ("911", 1),
       ("Cayenne", 1),
       ("Panamera", 1),
       ("C220", 2),
       ("GLE320", 2),
       ("Maybach", 2),
       ("Q8", 3),
       ("A4", 3),
       ("RS6", 3),
       ("X4", 4),
       ("M6", 4),
       ("118", 4),
       ("Golf", 5),
       ("Tiguan", 5),
       ("Polo", 5);

INSERT INTO users.price_type_search_service (name)
VALUES ("DAY"),
       ("KILOMETER");

INSERT INTO users.user_search_service (email, username)
VALUES ("mail@mail.com", "mile"),
       ("mail1@mail.com", "mile1");

INSERT INTO users.vehicle_search_service
(car_token,
 cdw,
 kids_seats_no,
 limit_km,
 traveled_km,
 model_id,
 owner_id, fuel_type_id, transmission_id, vehicle_type_id)
VALUES ('', true, 2, 'NO_LIMIT', 20000.0, 1, 1,1,2,3),
       ('', false, 2, 'NO_LIMIT', 20000.0, 3, 2,3,1,2),
       ('', false, 2, 'NO_LIMIT', 20000.0, 3, 2,3,1,2),
       ('', false, 2, 'NO_LIMIT', 20000.0, 3, 2,3,1,2),
       ('', false, 2, 'NO_LIMIT', 20000.0, 3, 2,3,1,2),
       ('', false, 2, 'NO_LIMIT', 20000.0, 3, 2,3,1,2),
       ('', false, 2, 'NO_LIMIT', 20000.0, 3, 2,3,1,2),
       ('', false, 2, 'NO_LIMIT', 20000.0, 3, 2,3,1,2),
       ('', false, 2, 'NO_LIMIT', 20000.0, 3, 2,3,1,2),
       ('', false, 2, 'NO_LIMIT', 20000.0, 3, 2,3,1,2),
       ('', false, 2, 'NO_LIMIT', 20000.0, 3, 2,3,1,2),
       ('', false, 2, 'NO_LIMIT', 20000.0, 3, 2,3,1,2),
       ('', false, 2, 'NO_LIMIT', 20000.0, 3, 2,3,1,2);

INSERT INTO users.availability_search_service
    (from_date, to_date, place, vehicle_id)
VALUES ('2020-02-10 07:00:00', '2020-02-16 07:00:00', 'Novi Sad', 1),
       ('2020-02-10 07:00:00', '2020-02-16 07:00:00', 'Novi Sad', 2),
       ('2020-02-10 07:00:00', '2020-02-16 07:00:00', 'Novi Sad', 3),
       ('2020-02-10 07:00:00', '2020-02-16 07:00:00', 'Novi Sad', 4),
       ('2020-02-10 07:00:00', '2020-02-16 07:00:00', 'Novi Sad', 5),
       ('2020-02-10 07:00:00', '2020-02-16 07:00:00', 'Novi Sad', 6),
       ('2020-02-10 07:00:00', '2020-02-16 07:00:00', 'Novi Sad', 7),
       ('2020-02-10 07:00:00', '2020-02-16 07:00:00', 'Novi Sad', 8),
       ('2020-02-10 07:00:00', '2020-02-16 07:00:00', 'Novi Sad', 9),
       ('2020-02-10 07:00:00', '2020-02-16 07:00:00', 'Novi Sad', 10),
       ('2020-02-10 07:00:00', '2020-02-16 07:00:00', 'Novi Sad', 11),
       ('2020-02-10 07:00:00', '2020-02-16 07:00:00', 'Novi Sad', 12),
       ('2020-02-10 07:00:00', '2020-02-16 07:00:00', 'Novi Sad', 13);
