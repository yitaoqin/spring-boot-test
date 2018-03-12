package com.example.controller;

import com.example.domain.ValidatorEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;
import java.util.Locale;

@Controller
public class HiController {

  /*  @Autowired
    private MessageSource messageSource;*/
    /*@RequestMapping("hi")
    public ValidatorEntity hi(@Valid ValidatorEntity entity, BindingResult result){
        if(result.hasErrors()){
            StringBuilder msg=new StringBuilder();
            List<FieldError> errors=result.getFieldErrors();
            Locale locale=LocaleContextHolder.getLocale();
            for(FieldError fieldError:errors){
                String errorMsg=messageSource.getMessage(fieldError,locale);
                msg.append(fieldError.getField());
                msg.append("||");
                msg.append(errorMsg);
                msg.append("。");
            }
            System.out.println(msg.toString());
        }
        return entity;
    }*/

    @RequestMapping("index")
    public String d(){

        return "index";
    }


}
