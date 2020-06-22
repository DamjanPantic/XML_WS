package com.programatori.carrental.service;

import com.programatori.carrental.dto.PriceTypeDTO;

import java.util.List;

public interface PriceService {
    List<PriceTypeDTO> getAllPriceTypes();
}
