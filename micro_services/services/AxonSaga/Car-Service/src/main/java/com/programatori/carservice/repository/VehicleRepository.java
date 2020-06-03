package com.programatori.carservice.repository;

import com.programatori.carservice.models.User;
import com.programatori.carservice.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    Vehicle findByCarToken(String token);
    List<Vehicle> findAllByOwner(User user);
}