package com.ntu.flower.shop.service.impl;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.ntu.flower.shop.config.MyConfig;
import com.ntu.flower.shop.domain.Flower;
import com.ntu.flower.shop.domain.Order;
import com.ntu.flower.shop.domain.OrderDetail;
import com.ntu.flower.shop.exception.MyException;
import com.ntu.flower.shop.exception.ex.MyExceptionEnum;
import com.ntu.flower.shop.repo.FlowerRepo;
import com.ntu.flower.shop.repo.OrderDetailRepo;
import com.ntu.flower.shop.repo.OrderRepo;
import com.ntu.flower.shop.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author Zed
 * @date 2020/5/16 下午3:44
 * @contact shadowl91@163.com
 */
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @Autowired
    private MyConfig config;

    @Autowired
    private FlowerRepo flowerRepo;

    @Autowired
    private OrderRepo orderRepo;

    @Autowired
    private OrderDetailRepo orderDetailRepo;

    @Override
    public List<Order> viewOrders(String json) {
        JSONObject ob = (JSONObject) JSONObject.parse(json);
        String account = ob.getString(config.account);
        if (StringUtils.isEmpty(account))
            throw new MyException(MyExceptionEnum.LOST_PARAM);
        List<Order> orders = orderRepo.getOrders(account);
        for (Order order: orders) {
            String orderId = order.getOrderId();
            List<OrderDetail> orderDetails = orderDetailRepo.getOrderDetails(orderId);
            order.setOrderDetails(orderDetails);
        }
        return orders;
    }

    @Override
    public Order viewOneOrder(String json) {
        JSONObject object = (JSONObject) JSONObject.parse(json);
        String orderId = object.getString("orderId");
        if (StringUtils.isEmpty(orderId))
            throw new MyException(MyExceptionEnum.LOST_PARAM);
        return orderRepo.getOneOrder(orderId);
    }

    @Transactional
    @Override
    public Order createOrder(String json) {
        JSONObject object = (JSONObject) JSONObject.parse(json);
        JSONArray array = object.getJSONArray(config.data);
        String account = object.getString(config.account);
        if (StringUtils.isEmpty(account) || array.size() < 1)
            throw new MyException(MyExceptionEnum.LOST_PARAM);
        String uuid = UUID.randomUUID().toString();
        String orderId = uuid.replace("-", "");
        Order order = new Order();
        order.setOrderId(orderId);
        order.setOrderAcc(account);
        double total = 0;
        log.info("uuid={}", orderId);
        List<OrderDetail> orderDetailList = new ArrayList<>();
        for (int i = 0; i < array.size(); i++) {
            JSONObject jsonObject = (JSONObject) array.get(i);
            String flowerId = jsonObject.getString(config.orderFlowerId);
            Integer count = jsonObject.getInteger(config.orderFlowerCount);
            Flower flower = flowerRepo.findById(flowerId).orElse(null);
            if (flower == null)
                throw new MyException(MyExceptionEnum.FLOWER_NOT_EXISTED);
            BigDecimal price = flower.getFlowerPrice();
            flower.setFlowerStock(flower.getFlowerStock() - count);
            flowerRepo.save(flower);
            double total_temp = price.multiply(new BigDecimal(count)).doubleValue();
            total += total_temp;
            OrderDetail orderDetail = new OrderDetail();
            orderDetail.setOrderId(orderId);
            orderDetail.setOrderDetailFlowerId(flowerId);
            orderDetail.setOrderDetailFlowerPrice(price);
            orderDetail.setOrderDetailNumber(count);
            orderDetailList.add(orderDetail);
            orderDetailRepo.save(orderDetail);
        }
        order.setOrderPrice(new BigDecimal(total));
        order.setOrderDetails(orderDetailList);
        orderRepo.save(order);
        return order;
    }
}
