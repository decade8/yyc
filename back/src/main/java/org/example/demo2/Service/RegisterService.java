package org.example.demo2.Service;

import org.example.demo2.Mapper.RegisterMapper;
import org.example.demo2.dto.Account;
import org.example.demo2.dto.Writer;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class RegisterService {
    @Resource
    private RegisterMapper registerMapper;

    // 注册
    public String registerAccount(Account account) {
//        这里的insert不是返回字符串所以没法判断是否成功，默认都是按照成功处理
        registerMapper.registerAccount(account);
        return "注册成功";
    }

    public String registerWriter(Writer writer) {
//       作者数据的添加
        registerMapper.registerWriter(writer);
        return "新建成功";
    }


    public String findName2(String username) {
        String message = "";
        // 判断注册的角色是否为空，返回的是字符串类型可以用来判断用户名是否存在
        if(registerMapper.findName2(username)== null) {
            message = "用户名不存在";
        }else {
            registerMapper.findName2(username);
            message = "用户名已存在";
        }
        return message;
    }




}

