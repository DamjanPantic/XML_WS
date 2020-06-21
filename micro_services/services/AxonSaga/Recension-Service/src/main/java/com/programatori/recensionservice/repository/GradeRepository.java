package com.programatori.recensionservice.repository;

import com.programatori.recensionservice.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {

    Boolean existsGradeByUserIdAndVehicleId(Long userId, Long vehicleId);
    List<Grade> findByVehicleId(Long id);
    Grade findByVehicleIdAndUserId(Long vehicleId, Long userId);
}