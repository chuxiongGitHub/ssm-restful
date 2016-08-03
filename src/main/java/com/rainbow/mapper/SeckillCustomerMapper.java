package com.rainbow.mapper;

import com.rainbow.entity.Seckill;
import com.rainbow.entity.SeckillCustomer;

import java.util.Date;
import java.util.List;

/**
 * Created by rainbow on 2016/8/3.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public interface SeckillCustomerMapper {
    /**
     * 减库存
     * @param seckillId
     * @param killTime
     * @return
     */
    int reduceNumber(Long seckillId, Date killTime);

    /**
     *根据id查询秒杀商品
     * @param seckillId
     * @return
     */
    SeckillCustomer queryById(Long seckillId);

    /**
     * 根据偏移量查询秒杀商品列表
     * @param offset
     * @param limit
     * @return
     */
    List<SeckillCustomer> queryAll(int offset, int limit);
}
