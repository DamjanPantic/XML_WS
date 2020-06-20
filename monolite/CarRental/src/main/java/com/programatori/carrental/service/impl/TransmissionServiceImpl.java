package com.programatori.carrental.service.impl;

import com.programatori.carrental.dto.TransmissionDTO;
import com.programatori.carrental.models.Transmission;
import com.programatori.carrental.repository.TransmissionRepository;
import com.programatori.carrental.service.TransmissionService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class TransmissionServiceImpl implements TransmissionService {

    @Autowired
    TransmissionRepository transmissionRepository;

    DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    @Override
    public ResponseEntity<?> getTransmissions() {
        List<Transmission> transmissions = transmissionRepository.findAll();
        if(transmissions == null)
            return new ResponseEntity<>("Transmissios dont exist!", HttpStatus.BAD_REQUEST);

        List<TransmissionDTO> retList = new ArrayList<>();
        for(Transmission t : transmissions)
            retList.add(dozerBeanMapper.map(t, TransmissionDTO.class));

        return new ResponseEntity<>(retList,HttpStatus.OK);
    }

}
