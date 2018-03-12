package com.example.domain;

import com.example.validator.FlagValidator;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.Future;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.Date;

public class ValidatorEntity implements Serializable{

    @NotBlank
    @Length(max = 30)
    private String name;
    @NotBlank
    @Email
    private String email;

    @Future
    @DateTimeFormat( pattern = "yyyy-MM-dd")
    private Date data;

    @FlagValidator(values = "1,2,3")
    private String v;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getV() {
        return v;
    }

    public void setV(String v) {
        this.v = v;
    }

    @Override
    public String toString() {
        return "ValidatorEntity{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", data=" + data +
                ", v='" + v + '\'' +
                '}';
    }
}
