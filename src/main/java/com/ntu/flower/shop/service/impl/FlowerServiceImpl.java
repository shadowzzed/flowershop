package com.ntu.flower.shop.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ntu.flower.shop.domain.Flower;
import com.ntu.flower.shop.exception.MyException;
import com.ntu.flower.shop.exception.ex.MyExceptionEnum;
import com.ntu.flower.shop.repo.FlowerRepo;
import com.ntu.flower.shop.service.FlowerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

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

    @Override
    public List<Flower> getAllFlowers() {
        return flowerRepo.findAll();
    }

    @Override
    public Flower getOneFlower(String json) {
        JSONObject object = (JSONObject) JSONObject.parse(json);
        String flowerId = object.getString("flowerId");
        if (StringUtils.isEmpty(flowerId))
            throw new MyException(MyExceptionEnum.FLOWER_NOT_EXISTED);
        return flowerRepo.getOne(flowerId);
    }
}
