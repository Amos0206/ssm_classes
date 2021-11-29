package com.zc.service;

import com.zc.entity.dto.UserAndOrder;

import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/29 23:17
 * @desc
 */
public interface IUserService {
    List<UserAndOrder> queryUserAndOrder();
}
