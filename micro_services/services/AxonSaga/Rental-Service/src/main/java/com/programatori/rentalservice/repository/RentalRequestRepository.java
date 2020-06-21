package com.programatori.rentalservice.repository;

import com.programatori.rentalservice.models.RentalRequest;
import com.programatori.rentalservice.models.RentalRequestStatus;
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


    @Query(value = "select r from RentalRequest r where r.ownerId = (:ownerId) and r.status = (:status)")
    List<RentalRequest> findRentalRequestByOwnerIdAndStatus(@Param("ownerId") Long ownerId, @Param("status") RentalRequestStatus status);

    @Query(value = "select r from RentalRequest r where r.status = (:status) ")
    List<RentalRequest> findRentalRequestByStatus(@Param("status") RentalRequestStatus status);

    RentalRequest findOneById(Long id);

    @Query(value = "select count(r) > 0 from RentalRequest r inner join r.vehicleIds v where ((v.vehicleId) = " +
            "(:vehicleId))" +
            "and r.status = 'PAID' and r.toDate < (:toDate) and r.customerId = (:customerId)")
    Boolean findRentalRequestByStatusAndDate(@Param("toDate") Date toDate,
                                                         @Param("customerId") Long customerId,
                                                         @Param("vehicleId") Long vehicleId);


    List<RentalRequest> findByCustomerId(Long customerId);

    List<RentalRequest> findByOwnerId(Long ownerId);
}