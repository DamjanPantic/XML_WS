package com.programatori.carservice.dto;

import com.programatori.carservice.models.LocationEntry;
import lombok.Data;

@Data
public class LocationEntryDTO {

    private Double lat;
    private Double lng;

    public LocationEntryDTO(LocationEntry locationEntry) {
        this.lat = locationEntry.getLat();
        this.lng = locationEntry.getLng();
    }
}
