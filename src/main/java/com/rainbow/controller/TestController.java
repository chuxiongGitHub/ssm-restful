package com.rainbow.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by rainbow on 2016/8/3.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
@Controller
@RequestMapping(value = "/test")
public class TestController {
    @RequestMapping(value = "/restful")
    @ResponseBody
    public String restful(int age) {

        return "age:" + age;
    }


}
