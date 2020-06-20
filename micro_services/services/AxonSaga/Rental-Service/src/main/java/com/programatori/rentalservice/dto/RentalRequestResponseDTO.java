package com.programatori.rentalservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RentalRequestResponseDTO {
    private Long id;
    private UserDTO owner;
    private UserDTO issuer;
    private VehicleBasicDTO vehicleBasicDTO;
    private Date fromDate;
    private Date toDate;
}
