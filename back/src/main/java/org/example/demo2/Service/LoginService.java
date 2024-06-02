package org.example.demo2.Service;

import org.example.demo2.Mapper.LoginMapper;
import org.example.demo2.dto.Account;
import org.springframework.stereotype.Service;
import org.example.demo2.dto.Writer;
import javax.annotation.Resource;
import java.util.List;

@Service
public class LoginService {
    @Resource
    private LoginMapper loginMapper;
    // 登录 只需要判断是否登录成功，并不需要返回具体的数据
    public String loginTosystem(String username,String password){
        String message = "";
        // 判断登录的角色是否为空
        if(loginMapper.loginTosystem(username,password)== null) {
            message = "登录失败";
        }else {
            loginMapper.loginTosystem(username,password);
            message = "登录成功";
        }
        return message;
    }

    // 获取登录人员的姓名
    public String findName(String username) {
        return loginMapper.findName(username);
    }
    //    获取登录人员各项信息
    public Account findMsg(String username) {
            return loginMapper.findMsg(username);
        }
//        获取作者的全部数据（包含多个作者对象）
    public List<Writer> findWriter() {
        return loginMapper.findWriter();
    }

//分页获取作者信息
    public List<Writer> findWriter1(int pagenow,int pagesize) {
        return loginMapper.findWriter1(pagenow,pagesize);
    }
//    获取查询结果
 public List<Writer> findWriter2(int pagenow,int pagesize,String name) {
        return loginMapper.findWriter2(pagenow,pagesize,name);
    }

    //
    public  Writer findone(int xuhao){
        return loginMapper.findone(xuhao);

    }
    //    删除作者数据
    public String deleteWriter (int xuhao) {
        String message ="";
        loginMapper.deleteWriter(xuhao);
        message = "删除成功!";
        return message;
}
    public String updateWriter (Writer writer) {
        String message ="";
        loginMapper.updateWriter(writer);
        message = "修改成功!";
        return message;
    }



}
