package com.zc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/30 0:44
 * @desc
 */
@Controller
@RequestMapping("hello")
public class FirstController {

    @RequestMapping("first.do")
    public String firstMvc(Model model){
        model.addAttribute("msg","hello,我是第一个SpringMVC入门程序");
        return "first";

    }
}
