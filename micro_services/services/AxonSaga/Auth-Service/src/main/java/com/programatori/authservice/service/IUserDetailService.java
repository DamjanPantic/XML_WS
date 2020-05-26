package com.programatori.authservice.service;

import com.programatori.authservice.models.User;

public interface IUserDetailService {

    public User save(User user);
    public User loadByUsername(String username);
}
