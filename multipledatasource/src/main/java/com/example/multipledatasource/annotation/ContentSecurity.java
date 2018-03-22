package com.example.multipledatasource.annotation;


import java.lang.annotation.*;

@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ContentSecurity {
    ContentSecurityAway away() default ContentSecurityAway.DES;
}
