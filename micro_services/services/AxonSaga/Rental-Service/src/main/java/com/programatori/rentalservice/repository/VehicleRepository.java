package com.programatori.rentalservice.repository;

import com.programatori.rentalservice.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle,Long> {
    Vehicle findByVehicleId(Long vehicleId);
}
