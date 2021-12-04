package com.zc.test;

import com.zc.service.CustomerService;
import com.zc.service.UserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/4 15:00
 * @desc
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-service.xml")
public class ServiceTest {
    @Autowired
    private UserService userService;

    @Autowired
    private CustomerService customerService;

    @Test
    public void userTest(){
        System.out.println(userService.verifyLogin("zhangsan", "123"));
    }

    @Test
    public void customerTest(){
        System.out.println(customerService.queryAll());
    }
}
