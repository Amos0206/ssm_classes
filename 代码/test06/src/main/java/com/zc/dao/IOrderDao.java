package com.zc.dao;

import com.zc.entity.dto.OrderAndProduct;
import com.zc.entity.dto.OrderAndUser;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/29 19:05
 * @desc
 */
public interface IOrderDao {
    OrderAndUser quaryAll();
    OrderAndProduct queryOrderDetail();
}
