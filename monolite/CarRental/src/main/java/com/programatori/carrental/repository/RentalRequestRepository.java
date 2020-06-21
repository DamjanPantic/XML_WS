package com.programatori.carrental.repository;

import com.programatori.carrental.models.RentalRequest;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface RentalRequestRepository extends JpaRepository<RentalRequest, Long> {

    @Query(value = "select r from RentalRequest r" +
            " inner join r.vehicles v where ((v.id) = (:vehicleId))" +
            "and ( ((r.fromDate) >= (:fromDate) and (r.fromDate) <= (:toDate)) or ((r.toDate) >= (:fromDate) and (r" +
            ".toDate) <= (:toDate)) or ((r.fromDate) <= (:fromDate) and (r.toDate) >= (:toDate)))"
    )
    List<RentalRequest> findInvalidRentals(@Param("vehicleId") Long vehicleId, @Param("fromDate") Date fromDate,
                                           @Param("toDate") Date toDate);


}
