package com.programatori.rentalservice.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VehicleBasicDTO {
    private Long id;
    private ModelDTO model;
    private Set<FeatureValueDTO> features;
}
