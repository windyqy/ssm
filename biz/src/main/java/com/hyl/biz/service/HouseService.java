package com.hyl.biz.service;

import com.hyl.biz.model.House;

import java.util.List;

public interface HouseService {
    public List<House> List(House house);

    public int Add(House house);

    public int Update(House house);

    public void Delete(House house);

    public int houseZtUpdate(House house);
}
