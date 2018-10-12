package com.mybatis.plus.mybatisplususe.service.impl;

import com.mybatis.plus.mybatisplususe.test.model.Test;
import com.mybatis.plus.mybatisplususe.mapper.TestMapper;
import com.mybatis.plus.mybatisplususe.service.TestService;
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
public class TestServiceImpl extends ServiceImpl<TestMapper, Test> implements TestService {

}
