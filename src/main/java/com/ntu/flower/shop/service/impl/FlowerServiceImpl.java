package com.ntu.flower.shop.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ntu.flower.shop.config.MyConfig;
import com.ntu.flower.shop.domain.Flower;
import com.ntu.flower.shop.exception.MyException;
import com.ntu.flower.shop.exception.ex.MyExceptionEnum;
import com.ntu.flower.shop.repo.FlowerRepo;
import com.ntu.flower.shop.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author Zed
 * @date 2020/5/16 下午4:52
 * @contact shadowl91@163.com
 */
@Service
public class FlowerServiceImpl implements FlowerService {

    @Autowired
    private FlowerRepo flowerRepo;

    @Autowired
    private MyConfig config;

    @Override
    public List<Flower> getAllFlowers() {
        return flowerRepo.findAll();
    }

    @Override
    public Flower getOneFlower(String json) {
        JSONObject object = (JSONObject) JSONObject.parse(json);
        String flowerId = object.getString(config.flowerId);
        if (StringUtils.isEmpty(flowerId))
            throw new MyException(MyExceptionEnum.FLOWER_NOT_EXISTED);
        return flowerRepo.getOne(flowerId);
    }

    @Override
    public Flower publishFlower(String json) {
        JSONObject jsonObject = JSONObject.parseObject(json);
        String flowerId = jsonObject.getString(config.flowerId);
        String flowerName = jsonObject.getString(config.flowerName);
        String type = jsonObject.getString(config.flowerType);
        String price = jsonObject.getString(config.flowerPrice);
        String stock = jsonObject.getString(config.flowerStock);
        String image = jsonObject.getString(config.flowerImage);
        if (StringUtils.isEmpty(flowerId) ||
        StringUtils.isEmpty(flowerName) ||
        StringUtils.isEmpty(type) ||
        StringUtils.isEmpty(price) ||
        StringUtils.isEmpty(stock) ||
        StringUtils.isEmpty(image))
            throw new MyException(MyExceptionEnum.LOST_PARAM);
        Flower flower = new Flower();
        flower.setFlowerStock(Integer.parseInt(stock));
        flower.setFlowerPrice(new BigDecimal(price));
        flower.setFlowerImage(image);
        flower.setFlowerType(Integer.parseInt(type));
        flower.setFlowerId(flowerId);
        flower.setFlowerName(flowerName);
        return flowerRepo.save(flower);
    }
}
