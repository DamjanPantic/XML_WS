INSERT INTO users.feature_type_car_service (name) VALUES
("FUEL"), ("TRANSMISSION"), ("CLASS");

INSERT INTO users.feature_value_car_service (value, type_id) VALUES
("DISEL", 1), ("PETROL", 1), ("LPG", 1),
("AUTOMATIC", 2), ("MANUAL", 2), ("SEMI-AUTOMATIC", 2),
("COUPE", 3), ("SUV", 3), ("SALOON", 3), ("CABBRIOLET", 3), ("ESTATE", 3);

INSERT INTO users.manufacturer_car_service (name) VALUES
("Porshe"), ("Mercedes-Benz"), ("Audi"), ("BMW"), ("VW");

INSERT INTO users.model_car_service (name, manufacturer_id) VALUES
("911", 1), ("Cayenne", 1), ("Panamera", 1),
("C220", 2), ("GLE320", 2), ("Maybach", 2),
("Q8", 3), ("A4", 3), ("RS6", 3),
("X4", 4), ("M6", 4), ("118", 4),
("Golf", 5), ("Tiguan", 5), ("Polo", 5);

INSERT INTO users.price_type_car_service (name) VALUES
("DAY"), ("KILOMETER");