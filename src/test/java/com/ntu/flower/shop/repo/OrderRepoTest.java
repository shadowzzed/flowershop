package com.ntu.flower.shop.repo;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Zed
 * @date 2020/5/16 下午4:19
 * @contact shadowl91@163.com
 */
@SpringBootTest
class OrderRepoTest {

    @Autowired
    OrderRepo repo;

    @Test
    void getOrders() {
        repo.getOrders("tr").forEach(System.out::println);
    }
}