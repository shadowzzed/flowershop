package com.ntu.flower.shop.repo;

import com.ntu.flower.shop.domain.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.math.BigDecimal;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author Zed
 * @date 2020/5/15 下午11:37
 * @contact shadowl91@163.com
 */
@SpringBootTest
class UserRepoTest {

    @Autowired
    private UserRepo repo;

    @Test
    public void testRep() {
        User user = new User();
        user.setUserAcc("testAccount");
        user.setPassword("123");
        user.setUserAdd("add");
        user.setUserBalance(new BigDecimal("2.5"));
        user.setUserNick("test Nick");
        user.setUserTel("123");
        repo.save(user);

        System.out.println(repo.findById("11").orElse(null));
//        System.out.println(repo.getOne("11"));
    }
}