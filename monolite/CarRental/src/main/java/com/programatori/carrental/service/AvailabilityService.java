package com.programatori.carrental.service;

import com.programatori.carrental.dto.AvailabilityDTO;
import org.springframework.http.ResponseEntity;

import java.text.ParseException;
import java.util.Set;

public interface AvailabilityService {

    public ResponseEntity<?> addReservation(Long id, AvailabilityDTO availabilityDTO) throws ParseException;

}
