package com.programatori.carrental.repository;

import com.programatori.carrental.models.Grade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface GradeRepository extends JpaRepository<Grade, Long> {

    @Query(value = "select g from Grade g inner join g.vehicle v where ((v.owner.id) = " +
            "(:owner))")
    List<Grade> getVehicleGradesForUser(@Param("owner") Long owner);
}