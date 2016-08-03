package com.rainbow.entity;

import java.util.List;

/**
 * Created by rainbow on 2016/8/3.
 * 一事专注，便是动人；一生坚守，便是深邃！
 */
public class SeckillQueryVo {
    private SeckillCustomer seckillCustomer;
    private List<SeckillCustomer> seckillCustomerList;

    public SeckillCustomer getSeckillCustomer() {
        return seckillCustomer;
    }

    public void setSeckillCustomer(SeckillCustomer seckillCustomer) {
        this.seckillCustomer = seckillCustomer;
    }

    public List<SeckillCustomer> getSeckillCustomerList() {
        return seckillCustomerList;
    }

    public void setSeckillCustomerList(List<SeckillCustomer> seckillCustomerList) {
        this.seckillCustomerList = seckillCustomerList;
    }
}
