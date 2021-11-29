package com.zc.entity.dto;

import com.zc.entity.Product;

import java.util.Date;
import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/29 22:46
 * @desc
 */
public class OrderAndProduct {
    private Integer id;
    private Integer userId;
    private String number;
    private Date createtime;
    List<Product> products;

    public OrderAndProduct() {
    }

    public OrderAndProduct(Integer id, Integer userId, String number, Date createtime, List<Product> products) {
        this.id = id;
        this.userId = userId;
        this.number = number;
        this.createtime = createtime;
        this.products = products;
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

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "OrderAndProduct{" +
                "id=" + id +
                ", userId=" + userId +
                ", number='" + number + '\'' +
                ", createtime=" + createtime +
                ", products=" + products +
                '}';
    }
}
