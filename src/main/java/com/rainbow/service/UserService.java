package com.rainbow.service;

import com.rainbow.entity.User;

import java.util.List;

/**
 * Created by rainbow on 2016/8/8.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public interface UserService  {
    //插入数据
    public void insertUser(User user);

    public List<User> userList();


    //根据用户名查找用户

    public User findUserByName(String usename) throws Exception;



}
