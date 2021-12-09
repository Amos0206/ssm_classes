package com.ahzc.stu.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/6 8:46
 * @desc 后台首页
 */
@Controller
public class IndexController {

    /**
     * 展示后台操作首页
     * @return
     */
    @GetMapping("indexUI")
    public String index(){
        return "index";
    }

    @GetMapping("welcome")
    public String welcome(){
        return "welcome";
    }

    @GetMapping("statistics")
    public String statistics(){
        return "statistics";
    }

    @GetMapping("logout")
    public String logout(){
        return "login";
    }
}
