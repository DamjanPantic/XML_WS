package com.programatori.recensionservice.service.impl;

import com.programatori.recensionservice.client.RentalClient;
import com.programatori.recensionservice.models.Grade;
import com.programatori.recensionservice.repository.GradeRepository;
import com.programatori.recensionservice.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    RentalClient rentalClient;

    @Autowired
    GradeRepository gradeRepository;

    @Override
    public ResponseEntity<?> addGrade(Grade grade) {

        Boolean exist = rentalClient.getRentalRequestByParams(grade.getUserId(),grade.getVehicleId());
        if(!exist)
            return new ResponseEntity<>("You cant grade this vehicle", HttpStatus.BAD_REQUEST);

        if(!gradeRepository.existsGradeByUserIdAndVehicleId(grade.getUserId(),grade.getVehicleId())){
            gradeRepository.save(grade);
            return new ResponseEntity<>(grade,HttpStatus.OK);
        }

        return new ResponseEntity<>("You have already rated the vehicle", HttpStatus.BAD_REQUEST);
    }
}
