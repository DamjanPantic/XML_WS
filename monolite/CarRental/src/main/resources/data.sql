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

INSERT INTO agentdb.user (email, username) VALUES
("mail@mail.com", "mile"),
("mail1@mail.com", "mile1");

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


