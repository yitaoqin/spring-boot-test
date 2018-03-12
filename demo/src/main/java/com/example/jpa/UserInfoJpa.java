package com.example.jpa;

import com.example.domain.UserInfoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

public interface UserInfoJpa extends JpaRepository<UserInfoEntity,String>,
        JpaSpecificationExecutor<UserInfoEntity>{
}
