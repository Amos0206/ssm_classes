package com.zc.test;

import com.zc.entity.dto.OrderAndProduct;
import com.zc.entity.dto.OrderAndUser;
import com.zc.entity.dto.UserAndOrder;
import com.zc.service.IOrderService;
import com.zc.service.IUserService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/29 23:42
 * @desc
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring.xml")
public class ServiceTest {

    @Autowired
    private IUserService userService;

    @Autowired
    private IOrderService orderService;


    /**
     * 查询所有订单信息，要求显示输出订单及订单关联的用户信息。
     */
    @Test
    public void orderAndUser(){
        List<OrderAndUser> orderAndUsers = orderService.orderAndUser();
        for (OrderAndUser e:orderAndUsers){
            System.out.println(e);
        }

    }

    /**
     * 查询所有用户信息及用户关联的订单信息。
     */
    @Test
    public void userAndOrder(){
        List<UserAndOrder> userAndOrders = userService.queryUserAndOrder();
        for (UserAndOrder e:userAndOrders){
            System.out.println(e);
        }
    }

    /**
     * 查询订单明细信息。
     */
    @Test
    public void orderDesc(){
        List<OrderAndProduct> orderAndProducts = orderService.orderDetailMap();
        for (OrderAndProduct e: orderAndProducts){
            System.out.println(e);
        }
    }

}
