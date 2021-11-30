package com.zc.controller;

import com.zc.r.ResultBean;
import com.zc.service.IItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/30 12:23
 * @desc
 */
@Controller
@RequestMapping("item")
public class ItemController {
    @Autowired
    private IItemService iItemService;


    @RequestMapping("index")
    public String queryAll(Model model){
        ResultBean resultBean = iItemService.queryAll();
        model.addAttribute("productList",resultBean.getData());
        return "product";
    }
}
