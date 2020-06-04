package com.programatori.rentalservice.repository;

import com.programatori.rentalservice.models.RentalRequest;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRequestRepository extends JpaRepository<RentalRequest,Long> {
}
