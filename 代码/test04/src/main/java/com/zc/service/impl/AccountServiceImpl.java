package com.zc.service.impl;

import com.zc.dao.impl.AccountDaoImpl;
import com.zc.entity.Account;
import com.zc.service.IAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/8 11:36
 * @desc
 */
@Service
public class AccountServiceImpl implements IAccountService {
    @Autowired
    private AccountDaoImpl accountDao;

    /**
     * 转账 业务
     * @param outAccount 转出中账户
     * @param inAccount  转入账户
     * @param money  转账金额
     */
    @Override
    @Transactional
    public void transForMoney(String outAccount, String inAccount, Integer money) {
        accountDao.accountOut(outAccount,money);
        accountDao.accountIn(inAccount,money);
    }

    /**
     * 开户
     * @param account
     * @return
     */
    @Override
    public int addAcount(Account account) {
       return accountDao.addAcount(account);
    }

    /**
     * 销户
     * @param id
     * @return
     */
    @Override
    public int deleteAcount(Integer id) {
        return accountDao.delAccount(id);
    }


    /**
     * 查询账户余额
     * @param username
     * @return
     */
    @Override
    public int query(String username) {
        return accountDao.query(username);
    }
}
