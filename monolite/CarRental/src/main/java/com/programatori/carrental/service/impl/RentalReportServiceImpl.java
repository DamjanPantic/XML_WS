package com.programatori.carrental.service.impl;

import com.programatori.carrental.dto.RentalReportDTO;
import com.programatori.carrental.models.RentalReport;
import com.programatori.carrental.models.RentalRequest;
import com.programatori.carrental.models.Vehicle;
import com.programatori.carrental.repository.RentalReportRepository;
import com.programatori.carrental.repository.RentalRequestRepository;
import com.programatori.carrental.repository.VehicleRepository;
import com.programatori.carrental.service.RentalReportService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RentalReportServiceImpl implements RentalReportService {

    @Autowired
    RentalReportRepository rentalReportRepository;

    @Autowired
    VehicleRepository vehicleRepository;

    @Autowired
    RentalRequestRepository rentalRequestRepository;


    @Override
    public RentalReport insertReport(RentalReportDTO rentalReportDTO) {
        RentalReport rentalReport = new RentalReport();
        System.out.println(rentalReportDTO.getVehicleId());
        Vehicle vehicle = vehicleRepository.findById(rentalReportDTO.getVehicleId()).orElse(null);
        RentalRequest request = rentalRequestRepository.findById(rentalReportDTO.getRequestId()).orElse(null);
        if(vehicle == null || request == null){
            return null;
        }
        rentalReport.setInfo(rentalReportDTO.getInfo());
        rentalReport.setDistance(rentalReportDTO.getDistance());
        rentalReport.setRequest(request);
        rentalReport.setVehicle(vehicle);

        rentalReportRepository.save(rentalReport);
        return rentalReport;
    }
}
