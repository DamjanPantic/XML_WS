package com.programatori.carservice.dto;

import com.programatori.carservice.models.PriceType;
import lombok.Data;

@Data
public class PriceTypeDTO {

    private Long id;
    private String name;

    public PriceTypeDTO(){}

    public PriceTypeDTO(PriceType priceType) {
        this.name = priceType.getName();
    }
}
