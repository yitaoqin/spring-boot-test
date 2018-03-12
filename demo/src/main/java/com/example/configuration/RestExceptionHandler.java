package com.example.configuration;

import com.example.domain.ApiResult;
import com.example.domain.ApiResultGenerator;
import org.springframework.web.bind.annotation.*;

@ControllerAdvice(annotations = RestController.class)
@ResponseBody
public class RestExceptionHandler {

    @ExceptionHandler
    @ResponseStatus
    public ApiResult runtimeExceptionHandler(Exception e){
        e.printStackTrace();
        return ApiResultGenerator.errorResult(e.getMessage(),e);
    }
}
