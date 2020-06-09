package com.programatori.rentalservice.repository;

import com.programatori.rentalservice.models.RentalRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface RentalRequestRepository extends JpaRepository<RentalRequest,Long> {


    @Query(value = "select r from RentalRequest r" +
            " inner join r.vehicleIds v where ((v.vehicleId) = (:vehicleId))" +
            "and ( ((r.fromDate) >= (:fromDate) and (r.fromDate) <= (:toDate)) or ((r.toDate) >= (:fromDate) and (r" +
            ".toDate) <= (:toDate)) or ((r.fromDate) <= (:fromDate) and (r.toDate) >= (:toDate)))"
    )
    List<RentalRequest> findInvalidRentals(@Param("vehicleId") Long vehicleId, @Param("fromDate") Date fromDate,
                                           @Param("toDate") Date toDate);
}