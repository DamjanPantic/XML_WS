package com.programatori.carservice.service.impl;

import com.programatori.carservice.dto.FeatureTypeDTO;
import com.programatori.carservice.dto.FeatureValueDTO;
import com.programatori.carservice.models.FeatureType;
import com.programatori.carservice.models.FeatureValue;
import com.programatori.carservice.repository.FeatureTypeRepository;
import com.programatori.carservice.repository.FeatureValueRepository;
import com.programatori.carservice.service.FeatureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class FeatureServiceImpl implements FeatureService {

    @Autowired
    private FeatureTypeRepository featureTypeRepository;

    @Autowired
    private FeatureValueRepository featureValueRepository;

    @Override
    public Set<FeatureTypeDTO> addFeatureType(FeatureTypeDTO featureTypeDTO) {
        FeatureType featureType = featureTypeRepository.findByName(featureTypeDTO.getName());
        if (featureType != null){
            return null;
        }

        featureType = new FeatureType();
        featureType.setName(featureTypeDTO.getName());
        featureTypeRepository.save(featureType);

        return getAllFeatureTypes();
    }

    @Override
    public Set<FeatureTypeDTO> updateFeatureType(String name, FeatureTypeDTO featureTypeDTO) {
        FeatureType featureType = featureTypeRepository.findByName(name);
        if (featureType == null){
            return null;
        }

        featureType.setName(featureTypeDTO.getName());
        featureTypeRepository.save(featureType);

        return getAllFeatureTypes();
    }

    @Override
    public Boolean deleteFeatureType(String name) {
        FeatureType featureType = featureTypeRepository.findByName(name);
        if (featureType == null){
            return false;
        }

        featureTypeRepository.delete(featureType);

        return true;
    }

    @Override
    public Set<FeatureTypeDTO> getAllFeatureTypes() {
        List<FeatureType> featureTypes = featureTypeRepository.findAll();
        Set<FeatureTypeDTO> featureTypesDTO = new HashSet<>();
        for (FeatureType featureType: featureTypes) {
            featureTypesDTO.add(new FeatureTypeDTO(featureType));
        }

        return featureTypesDTO;
    }

    @Override
    public Set<FeatureValueDTO> addFeatureValue(FeatureValueDTO featureValueDTO) {
        FeatureType featureType = featureTypeRepository.findByName(featureValueDTO.getType().getName());
        FeatureValue featureValue = featureValueRepository.findByValue(featureValueDTO.getValue());
        if (featureType == null || featureValue != null){
            return null;
        }

        featureValue = new FeatureValue();
        featureValue.setValue(featureValueDTO.getValue());
        featureValue.setType(featureType);

        featureValueRepository.save(featureValue);

        return getAllFeatureValues();
    }

    @Override
    public Set<FeatureValueDTO> updateFeatureValue(String value, FeatureValueDTO featureValueDTO) {
        FeatureValue featureValue = featureValueRepository.findByValue(value);
        if (featureValue == null){
            return null;
        }

        featureValue.setValue(featureValueDTO.getValue());

        featureValueRepository.save(featureValue);

        return getAllFeatureValues();
    }

    @Override
    public Boolean deleteFeatureValue(String value) {
        FeatureValue featureValue = featureValueRepository.findByValue(value);
        if (featureValue == null){
            return false;
        }

        featureValueRepository.delete(featureValue);

        return true;
    }

    @Override
    public Set<FeatureValueDTO> getAllFeatureValues() {
        List<FeatureValue> featureValues = featureValueRepository.findAll();
        Set<FeatureValueDTO> featureValuesDTO = new HashSet<>();
        for (FeatureValue featureValue: featureValues){
            featureValuesDTO.add(new FeatureValueDTO(featureValue));
        }

        return featureValuesDTO;
    }

    @Override
    public Set<FeatureValueDTO> getFeatureValuesofType(String name) {
        FeatureType featureType = featureTypeRepository.findByName(name);
        Set<FeatureValueDTO> featureValuesDTO = new HashSet<>();
        if (featureType == null){
            return null;
        }

        for (FeatureValue featureValue: featureType.getValues()) {
            featureValuesDTO.add(new FeatureValueDTO(featureValue));
        }

        return featureValuesDTO;
    }
}
