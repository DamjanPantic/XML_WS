package com.programatori.authservice.repository;

import com.programatori.authservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface IUserRepository extends JpaRepository<User,Long> {
    User findByUsername(String username);
}
