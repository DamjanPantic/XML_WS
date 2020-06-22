package com.programatori.carrental.repository;

import com.programatori.carrental.models.Image;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ImageRepository extends JpaRepository<Image, Long> {
    List<Image> findAllByVehicleId(Long vehicleId);
}
