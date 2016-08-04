package com.rainbow.mapper;

import com.rainbow.entity.Seckill;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by rainbow on 2016/8/3.
 * 每天进步一小点
 */
//配置spring与junit整合，为了Junit启动时加载spring IOC容器
@RunWith(SpringJUnit4ClassRunner.class)
//告诉Junit spring配置文件
@ContextConfiguration({"classpath:springmvc/applicationContext-dao.xml"})
public class SeckillMapperTest {
    //注入mapper实现依赖类
    @Resource
    private SeckillMapper seckillMapper;

    @Test
    public void testInsert() throws Exception {


        Seckill seckill=new Seckill();
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        seckill.setEndTime(new Date());
        seckill.setCreateTime(new Date());
        seckill.setStartTime(new Date());
        seckill.setName("比亚迪轿车");
        seckill.setNumber(2);
        seckillMapper.insert(seckill);

    }

    @Test
    public void testReduceNumber() throws Exception {


        int updateCount=seckillMapper.reduceNumber(1000L,new Date());
        System.out.println(updateCount);
    }

    @Test
    public void testQueryById() throws Exception {
        long id = 1000;
        Seckill seckill = seckillMapper.queryById(id);
        System.out.println(seckill.getName());
        System.out.println(seckill);
    }

    @Test
    public void testQueryAll() throws Exception {

        List<Seckill> list=seckillMapper.queryAll(0,100);
        for (Seckill seckill:list){
            System.out.println(seckill);
        }

    }
}