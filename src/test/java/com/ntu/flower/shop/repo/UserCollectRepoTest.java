package com.ntu.flower.shop.repo;

import com.ntu.flower.shop.domain.UserCollect;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Zed
 * @date 2020/5/16 下午3:12
 * @contact shadowl91@163.com
 */
@SpringBootTest
class UserCollectRepoTest {
    @Autowired
    UserCollectRepo userCollectRepo;
    @Test
    void test() {
        UserCollect collect = new UserCollect();
        collect.setUserId("2");
        collect.setFloId("1");
        userCollectRepo.save(collect);

    }

    @Test
    void test1() {
//        userCollectRepo.queryAll("1").forEach(System.out::println);
        UserCollect userCollect = userCollectRepo.queryOne("2", "1");
        System.out.println(userCollectRepo);
        userCollectRepo.delete(userCollect);
    }
}