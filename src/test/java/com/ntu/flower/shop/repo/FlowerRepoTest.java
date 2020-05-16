package com.ntu.flower.shop.repo;

import com.ntu.flower.shop.domain.Flower;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Zed
 * @date 2020/5/16 上午12:09
 * @contact shadowl91@163.com
 */
@SpringBootTest
class FlowerRepoTest {
    @Autowired
    FlowerRepo repo;

    @Test
    @Transactional
    public void testRepo() {
        Flower flower = new Flower();
        flower.setFlowerId("111");
        flower.setFlowerType(1);
        flower.setFlowerImage("222");
        flower.setFlowerPrice(new BigDecimal("3.4"));
        flower.setFlowerStock(10);
        repo.save(flower);

        repo.findAll().forEach(System.out::println);
    }

}