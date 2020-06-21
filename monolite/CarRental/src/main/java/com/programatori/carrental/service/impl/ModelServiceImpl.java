package com.programatori.carrental.service.impl;

import com.programatori.carrental.dto.ModelDTO;
import com.programatori.carrental.models.Manufacturer;
import com.programatori.carrental.models.Model;
import com.programatori.carrental.repository.ManufacturerRepository;
import com.programatori.carrental.repository.ModelRepository;
import com.programatori.carrental.service.ModelService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ModelServiceImpl implements ModelService {

    @Autowired
    ModelRepository modelRepository;

    @Autowired
    ManufacturerRepository manufacturerRepository;

    DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    @Override
    public ResponseEntity<?> getModelsByManufacturer(String name) {
        Manufacturer manufacturer = manufacturerRepository.findByName(name);
        if(manufacturer == null)
            return new ResponseEntity<>("Manufacturer doesn't exist!", HttpStatus.BAD_REQUEST);

        List<Model> models = modelRepository.findByManufacturer(manufacturer);
        if(models == null)
            return new ResponseEntity<>("Models don't exist!", HttpStatus.BAD_REQUEST);


        List<ModelDTO> retList = new ArrayList<>();
        for(Model m : models)
            retList.add(dozerBeanMapper.map(m, ModelDTO.class));

        return new ResponseEntity<>(retList,HttpStatus.OK);
    }
}
