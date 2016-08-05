package com.rainbow.generator.entity;

import java.util.Date;

public class SuccessKilled extends SuccessKilledKey {
    private Byte status;

    private Date createTime;

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}