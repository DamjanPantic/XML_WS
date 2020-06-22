package com.programatori.carrental.service;

import org.springframework.http.ResponseEntity;

public interface GradeService {
    ResponseEntity<?> getVehicleGradeForUser(Long id);
}
