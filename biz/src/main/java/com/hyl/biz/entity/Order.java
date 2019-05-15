package com.hyl.biz.entity;

import com.hyl.core.model.BaseObj;

import java.sql.Date;
public class Order extends BaseObj {
    //订单
    private String uid;//订单用户ID
    private String hid;//订单房源ID
    private Date starttime;//订单开始时间
    private Integer totalmonth;//订单租房时长(按月计算)
    private String status;//订单状态

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    public Date getStarttime() {
        return starttime;
    }

    public void setStarttime(Date starttime) {
        this.starttime = starttime;
    }

    public Integer getTotalmonth() {
        return totalmonth;
    }

    public void setTotalmonth(Integer totalmonth) {
        this.totalmonth = totalmonth;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

