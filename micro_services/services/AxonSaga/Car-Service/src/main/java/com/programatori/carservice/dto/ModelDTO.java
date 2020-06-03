package com.programatori.carservice.dto;

import com.programatori.carservice.models.Model;
import lombok.Data;

@Data
public class ModelDTO {

    private Long id;
    private String name;
    private ManufacturerDTO manufacturer;

    public ModelDTO(){}

    public ModelDTO(Model model) {
        this.name = model.getName();
        this.manufacturer = new ManufacturerDTO(model.getManufacturer());
    }
}
