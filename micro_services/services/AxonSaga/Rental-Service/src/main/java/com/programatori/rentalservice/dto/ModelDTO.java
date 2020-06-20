package com.programatori.rentalservice.dto;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ModelDTO {

    private Long id;
    private String name;
    private ManufacturerDTO manufacturer;
}
