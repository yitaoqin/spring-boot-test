package com.example.controller;

import com.example.domain.Clinic;
import com.example.domain.LoggerInfos;
import com.example.jpa.ClinicJpa;
import com.example.jpa.LoggerInfosJpa;
import com.example.service.ClinicService;
import com.example.utils.LoggerUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.http.HttpServletRequest;
import java.util.List;


@RestController
@RequestMapping("clinic")
public class ClinicController {

    private Logger logger= LoggerFactory.getLogger(getClass().getName());

    @Autowired
    private ClinicService clinicService;

    /*@Autowired
    private LoggerInfosJpa loggerInfosJpa;*/

    @RequestMapping("list")
    public List<Clinic> list(HttpServletRequest request,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "4") Integer size){
        List<Clinic> clinic=clinicService.list(page,size);

        request.setAttribute(LoggerUtils.LOGGER_RETURN,clinic);
        return clinic;
    }


}
