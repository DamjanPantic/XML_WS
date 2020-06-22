package com.programatori.carrental.service.impl;

import com.programatori.carrental.models.Grade;
import com.programatori.carrental.repository.GradeRepository;
import com.programatori.carrental.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeServiceImpl implements GradeService {

    @Autowired
    GradeRepository gradeRepository;

    @Override
    public ResponseEntity<?> getVehicleGradeForUser(Long id) {
        List<Grade> grades = gradeRepository.getVehicleGradesForUser(id);
        if(grades == null)
            return new ResponseEntity<>("grades null", HttpStatus.BAD_REQUEST);


        return new ResponseEntity<>(grades, HttpStatus.OK);

    }
}
