package com.example.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class FlagVa implements ConstraintValidator<FlagValidator,Object> {
    private String values;
    @Override
    public void initialize(FlagValidator flagValidator) {
        values=flagValidator.values();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        String[] valueArray=values.split(",");
        boolean flag=false;
        for(String v:valueArray){
            if(v.equals(o)){
                flag=true;
                break;
            }
        }
        return flag;
    }
}