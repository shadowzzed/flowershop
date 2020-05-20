package com.ntu.flower.shop.repo;

import com.ntu.flower.shop.domain.ShoppingCar;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Zed
 * @date 2020/5/20 下午1:35
 * @contact shadowl91@163.com
 */
@SpringBootTest
class ShoppingCarRepoTest {
    @Autowired
    ShoppingCarRepo shoppingCarRepo;

    @Test
    public void test() {
//        System.out.println(shoppingCarRepo.getOneRecord("11", "111"));
        ShoppingCar shoppingCar = new ShoppingCar();
        shoppingCar.setScarUserId("11");
        shoppingCar.setScarFlowerId("22");
        shoppingCar.setScarFlowerNum(20);
        shoppingCarRepo.save(shoppingCar);
    }

}