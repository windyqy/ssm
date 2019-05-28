package com.hyl.biz.dao;

import com.hyl.biz.model.House;

import java.util.List;

public interface HouseMapper {
    public List<House> houseList(House house);

    public int houseAdd(House house);

    public int houseUpdate(House house);

    public void houseDelete(House house);

    public int houseZtUpdate(House house);
}
