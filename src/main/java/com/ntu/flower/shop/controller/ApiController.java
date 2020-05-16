package com.ntu.flower.shop.controller;

import com.ntu.flower.shop.config.MyConfig;
import com.ntu.flower.shop.domain.*;
import com.ntu.flower.shop.exception.MyException;
import com.ntu.flower.shop.exception.ex.MyExceptionEnum;
import com.ntu.flower.shop.repo.FlowerRepo;
import com.ntu.flower.shop.service.FlowerService;
import com.ntu.flower.shop.service.OrderService;
import com.ntu.flower.shop.service.UserCollectService;
import com.ntu.flower.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author Zed
 * @date 2020/5/16 上午12:14
 * @contact shadowl91@163.com
 */
@SuppressWarnings("ALL")
@RestController
public class ApiController {

    @Autowired
    private MyConfig config;

    @Autowired
    private FlowerService flowerService;

    @Autowired
    private UserCollectService userCollectService;

    @Autowired
    private UserService userService;

    @Autowired
    private OrderService orderService;
    /**
     * create user
     * not null account,password,nick
     * @param msg
     * @return
     */
    @PostMapping("/api/v1/user")
    public Resp register(@RequestBody String msg) {
        this.ifDataInIsEmpty(msg);
        User user = userService.register(msg);
        return new Resp.Builder<User>()
                .code("200")
                .msg("success")
                .data(user)
                .build();
    }

    /**
     * not null account , password
     * @param msg
     * @return
     */
    @PostMapping("/api/v1/user/{userAccount}")
    public Resp login(@RequestBody String msg) {
        this.ifDataInIsEmpty(msg);
        User user = userService.login(msg);
        return new Resp.Builder<User>()
                .code("200")
                .msg("success")
                .data(user)
                .build();
    }

    /**
     * not null account
     * @param msg
     * @return
     */
    @PostMapping("/api/v1/user/profile")
    public Resp update(@RequestBody String msg) {
        this.ifDataInIsEmpty(msg);
        User user = userService.update(msg);
        return new Resp.Builder<User>()
                .code("200")
                .msg("success")
                .data(user)
                .build();
    }

    @GetMapping("/api/v1/collect/user/{account}")
    public Resp viewCollect(@PathVariable("account")String account) {
        List<UserCollect> collects = userCollectService.viewCollect(account);
        return new Resp.Builder<List<UserCollect>>()
                .code("200")
                .msg("success")
                .data(collects)
                .build();
    }

    @PostMapping("/api/v1/collect/{account}")
    public Resp updateCollect(@RequestBody String msg) {
        this.ifDataInIsEmpty(msg);
        UserCollect userCollect = userCollectService.addCollect(msg);
        return new Resp.Builder<UserCollect>()
                .code("200")
                .msg("success")
                .data(userCollect)
                .build();
    }

    @PostMapping("/api/v1/collect/")
    public Resp removeCollect(@RequestBody String msg) {
        this.ifDataInIsEmpty(msg);
        userCollectService.deleteCollect(msg);
        return new Resp.Builder<>()
                .code("200")
                .msg("success")
                .build();
    }

    @PostMapping("/api/v1/order/{userAccount}")
    public Resp createOrder(@RequestBody String msg) {
        this.ifDataInIsEmpty(msg);
        Order order = orderService.createOrder(msg);
        return new Resp.Builder<Order>()
                .code("200")
                .msg("success")
                .data(order)
                .build();
    }

    @GetMapping("/api/v1/order/one/{orderId}")
    public Resp viewOneOrder(@RequestBody String msg) {
        this.ifDataInIsEmpty(msg);
        Order order = orderService.viewOneOrder(msg);
        return new Resp.Builder<Order>()
                .code("200")
                .msg("success")
                .data(order)
                .build();
    }

    @GetMapping("/api/v1/order/all/{account}")
    public Resp viewAllOrders(@RequestBody String msg) {
        this.ifDataInIsEmpty(msg);
        List<Order> orders = orderService.viewOrders(msg);
        return new Resp.Builder<List<Order>>()
                .code("200")
                .msg("success")
                .data(orders)
                .build();
    }


    @GetMapping("/api/v1/flower/all")
    public Resp viewAllFlowers() {

        List<Flower> list = flowerService.getAllFlowers();
        return new Resp.Builder<List<Flower>>()
                .code("200")
                .msg("success")
                .data(list)
                .build();
    }

    @GetMapping("/api/v1/flower/{flowerId}")
    public Resp viewOneFlower(@RequestBody String msg) {
        this.ifDataInIsEmpty(msg);
        Flower flower = flowerService.getOneFlower(msg);
        return new Resp.Builder<Flower>()
                .data(flower)
                .code("200")
                .msg("success")
                .build();
    }


    private void ifDataInIsEmpty(String msg) {
        if (!"dev".equals(config.mode)&& StringUtils.isEmpty(msg))
            throw new MyException(MyExceptionEnum.JSON_IS_NULL);
    }



}
