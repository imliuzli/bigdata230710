package com.atguigu.springbootdemo.user.service.impl;

import com.atguigu.springbootdemo.user.bean.UserInfo;
import com.atguigu.springbootdemo.user.mapper.UserInfoMapper;
import com.atguigu.springbootdemo.user.service.UserInfoService;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表 服务实现类
 * </p>
 *
 * @author WEIYUNHUI
 * @since 2023-11-15
 */
@Service
@DS("gmall")
public class UserInfoServiceImpl extends ServiceImpl<UserInfoMapper, UserInfo> implements UserInfoService {

}
