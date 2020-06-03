package com.programatori.carservice.dto;

import com.programatori.carservice.models.Manufacturer;
import lombok.Data;

@Data
public class ManufacturerDTO {

    private Long id;
    private String name;

    public ManufacturerDTO(){}

    public ManufacturerDTO(Manufacturer manufacturer) {
        this.name = manufacturer.getName();
    }
}
