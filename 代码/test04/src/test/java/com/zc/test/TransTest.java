package com.zc.test;

import com.zc.dao.impl.AccountDaoImpl;
import com.zc.entity.Account;
import com.zc.service.IAccountService;
import com.zc.service.impl.AccountServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/14 10:26
 * @desc
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class TransTest {

    @Autowired
    private IAccountService accountService;



    @Test
    public void TestAccountData(){
        //1、开户
        System.out.println("---开户---");
        Account ac = new Account();
        ac.setUsername("布凡");
        ac.setMoney(6000);
        accountService.addAcount(ac);
        System.out.println("--布凡账户余额"+accountService.query("布凡"));

        //2、销户
        System.out.println("---销户---");
        int i = accountService.deleteAcount(6);
        if (i>0) {
            System.out.println("销户成功!");
        }

        //3、转账
        System.out.println("---转账---");

        accountService.query("李四");
        System.out.println("张三账户余额:"+accountService.query("张三")+"\t"+"李四账户余额:"+accountService.query("李四"));
        accountService.transForMoney("张三","李四",600);
        System.out.println("转账后：\n"+"张三账户余额:"+accountService.query("张三")+"\t"+"李四账户余额:"+accountService.query("李四"));

        //4、查询账户余额
        System.out.println("---查询余额---");
        System.out.println(accountService.query("王五"));
    }
}
