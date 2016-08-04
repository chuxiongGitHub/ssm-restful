package com.rainbow.exception;

/**
 * Created by rainbow on 2016/8/4.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
//重复秒杀异常（运行期异常）
public class RepeatKillException  extends SeckillException{

    public RepeatKillException(String message) {
        super(message);
    }

    public RepeatKillException(String message, Throwable cause) {
        super(message, cause);
    }
}
