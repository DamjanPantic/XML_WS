package com.programatori.carservice.repository;

import com.programatori.carservice.dto.AvailabilityDTO;
import com.programatori.carservice.models.Availability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AvailabilityRepository extends JpaRepository<Availability, Long> {

    Set<AvailabilityDTO> findByVehicleId(Long id);
}
