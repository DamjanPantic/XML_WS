INSERT INTO agentdb.manufacturer (name) VALUES
("Porshe"), ("Mercedes-Benz"), ("Audi"), ("BMW"), ("VW");

INSERT INTO agentdb.model (name, manufacturer_id) VALUES
("911", 1), ("Cayenne", 1), ("Panamera", 1),
("C220", 2), ("GLE320", 2), ("Maybach", 2),
("Q8", 3), ("A4", 3), ("RS6", 3),
("X4", 4), ("M6", 4), ("118", 4),
("Golf", 5), ("Tiguan", 5), ("Polo", 5);

INSERT INTO agentdb.price_type (name) VALUES
("DAY"), ("KILOMETER");

INSERT INTO agentdb.user (email, username, password) VALUES
("mail@mail.com", "mile", "123"),
("mail1@mail.com", "mile1", "123");

INSERT INTO agentdb.transmission (name)
VALUES ("Manual gearbox"),
       ("Semi-automatic"),
       ("Automatic transmission");

INSERT INTO agentdb.vehicle_type (type)
VALUES ("Cabriolet"),
       ("Estate car"),
       ("Saloon"),
       ("Small car"),
       ("Sports car"),
       ("SUV");

INSERT INTO agentdb.fuel_type (type)
VALUES ("Petrol"),
       ("Diesel"),
       ("Electric"),
       ("Hybrid (petrol/electric)"),
       ("Hybrid (diesel/electric)"),
       ("LPG");

insert into agentdb.rental_request (from_date, owner_id, status, to_date, customer_id) VALUES
('2020-02-10 07:00:00',1,'RESERVED','2020-02-10 10:00:00',2);


INSERT INTO agentdb.vehicle
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

insert into agentdb.comment (comment_status, content, user_id,vehicle_id) VALUES
('APPROVED','asd',1,1),
('APPROVED','asd',1,1),
('APPROVED','asd',1,1);

insert into agentdb.grade ( grade_value, user_id,vehicle_id) VALUES
(1,1,1),
(3,1,1),
(5,1,1);


