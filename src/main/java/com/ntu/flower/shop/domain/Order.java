package com.ntu.flower.shop.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.List;

/**
 * @author Zed
 * @date 2020/5/15 下午11:48
 * @contact shadowl91@163.com
 */
@Entity
@Data
@Table(name = "t_order")
public class Order implements Serializable {
    @Id
    @Column(name = "order_id")
    private String orderId;

    @Column(name = "order_account")
    private String orderAcc;

    @Column(name = "order_price")
    private BigDecimal orderPrice;

    @Transient
    private List<OrderDetail> orderDetails;
}
