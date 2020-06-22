package com.programatori.carrental.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class RentalReportDTO {
    private Double distance;
    private String info;
    private Long vehicleId;
    private Long requestId;
}
