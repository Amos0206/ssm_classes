package com.zc.service;

import com.zc.r.ResultBean;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/4 14:55
 * @desc
 */
public interface UserService {
    ResultBean verifyLogin(String username,String password);
}
