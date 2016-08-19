package com.rainbow.mapper;

import com.rainbow.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by rainbow on 2016/8/8.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉Junit spring配置文件
@ContextConfiguration({"classpath:springmvc/applicationContext-dao.xml"})
public class UserMapperTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testInsertUser() throws Exception {

        User user=new User();
        user.setUsername("dfadsf");
        user.setPassword("ddd");
        user.setAge(1);
        user.setCreateTime(new Date());
        userMapper.insertUser(user);


    }

    @Test
    public void testUserList() throws Exception {
        List<User> list=userMapper.userList();
        for (User user:list){
            System.out.println(user);
        }

    }

    @Test
    public void testGetUserByName() throws Exception {

        String username="rainbow";

        User user=userMapper.getUserByName(username);

        System.out.println("查询到的用户名信息是："+user.getUsername()+";"+user.getPassword());

    }
}