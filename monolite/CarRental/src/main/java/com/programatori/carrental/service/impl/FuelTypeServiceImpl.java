package com.programatori.carrental.service.impl;

import com.programatori.carrental.dto.FuelTypeDTO;
import com.programatori.carrental.models.FuelType;
import com.programatori.carrental.repository.FuelTypeRepository;
import com.programatori.carrental.service.FuelTypeService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class FuelTypeServiceImpl implements FuelTypeService {


    @Autowired
    FuelTypeRepository fuelTypeRepository;

    DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    @Override
    public ResponseEntity<?> getFuelTypes() {
        List<FuelType> fuelTypes = fuelTypeRepository.findAll();
        if(fuelTypes == null)
            return new ResponseEntity<>("FuelTypes dont exist!", HttpStatus.BAD_REQUEST);

        List<FuelTypeDTO> retList = new ArrayList<>();
        for(FuelType f : fuelTypes)
            retList.add(dozerBeanMapper.map(f, FuelTypeDTO.class));

        return new ResponseEntity<>(retList,HttpStatus.OK);    }

}
