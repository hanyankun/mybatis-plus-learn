package com.mybatis.plus.mybatisplususe.test.controller;


import com.mybatis.plus.mybatisplususe.test.model.Test;
import com.mybatis.plus.mybatisplususe.service.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2018-09-27
 */
@RestController
@RequestMapping("/test")
public class TestController {
    @Autowired
    private TestService testService;
    /*测试一下时间类型*/
    @GetMapping("/all")
    public List<Test> findAll(){
        List<Test> list = testService.list(null);
        System.out.println(list);
        return list;
    }

    @PostMapping("/input")
    public Test inputDateTime(@RequestBody Test test){
        System.out.println(test);
        testService.save(test);
        return test;
    }
}

