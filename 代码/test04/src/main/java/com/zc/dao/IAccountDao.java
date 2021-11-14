package com.zc.dao;

import com.zc.entity.Account;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/8 11:34
 * @desc
 */
public interface IAccountDao {

    //开户
    public int addAcount(Account account);

    //销户
    public int delAccount(Integer id);

    //转入
    public void accountIn(String name,Integer money);


    //转出
    public void accountOut(String name,Integer money);


    //根据账户名查询账户余额
    public Integer query(String username);
}
