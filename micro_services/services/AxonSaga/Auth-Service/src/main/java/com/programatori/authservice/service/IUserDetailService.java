package com.programatori.authservice.service;

import com.programatori.authservice.dto.UserDTO;
import com.programatori.authservice.models.Individual;
import com.programatori.authservice.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserDetailService {

    public User save(User user);
    public Boolean deleteById(Long id);
    public Individual saveIndividual(User user);
    public User blockUserById(Long id);
    public User unBlockUserById(Long id);
    public User findByUsername(String username);
    public User updateRole(String role, Long id);
    public User findByEmail(String email);
    public UserDTO findById(Long id);
    public List<UserDTO> findAll();
}
