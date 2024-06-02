package org.example.demo2.Mapper;

import org.apache.ibatis.annotations.Param;
import org.example.demo2.dto.Account;

public interface ForgetMapper {
    void forgetAccount(@Param("account") Account account);

    // 获取修改人的username
    String findName1(@Param("username")String username);
}
