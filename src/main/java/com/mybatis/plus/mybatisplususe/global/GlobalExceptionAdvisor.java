package com.mybatis.plus.mybatisplususe.global;

import com.baomidou.kaptcha.exception.KaptchaException;
import com.baomidou.kaptcha.exception.KaptchaIncorrectException;
import com.baomidou.kaptcha.exception.KaptchaNotFoundException;
import com.baomidou.kaptcha.exception.KaptchaTimeoutException;
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

    @ExceptionHandler(value = KaptchaException.class)
    public String kaptchaExceptionHandler(KaptchaException kaptchaException) {
        if (kaptchaException instanceof KaptchaIncorrectException) {
            return "验证码不正确";
        } else if (kaptchaException instanceof KaptchaNotFoundException) {
            return "验证码未找到";
        } else if (kaptchaException instanceof KaptchaTimeoutException) {
            return "验证码过期";
        } else {
            return "验证码渲染失败";
        }
    }

    @ExceptionHandler(value = Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public String test(Exception e){
        e.printStackTrace();
        return e.getMessage();
    }
}
