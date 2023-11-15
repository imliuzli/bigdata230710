package com.atguigu.springbootdemo.user.mapper;

import com.atguigu.springbootdemo.user.bean.UserInfo;
import com.baomidou.dynamic.datasource.annotation.DS;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * <p>
 * 用户表 Mapper 接口
 * </p>
 *
 * @author WEIYUNHUI
 * @since 2023-11-15
 */
@Mapper
@DS("gmall")
public interface UserInfoMapper extends BaseMapper<UserInfo> {

}
