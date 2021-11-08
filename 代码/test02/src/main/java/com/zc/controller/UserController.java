package com.zc.controller;

import com.zc.service.UserService;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/8 8:32
 * @desc
 */
public class UserController {

    private UserService userService;

    public void say(){
        userService.say();
        System.out.println("userController say hello spring!");
    }

    public void setUserService(UserService userService) {
        this.userService = userService;
    }
}
