package com.atguigu.springbootdemo.customer.service;

import com.atguigu.springbootdemo.customer.bean.Customer;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * @Author: imliuzli
 * @Description: TODO
 * @Date: 2023/11/15 20:38
 */
public interface CustomerService extends IService<Customer> {

    List<Customer> getCustomerList(String username,Integer age);
    void deleteCustomer(Integer id);
    void updateCustomer(Customer customer);
    void saveCustomer( Customer customer ) ;
    Customer getCustomer(Integer id );
}
