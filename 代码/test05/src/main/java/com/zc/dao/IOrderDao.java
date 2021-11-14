package com.zc.dao;

import com.zc.entity.Order;

import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/14 15:11
 * @desc
 */
public interface IOrderDao {
    public List<Order> queryAll();
}
