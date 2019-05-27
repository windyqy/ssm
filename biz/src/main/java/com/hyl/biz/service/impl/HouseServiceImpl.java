package com.hyl.biz.service.impl;

import com.hyl.biz.model.House;
import com.hyl.biz.service.HouseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HouseServiceImpl implements HouseService {
    @Autowired
    HouseMapper houseMapper;
    public int houseZtUpdate(House house){
        return houseMapper.houseZtUpdate(house);
    }
    public List<House> List(House house){
        return houseMapper.houseList(house);
    }
    public int Add(House house){
        return houseMapper.houseAdd(house);
    }
    public int Update(House house){
        return houseMapper.houseUpdate(house);
    }
    public void Delete(House house){
        houseMapper.houseDelete(house);
    }

}
