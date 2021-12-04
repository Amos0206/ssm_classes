package com.zc.service;

import com.zc.entity.Customer;
import com.zc.r.ResultBean;

import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/4 16:04
 * @desc
 */
public interface CustomerService {
    ResultBean save(Customer customer);
    ResultBean del(Integer id);
    ResultBean edit(Customer customer);
    ResultBean queryAll();
    ResultBean queryById(Integer id);
}
