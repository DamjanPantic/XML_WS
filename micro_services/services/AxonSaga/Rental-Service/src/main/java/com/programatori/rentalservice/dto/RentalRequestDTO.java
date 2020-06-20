package com.programatori.rentalservice.dto;

import com.programatori.rentalservice.models.RentalRequestStatus;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RentalRequestDTO {
    private Long id;
    private Long ownerId;
    private Long customerId;
    private String fromDate;
    private String toDate;
    private Boolean bundle;
    private Long vehicleId;
    private RentalRequestStatus status;

    public  RentalRequestDTO(){}

}
