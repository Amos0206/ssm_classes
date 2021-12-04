package com.zc.service.impl;

import com.zc.dao.IUserDao;
import com.zc.entity.User;
import com.zc.r.ResultBean;
import com.zc.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/4 14:55
 * @desc
 */
@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private IUserDao userDao;

    @Override
    public ResultBean verifyLogin(String username, String password) {
        User user = userDao.selectUserByUsername(username);
        if(user!=null){
            if(password.equals(user.getPassword())){
                return ResultBean.success("success",user);
            }else{
                return ResultBean.error("failed");
            }
        }else {
            return ResultBean.error("用户不存在!");
        }
    }
}
