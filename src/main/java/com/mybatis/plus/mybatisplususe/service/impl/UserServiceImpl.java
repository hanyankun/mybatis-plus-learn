package com.mybatis.plus.mybatisplususe.service.impl;

import com.mybatis.plus.mybatisplususe.test.model.User;
import com.mybatis.plus.mybatisplususe.mapper.UserMapper;
import com.mybatis.plus.mybatisplususe.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author admin
 * @since 2018-09-27
 */
@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {

}
