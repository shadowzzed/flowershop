package com.ntu.flower.shop.repo;

import com.ntu.flower.shop.domain.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author Zed
 * @date 2020/5/15 下午11:57
 * @contact shadowl91@163.com
 */
@Repository
public interface OrderRepo extends JpaRepository<Order, String> {
    @Query(value = "select * from t_order where order_account = ?",nativeQuery = true)
    public List<Order> getOrders(String account);

    @Query(value = "select * from t_order where order_id = ?",nativeQuery = true)
    public Order getOneOrder(String orderId);
}
