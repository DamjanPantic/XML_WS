package com.programatori.carrental.repository;

import com.programatori.carrental.models.Price;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PriceRepository extends JpaRepository<Price,Long> {
}
