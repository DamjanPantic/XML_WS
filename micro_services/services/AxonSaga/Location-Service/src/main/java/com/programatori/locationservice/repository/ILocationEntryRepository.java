package com.programatori.locationservice.repository;

import com.programatori.locationservice.models.LocationEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ILocationEntryRepository extends JpaRepository<LocationEntry,Long> {

}
