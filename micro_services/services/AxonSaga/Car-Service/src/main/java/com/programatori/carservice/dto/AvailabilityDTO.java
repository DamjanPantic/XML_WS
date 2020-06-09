package com.programatori.carservice.dto;

import com.programatori.carservice.models.Availability;
import lombok.Data;

@Data
public class AvailabilityDTO {

    private Long id;
    private String place;
    private String fromDate;
    private String toDate;

    public  AvailabilityDTO(){}

    public AvailabilityDTO(Availability availability) {
        this.place = availability.getPlace();
        this.fromDate = availability.getFromDate().toString();
        this.toDate = availability.getToDate().toString();
    }
}
