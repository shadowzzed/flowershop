package com.ntu.flower.shop.service;

import com.ntu.flower.shop.domain.ShoppingCar;

import java.util.List;

/**
 * @author Zed
 * @date 2020/5/20 下午1:38
 * @contact shadowl91@163.com
 */
public interface ShoppingCarService {
    public ShoppingCar getOneRecord(String json);

    public ShoppingCar addOneRecord(String json);

    public List<ShoppingCar> getAllRecords(String json);
}
