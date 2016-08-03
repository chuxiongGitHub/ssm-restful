package com.rainbow.mapper;

import com.rainbow.entity.SuccessSeckilled;
import org.apache.ibatis.annotations.Param;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * Created by rainbow on 2016/8/3.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public interface SuccessSeckilledMapper {

    /**
     * 插入购买明细
     * @param seckillId
     * @param userPhone
     * @return
     */
    int insertSuccessSeckilled(@Param("seckillId") long seckillId, @Param("user_Phone") long userPhone);

    /**
     * 根据id查询SuccessSeckilled并携带秒杀产品对象实体
     * @param seckillId
     * @return
     */
    SuccessSeckilled queryByIdWithSeckill(@Param("seckillId") long seckillId,@Param("userPhone") Long userPhone);
}
