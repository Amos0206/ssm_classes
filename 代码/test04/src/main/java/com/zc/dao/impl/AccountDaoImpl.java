package com.zc.dao.impl;

import com.zc.dao.IAccountDao;
import com.zc.entity.Account;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/8 11:36
 * @desc
 */
@Repository
public class AccountDaoImpl implements IAccountDao {
    @Autowired
    private JdbcTemplate jdbcTemplate;


    @Override
    public int addAcount(Account account) {
        String sql = "insert into account(username,money) values(?,?)";
        return jdbcTemplate.update(sql, account.getUsername(), account.getMoney());
    }

    @Override
    public int delAccount(Integer id) {
        String sql = "delete from account where id=?";
        return jdbcTemplate.update(sql,id);
    }

    @Override
    public void accountIn(String name,Integer money) {
        String sql  = "update account set money= money+ ? where username = ?";
        jdbcTemplate.update(sql, money, name);
    }

    @Override
    public void accountOut(String name,Integer money) {
        String sql  = "update account set money= money- ? where username = ?";
        jdbcTemplate.update(sql,money,name);
    }

    @Override
    public Integer query(String username) {
        String sql = "select * from account where username = ?";
        try {
            Account account = jdbcTemplate.queryForObject(sql, new BeanPropertyRowMapper<>(Account.class), username);
            return account.getMoney();
        }catch (Exception e){
            return null;
        }
    }
}
