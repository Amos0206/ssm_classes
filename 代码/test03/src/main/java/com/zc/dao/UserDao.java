package com.zc.dao;

import org.springframework.stereotype.Repository;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/8 10:05
 * @desc
 */

@Repository
public class UserDao {
    public void say(){
        System.out.println("userDao say hello spring!");
    }
}
