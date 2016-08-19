package com.rainbow.controller;

import com.rainbow.dto.UserResult;
import com.rainbow.entity.User;
import com.rainbow.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by rainbow on 2016/8/8.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    //添加用户
    @RequestMapping(value = "/addUser")
    public String addUser(User user) {
        userService.insertUser(user);
        return "redirect:/user/userList";
    }
    //展示所有用户列表
    @RequestMapping(value = "/userList")
    public String userList(Model model) {

        List<User> list = userService.userList();
        model.addAttribute("user", list);
        return "/user/userList";
    }
    //注册用户展示表单
    @RequestMapping(value = "/userForm")
    public String userForm(){
        return "/user/userForm";
    }


}
