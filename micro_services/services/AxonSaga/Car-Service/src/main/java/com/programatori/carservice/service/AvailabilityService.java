package com.programatori.carservice.service;

import com.programatori.carservice.dto.AvailabilityDTO;

import java.text.ParseException;
import java.util.Set;

public interface AvailabilityService {

    public Set<AvailabilityDTO> addAvailability(Long id, AvailabilityDTO availabilityDTO) throws ParseException;
    public Set<AvailabilityDTO> addReservation(Long id, AvailabilityDTO availabilityDTO);
}
