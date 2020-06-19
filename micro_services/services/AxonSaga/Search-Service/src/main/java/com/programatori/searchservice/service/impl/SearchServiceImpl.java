package com.programatori.searchservice.service.impl;

import com.programatori.searchservice.models.Vehicle;
import com.programatori.searchservice.repository.SearchRepository;
import com.programatori.searchservice.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Service
public class SearchServiceImpl implements SearchService {

    @Autowired
    SearchRepository searchRepository;


    @Override
    public Page<Vehicle> searchVehicleByParams(String place, String fromDate, String toDate, String brand, String models, String fuel, String transmission, String vehicleType, Integer pageNo) throws ParseException {
        Pageable page = PageRequest.of(pageNo, 10);

        List<String> carModels = models == ""? null: Arrays.asList(models.split(","));
        List<String> fuels = fuel == ""? null: Arrays.asList(fuel.split(","));
        List<String> vehicleTypes = vehicleType == ""? null: Arrays.asList(vehicleType.split(","));
        List<String> transmissions = transmission == ""? null: Arrays.asList(transmission.split(","));

        Date f = new SimpleDateFormat("hh:mm dd-MM-yyyy").parse(fromDate);
        Date t = new SimpleDateFormat("hh:mm dd-MM-yyyy").parse(toDate);
        String b = brand == "" ? null : brand;

        return searchRepository.getBySearchParams(place, f, t, b, carModels, vehicleTypes, fuels,
                transmissions, page);

    }

    @Override
    public Page<Vehicle> getVehicles(Integer pageNo) {
        Pageable page = PageRequest.of(pageNo, 10);
        return searchRepository.findAll(page);
    }

}
