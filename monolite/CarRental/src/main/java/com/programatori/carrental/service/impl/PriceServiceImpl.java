package com.programatori.carrental.service.impl;

import com.programatori.carrental.dto.ModelDTO;
import com.programatori.carrental.dto.PriceTypeDTO;
import com.programatori.carrental.models.PriceType;
import com.programatori.carrental.repository.PriceTypeRepository;
import com.programatori.carrental.service.PriceService;
import org.dozer.DozerBeanMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PriceServiceImpl implements PriceService {

    @Autowired
    PriceTypeRepository priceTypeRepository;

    DozerBeanMapper dozerBeanMapper = new DozerBeanMapper();

    @Override
    public List<PriceTypeDTO> getAllPriceTypes() {
        List<PriceTypeDTO> priceTypeDTOS = new ArrayList<>();
        for (PriceType priceType: priceTypeRepository.findAll()) {
            priceTypeDTOS.add(dozerBeanMapper.map(priceType, PriceTypeDTO.class));
        }
        return priceTypeDTOS;
    }
}
