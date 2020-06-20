package com.programatori.carrental.service.impl;

import com.programatori.carrental.dto.ManufacturerDTO;
import com.programatori.carrental.models.Manufacturer;
import com.programatori.carrental.repository.ManufacturerRepository;
import com.programatori.carrental.service.ManufacturerService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ManufacturerServiceImpl implements ManufacturerService {

    @Autowired
    ManufacturerRepository manufacturerRepository;

    DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    @Override
    public ResponseEntity<?> getAllManufacturers() {
        List<Manufacturer> manufacturers = manufacturerRepository.findAll();
        if(manufacturers == null)
            return new ResponseEntity<>("Manufacturers null", HttpStatus.BAD_REQUEST);

        List<ManufacturerDTO> retList = new ArrayList<>();
        for(Manufacturer m : manufacturers)
            retList.add(dozerBeanMapper.map(m, ManufacturerDTO.class));

        return new ResponseEntity<>(retList,HttpStatus.OK);    }
}
