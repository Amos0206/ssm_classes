package com.zc.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/29 19:01
 * @desc
 */
public class Order implements Serializable {

    private Integer id;
    private Integer userId;
    private String number;
    private Date createtime;

    public Order() {
    }

    public Order(Integer id, Integer userId, String number, Date createtime) {
        this.id = id;
        this.userId = userId;
        this.number = number;
        this.createtime = createtime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Date getCreatetime() {
        return createtime;
    }

    public void setCreatetime(Date createtime) {
        this.createtime = createtime;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id=" + id +
                ", userId=" + userId +
                ", number='" + number + '\'' +
                ", createtime=" + createtime +
                '}';
    }
}
