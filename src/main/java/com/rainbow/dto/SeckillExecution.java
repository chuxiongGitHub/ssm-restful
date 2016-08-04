package com.rainbow.dto;

import com.rainbow.entity.SuccessSeckilled;
import com.rainbow.enums.SeckillStatEnum;

/**
 * Created by rainbow on 2016/8/4.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
//封装秒杀执行后结果
public class SeckillExecution {

    private Long seckillId;

    //秒杀执行过过状态
    private int status;

    //状态描述
    private String statusInfo;

    //秒杀成功对象
    private SuccessSeckilled successSeckilled;

    public SeckillExecution(Long seckillId, SeckillStatEnum statEnum, SuccessSeckilled successSeckilled) {
        this.seckillId = seckillId;
        this.status = statEnum.getStatus();
        this.statusInfo = statEnum.getStatusInfo();
        this.successSeckilled = successSeckilled;
    }

    public SeckillExecution(Long seckillId, SeckillStatEnum statEnum) {
        this.seckillId = seckillId;
        this.status = statEnum.getStatus();
        this.statusInfo = statEnum.getStatusInfo();
    }

    public Long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getStatusInfo() {
        return statusInfo;
    }

    public void setStatusInfo(String statusInfo) {
        this.statusInfo = statusInfo;
    }

    public SuccessSeckilled getSuccessSeckilled() {
        return successSeckilled;
    }

    public void setSuccessSeckilled(SuccessSeckilled successSeckilled) {
        this.successSeckilled = successSeckilled;
    }

    @Override
    public String toString() {
        return "SeckillExecution{" +
                "seckillId=" + seckillId +
                ", status=" + status +
                ", statusInfo='" + statusInfo + '\'' +
                ", successSeckilled=" + successSeckilled +
                '}';
    }
}
