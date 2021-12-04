package com.zc.dao;

import com.zc.entity.Customer;

import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/4 15:55
 * @desc
 */
public interface ICustomerDao {
    List<Customer> selectAll();
    Integer insertData(Customer customer);
    Integer delCustomer(Integer id);
    Integer updataCustomer(Customer customer);
    Customer selectById(Integer id);
}
