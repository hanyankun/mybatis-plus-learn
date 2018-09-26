package com.mybatis.plus.mybatisplususe.global;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * //TODO
 *
 * @author zhuquanwen
 * @vesion 1.0
 * @date 2018/9/26 21:00
 * @since jdk1.8
 */
@RestControllerAdvice
public class GlobalExceptionAdvisor {
    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String test(Exception e){
        e.printStackTrace();
        return e.getMessage();
    }
}
