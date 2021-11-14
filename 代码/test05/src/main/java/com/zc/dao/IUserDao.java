package com.zc.dao;

import com.zc.entity.User;

import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/14 13:56
 * @desc
 */
public interface IUserDao {

    public int insertUser(User user);

    public User queryById(Integer id);

    public int updateUser(User user);

    public List<User> queryUserByName(String username);

    public Integer count();

    public User queryBySexAndName();

    public List<User> queryByManyId();
}
