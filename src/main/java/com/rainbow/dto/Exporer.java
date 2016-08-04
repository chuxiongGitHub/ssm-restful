package com.rainbow.dto;

/**
 * Created by rainbow on 2016/8/4.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
//暴露秒杀地址DTO
public class Exporer {
    //是否开启秒杀
    private boolean exposed;
    //一种加密措施
    private String md5;
    private Long seckillId;
    //系统当前时间
    private Long now;
    //开启时间
    private Long start;
    //结束时间
    private Long end;

    public Exporer(boolean exposed,String md5, Long seckillId) {
        this.exposed = exposed;
        this.md5 = md5;
        this.seckillId = seckillId;
    }

    public Exporer(boolean exposed,Long seckillId, Long now, Long end, Long start) {
        this.exposed = exposed;
        this.seckillId=seckillId;
        this.now = now;
        this.end = end;
        this.start = start;
    }

    public Exporer(boolean exposed, Long seckillId) {
        this.exposed = exposed;
        this.seckillId = seckillId;
    }

    public boolean isExposed() {
        return exposed;
    }

    public void setExposed(boolean exposed) {
        this.exposed = exposed;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public Long getSeckillId() {
        return seckillId;
    }

    public void setSeckillId(Long seckillId) {
        this.seckillId = seckillId;
    }

    public Long getNow() {
        return now;
    }

    public void setNow(Long now) {
        this.now = now;
    }

    public Long getStart() {
        return start;
    }

    public void setStart(Long start) {
        this.start = start;
    }

    public Long getEnd() {
        return end;
    }

    public void setEnd(Long end) {
        this.end = end;
    }

    @Override
    public String toString() {
        return "Exporer{" +
                "exposed=" + exposed +
                ", md5='" + md5 + '\'' +
                ", seckillId=" + seckillId +
                ", now=" + now +
                ", start=" + start +
                ", end=" + end +
                '}';
    }
}
