package com.programatori.authservice.service;

import com.programatori.authservice.models.User;
import com.programatori.authservice.repository.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

    @Autowired
    IUserRepository userRepository;

    @Override
    public User save(User user) {

        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        User u = new User();
        u.setEmail(user.getEmail());
        u.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
        u.setUsername(user.getUsername());
        return userRepository.save(u);
    }
}
