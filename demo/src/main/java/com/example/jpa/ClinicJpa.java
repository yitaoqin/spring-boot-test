package com.example.jpa;

import com.example.domain.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface ClinicJpa extends JpaRepository<Clinic,String>,JpaSpecificationExecutor<Clinic>,Serializable{
}
