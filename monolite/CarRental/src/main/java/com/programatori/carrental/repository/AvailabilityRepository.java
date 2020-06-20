package com.programatori.carrental.repository;

import com.programatori.carrental.dto.AvailabilityDTO;
import com.programatori.carrental.models.Availability;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Set;

public interface AvailabilityRepository extends JpaRepository<Availability, Long> {

    Set<AvailabilityDTO> findByVehicleId(Long id);

}
