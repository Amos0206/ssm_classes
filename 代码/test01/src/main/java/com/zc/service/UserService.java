package com.zc.service;

import com.zc.R.ResultBean;
import com.zc.domain.User;
import com.zc.utils.PageInfo;

import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/2 10:01
 * @desc
 */
public interface UserService {

    public ResultBean allUser();
    public ResultBean queryById(Integer id);
    public ResultBean save(User user);
    public ResultBean updated(User user);
    public ResultBean del(Integer id);
    public PageInfo<User> getPageDates(int startindex, int endindex);

}
