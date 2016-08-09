package com.rainbow.service.impl;

import com.rainbow.entity.User;
import com.rainbow.mapper.UserMapper;
import com.rainbow.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Created by rainbow on 2016/8/8.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
@Service
public class UserServiceImpl implements UserService {
    private static Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    //注入mapper接口
    @Autowired
    private UserMapper userMapper;

    public void insertUser(User user) {


        userMapper.insertUser(user);
        logger.info("注册的用户是：{}", user);

    }

    public List<User> userList() {
       List<User> list= userMapper.userList();

        return list;
    }
}
