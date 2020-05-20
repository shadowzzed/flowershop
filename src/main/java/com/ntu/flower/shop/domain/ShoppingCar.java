package com.ntu.flower.shop.domain;

import lombok.Data;

import javax.persistence.*;

/**
 * @author Zed
 * @date 2020/5/20 下午1:20
 * @contact shadowl91@163.com
 */
@Entity
@Data
@Table(name = "t_scar")
public class ShoppingCar {
    @Id
    @Column(name = "scar_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer scarId;

    @Column(name = "scar_usr_id")
    private String scarUserId;

    @Column(name = "scar_flo_id")
    private String scarFlowerId;

    @Column(name = "scar_flow_num")
    private Integer scarFlowerNum;

}
