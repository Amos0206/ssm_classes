package com.zc.entity.dto;

import com.zc.entity.Order;
import com.zc.entity.User;

import java.util.Date;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/29 19:31
 * @desc
 */
public class OrderAndUser{
    private Integer id;
    private Integer userId;
    private String number;
    private Date createtime;
    private User user;

    public OrderAndUser() {
    }

    public OrderAndUser(Integer id, Integer userId, String number, Date createtime, User user) {
        this.id = id;
        this.userId = userId;
        this.number = number;
        this.createtime = createtime;
        this.user = user;
    }

    @Override
    public String toString() {
        return "OrderAndUser{" +
                "id=" + id +
                ", userId=" + userId +
                ", number='" + number + '\'' +
                ", createtime=" + createtime +
                ", user=" + user +
                '}';
    }
}
