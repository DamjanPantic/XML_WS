package com.programatori.carservice.dto;

import com.programatori.carservice.models.FeatureType;
import lombok.Data;

@Data
public class FeatureTypeDTO {

    private String name;

    public FeatureTypeDTO() {
    }

    public FeatureTypeDTO(FeatureType featureType) {
        this.name = featureType.getName();
    }
}
