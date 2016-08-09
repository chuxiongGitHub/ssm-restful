package com.rainbow.controller;

import com.rainbow.dto.Exporer;
import com.rainbow.dto.SeckillExecution;
import com.rainbow.dto.SeckillResult;
import com.rainbow.entity.Seckill;
import com.rainbow.enums.SeckillStatEnum;
import com.rainbow.exception.RepeatKillException;
import com.rainbow.exception.SeckillCloseException;
import com.rainbow.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
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
        return "redirect:/seckill/getSeckillList";
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
        modelAndView.setViewName("list1");
        return modelAndView;
    }

    /**
     * 展示所有商品
     *
     * @param model
     * @return
     */
    @RequestMapping(value = "/queryList")
    public String queryList(Model model) {
        List<Seckill> list = seckillService.queryList();

        model.addAttribute("list", list);

        return "list";

    }

    @RequestMapping(value = "/{seckillId}/detail")
    public String detail(@PathVariable("seckillId") Long seckillId, Model model) {
        if (seckillId == null) {
            return "redrict:/seckill/queryList";
        }
        Seckill seckill = seckillService.getById(seckillId);
        if (seckill == null) {
            return "forward:/seckill/queryList";
        }
        model.addAttribute("seckill", seckill);
        return "detail";
    }


    //返回json类型
    @RequestMapping(value = "/{seckillId}/exposer", method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResult<Exporer> exposer(@PathVariable("seckillId") Long seckillId) {

        SeckillResult<Exporer> result;
        try {
            Exporer exporer = seckillService.exportSeckillUrl(seckillId);
            result = new SeckillResult<Exporer>(true, exporer);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            result = new SeckillResult<Exporer>(false, e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/{seckillId}/{md5}/execution", method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResult<SeckillExecution> execute(@PathVariable("seckillId") Long seckillId,
                                                   @PathVariable("md5") String md5,
                                                   @CookieValue(value = "killPhone", required = false) Long phone) {

        if (phone == null) {
            return new SeckillResult<SeckillExecution>(false, "未注册");
        }
        SeckillResult<SeckillExecution> result;
        try {
            SeckillExecution execution = seckillService.excuteSeckill(seckillId, phone, md5);
            return new SeckillResult<SeckillExecution>(true, execution);
        } catch (RepeatKillException e1) {
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.REPEAT_KILL);
            return new SeckillResult<SeckillExecution>(false, execution);
        } catch (SeckillCloseException e2) {
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.END);
            return new SeckillResult<SeckillExecution>(false, execution);
        } catch (Exception e) {
            logger.error(e.getMessage(), e);
            SeckillExecution execution = new SeckillExecution(seckillId, SeckillStatEnum.INNER_ERRO);
            return new SeckillResult<SeckillExecution>(false, execution);
        }
    }

    //获取系统时间
    @RequestMapping(value = "/time/now", method = RequestMethod.GET)
    @ResponseBody
    public SeckillResult<Long> time() {
        Date date = new Date();
        return new SeckillResult(true, date.getTime());
    }
}
