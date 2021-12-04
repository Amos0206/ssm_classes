package com.zc.controller;

import com.zc.r.ResultBean;
import com.zc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/4 15:09
 * @desc
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("login")
    @ResponseBody()
    public ResultBean login(String username,String password){
        return userService.verifyLogin(username, password);
    }
}
