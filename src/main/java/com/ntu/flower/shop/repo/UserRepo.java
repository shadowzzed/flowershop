package com.ntu.flower.shop.repo;

import com.ntu.flower.shop.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author Zed
 * @date 2020/5/15 下午11:37
 * @contact shadowl91@163.com
 */
@Repository
public interface UserRepo extends JpaRepository<User, String> {
}
