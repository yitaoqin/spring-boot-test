package com.example.multipledatasource.annotation;

import java.lang.annotation.*;

@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ContentSecurityAttribute {

   String value();
}
