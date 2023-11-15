package com.atguigu.springbootdemo.customer.service.impl;

import com.atguigu.springbootdemo.customer.bean.Customer;
import com.atguigu.springbootdemo.customer.mapper.CustomerMapper;
import com.atguigu.springbootdemo.customer.service.CustomerService;
import com.atguigu.springbootdemo.util.SqlUtil;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Author: imliuzli
 * @Description: TODO
 * @Date: 2023/11/15 20:39
 */
@Service
@DS("test")
public class CustomerServiceImpl extends ServiceImpl<CustomerMapper,Customer> implements CustomerService {
    @Autowired
    CustomerMapper customerMapper;


    @Override
    public List<Customer> getCustomerList(String username, Integer age) {
        // 对于动态的条件,不确定的条件,需要在service中处理,将处理好的(sql)传入到mapper中
//        String sql = "select id,username,age from customer where 1 = 1";
//        if (username != null){
//            sql += " and username = '" + SqlUtil.filterUnsafeSql(username) + "'";
//        }
//        if (age != null){
//            sql += " and age = " + age;
//        }
//        sql += " and username <> 'zhangsan'";
//        List<Customer> customerList = customerMapper.selectCustomerList(sql);
        List<Customer> customerList = customerMapper.selectList(
                new QueryWrapper<Customer>()
                        .eq(username != null, "username", SqlUtil.filterUnsafeSql(username))
                        .eq(age != null, "age", age)
        );
        return customerList;
    }

    @Override
    public void deleteCustomer(Integer id) {
        customerMapper.deleteCustomer(id);
    }

    @Override
    public void updateCustomer(Customer customer) {
        // 业务处理...

        // 调用数据层,修改数据库中的数据
        customerMapper.updateCustomer(customer);
    }

    @Override
    public void saveCustomer(Customer customer) {
        // 业务处理......

        //调用数据层，将数据写入到数据库中
        customerMapper.insertCustomer(customer);
    }

    @Override
    public Customer getCustomer(Integer id) {
        Customer customer = customerMapper.selectCustomerById(id);
        return customer;
    }
}
