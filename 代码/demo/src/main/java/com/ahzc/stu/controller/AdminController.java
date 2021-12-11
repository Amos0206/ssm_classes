package com.ahzc.stu.controller;

import com.ahzc.stu.entity.Admin;
import com.ahzc.stu.service.IAdminService;
import com.ahzc.stu.utils.MD5Util;
import com.ahzc.stu.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/5 16:21
 * @desc
 */
@Controller
@RequestMapping("admin")
public class AdminController {
    @Autowired
    private IAdminService adminService;

    @GetMapping("list")
    public String list(Model model, Admin admin){
        List<Admin> admins = adminService.queryAll(admin);
        model.addAttribute("admins",admins);
        return "admin/admin-list";
    }

    @GetMapping("edit")
    public String edit(Model model,Admin admin){
        return "admin/admin-edit";
    }

    @GetMapping("addHtml")
    public String addHtml(){
        return "admin/admin-add";
    }

    @PostMapping("add")
    @ResponseBody
    public ResultBean add(Admin admin){
        return adminService.add(admin);
    }

    @GetMapping("del/{id}")
    @ResponseBody
    public ResultBean del(@PathVariable("id") Integer id){
        return adminService.del(id);
    }

    @PostMapping("query/{user}")
    @ResponseBody
    public ResultBean query(@PathVariable("user") String user){
        return adminService.queryByUser(user);
    }

    @PostMapping("updatepwd")
    @ResponseBody
    public ResultBean updatePwd(Admin admin){
        Admin admin1 = new Admin();
        admin1.setUsername(admin.getUsername());
        admin1.setPassword(MD5Util.md5(admin.getPassword()));
        return adminService.updatePwd(admin1);
    }

}
