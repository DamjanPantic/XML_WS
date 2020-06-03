package com.programatori.carservice.repository;

import com.programatori.carservice.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ModelRepository extends JpaRepository<Model, Long> {

}
