package com.atguigu.springbootdemo.bean;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author imliuzli
 * @version 1.0
 * @description: TODO
 * @date 2023/11/14 18:02
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Customer {
    private String id;

    private String username;

    private Integer age;
}
