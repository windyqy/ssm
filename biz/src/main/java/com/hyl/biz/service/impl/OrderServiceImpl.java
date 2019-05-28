package com.hyl.biz.service.impl;

import com.hyl.biz.dao.OrderMapper;
import com.hyl.biz.model.Order;
import com.hyl.biz.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    public int orderUpzt(Order order) {
        return orderMapper.orderUpzt(order);
    }

    public List<Order> orderListone(Order order) {
        return orderMapper.orderListone(order);
    }

    public int orderAdd(Order order) {
        return orderMapper.orderAdd(order);
    }

    public int orderUpdate(Order order) {
        return orderMapper.orderUpdate(order);
    }

    public void orderDelete(Order order) {
        orderMapper.orderDelete(order);
    }
}
