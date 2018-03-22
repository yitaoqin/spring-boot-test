package com.example.multipledatasource.controller;

import com.example.multipledatasource.annotation.ContentSecurity;
import com.example.multipledatasource.annotation.ContentSecurityAttribute;
import com.example.multipledatasource.entity.StudentEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class JspController {

    @RequestMapping(value = "/submit")
    @ContentSecurity
    public String resolver(@ContentSecurityAttribute("student") @Valid StudentEntity student)
    {
        System.out.println( "学生名称："+student.getName()+"，学生年龄："+student.getAge());
        return "SUCCESS";
    }

}
