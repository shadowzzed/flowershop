package com.ntu.flower.shop.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.ntu.flower.shop.config.MyConfig;
import com.ntu.flower.shop.domain.User;
import com.ntu.flower.shop.domain.UserCollect;
import com.ntu.flower.shop.exception.MyException;
import com.ntu.flower.shop.exception.ex.MyExceptionEnum;
import com.ntu.flower.shop.repo.UserCollectRepo;
import com.ntu.flower.shop.repo.UserRepo;
import com.ntu.flower.shop.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

/**
 * @author Zed
 * @date 2020/5/16 上午12:13
 * @contact shadowl91@163.com
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private MyConfig config;

    @Autowired
    private UserRepo userRepo;

    @Autowired
    private UserCollectRepo userCollectRepo;

    @Override
    public User register(String json) {
        User user_db = null;
        User user = JSONObject.parseObject(json, User.class);
        if (StringUtils.isEmpty(user.getUserAcc()) || StringUtils.isEmpty(user.getPassword()) || StringUtils.isEmpty(user.getUserNick()))
            throw new MyException(MyExceptionEnum.LOST_PARAM);
        User one = userRepo.findById(user.getUserAcc()).orElse(null);
        if (one != null)
            throw new MyException(MyExceptionEnum.ACCOUNT_EXISTED);
        try {
            user.setPassword(URLEncoder.encode(user.getPassword(), "utf-8"));
            user_db = userRepo.save(user);
        } catch (UnsupportedEncodingException e) {
            throw new MyException(MyExceptionEnum.SYS_ERROR);
        }
        return user_db;
    }

    @Override
    public User login(String json) {
        User user = JSONObject.parseObject(json, User.class);
        if (StringUtils.isEmpty(user.getUserAcc()) || StringUtils.isEmpty(user.getPassword()))
            throw new MyException(MyExceptionEnum.LOST_PARAM);
        User one = userRepo.findById(user.getUserAcc()).orElse(null);
        if (one == null)
            throw new MyException(MyExceptionEnum.ACCOUNT_NOT_EXISTED);
        String password = "";
        try {
            password = URLDecoder.decode(user.getPassword(), "utf-8");
        } catch (UnsupportedEncodingException e) {
            throw new MyException((MyExceptionEnum.SYS_ERROR));
        }
        if (!password.equals(one.getPassword()))
            throw new MyException(MyExceptionEnum.PASSWORD_WRONG);
        return one;
    }

    @Override
    public User update(String json) {
        User user = JSONObject.parseObject(json, User.class);
        if (StringUtils.isEmpty(user.getUserAcc()) || StringUtils.isEmpty(user.getPassword()) || StringUtils.isEmpty(user.getUserNick()))
            throw new MyException(MyExceptionEnum.LOST_PARAM);
        return userRepo.save(user);
    }


}
