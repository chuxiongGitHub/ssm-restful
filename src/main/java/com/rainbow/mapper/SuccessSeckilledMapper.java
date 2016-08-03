package com.rainbow.mapper;

import com.rainbow.entity.SuccessSeckilled;

/**
 * Created by rainbow on 2016/8/3.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public interface SuccessSeckilledMapper {

    /**
     * 插入购买明细
     * @param seckilled
     * @param userPhone
     * @return
     */
    int insertSuccessSeckilled(long seckilled,long userPhone);

    /**
     * 根据id查询SuccessSeckilled并携带秒杀产品对象实体
     * @param seckillId
     * @return
     */
    SuccessSeckilled queryByIdWithSeckill(long seckillId);
}
