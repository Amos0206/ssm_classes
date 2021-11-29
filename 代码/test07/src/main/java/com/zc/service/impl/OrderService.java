package com.zc.service.impl;

import com.zc.dao.IOrderDao;
import com.zc.entity.dto.OrderAndProduct;
import com.zc.entity.dto.OrderAndUser;
import com.zc.service.IOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/11/29 23:51
 * @desc
 */
@Service
public class OrderService implements IOrderService {
    @Autowired
    private IOrderDao orderDao;

    @Override
    public List<OrderAndUser> orderAndUser() {
        return orderDao.quaryAll();
    }

    @Override
    public List<OrderAndProduct> orderDetailMap() {
        return orderDao.queryOrderDetail();
    }
}
