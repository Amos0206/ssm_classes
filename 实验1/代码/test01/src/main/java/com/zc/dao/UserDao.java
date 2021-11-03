package com.zc.dao;

import com.zc.domain.User;

import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/1 23:04
 * @desc
 */
public interface UserDao {
    List<User> queryAll();

    User queryById(Integer id);

    int updateData(User user);

    int delUser(Integer id);

    int insertData(User user);

    List<User> getPageDates(int startindex, int endindex);
}