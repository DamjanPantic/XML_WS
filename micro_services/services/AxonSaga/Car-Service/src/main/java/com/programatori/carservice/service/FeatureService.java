package com.programatori.carservice.service;

import com.programatori.carservice.dto.FeatureTypeDTO;
import com.programatori.carservice.dto.FeatureValueDTO;

import java.util.Set;

public interface FeatureService {

    public Set<FeatureTypeDTO> addFeatureType(FeatureTypeDTO featureTypeDTO);
    public Set<FeatureTypeDTO> updateFeatureType(String name, FeatureTypeDTO featureTypeDTO);
    public Boolean deleteFeatureType(String name);
    public Set<FeatureTypeDTO> getAllFeatureTypes();

    public Set<FeatureValueDTO> addFeatureValue(FeatureValueDTO featureValueDTO);
    public Set<FeatureValueDTO> updateFeatureValue(String value, FeatureValueDTO featureValueDTO);
    public Boolean deleteFeatureValue(String value);
    public Set<FeatureValueDTO> getAllFeatureValues();
    public Set<FeatureValueDTO> getFeatureValuesofType(String name);
}
