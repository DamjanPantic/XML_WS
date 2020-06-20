package com.programatori.carservice.dto;

import com.programatori.carservice.models.Image;
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
