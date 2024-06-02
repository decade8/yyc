package org.example.demo2.Mapper;
import org.example.demo2.dto.Writer;
import org.example.demo2.dto.Account;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface LoginMapper {
    // 登录
    String loginTosystem(@Param("username")String username, @Param("password")String password);
    // 获取登录的人的姓名
    String findName(@Param("username")String username);
    //    获取登录人员各项信息
    Account findMsg(@Param("username")String username);
//    获取全部作者对象的数据
    List<Writer> findWriter();

//    分页获取作者信息
    List<Writer> findWriter1(@Param("pagenow")int pagenow,@Param("pagesize")int pagesize);
//    获取查询结果
    List<Writer> findWriter2(@Param("pagenow")int pagenow,@Param("pagesize")int pagesize,String name);
//    删除作者数据
    void deleteWriter(@Param("xuhao")int xuhao);
//    获取要修改作者的信息
    Writer findone(@Param("xuhao")int xuhao);
//    修改作者数据
    void updateWriter(@Param("writer")Writer writer);
}

