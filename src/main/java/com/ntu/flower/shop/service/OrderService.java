package com.ntu.flower.shop.service;

import com.ntu.flower.shop.domain.Order;

import java.util.List;

/**
 * @author Zed
 * @date 2020/5/16 下午1:59
 * @contact shadowl91@163.com
 */
public interface OrderService {

    public List<Order> viewOrders(String json);

    public Order viewOneOrder(String json);

    public Order createOrder(String json);
}
