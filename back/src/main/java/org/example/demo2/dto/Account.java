package org.example.demo2.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * @author hxc
 * @dateTime: 2021-12-2
 * @description: 账号登录注册实体
 * */
@Data//字段生成get和set方法
public class Account {
    private String id;
    // 姓名
    private String name;
    // 账号
    private String username;
    // 密码
    private String password;
    //邮箱
    private String email;
    //头像
    private String avatar;
//   年龄
    private String year;

}

