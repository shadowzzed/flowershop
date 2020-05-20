package com.ntu.flower.shop.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.ntu.flower.shop.config.MyConfig;
import com.ntu.flower.shop.domain.ShoppingCar;
import com.ntu.flower.shop.exception.MyException;
import com.ntu.flower.shop.exception.ex.MyExceptionEnum;
import com.ntu.flower.shop.repo.ShoppingCarRepo;
import com.ntu.flower.shop.service.ShoppingCarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author Zed
 * @date 2020/5/20 下午1:46
 * @contact shadowl91@163.com
 */
@Service
public class ShoppingCarServiceImpl implements ShoppingCarService {

    @Autowired
    private MyConfig config;

    @Autowired
    private ShoppingCarRepo repo;

    @Override
    public ShoppingCar getOneRecord(String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        String userAcc = jsonObject.getString(config.username);
        String flowerId = jsonObject.getString(config.flowerId);
        if (StringUtils.isEmpty(userAcc) || StringUtils.isEmpty(flowerId))
            throw new MyException(MyExceptionEnum.LOST_PARAM);
        return repo.getOneRecord(userAcc, flowerId);
    }

    @Override
    public ShoppingCar addOneRecord(String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        String userAcc = jsonObject.getString(config.username);
        String flowerId = jsonObject.getString(config.flowerId);
        Integer flowerNum = jsonObject.getInteger(config.orderFlowerCount);
        if (StringUtils.isEmpty(userAcc) || StringUtils.isEmpty(flowerId) || flowerNum == null)
            throw new MyException(MyExceptionEnum.LOST_PARAM);
        ShoppingCar shoppingCar = new ShoppingCar();
        shoppingCar.setScarFlowerId(flowerId);
        shoppingCar.setScarFlowerNum(flowerNum);
        shoppingCar.setScarUserId(userAcc);
        return repo.save(shoppingCar);
    }

    @Override
    public List<ShoppingCar> getAllRecords(String json) {
        JSONObject jsonObject = JSON.parseObject(json);
        String userAcc = jsonObject.getString(config.username);
        if (StringUtils.isEmpty(userAcc))
            throw new MyException(MyExceptionEnum.LOST_PARAM);
        return repo.getAllRecords(userAcc);
    }
}
