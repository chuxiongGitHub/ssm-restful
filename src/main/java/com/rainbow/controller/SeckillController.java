package com.rainbow.controller;

import com.rainbow.entity.Seckill;
import com.rainbow.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * Created by rainbow on 2016/8/3.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
@Controller
@RequestMapping(value = "/seckill")
public class SeckillController {
    private static Logger logger = LoggerFactory.getLogger(SeckillController.class);
    //注入service
    @Autowired
    private SeckillService seckillService;

    //添加商品展示页
    @RequestMapping(value = "/seckillForm")
    public String insertForm() {
        return "seckillForm";
    }

    //插入数据
    @RequestMapping(value = "/insertSeckill", method = RequestMethod.POST)
    public String insertSeckill(Seckill seckill, HttpServletRequest request) throws Exception {
        seckillService.insertSeckill(seckill);
        logger.info("插入数据的id是：" + request.getParameter("seckillId"));
        return "redirect:success";
    }

    @RequestMapping(value = "/success")
    public String success() {
        return "success";
    }

    @RequestMapping(value = "/getSeckillList")
    public ModelAndView getSeckillList() {
        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}", list);
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.addObject("seckill", list);
        modelAndView.setViewName("seckillList");
        return modelAndView;
    }

}
