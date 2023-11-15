package com.atguigu.springbootdemo.customer.mapper;

import com.atguigu.springbootdemo.customer.bean.Customer;
import com.baomidou.dynamic.datasource.annotation.DS;
import org.apache.ibatis.annotations.*;
import com.baomidou.mybatisplus.core.mapper.BaseMapper ;

import java.util.List;

/**
 * @Author:     imliuzli
 * @Description:  TODO  
 * @Date:    2023/11/15 20:39
 */
@Mapper
@DS("test")
public interface CustomerMapper extends BaseMapper<Customer> {

    @Select("${sql}")
    List<Customer> selectCustomerList(String sql);
    @Delete("delete from customer where id = #{id}")
    void deleteCustomer(Integer id);
    @Update("update customer set username = #{username} , age = #{age} where id = #{id}")
    void updateCustomer(Customer customer);
    @Insert(" insert into customer (id , username ,age ) values ( #{c.id} , #{c.username} , #{c.age} ) ")
    void insertCustomer(@Param("c") Customer customer) ;
    @Select("select id, username, age from customer where id = #{id}")
    Customer selectCustomerById( Integer id ) ;
}
