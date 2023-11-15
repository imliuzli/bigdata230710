package com.atguigu.springbootdemo.customer.controller;

import com.alibaba.fastjson.JSON;
import com.atguigu.springbootdemo.customer.bean.Customer;
import com.atguigu.springbootdemo.customer.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author imliuzli
 * @version 1.0
 * @description: TODO
 * @date 2023/11/14 16:40
 *
 * 控制层组件
 *      组件 : Spring容器来说。未来Spring容器会帮我们管理controller、service、mapper层的类，
 *            负责具体对象的创建、管理、销毁等工作
 *            而一个具体的类被Spring管理后。可以称之为一个组件
 *
 * @RestController: 标识为控制层的组件， 意味着未来Spring会帮我们管理该类对象的创建、 装配、 销毁等。
 */
@RestController
public class CustomerController {
    public static final String SUCCESS = "success";

    @Autowired
    CustomerService customerService;

    /**
     * SQL注入
     *
     * 客户端请求: localhost:8080/get?username=zhangsan&age=25
     */
    @GetMapping("/get")
    public List<Customer> get(
            @RequestParam(value = "username",required = false) String username,
            @RequestParam(value = "age",required = false) Integer age){
        List<Customer> customerList = customerService.getCustomerList(username, age);
        return customerList;
    }

    /**
     * 删除Customer
     *
     * 客户端请求 : localhost:8080/deletecustomer/1011
     */
    @GetMapping("/deletecustomer/{id}")
    public String deleteCustomer(@PathVariable("id") Integer id){
        // 调用业务层的组件
        // 我们自己的方法
        // customerService.deleteCustomer(id);
        customerService.removeById(id);
        return SUCCESS;
    }

    /**
     * 修改Customer
     *
     * 客户端请求 : localhost:8080/updatecustomer
     */
    @PostMapping("/updatecustomer")
    public String updateCustomer(@RequestBody Customer customer){
        // 调用业务层组件
        // 我们自己的方法
        // customerService.updateCustomer(customer);
        customerService.updateById(customer);
        return SUCCESS;
    }

    /**
     * 新增Customer
     *
     * 客户端的请求 : localhost:8080/savecustomer
     */
    @PostMapping("/savecustomer")
    public String saveCustomer( @RequestBody Customer customer ){
        // 调用业务层足组件
        // 我们自己的方法
        // customerService.saveCustomer(customer);
        // MP的方法
        customerService.save(customer);

        return SUCCESS ;
    }

    /**
     * 查询Customer对象
     *
     * 客户端请求: localhost:8080/getcustomer/1001
     */
    @GetMapping ("/getcustomer/{id}")
    public Customer getCustomer(@PathVariable("id") Integer id){
        // 调用业务层足组件
        // 我们自己的方法
        // Customer customer = customerService.getCustomer(id);
        Customer customer = customerService.getById(id);
        return customer;
    }

    /**
     * 状态码 :
     *
     *      200 : OK
     *
     *      400 : 参数个数或者类型不匹配
     *
     *      404 : 请求资源不存在
     *
     *      405 : 请求方式不正确
     *
     *      500 : 服务器内部出错
     */

    /**
     * 动态参数
     *
     * localhost:8080/dynamicparam?username=zhangsan&age=33&addr=beijing
     */
    @GetMapping(value = "dynamicparam")
    public String dynamicparam(
            @RequestParam(value = "username",required = false,defaultValue = "Unknown") String username,
            @RequestParam(value = "age",required = false,defaultValue = "18") Integer age,
            @RequestParam(value = "addr",required = false,defaultValue = "China") String addr){

        if (true){
            throw new RuntimeException("抛异常了....");
        }
        System.out.println("username = " + username);
        System.out.println("age = " + age);
        System.out.println("addr = " + addr);

        return SUCCESS;

    }
    /**
     * 请求方式 :
     *
     *      GET  : 用于读。 限制参数传递的最大大小。
     *
     *
     *      POST : 用于写。 理论上参数传递的大小无上限。
     */
//    @RequestMapping(value = "method",method = RequestMethod.GET)
    @GetMapping(value = "/method")
//    @PostMapping(value = "/method")
//    @RequestMapping(value = "method")
    public String method() {
        return SUCCESS;
    }

    /**
     * 相应结果的格式 :
     *      目前，前后端分离开发，基本上都是按照约定好的格式进行数据交换，而常用的格式就是JSON
     *
     *      客户端的请求:  localhost:8080/result?username=zs&age=22
     */
    @RequestMapping(value = "/result")
    public String result( @RequestParam(value = "username") String username, @RequestParam(value = "age") Integer age){

        Customer customer = new Customer("1005", username, age);

        return JSON.toJSONString(customer);
    }
    /**
     * 请求参数 :
     *      1. 键值对参数
     *          例子:  https://search.jd.com/Search?keyword=%E6%89%8B%E6%9C%BA&enc=utf-8&pvid=09af11f27fff424fa9c56ea16ffd197e
     *
     *          客户端的请求 : http://localhost:8080/param1?username=zhangsan&age=22
     *      2. 请求路径中的参数
     *          例子 : https://movie.douban.com/subject/35448384
     *                https://movie.douban.com/subject/34678231
     *                https://movie.douban.com/subject/35875180
     *          客户端的请求 :
     *                http://localhost:8080/param2/zhangsan/25
     *
     *          @PathVariable: 将请求路径中的参数映射到请求处理方法的形参上。
     *
     *      3. 请求体参数
     *
     *          @RequestBody : 将请求体的参数封装到指定的对象中。 要求实际的参数名与类的属性名一致。
     */

    @RequestMapping(value = "/param3")
    public String param3( @RequestBody Customer customer){

        System.out.println("customer = " + customer);

        return SUCCESS;

    }

    @RequestMapping(value = "/param2/{username}/{age}")
    public String param2(@PathVariable(value = "username") String username, @PathVariable(value = "age") Integer age){
        System.out.println("username = " + username + " , age " + age);
        return SUCCESS;
    }

    @RequestMapping(value = "/param1")
    public String param1(@RequestParam(value = "username") String username, @RequestParam(value = "age") Integer age){
        System.out.println("username = " + username + " , age " + age);
        return SUCCESS;
    }
    /**
     * 客户端的请求 : http://localhost:8080/hello
     *
     * 一个请求需要对应一个请求处理方法
     */
    @RequestMapping(value="/hello")
    public String hello(){

        return SUCCESS ;
    }
}
