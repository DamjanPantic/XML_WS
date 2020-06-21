package com.programatori.carservice.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
public class VehicleModelDTO {
    private Long id;
    private ModelDTO model;
}
