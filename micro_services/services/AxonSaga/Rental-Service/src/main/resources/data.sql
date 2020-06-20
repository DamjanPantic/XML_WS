insert into users.rental_request_rental_service (from_date, owner_id, status, to_date, customer_id) VALUES
('2020-02-10 07:00:00',1,'RESERVED','2020-02-10 07:00:00',2);

insert into users.vehicle_rental_service (vehicle_id) VALUES
(1);

insert into users.rental_request_vehicles_rental_service (rental_request_id,vehicle_id) VALUES
(1,1);

