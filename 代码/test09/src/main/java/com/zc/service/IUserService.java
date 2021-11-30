package com.zc.service;

import com.zc.r.ResultBean;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/30 11:23
 * @desc
 */
public interface IUserService {
    ResultBean loginVerify(String username, String password);
}
