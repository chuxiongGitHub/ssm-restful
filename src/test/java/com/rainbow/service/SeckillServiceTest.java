package com.rainbow.service;

import com.rainbow.dto.Exporer;
import com.rainbow.dto.SeckillExecution;
import com.rainbow.entity.Seckill;
import com.rainbow.entity.SuccessSeckilled;
import com.rainbow.exception.RepeatKillException;
import com.rainbow.exception.SeckillCloseException;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by rainbow on 2016/8/4.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:springmvc/applicationContext-dao.xml",
        "classpath:springmvc/applicationContext-service.xml"})
public class SeckillServiceTest {
    private static Logger logger = LoggerFactory.getLogger(SeckillService.class);

    @Autowired
    private SeckillService seckillService;

    @Test
    public void testInsertSeckill() throws Exception {
        Seckill seckill=new Seckill();
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        seckill.setEndTime(new Date());
        seckill.setCreateTime(new Date());
        seckill.setStartTime(new Date());
        seckill.setName("比亚迪轿车");
        seckill.setNumber(2);
        seckillService.insertSeckill(seckill);
        logger.info("插入的数据是={}",seckill);
    }

    @Test
    public void testGetSeckillList() throws Exception {

        List<Seckill> list = seckillService.getSeckillList();
        logger.info("list={}", list);
    }

    @Test
    public void testGetById() throws Exception {

        long id = 1000;
        Seckill seckill = seckillService.getById(id);
        logger.info("seckill={}", seckill);
    }

    @Test
    public void testExportSeckillUrl() throws Exception {
        long id = 1001;
        Exporer exporer = seckillService.exportSeckillUrl(id);
        if (exporer.isExposed()) {
            logger.info("exposer={}", exporer);
            long phone = 13698740791L;
            String md5 = exporer.getMd5();
            try {
                SeckillExecution execution = seckillService.excuteSeckill(id, phone, md5);
                logger.info("execution={}", execution);
            } catch (RepeatKillException e1) {
                logger.error(e1.getMessage());
            } catch (SeckillCloseException e2) {
                logger.info(e2.getMessage());
            }
        } else {
            logger.warn("exposer={}", exporer);
        }

    }

    @Test
    public void testExcuteSeckill() throws Exception {


    }
}