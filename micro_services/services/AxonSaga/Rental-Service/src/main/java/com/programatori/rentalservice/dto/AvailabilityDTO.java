package com.programatori.rentalservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class AvailabilityDTO {

    private Long id;

    private String place;

    private Date fromDate;

    private Date toDate;
}
