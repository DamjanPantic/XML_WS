package com.programatori.carrental.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class PriceDTO {

    private Long id;
    private String value;
    private PriceTypeDTO type;

}
