package com.rainbow.service;

import com.rainbow.dto.Exporer;
import com.rainbow.dto.SeckillExecution;
import com.rainbow.entity.Seckill;
import com.rainbow.exception.RepeatKillException;
import com.rainbow.exception.SeckillCloseException;
import com.rainbow.exception.SeckillException;

import java.util.List;

/**
 * Created by rainbow on 2016/8/3.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
//站在“使用者”的角度设计接口
//1、方法定义的粒度
//2、传递的参数
//3、返回类型
public interface SeckillService {
    //插入数据
    void insertSeckill(Seckill seckill) throws Exception;

    //展示所有秒杀产品的列表
    List<Seckill> getSeckillList();

    /**
     * 查询单个秒杀记录
     *
     * @param seckillId
     * @return
     */
    Seckill getById(Long seckillId);

    /**
     * 秒杀开启输出秒杀接口地址
     * 否则输出系统时间和秒杀时间
     *
     * @param seckillId
     */
    Exporer exportSeckillUrl(long seckillId);

    /**
     * 执行秒杀操作
     * @param seckillId
     * @param userPhone
     * @param md5
     */
    SeckillExecution excuteSeckill(Long seckillId, Long userPhone, String md5)
            throws SeckillException,RepeatKillException,SeckillCloseException;

    List<Seckill> queryList();
}
