package com.programatori.rentalservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class ApproveDenyRequestDTO {

    private long vehicleId;
    private boolean approve;
    private long requestId;

}
