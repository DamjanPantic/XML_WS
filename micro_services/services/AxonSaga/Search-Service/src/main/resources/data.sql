INSERT INTO users.feature_type_search_service (name)
VALUES ("FUEL"),
       ("TRANSMISSION"),
       ("CLASS");

INSERT INTO users.feature_value_search_service (value, type_id)
VALUES ("DISEL", 1),
       ("PETROL", 1),
       ("LPG", 1),
       ("AUTOMATIC", 2),
       ("MANUAL", 2),
       ("SEMI-AUTOMATIC", 2),
       ("COUPE", 3),
       ("SUV", 3),
       ("SALOON", 3),
       ("CABBRIOLET", 3),
       ("ESTATE", 3);

INSERT INTO users.manufacturer_search_service (name)
VALUES ("Porshe"),
       ("Mercedes-Benz"),
       ("Audi"),
       ("BMW"),
       ("VW");

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
 owner_id)
VALUES ('', true, 2, 'NO_LIMIT', 20000.0, 1, 1),
       ('', false, 2, 'NO_LIMIT', 20000.0, 3, 2);

INSERT INTO users.availability_search_service
    (from_date, to_date, place, vehicle_id)
VALUES ('2020-02-10 07:00:00', '2020-02-16 07:00:00', 'Novi Sad', 1),
       ('2020-02-10 07:00:00', '2020-02-16 07:00:00', 'Novi Sad', 2);

INSERT INTO users.vehicle_features_search_service
    (vehicle_id, feature_id)
VALUES (1, 2),
       (2, 1),
       (2, 4);