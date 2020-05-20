package com.ntu.flower.shop.repo;

import com.ntu.flower.shop.domain.ShoppingCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Zed
 * @date 2020/5/20 下午1:32
 * @contact shadowl91@163.com
 */
@Repository
public interface ShoppingCarRepo extends JpaRepository<ShoppingCar, Integer> {
    @Query(value = "select * from t_scar where scar_usr_id = ? and scar_flo_id = ?",nativeQuery = true)
    public ShoppingCar getOneRecord(String userAccount, String flowerId);

    @Query(value = "select * from t_scar where scar_usr_id = ?", nativeQuery = true)
    public List<ShoppingCar> getAllRecords(String userAccount);
}
