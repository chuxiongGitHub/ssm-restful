package com.rainbow.service.impl;

import com.rainbow.entity.Seckill;
import com.rainbow.mapper.SeckillMapper;
import com.rainbow.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;


/**
 * Created by rainbow on 2016/8/3.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public class SeckillServiceImpl implements SeckillService {
    private static Logger logger = LoggerFactory.getLogger(SeckillServiceImpl.class);

    //注入mapper
    @Autowired
    private SeckillMapper seckillMapper;

    public void insertSeckill(Seckill seckill) throws Exception {
        //调用mybatis的mapper接口执行插入操作
        logger.info("开始插入数据");
        seckillMapper.insert(seckill);
        logger.info("插入的数据是：", seckill);

    }
}
