package com.zc.service;

import com.zc.dao.UserDao;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/8 8:38
 * @desc
 */
public class UserService {
    private UserDao userDao;

    public void say(){
        userDao.say();
        System.out.println("userService say hello spring!");
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }
}
