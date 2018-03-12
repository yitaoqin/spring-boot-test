package com.example.service;

import com.example.domain.Clinic;
import com.example.jpa.ClinicJpa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@CacheConfig(cacheNames = "clinic")
public class ClinicService {

    @Autowired
    private ClinicJpa clinicJpa;

    @Cacheable(value = "list")
    public List<Clinic> list(int page,int size){
        PageRequest pageRequest=new PageRequest(page-1,size);
        System.out.println(size/page);
        return clinicJpa.findAll(pageRequest).getContent();
    }
}
