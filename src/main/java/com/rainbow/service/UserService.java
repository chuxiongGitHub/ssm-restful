package com.rainbow.service;

import com.rainbow.entity.User;

import java.util.List;

/**
 * Created by rainbow on 2016/8/8.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public interface UserService  {
    //插入数据
    void insertUser(User user);

    List<User> userList();
}
