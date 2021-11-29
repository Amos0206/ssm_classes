package com.zc.entity.dto;

import com.zc.entity.Order;

import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/29 22:12
 * @desc
 */
public class UserAndOrder {
    private Integer id;
    private String username;
    private String password;
    private Date birthday;
    private String sex;
    List<Order> orders;

    public UserAndOrder() {
    }

    public UserAndOrder(Integer id, String username, String password, Date birthday, String sex, List<Order> orders) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.birthday = birthday;
        this.sex = sex;
        this.orders = orders;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "UserAndOrder{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", birthday=" + birthday +
                ", sex='" + sex + '\'' +
                ", orders=" + orders +
                '}';
    }
}
