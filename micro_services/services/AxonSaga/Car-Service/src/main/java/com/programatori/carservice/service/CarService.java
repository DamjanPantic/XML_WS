package com.programatori.carservice.service;

import java.security.NoSuchAlgorithmException;

public interface CarService {

    public String generateToken(Long id) throws NoSuchAlgorithmException;
}
