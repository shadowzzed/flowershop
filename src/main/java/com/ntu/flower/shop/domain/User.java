package com.ntu.flower.shop.domain;

import lombok.Data;
import org.hibernate.annotations.Proxy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * @author Zed
 * @date 2020/5/15 下午11:30
 * @contact shadowl91@163.com
 */
@Entity
@Data
@Proxy(lazy = false)
@Table(name = "t_user")
public class User implements Serializable {
    @Id
    @Column(name = "user_account")
    private String userAcc;

    @Column(name = "user_nick")
    private String userNick;

    @Column(name = "user_password")
    private String password;

    @Column(name = "user_address")
    private String userAdd;

    @Column(name = "user_balance")
    private BigDecimal userBalance;

    @Column(name = "user_tel")
    private String userTel;
}
