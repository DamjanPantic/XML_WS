package com.programatori.carservice.repository;

import com.programatori.carservice.models.FeatureType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureTypeRepository extends JpaRepository<FeatureType, Long> {
    FeatureType findByName(String name);
}
