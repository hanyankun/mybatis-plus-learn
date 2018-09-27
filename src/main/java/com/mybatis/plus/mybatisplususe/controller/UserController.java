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
    public List<User> t2() {
        IPage<User> page = userService.page(new Page<User>(0, 12), null);
        List<User> records = page.getRecords();
        return records;
    }

    /*分页查询返回Map*/
    @GetMapping("/t23")
    public IPage<Map<String, Object>> t23() {
        IPage<Map<String, Object>> mapIPage = userService.pageMaps(new Page<User>(2, 12), null);
        return mapIPage;
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
        for (int i = 0; i < 100 ; i++) {
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

    /*保存或修改*/
    @GetMapping("/t25")
    public boolean t25() {
        User user = userService.getById(1);
        user.setId(null);
        user.setUsername("admin");
        boolean b = userService.saveOrUpdate(user);
        return b;
    }

    /*批量保存或修改*/
    @GetMapping("/t26")
    public boolean t26() {
        List<User> users = new ArrayList<>();
        for (int i = 0; i < 10 ; i++) {
            User user = userService.getById(1);
            user.setId(null);
            user.setUsername("admin" + new Random().nextInt(20));
            users.add(user);
        }
        boolean b = userService.saveOrUpdateBatch(users);
        return b;
    }

    /*测试ID查询*/
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

    /*按照查询条件删除*/
    @GetMapping("/t22")
    public boolean t22() {
        QueryWrapper queryWrapper = new QueryWrapper();
        queryWrapper.eq("id", 101);
        boolean remove = userService.remove(queryWrapper);
        return remove;
    }

    /*按照Map查询条件删除*/
    @GetMapping("/t24")
    public boolean t24() {
        Map map = new HashMap();
        map.put("id","101");
        boolean remove = userService.removeByMap(map);
        return remove;
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

    /*groupby order by 等操作*/
    @GetMapping("/t13")
    public List t13() {
        QueryWrapper userQueryWrapper = new QueryWrapper();
        userQueryWrapper.groupBy("username");
        userQueryWrapper.orderByDesc("username");
        userQueryWrapper.select(" username, count(username) AS count");
        List list = userService.listMaps(userQueryWrapper);
        return list;
    }

    /*按照条件计数count操作*/
    @GetMapping("/t14")
    public int t14() {
        QueryWrapper userQueryWrapper = new QueryWrapper();
        userQueryWrapper.like("username","zqw2");
        int count = userService.count(userQueryWrapper);
        return count;
    }

    /*按照条件查询返回Map,只返回一条值*/
    @GetMapping("/t15")
    public Map t15() {
        QueryWrapper userQueryWrapper = new QueryWrapper();
        userQueryWrapper.like("username","zqw2");
        Map map = userService.getMap(userQueryWrapper);
        return map;
    }

    /*按照条件查询返回List<Map>,返回多个值*/
    @GetMapping("/t16")
    public List<Map<String,Object>> t16() {
        QueryWrapper userQueryWrapper = new QueryWrapper();
        userQueryWrapper.like("username","zqw2");
        List<Map<String, Object>> list = userService.listMaps(userQueryWrapper);
        return list;
    }

    /*按照条件查询返回Object*/
    @GetMapping("/t17")
    public Object t17() {
        QueryWrapper userQueryWrapper = new QueryWrapper();
        userQueryWrapper.like("username","zqw2");
        Object obj = userService.getObj(userQueryWrapper);
        return obj;
    }

    /*按照条件查询一个值*/
    @GetMapping("/t18")
    public User t18() {
        QueryWrapper userQueryWrapper = new QueryWrapper();
        userQueryWrapper.like("username","zqw2");
        User one = userService.getOne(userQueryWrapper);
        return one;
    }

    /*按照条件查询一个值,如果这个条件查到的不是一个值，而是多个，那么抛出异常*/
    @GetMapping("/t19")
    public User t19() {
        QueryWrapper userQueryWrapper = new QueryWrapper();
        userQueryWrapper.like("username","zqw2");
        User one = userService.getOne(userQueryWrapper, true);
        return one;
    }

    /*按照多个ID查询*/
    @GetMapping("/t20")
    public Collection<User> t20() {
        Collection<User> users = userService.listByIds(Arrays.asList(1, 2, 3, 4, 5));
        return users;
    }

    /*按照一个Map多个条件与查询*/
    @GetMapping("/t21")
    public Collection t21() {
        Map map = new HashMap();
        map.put("username", "zqw27");
        map.put("id",71);
        Collection collection = userService.listByMap(map);
        return collection;
    }


}

