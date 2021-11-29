package com.zc.service.impl;

import com.zc.dao.IUserDao;
import com.zc.entity.dto.UserAndOrder;
import com.zc.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/29 23:33
 * @desc
 */
@Service
public class UserServiceImpl implements IUserService{

    @Autowired
    private IUserDao userDao;

    @Override
    public List<UserAndOrder> queryUserAndOrder() {
        return userDao.queryAllUser();
    }
}
