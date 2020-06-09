package com.programatori.rentalservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
public class RentalRequestDTO {
    private Long id;
    private Long ownerId;
    private Long customerId;
    private String fromDate;
    private String toDate;
    private Boolean bundle;
    private Long vehicleId;

}
