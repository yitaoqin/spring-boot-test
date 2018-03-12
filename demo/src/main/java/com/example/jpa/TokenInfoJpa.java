package com.example.jpa;

import com.example.domain.TokenInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface TokenInfoJpa extends JpaRepository<TokenInfoEntity,Long>,
        JpaSpecificationExecutor<TokenInfoEntity> {
}
