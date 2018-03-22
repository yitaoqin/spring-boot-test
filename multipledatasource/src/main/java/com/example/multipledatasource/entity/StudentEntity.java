package com.example.multipledatasource.entity;

import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Min;

@Data
public class StudentEntity
{
    @NotEmpty
    private String name;
    @Min(value = 18,message = "年龄最小18岁")
    private int age;
}
