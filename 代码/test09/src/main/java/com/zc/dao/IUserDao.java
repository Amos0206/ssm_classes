package com.zc.dao;

import com.zc.entity.User;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/30 11:03
 * @desc
 */
public interface IUserDao {
    User selectByUsername(String username);
}
