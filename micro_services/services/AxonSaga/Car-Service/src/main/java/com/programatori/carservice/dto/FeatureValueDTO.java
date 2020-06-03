package com.programatori.carservice.dto;

import com.programatori.carservice.models.FeatureValue;
import lombok.Data;

@Data
public class FeatureValueDTO {

    private Long id;
    private String value;
    private FeatureTypeDTO type;

    public FeatureValueDTO(){}

    public FeatureValueDTO(FeatureValue featureValue) {
        this.value = featureValue.getValue();
        this.type = new FeatureTypeDTO(featureValue.getType());
    }
}
