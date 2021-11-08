package com.zc.service;

import com.zc.dao.UserDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/8 10:05
 * @desc
 */
@Service
public class UserService {
    @Autowired
    private UserDao userDao;

    public void say(){
        userDao.say();
        System.out.println("userService say hello spring!");
    }
}
