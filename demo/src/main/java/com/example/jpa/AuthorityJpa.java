package com.example.jpa;

import com.example.domain.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityJpa extends JpaRepository<Authority,String>{
}
