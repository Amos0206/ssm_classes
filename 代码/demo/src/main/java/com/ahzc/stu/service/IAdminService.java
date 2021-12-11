package com.ahzc.stu.service;

import com.ahzc.stu.entity.Admin;
import com.ahzc.stu.vo.ResultBean;

import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/5 15:54
 * @desc
 */
public interface IAdminService {
    /**
     * 登录验证
     * @param username 账号
     * @param password 密码
     * @return 自定义封装pojo
     */
    ResultBean loginVerify(String username,String password);

    /**
     * 查询所有用户
     * @param admin 账户
     * @return list集合
     */
    List<Admin> queryAll(Admin admin);

    ResultBean add(Admin admin);

    ResultBean del(Integer id);

    ResultBean queryByUser(String user);

    ResultBean updatePwd(Admin admin);
}
