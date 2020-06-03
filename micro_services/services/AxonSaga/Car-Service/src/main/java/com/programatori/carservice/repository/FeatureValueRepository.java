package com.programatori.carservice.repository;

import com.programatori.carservice.models.FeatureValue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FeatureValueRepository extends JpaRepository<FeatureValue, Long> {
    FeatureValue findByValue(String value);
}
