package com.programatori.carservice.repository;

import com.programatori.carservice.models.PriceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceTypeRepository extends JpaRepository<PriceType, Long> {
}
