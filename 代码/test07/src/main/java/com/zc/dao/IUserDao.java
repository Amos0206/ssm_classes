package com.zc.dao;

import com.zc.entity.dto.UserAndOrder;

import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/29 19:04
 * @desc
 */
public interface IUserDao {
    List<UserAndOrder> queryAllUser();
}
