package com.ntu.flower.shop.service;

import com.ntu.flower.shop.domain.User;
import com.ntu.flower.shop.domain.UserCollect;

/**
 * @author Zed
 * @date 2020/5/16 上午12:12
 * @contact shadowl91@163.com
 */
public interface UserService {

    public User register(String json);

    public User login(String json);

    public User update(String json);

}
