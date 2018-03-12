package com.example.jpa;

import com.example.domain.LoggerInfos;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoggerInfosJpa extends JpaRepository<LoggerInfos,Long> {
}
