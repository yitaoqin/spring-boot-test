package com.example.jpa;

import com.example.domain.Users;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserJpa extends JpaRepository<Users,Long> {
    Users findByUsername(String username);
}
