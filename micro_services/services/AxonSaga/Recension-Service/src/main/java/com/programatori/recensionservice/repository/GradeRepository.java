package com.programatori.recensionservice.repository;

import com.programatori.recensionservice.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;

public interface GradeRepository extends JpaRepository<Grade, Long> {

    Boolean existsGradeByUserIdAndVehicleId(Long userId, Long vehicleId);
}
