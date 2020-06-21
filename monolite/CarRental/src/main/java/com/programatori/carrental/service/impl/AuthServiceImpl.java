package com.programatori.carrental.service.impl;

import com.programatori.carrental.models.User;
import com.programatori.carrental.repository.UserRepository;
import com.programatori.carrental.service.AuthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    @Autowired
    UserRepository userRepository;

    @Override
    public ResponseEntity<?> registerUser(User user) {

        if (userRepository.findByEmail(user.getEmail()) != null || userRepository.findByUsername(user.getUsername()) != null){
            return new ResponseEntity<>("User with that username or email alredy exist", HttpStatus.BAD_REQUEST);
        }

        userRepository.save(user);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @Override
    public ResponseEntity<?> loginUser(User user) {
        User existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser != null && existingUser.getPassword().equals(user.getPassword())){
            return new ResponseEntity<>(existingUser, HttpStatus.OK);
        }

        return new ResponseEntity<>("No such user", HttpStatus.BAD_REQUEST);
    }
}
