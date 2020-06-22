package com.programatori.carrental.service;

import org.springframework.http.ResponseEntity;

public interface CommentService {
    ResponseEntity<?> getVehicleCommentsForUser(Long id);

}
