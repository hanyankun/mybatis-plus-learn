package com.mybatis.plus.mybatisplususe.controller;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.api.ApiController;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.mybatis.plus.mybatisplususe.model.User;
import com.mybatis.plus.mybatisplususe.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sun.nio.cs.US_ASCII;

import java.util.*;

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
public class UserController extends ApiController {
    @Autowired
    private UserService userService;
    /*测试查询全部*/
    @GetMapping()
    public List<User> findAll(){
        List<User> list = userService.list(null);
        return list;
    }

    /*测试参数出错*/
    @GetMapping("/t1")
    public List<User> t1(String a){
        Assert.notNull(a, "不能为空");
        List<User> list = userService.list(null);
        return list;
    }

    /*测试分页查询*/
    @GetMapping("/t2")
    public IPage<User> t2() {
        return userService.page(new Page<User>(0, 12), null);
    }

    /*测试插入*/
    @GetMapping("/t3")
    public User t3() {
        User user = new User();
        user.setPassword(UUID.randomUUID().toString());
        user.setPhone("121");
        user.setRealname("221");
        user.setUsername("zqw" + new Random().nextInt(100));
        userService.save(user);
        return user;
    }

    /*测试批量插入*/
    @GetMapping("/t4")
    public List<User> t4() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            User user = new User();
            user.setPassword(UUID.randomUUID().toString());
            user.setPhone("121");
            user.setRealname("221");
            user.setUsername("zqw" + new Random().nextInt(100));
            users.add(user);
        }
        userService.saveBatch(users);
        return users;
    }

    /*测试插入ID回传*/
    @GetMapping("/t5")
    public Integer t5() {
        User user = new User();
        user.setPassword(UUID.randomUUID().toString());
        user.setPhone("121");
        user.setRealname("221");
        user.setUsername("zqw" + new Random().nextInt(100));
        userService.save(user);
        return user.getId();
    }

    /*测试插入ID查询*/
    @GetMapping("/t6")
    public User t6() {
        User user = userService.getById(1);
        return user;
    }
    /*测试按照ID删除*/
    @GetMapping("/t7")
    public boolean t7() {
        return userService.removeById(2);
    }

    /*测试按照多个ID删除*/
    @GetMapping("/t8")
    public boolean t8() {
        return userService.removeByIds(Arrays.asList(2,3,4));
    }

    /*测试按照ID修改*/
    @GetMapping("/t9")
    public boolean t9() {
        User user = userService.getById(73);
        user.setRealname("myrealname");
        return userService.updateById(user);
    }

    /*测试按照条件更新*/
    @GetMapping("/t10")
    public boolean t10() {
        User user = new User();
        user.setPassword(UUID.randomUUID().toString());
        user.setPhone("121444");
        user.setRealname("221");
        user.setUsername("zqw" + new Random().nextInt(100));
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.set("realname", "xxx");
        return userService.update(user, updateWrapper);
    }

    /*测试按照条件更新*/
    @GetMapping("/t11")
    public boolean t11() {
        User user = new User();
        user.setPassword(UUID.randomUUID().toString());
        user.setPhone("121444");
        user.setRealname("221");
        user.setUsername("zqw" + new Random().nextInt(100));
        UpdateWrapper<User> updateWrapper = new UpdateWrapper<>();
        updateWrapper.between("id",34,78);
        return userService.update(user, updateWrapper);
    }
    /*测试按照条件查询*/
    @GetMapping("/t12")
    public List<User> t12() {
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.eq("id", 5);
        userQueryWrapper.or(q -> q.like("username","zqw8"));
        List<User> users = userService.list(userQueryWrapper);
        return users;
    }


}

