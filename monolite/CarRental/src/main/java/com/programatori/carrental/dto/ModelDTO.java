package com.programatori.carrental.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class ModelDTO {

    private Long id;
    private String name;
    private ManufacturerDTO manufacturer;

}
