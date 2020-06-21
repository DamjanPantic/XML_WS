package com.programatori.carrental.service;

import com.programatori.carrental.models.User;
import org.springframework.http.ResponseEntity;

public interface AuthService {

    ResponseEntity<?> registerUser(User user);

    ResponseEntity<?> loginUser(User user);
}
