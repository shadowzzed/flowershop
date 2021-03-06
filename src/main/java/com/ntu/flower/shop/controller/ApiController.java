package com.ntu.flower.shop.controller;

import com.ntu.flower.shop.config.MyConfig;
import com.ntu.flower.shop.domain.*;
import com.ntu.flower.shop.exception.MyException;
import com.ntu.flower.shop.exception.ex.MyExceptionEnum;
import com.ntu.flower.shop.repo.FlowerRepo;
import com.ntu.flower.shop.service.*;
import lombok.extern.slf4j.Slf4j;
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
@Slf4j
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
    private ShoppingCarService shoppingCarService;

    @Autowired
    private OrderService orderService;
    /**
     * create user
     * not null account,password,nick
     * @param msg
     * @return
     */
    @PostMapping("/api/v1/user")
    public Resp register(String msg) {
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
    public Resp login(String msg) {
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
    public Resp update(String msg) {
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
    public Resp updateCollect(String msg) {
        this.ifDataInIsEmpty(msg);
        UserCollect userCollect = userCollectService.addCollect(msg);
        return new Resp.Builder<UserCollect>()
                .code("200")
                .msg("success")
                .data(userCollect)
                .build();
    }

    @PostMapping("/api/v1/collect/")
    public Resp removeCollect(String msg) {
        this.ifDataInIsEmpty(msg);
        userCollectService.deleteCollect(msg);
        return new Resp.Builder<>()
                .code("200")
                .msg("success")
                .build();
    }

    @PostMapping("/api/v1/order/{userAccount}")
    public Resp createOrder(String msg) {
        this.ifDataInIsEmpty(msg);
        Order order = orderService.createOrder(msg);
        return new Resp.Builder<Order>()
                .code("200")
                .msg("success")
                .data(order)
                .build();
    }

    @GetMapping("/api/v1/order/one/{orderId}")
    public Resp viewOneOrder(String msg) {
        this.ifDataInIsEmpty(msg);
        Order order = orderService.viewOneOrder(msg);
        return new Resp.Builder<Order>()
                .code("200")
                .msg("success")
                .data(order)
                .build();
    }

    @GetMapping("/api/v1/order/all/{account}")
    public Resp viewAllOrders(String msg) {
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
    public Resp viewOneFlower(String msg) {
        this.ifDataInIsEmpty(msg);
        Flower flower = flowerService.getOneFlower(msg);
        return new Resp.Builder<Flower>()
                .data(flower)
                .code("200")
                .msg("success")
                .build();
    }

    @GetMapping("/api/v1/shopping/car/one/{userAccount}")
    public Resp getOneShoppingCarRecord(String msg) {
        this.ifDataInIsEmpty(msg);
        ShoppingCar shoppingCar = shoppingCarService.getOneRecord(msg);
        return new Resp.Builder<ShoppingCar>()
                .code("200")
                .msg("success")
                .data(shoppingCar)
                .build();
    }

    @PostMapping("/api/v1/shopping/car/")
    public Resp addOneShoppingCarRecord(String msg) {
        this.ifDataInIsEmpty(msg);
        ShoppingCar shoppingCar = shoppingCarService.addOneRecord(msg);
        return new Resp.Builder<ShoppingCar>()
                .code("200")
                .msg("success")
                .data(shoppingCar)
                .build();
    }

    @GetMapping("/api/v1/shopping/car/all/")
    public Resp getAllRecords(String msg) {
        this.ifDataInIsEmpty(msg);
        List<ShoppingCar> list = shoppingCarService.getAllRecords(msg);
        return new Resp.Builder<List<ShoppingCar>>()
                .data(list)
                .code("200")
                .msg("success")
                .build();
    }

    @PostMapping("/api/v1/flower/one/1")
    public Resp publishFlower(String msg) {
        this.ifDataInIsEmpty(msg);
        Flower flower = flowerService.publishFlower(msg);
        return new Resp.Builder<Flower>()
                .msg("success")
                .code("200")
                .data(flower)
                .build();
    }

    private void ifDataInIsEmpty(String msg) {
        if (!"dev".equals(config.mode)&& StringUtils.isEmpty(msg))
            throw new MyException(MyExceptionEnum.JSON_IS_NULL);
        log.info("msg = {}",msg);
    }



}
