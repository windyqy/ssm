package com.hyl.biz.dao;

import com.hyl.biz.model.Order;

import java.util.List;

public interface OrderMapper {
    public int orderUpzt(Order order);

    public List<Order> orderListone(Order order);

    public int orderAdd(Order order);

    public int orderUpdate(Order order);

    public void orderDelete(Order order);
}
