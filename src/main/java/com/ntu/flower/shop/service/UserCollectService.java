package com.ntu.flower.shop.service;

import com.ntu.flower.shop.domain.UserCollect;

import java.util.List;

/**
 * @author Zed
 * @date 2020/5/16 下午3:17
 * @contact shadowl91@163.com
 */
public interface UserCollectService {
    public UserCollect addCollect(String json);

    public List<UserCollect> viewCollect(String account);

    public void deleteCollect(String json);
}
