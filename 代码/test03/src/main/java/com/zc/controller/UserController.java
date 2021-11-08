package com.zc.controller;

import com.zc.service.UserService;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/8 10:05
 * @desc
 */
@Controller
public class UserController {
    @Resource
    private UserService userService;

    public void say(){
        userService.say();
        System.out.println("userController say hello spring!");
    }
}
