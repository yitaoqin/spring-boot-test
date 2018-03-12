package com.example.jpa;

import com.example.domain.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface UserEntityJpa extends JpaRepository<UserEntity,String> {

    @Query("select u from UserEntity u where lower(u.username)=lower(:username) ")
    UserEntity findByUsernameCaseInsensitive(@Param("username") String username);
}
