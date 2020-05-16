package com.ntu.flower.shop.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ntu.flower.shop.config.MyConfig;
import com.ntu.flower.shop.domain.UserCollect;
import com.ntu.flower.shop.exception.MyException;
import com.ntu.flower.shop.exception.ex.MyExceptionEnum;
import com.ntu.flower.shop.repo.UserCollectRepo;
import com.ntu.flower.shop.service.UserCollectService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;

/**
 * @author Zed
 * @date 2020/5/16 下午3:18
 * @contact shadowl91@163.com
 */
@Service
public class UserCollectServiceImpl implements UserCollectService {
    @Autowired
    private MyConfig config;

    @Autowired
    private UserCollectRepo userCollectRepo;

    @Override
    public UserCollect addCollect(String json) {
        JSONObject object = (JSONObject) JSONObject.parse(json);
        String account = object.getString(config.account);
        String flowerId = object.getString(config.flowerId);
        if (StringUtils.isEmpty(account) || StringUtils.isEmpty(flowerId))
            throw new MyException(MyExceptionEnum.LOST_PARAM);
        UserCollect userCollect = new UserCollect();
        userCollect.setUserId(account);
        userCollect.setFloId(flowerId);
        List<UserCollect> collects = userCollectRepo.queryAll(account);
        for (UserCollect collect : collects) {
            if (collect.getFloId().equals(flowerId))
                throw new MyException(MyExceptionEnum.CANNOT_REPEAT_ADD);
        }
        userCollectRepo.save(userCollect);
        return userCollect;
    }

    @Override
    public List<UserCollect> viewCollect(String account) {
        if (StringUtils.isEmpty(account))
            throw new MyException(MyExceptionEnum.LOST_PARAM);
        List<UserCollect> collects = userCollectRepo.queryAll(account);
        return collects;
    }

    @Override
    public void deleteCollect(String json) {
        JSONObject object = (JSONObject) JSONObject.parse(json);
        String account = object.getString(config.account);
        String flowerId = object.getString(config.flowerId);
        UserCollect userCollect = userCollectRepo.queryOne(account, flowerId);
        if (userCollect == null)
            throw new MyException(MyExceptionEnum.COLLECT_NOT_EXISTED);
        userCollectRepo.delete(userCollect);
    }
}
