package com.ntu.flower.shop.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

/**
 * @author Zed
 * @date 2020/5/16 上午12:41
 * @contact shadowl91@163.com
 */
@Configuration
public class MyConfig {

    @Value("${value.usr.name}")
    public String username;

    @Value("${value.collect.flower.id}")
    public String flowerId;

    @Value("${value.order.flower.id}")
    public String orderFlowerId;

    @Value("${value.order.flower.num}")
    public String orderFlowerCount;

    @Value("${value.order.data}")
    public String data;

    @Value("${value.mode.dev}")
    public String mode;

    @Value("${value.usr.password}")
    public String password;

    @Value("${value.usr.account}")
    public String account;

    @Value("${value.usr.address}")
    public String address;

    @Value("${value.usr.balance}")
    public String balance;

    @Value("${value.usr.tel}")
    public String telphone;

}
