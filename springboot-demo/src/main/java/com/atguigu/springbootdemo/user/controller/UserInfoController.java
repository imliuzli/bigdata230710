package com.atguigu.springbootdemo.user.controller;

import com.atguigu.springbootdemo.user.bean.UserInfo;
import com.atguigu.springbootdemo.user.service.UserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author WEIYUNHUI
 * @since 2023-11-15
 */
@RestController
@RequestMapping("/user/")
public class UserInfoController {
    public static final String SUCCESS = "success";

    @Autowired
    UserInfoService userInfoService;

    /**
     * 删除UserInfo
     */
    @GetMapping("/deleteuser/{id}")
    public String deleteUser(@PathVariable("id") Long id){
        userInfoService.removeById(id);
        return SUCCESS;
    }

    /**
     * 修改UserInfo
     */
    @PostMapping("/updateuser")
    public String updateUser(@RequestBody UserInfo userInfo){
        userInfoService.updateById(userInfo);
        return SUCCESS;
    }

    /**
     * 增加UserInfo
     */
    @PostMapping("/saveuser")
    public String saveUser(@RequestBody UserInfo userInfo){
        userInfoService.save(userInfo);
        return SUCCESS;
    }

    /**
     * 查找UserInfo
     */
    @GetMapping("/getuser/{id}")
    public UserInfo getUser(@PathVariable("id") Long id){
        return userInfoService.getById(id);
    }
}
