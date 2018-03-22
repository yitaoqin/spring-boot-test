package com.example.multipledatasource.controller;

import com.alibaba.fastjson.JSON;
import com.example.multipledatasource.annotation.ParameterModel;
import com.example.multipledatasource.entity.StudentEntity;
import com.example.multipledatasource.entity.TeacherEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class JspController {

    @RequestMapping(value = "/submit")
    public String resolver(@ParameterModel TeacherEntity teacher, @ParameterModel StudentEntity student)
    {
        return "教师名称："+ JSON.toJSON(teacher.getName()) +"，学生名称："+student.getName()+"，学生年龄："+student.getAge();
    }

}
