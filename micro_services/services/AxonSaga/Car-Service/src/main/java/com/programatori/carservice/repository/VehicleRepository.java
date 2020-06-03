package com.programatori.carservice.repository;

import com.programatori.carservice.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Vehicle findByCarToken(String token);
}