package com.zc.test;

import com.zc.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/30 11:27
 * @desc
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring/spring-service.xml")
public class UserServiceTest {

    @Autowired
    private IUserService userService;


    @Test
    public void verify(){
        System.out.println(userService.loginVerify("zhangsan", "12"));
//        System.out.println();
    }
}
