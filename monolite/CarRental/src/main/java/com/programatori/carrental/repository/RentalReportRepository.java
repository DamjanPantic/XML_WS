package com.programatori.carrental.repository;

import com.programatori.carrental.models.RentalReport;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalReportRepository  extends JpaRepository<RentalReport, Long> {
}
