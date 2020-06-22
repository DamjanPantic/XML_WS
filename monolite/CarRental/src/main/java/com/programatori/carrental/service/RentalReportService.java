package com.programatori.carrental.service;

import com.programatori.carrental.dto.RentalReportDTO;
import com.programatori.carrental.models.RentalReport;

public interface RentalReportService {
    public RentalReport insertReport(RentalReportDTO rentalReportDTO);

}
