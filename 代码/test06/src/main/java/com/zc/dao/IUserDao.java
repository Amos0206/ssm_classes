package com.zc.dao;

import com.zc.entity.dto.UserAndOrder;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/29 19:04
 * @desc
 */
public interface IUserDao {
    UserAndOrder queryAllUser();
}
