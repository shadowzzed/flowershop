package com.ntu.flower.shop.service;

import com.ntu.flower.shop.domain.Flower;

import java.util.List;

/**
 * @author Zed
 * @date 2020/5/16 下午4:52
 * @contact shadowl91@163.com
 */
public interface FlowerService {
    List<Flower> getAllFlowers();
    Flower getOneFlower(String json);
    Flower publishFlower(String json);
}
