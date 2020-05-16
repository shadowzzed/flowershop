package com.ntu.flower.shop.repo;

import com.ntu.flower.shop.domain.UserCollect;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Zed
 * @date 2020/5/16 上午12:08
 * @contact shadowl91@163.com
 */
@Repository
public interface UserCollectRepo extends JpaRepository<UserCollect, String> {
    @Query(value = "select * from t_collect where colct_usr_id = ?", nativeQuery = true)
    public List<UserCollect> queryAll(String account);

    @Query(value = "select * from t_collect where colct_usr_id = ? and colct_flo_id = ?", nativeQuery = true)
    public UserCollect queryOne(String account, String flowerId);
}
