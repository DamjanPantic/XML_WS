package com.programatori.carservice.repository;

import com.programatori.carservice.models.Availability;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AvailabilityRepository extends JpaRepository<Availability, Long> {

}
