package com.programatori.recensionservice.service;

import com.programatori.recensionservice.models.Grade;
import org.springframework.http.ResponseEntity;

public interface GradeService {

    public ResponseEntity<?> addGrade(Grade grade);
    public ResponseEntity<?> getVehicleRating(Long id);
    public ResponseEntity<?> getVehicleGradeByUser(Long vehicleId,Long userId);

}
