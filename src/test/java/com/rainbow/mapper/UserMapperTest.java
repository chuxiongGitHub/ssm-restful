package com.rainbow.mapper;

import com.rainbow.entity.User;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by rainbow on 2016/8/8.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
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
}