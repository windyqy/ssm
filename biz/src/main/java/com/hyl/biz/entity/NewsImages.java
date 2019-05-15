package com.hyl.biz.entity;

import com.hyl.core.model.BaseObj;

public class NewsImages extends BaseObj {
    //新闻图片
    private String address;//新闻图片地址
    private Integer nid;//新闻图片对应新闻ID

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getNid() {
        return nid;
    }

    public void setNid(Integer nid) {
        this.nid = nid;
    }
}
