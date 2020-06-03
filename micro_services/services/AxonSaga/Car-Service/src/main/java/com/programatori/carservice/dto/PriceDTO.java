package com.programatori.carservice.dto;

import com.programatori.carservice.models.Price;
import lombok.Data;

@Data
public class PriceDTO {

    private String value;
    private PriceTypeDTO type;

    public PriceDTO(Price price) {
        this.value = price.getValue();
        this.type = new PriceTypeDTO(price.getType());
    }
}
