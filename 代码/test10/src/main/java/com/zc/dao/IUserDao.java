package com.zc.dao;

import com.zc.entity.User;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/4 14:44
 * @desc
 */
public interface IUserDao {
    User selectUserByUsername(String name);
}
