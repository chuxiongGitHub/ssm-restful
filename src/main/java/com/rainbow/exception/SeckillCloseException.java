package com.rainbow.exception;

/**
 * Created by rainbow on 2016/8/4.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
//秒杀关闭异常
public class SeckillCloseException extends  SeckillException{
    public SeckillCloseException(String message) {
        super(message);
    }

    public SeckillCloseException(String message, Throwable cause) {
        super(message, cause);
    }
}
