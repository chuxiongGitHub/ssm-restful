package com.rainbow.mapper.cache;

import com.rainbow.entity.Seckill;
import com.rainbow.mapper.SeckillMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;

/**
 * Created by rainbow on 2016/8/9.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:springmvc/applicationContext-dao.xml"})
public class RedisDaoTest {

    private long id = 1003;

    @Autowired
    private RedisDao redisDao;
    @Autowired
    private SeckillMapper seckillMapper;

    @Test
    public void testGetSeckill() throws Exception {

        Seckill seckill = redisDao.getSeckill(id);
        if (seckill == null) {
            seckill = seckillMapper.queryById(id);
            if (seckill != null) {
                String result = redisDao.putSeckill(seckill);
                System.out.println(result);

                redisDao.getSeckill(id);
                seckill = seckillMapper.queryById(id);
                System.out.println(seckill);


            }
        }

    }

    @Test
    public void testPutSeckill() throws Exception {

    }
}