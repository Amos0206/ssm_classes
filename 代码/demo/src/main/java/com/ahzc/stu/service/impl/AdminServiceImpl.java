package com.ahzc.stu.service.impl;

import com.ahzc.stu.entity.Admin;
import com.ahzc.stu.mapper.IAdminMapper;
import com.ahzc.stu.service.IAdminService;
import com.ahzc.stu.utils.MD5Util;
import com.ahzc.stu.vo.ResultBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/5 16:00
 * @desc
 */
@Service
public class AdminServiceImpl implements IAdminService {
    @Autowired
    private IAdminMapper adminMapper;

    @Override
    public ResultBean loginVerify(String username, String password) {
        Admin admin = adminMapper.queryByUsername(username);
        if(admin!=null){
            String pwd = MD5Util.md5(password);
            if(pwd.equals(admin.getPassword())){
                return ResultBean.success("success",admin);
            }else{
                return ResultBean.error("failed");
            }
        }else{
            return ResultBean.error("failed");
        }
    }

    @Override
    public List<Admin> queryAll(Admin admin) {
        List<Admin> admins = adminMapper.queryAll(admin);
        if(admins.size()>0){
            return admins;
        }else{
            return null;
        }
    }

    @Override
    public ResultBean add(Admin admin) {
        Admin admin1 = new Admin();
        admin1.setUsername(admin.getUsername());
        String s = MD5Util.md5(admin.getPassword());
        admin1.setPassword(s);
        int i = adminMapper.insert(admin1);
        if(i>0){
            return ResultBean.success("success",null);
        }else{
            return ResultBean.error();
        }
    }

    @Override
    public ResultBean del(Integer id) {
        int i = adminMapper.deleteById(id);
        if(i>0){
            return ResultBean.success("success",null);
        }else{
            return ResultBean.error();
        }
    }
}
