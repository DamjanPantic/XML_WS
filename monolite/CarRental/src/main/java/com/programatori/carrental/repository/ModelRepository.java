package com.programatori.carrental.repository;

import com.programatori.carrental.models.Manufacturer;
import com.programatori.carrental.models.Model;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ModelRepository extends JpaRepository<Model,Long> {
    List<Model> findByManufacturer(Manufacturer manufacturer);
}
