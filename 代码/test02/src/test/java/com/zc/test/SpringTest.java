package com.zc.test;

import com.zc.controller.UserController;
import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/8 8:55
 * @desc
 */
public class SpringTest {

    @Test
    public void loadXml(){
        /*1、加载配置文件*/
        ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

        /*通过bean的id获取对象*/
        UserController controller =(UserController) context.getBean("controller");

        /*调用对象中的方法*/
        controller.say();
    }
}
