package com.hyl.biz.service.impl;

import com.lx.mapper.HouseImagesMapper;
import com.lx.service.HouseImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class HouseImagesServiceImpl implements HouseImagesService {
    @Autowired
    HouseImagesMapper houseImagesMapper;
}
