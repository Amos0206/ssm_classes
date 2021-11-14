package com.zc.service;

import com.zc.entity.Account;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/8 11:35
 * @desc
 */
public interface IAccountService {
    /**
     * 账户转账，把outAccount的钱转入到inAccount的账户中
     * @param outAccount
     * @param inAccount
     * @param money
     */
    void transForMoney(String  outAccount, String inAccount, Integer money);
    /**
     * 开户
     */
    public int addAcount(Account account);
    /**
     * 销户
     */
    public int deleteAcount(Integer id);
    /**
     * 查看账户余额
     */
    public int query(String username);

}
