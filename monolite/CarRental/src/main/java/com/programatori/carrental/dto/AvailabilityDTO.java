package com.programatori.carrental.dto;

import com.programatori.carrental.models.Availability;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class AvailabilityDTO {

    private Long id;
    private String place;
    private String fromDate;
    private String toDate;

}
