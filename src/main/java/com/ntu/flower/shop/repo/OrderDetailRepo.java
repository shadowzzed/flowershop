package com.ntu.flower.shop.repo;

import com.ntu.flower.shop.domain.OrderDetail;
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
public interface OrderDetailRepo extends JpaRepository<OrderDetail, String> {

    @Query(value = "select * from t_orderdetail where od_order_id = ?",nativeQuery = true)
    public List<OrderDetail> getOrderDetails(String orderId);
}
