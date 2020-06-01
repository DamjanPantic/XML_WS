package com.programatori.authservice.repository;

import com.programatori.authservice.models.Admin;
import com.programatori.authservice.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAdminRepository extends JpaRepository<Admin,Long> {
}
