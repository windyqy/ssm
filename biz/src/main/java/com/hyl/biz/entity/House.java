package com.hyl.biz.entity;

import com.hyl.core.model.BaseObj;

public class House extends BaseObj {
    //房源
    private String area;//房源所在区域
    private String way;//房源出租方式
    private Integer price;//房源出租价格
    private String type;//房源户型
    private String orientation;//房源朝向
    private Integer size;//房源面积大小
    private String feature;//房源特色
    private boolean vacancy;//房源是否空置

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getWay() {
        return way;
    }

    public void setWay(String way) {
        this.way = way;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getOrientation() {
        return orientation;
    }

    public void setOrientation(String orientation) {
        this.orientation = orientation;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public String getFeature() {
        return feature;
    }

    public void setFeature(String feature) {
        this.feature = feature;
    }

    public boolean getVacancy() {
        return vacancy;
    }

    public void setVacancy(boolean vacancy) {
        this.vacancy = vacancy;
    }
}
