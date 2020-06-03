package com.programatori.carservice.repository;

import com.programatori.carservice.models.LocationEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LocationEntryRepository extends JpaRepository<LocationEntry, Long> {
}
