package com.programatori.authservice.repository;

import com.programatori.authservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User,Long> {

}
