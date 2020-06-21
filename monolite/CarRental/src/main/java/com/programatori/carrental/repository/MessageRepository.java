package com.programatori.carrental.repository;

import com.programatori.carrental.models.Message;
import com.programatori.carrental.models.RentalRequest;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface MessageRepository extends JpaRepository<Message, Long> {
    List<Message> findByRentalRequest(RentalRequest rentalRequest);
}
