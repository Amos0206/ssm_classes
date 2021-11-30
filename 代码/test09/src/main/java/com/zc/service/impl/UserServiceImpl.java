package com.zc.service.impl;

import com.zc.dao.IUserDao;
import com.zc.entity.User;
import com.zc.r.ResultBean;
import com.zc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/30 11:23
 * @desc
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public ResultBean loginVerify(String username, String password) {
        User user = userDao.selectByUsername(username);
        if(user!=null){
            if(password.equals(user.getPassword())){
                return ResultBean.success("登录成功!");
            }else{
                return ResultBean.error("用户名或密码错误！");
            }
        }else{
            return ResultBean.error("用户未注册！");
        }
    }
}
