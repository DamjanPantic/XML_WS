package com.programatori.messageservice.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RentalRequestDTO {
    private Long id;
    private Long ownerId;
    private Long customerId;
    private String fromDate;
    private String toDate;
    private Boolean bundle;
    private Long vehicleId;
    private String status;

    public RentalRequestDTO(){}

}
