package com.zc.controller;

import com.zc.entity.Customer;
import com.zc.r.ResultBean;
import com.zc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/4 16:48
 * @desc
 */
@Controller
@RequestMapping("customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("index")
    public String customerIndex(Model model){
        ResultBean resultBean = customerService.queryAll();
        model.addAttribute("customers",resultBean.getData());
        return "customer";
    }

    @PostMapping("save")
    @ResponseBody
    public ResultBean save(Customer customer){
        return customerService.save(customer);
    }

    @GetMapping("del")
    @ResponseBody
    public ResultBean del(Integer id){
        return customerService.del(id);
    }

    @PostMapping("update")
    @ResponseBody
    public ResultBean update(Customer customer){
        return customerService.edit(customer);
    }

    @GetMapping("queryById")
    @ResponseBody
    public ResultBean queryById(Integer id){
        return customerService.queryById(id);
    }

    @GetMapping
    @ResponseBody
    public ResultBean list(){
        return customerService.queryAll();
    }
}
