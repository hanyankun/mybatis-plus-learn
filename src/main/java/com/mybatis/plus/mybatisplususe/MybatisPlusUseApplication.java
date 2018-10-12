package com.mybatis.plus.mybatisplususe;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
@MapperScan("com.mybatis.plus.mybatisplususe.mapper")
public class MybatisPlusUseApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisPlusUseApplication.class, args);
    }
}
