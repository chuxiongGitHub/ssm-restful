package com.rainbow.entity;

import java.util.Date;

/**
 * Created by rainbow on 2016/8/8.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public class User {
    private int userId;
    private String username;
    private String password;
    private int age;
    private Date createTime;

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
