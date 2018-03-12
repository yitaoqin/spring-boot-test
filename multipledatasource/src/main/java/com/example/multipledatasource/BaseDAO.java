package com.example.multipledatasource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;

import java.io.Serializable;

public interface BaseDAO<T> extends JpaRepository<T,String>,JpaSpecificationExecutor<T>,Serializable {
}
