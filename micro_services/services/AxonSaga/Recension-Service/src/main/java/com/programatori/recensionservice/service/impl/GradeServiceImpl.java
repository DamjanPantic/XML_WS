package com.programatori.recensionservice.service.impl;

import com.programatori.recensionservice.client.RentalClient;
import com.programatori.recensionservice.models.Grade;
import com.programatori.recensionservice.repository.GradeRepository;
import com.programatori.recensionservice.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

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
            Double rating = 0.0;
            List<Grade> grades = gradeRepository.findByVehicleId(grade.getVehicleId());
            for(Grade g : grades){
                rating+=g.getGradeValue();
            }
            rating=rating/grades.size();
            return new ResponseEntity<>(rating,HttpStatus.OK);
        }

        return new ResponseEntity<>("You have already rated the vehicle", HttpStatus.BAD_REQUEST);
    }

    @Override
    public ResponseEntity<?> getVehicleRating(Long id) {
        Double rating = 0.0;
        List<Grade> grades = gradeRepository.findByVehicleId(id);
        if(grades == null)
            return new ResponseEntity<>("This vehicle dont have rating", HttpStatus.BAD_REQUEST);

        for(Grade g : grades){
            rating+=g.getGradeValue();
        }
        rating=rating/grades.size();
        return new ResponseEntity<>(rating,HttpStatus.OK);
    }

    @Override
    public ResponseEntity<?> getVehicleGradeByUser(Long vehicleId, Long userId) {
        Grade grade = gradeRepository.findByVehicleIdAndUserId(vehicleId, userId);
        if(grade == null)
            return new ResponseEntity<>("Grade dont exist", HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(grade.getGradeValue(),HttpStatus.OK);
    }
}
