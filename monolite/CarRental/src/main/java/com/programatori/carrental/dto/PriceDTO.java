package com.programatori.carrental.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class PriceDTO {

    private Long id;
    private String value;
    private PriceTypeDTO type;

}
