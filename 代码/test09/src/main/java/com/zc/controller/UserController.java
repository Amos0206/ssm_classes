package com.zc.controller;

import com.zc.r.ResultBean;
import com.zc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/30 11:32
 * @desc
 */
@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    private IUserService userService;

    @RequestMapping("index")
    public String loginIndex(){
        return "login";
    }

    @GetMapping("login")
    public String login(String username, String password, HttpSession session){
        ResultBean resultBean = userService.loginVerify(username, password);
        //System.out.println(resultBean);
        if(resultBean.getCode()==1000){
            session.setAttribute("userInfo",username);
            return "product";
        }else{
            return "login";
        }

    }
}
