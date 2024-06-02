package org.example.demo2.Mapper;

import org.example.demo2.dto.Account;
import org.example.demo2.dto.Writer;
import org.apache.ibatis.annotations.Param;


public interface RegisterMapper {
    // 注册 定义两个函数用来给映射文件传参
    void registerAccount(@Param("account")Account account);
    String findName2(@Param("username")String username);
//    注册作者信息
    void registerWriter(@Param("writer")Writer writer);
}

