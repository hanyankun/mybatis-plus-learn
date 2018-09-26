package com.mybatis.plus.mybatisplususe.controller;


import com.mybatis.plus.mybatisplususe.model.User;
import com.mybatis.plus.mybatisplususe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author admin
 * @since 2018-09-26
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping()
    public List<User> findAll(){
        List<User> list = userService.list(null);
        return list;
    }
}

