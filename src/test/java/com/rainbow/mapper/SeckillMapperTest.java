package com.rainbow.mapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by rainbow on 2016/8/3.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */

/**
 * 配置spring和Junit整合，为了Junit启动时加载spring IOC
 */
@RunWith(SpringJUnit4ClassRunner.class)
//告诉Junit spring配置文件
@ContextConfiguration("classpath:springmvc/applicationContext-dao.xml")
public class SeckillMapperTest {
    //注入mapper接口实现类
    @Resource
    private SeckillMapper seckillMapper;

    @Test
    public void testInsert() throws Exception {

    }

    @Test
    public void testReduceNumber() throws Exception {

    }

    @Test
    public void testQueryById() throws Exception {

    }

    @Test
    public void testQueryAll() throws Exception {

    }
}