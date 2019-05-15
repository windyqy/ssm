package com.hyl.biz.entity;

import com.hyl.core.model.BaseObj;

public class HouseImages extends BaseObj {
    //
    private String address;//房屋图片地址

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getHid() {
        return hid;
    }

    public void setHid(String hid) {
        this.hid = hid;
    }

    private String hid;//房屋图片对应房屋ID
}
