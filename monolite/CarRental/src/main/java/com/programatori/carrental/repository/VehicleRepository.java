package com.programatori.carrental.repository;

import com.programatori.carrental.models.User;
import com.programatori.carrental.models.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VehicleRepository extends JpaRepository<Vehicle, Long> {
    List<Vehicle> findAllByOwner(User user);

}
