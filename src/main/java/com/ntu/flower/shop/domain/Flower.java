package com.ntu.flower.shop.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Zed
 * @date 2020/5/15 下午11:55
 * @contact shadowl91@163.com
 */
@Entity
@Data
@Table(name = "t_flower")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler","flowerId"})
public class Flower implements Serializable {

    @Id
    @Column(name = "flo_id")
    private String flowerId;

    @Column(name = "flo_type")
    private int flowerType;

    @Column(name = "flo_src")
    private String flowerImage;

    @Column(name = "flo_price")
    private BigDecimal flowerPrice;

    @Column(name = "flo_stock")
    private int flowerStock;
}
