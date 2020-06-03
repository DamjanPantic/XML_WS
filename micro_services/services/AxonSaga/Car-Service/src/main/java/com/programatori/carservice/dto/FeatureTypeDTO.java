package com.programatori.carservice.dto;

import com.programatori.carservice.models.FeatureType;
import lombok.Data;

@Data
public class FeatureTypeDTO {

    private Long id;
    private String name;

<<<<<<< HEAD
    public FeatureTypeDTO() {
    }
=======
    public FeatureTypeDTO(){}
>>>>>>> car/ads

    public FeatureTypeDTO(FeatureType featureType) {
        this.name = featureType.getName();
    }
}
