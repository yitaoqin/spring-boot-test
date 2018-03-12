package com.example.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.PARAMETER,ElementType.FIELD})
@Constraint(validatedBy = FlagVa.class)
public @interface FlagValidator {

    String values();
    String message() default "非法flag标记";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

}
