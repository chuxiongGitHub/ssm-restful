package com.rainbow.enums;

/**
 * Created by rainbow on 2016/8/4.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
//使用枚举表示常量数字段
public enum SeckillStatEnum {
    SUCCESS(1,"秒杀成功"),
    END(0,"秒杀结束"),
    REPEAT_KILL(-1,"重复秒杀"),
    INNER_ERRO(-2,"系统异常"),
    DATA_REARITE(-3,"数据篡改")
    ;

    private int status;
    private String statusInfo;

    SeckillStatEnum(int status, String statusInfo) {
        this.status = status;
        this.statusInfo = statusInfo;
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
    public static SeckillStatEnum statusOf(int index) {
        for (SeckillStatEnum status : values()) {
            if (status.getStatus() == index) {
                return status;
            }
        }
        return null;

    }
}
