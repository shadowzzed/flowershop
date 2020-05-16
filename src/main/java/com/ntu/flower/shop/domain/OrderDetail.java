package com.ntu.flower.shop.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Zed
 * @date 2020/5/15 下午11:50
 * @contact shadowl91@163.com
 */
@Entity
@Table(name = "t_orderdetail")
@Data
public class OrderDetail implements Serializable {
    @Id
    @Column(name = "od_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String orderDetailId;

    @Column(name = "od_order_id")
    private String orderId;

    @Column(name = "od_flo_id")
    private String orderDetailFlowerId;

    @Column(name = "od_num")
    private int orderDetailNumber;

    @Column(name = "od_flo_price")
    private BigDecimal orderDetailFlowerPrice;
}
