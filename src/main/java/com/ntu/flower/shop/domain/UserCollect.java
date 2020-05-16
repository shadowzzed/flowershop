package com.ntu.flower.shop.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

/**
 * @author Zed
 * @date 2020/5/15 下午11:46
 * @contact shadowl91@163.com
 */
@Entity
@Data
@Table(name = "t_collect")
public class UserCollect implements Serializable {

    @Id
    @Column(name = "colct_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int collectId;

    @Column(name = "colct_usr_id")
    private String userId;

    @Column(name = "colct_flo_id")
    private String floId;
}
