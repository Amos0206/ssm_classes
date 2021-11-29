package com.zc.service;

import com.zc.entity.dto.OrderAndProduct;
import com.zc.entity.dto.OrderAndUser;

import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/29 23:50
 * @desc
 */
public interface IOrderService {
    List<OrderAndUser> orderAndUser();
    List<OrderAndProduct> orderDetailMap();
}
