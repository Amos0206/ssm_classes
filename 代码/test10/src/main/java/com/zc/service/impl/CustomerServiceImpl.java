package com.zc.service.impl;

import com.zc.dao.ICustomerDao;
import com.zc.entity.Customer;
import com.zc.r.ResultBean;
import com.zc.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @version 1.0
 * @Author ZC
 * @date 2021/12/4 16:06
 * @desc
 */
@Service
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private ICustomerDao customerDao;

    @Override
    public ResultBean save(Customer customer) {
        Integer i = customerDao.insertData(customer);
        if(i>0){
            return  ResultBean.success("success",null);
        }else{
            return ResultBean.error("failed");
        }
    }

    @Override
    public ResultBean del(Integer id) {
        Integer i = customerDao.delCustomer(id);
        if(i>0){
            return  ResultBean.success("success",null);
        }else{
            return ResultBean.error("failed");
        }
    }

    @Override
    public ResultBean edit(Customer customer) {
//        Integer i = customerDao.updataCustomer(customer);
//        if(i>0){
//            return  ResultBean.success("success",null);
//        }else{
//            return ResultBean.error("failed");
//        }
        return customerDao.updataCustomer(customer)>0 ? ResultBean.success("success",null):ResultBean.error("failed");
    }

    @Override
    public ResultBean queryAll() {
        List<Customer> customers = customerDao.selectAll();
        if(customers.size()>0){
            return  ResultBean.success("success",customers);
        }else{
            return ResultBean.error("failed");
        }
    }

    @Override
    public ResultBean queryById(Integer id) {
        Customer customer = customerDao.selectById(id);
        if(customer!=null){
            return  ResultBean.success("success",customer);
        }else{
            return ResultBean.error("failed");
        }
    }
}
