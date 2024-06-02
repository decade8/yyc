package org.example.demo2.Service;

import org.example.demo2.Mapper.ForgetMapper;
import org.example.demo2.dto.Account;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class ForgetService {
    @Resource
    private ForgetMapper forgetMapper;

    public String forgetAccount(Account account) {
        forgetMapper.forgetAccount(account);
        return "修改成功";
    }

    public String findName1(String username) {
        String message = "";
        // 判断登录的角色是否为空
        if(forgetMapper.findName1(username)== null) {
            message = "修改失败";
        }else {
            forgetMapper.findName1(username);
            message = "修改成功";
        }
        return message;
    }
    }

