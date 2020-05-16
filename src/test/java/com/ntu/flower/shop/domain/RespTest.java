package com.ntu.flower.shop.domain;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Zed
 * @date 2020/5/16 下午2:41
 * @contact shadowl91@163.com
 */
class RespTest {
    @Test
    void test() {
        User user = new User();
        user.setPassword("111");
        Resp build = new Resp.Builder<>()
                .code("200")
                .msg("222")
                .data(user)
                .build();
        System.out.println(build);

        OrderDetail orderDetail = new OrderDetail();
        orderDetail.setOrderDetailFlowerId("22");
        List<OrderDetail> orderDetails = new ArrayList<>();
        OrderDetail orderDetail1 = new OrderDetail();
        orderDetail1.setOrderDetailFlowerId("11");
        orderDetails.add(orderDetail);
        orderDetails.add(orderDetail1);
        OrderDetail[] orderDetails1 = orderDetails.toArray(new OrderDetail[0]);
        Resp<Object> build1 = new Resp.Builder<>()
                .code("200")
                .msg("22")
                .data(orderDetails1)
                .build();
        System.out.println(JSON.toJSONString(orderDetails1));
        System.out.println(JSON.toJSONString(build1));
        String json = JSON.toJSONString(build1);
        JSONObject jsonObject = JSON.parseObject(json);
        String data = jsonObject.getString("data");
        System.out.println(data);
        JSONArray objects = JSONObject.parseArray(data);
        for (int i = 0; i < objects.size(); i++) {
            Object o = objects.get(i);
            System.out.println(objects.get(i));
            JSONObject o1 = (JSONObject) o;
            System.out.println(o1.getString("orderDetailFlowerId"));
        }
//        System.out.println();
    }




}