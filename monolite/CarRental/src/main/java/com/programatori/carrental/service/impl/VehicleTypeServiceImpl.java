package com.programatori.carrental.service.impl;

import com.programatori.carrental.dto.VehicleTypeDTO;
import com.programatori.carrental.models.VehicleType;
import com.programatori.carrental.repository.VehicleTypeRepository;
import com.programatori.carrental.service.VehicleTypeService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class VehicleTypeServiceImpl implements VehicleTypeService {

    @Autowired
    VehicleTypeRepository vehicleTypeRepository;

    DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    @Override
    public ResponseEntity<?> getVehicleTypes() {
        List<VehicleType> vehicleTypes = vehicleTypeRepository.findAll();
        if(vehicleTypes == null)
            return new ResponseEntity<>("VehicleTypes dont exist!", HttpStatus.BAD_REQUEST);

        List<VehicleTypeDTO> retList = new ArrayList<>();
        for(VehicleType v : vehicleTypes)
            retList.add(dozerBeanMapper.map(v, VehicleTypeDTO.class));

        return new ResponseEntity<>(retList,HttpStatus.OK);
    }
}
