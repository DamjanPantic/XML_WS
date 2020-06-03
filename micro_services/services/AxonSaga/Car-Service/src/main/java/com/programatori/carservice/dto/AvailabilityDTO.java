package com.programatori.carservice.dto;

import com.programatori.carservice.models.Availability;
import lombok.Data;

import java.util.Date;

@Data
public class AvailabilityDTO {

    private Long id;
    private String place;
    private Date fromDate;
    private Date toDate;

    public  AvailabilityDTO(){}

    public AvailabilityDTO(Availability availability) {
        this.place = availability.getPlace();
        this.fromDate = availability.getFromDate();
        this.toDate = availability.getToDate();
    }
}
