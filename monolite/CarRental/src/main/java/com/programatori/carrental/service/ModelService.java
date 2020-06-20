package com.programatori.carrental.service;

import org.springframework.http.ResponseEntity;

public interface ModelService {
    public ResponseEntity<?> getModelsByManufacturer(String name);
}
