package com.rainbow.mapper;

import com.rainbow.entity.SuccessSeckilled;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by rainbow on 2016/8/3.
 * 每天进步一小点
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:springmvc/applicationContext-dao.xml"})
public class SuccessSeckilledMapperTest {

    //注入mapper接口
    @Resource
    private SuccessSeckilledMapper successSeckilledMapper;

    @Test
    public void testInsertSuccessSeckilled() throws Exception {

        int count = successSeckilledMapper.insertSuccessSeckilled(1000L, 13698740791L);
        System.out.println(count);

    }

    @Test
    public void testQueryByIdWithSeckill() throws Exception {
        SuccessSeckilled successSeckilled = successSeckilledMapper.queryByIdWithSeckill(1000L, 13698740791L);
        System.out.println(successSeckilled);
    }
}