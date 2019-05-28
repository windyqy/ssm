package com.hyl.biz.service;

import com.hyl.biz.model.Order;

import java.util.List;

public interface OrderService {
    public int orderUpzt(Order order);

    public List<Order> orderListone(Order order);

    public int orderAdd(Order order);

    public int orderUpdate(Order order);

    public void orderDelete(Order order);
}
