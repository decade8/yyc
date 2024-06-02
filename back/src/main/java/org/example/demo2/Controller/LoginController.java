package org.example.demo2.Controller;

import org.example.demo2.Service.LoginService;
import org.example.demo2.Vo.ResultVo;
import org.example.demo2.constant.ResutEnum;
import org.example.demo2.dto.Account;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.example.demo2.dto.Writer;
import org.springframework.web.bind.annotation.*;
import javax.annotation.Resource;
import org.example.demo2.Mapper.SysUserMapper;

import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.UUID;
import org.springframework.beans.factory.annotation.Value;

@RestController
@RequestMapping("/login/*")
public class LoginController {
    @Resource
    private LoginService loginService;

    // 登录到系统
    @GetMapping("/loginTosystem")
    public ResultVo loginTosystem(@RequestParam("username")String username, @RequestParam("password")String password) {
        return new ResultVo(ResutEnum.OK,loginService.loginTosystem(username,password));
    }
    @GetMapping("/findName")
    public ResultVo findName(@RequestParam("username")String username) {
        return new ResultVo(ResutEnum.OK,loginService.findName(username));
    }
    @GetMapping("/findMsg")
    public ResultVo findMsg(@RequestParam("username")String username) {
        return new ResultVo(ResutEnum.OK,loginService.findMsg(username));
    }


//    获取所有作者数据
    @GetMapping("/findWriter")
    public ResultVo findWriter() {
        return new ResultVo(ResutEnum.OK,loginService.findWriter());
    }
//分页获取
    @GetMapping("/findWriter1")
    public ResultVo findWriter1(@RequestParam("pagenow")int pagenow, @RequestParam("pagesize")int pagesize) {
        return new ResultVo(ResutEnum.OK,loginService.findWriter1(pagenow,pagesize));
    }
//    分页查询
@GetMapping("/findWriter2")
public ResultVo findWriter2(@RequestParam("pagenow")int pagenow, @RequestParam("pagesize")int pagesize,@RequestParam("name")String name){
    return new ResultVo(ResutEnum.OK,loginService.findWriter2(pagenow,pagesize,name));
}
    @GetMapping("/findone")
    public ResultVo findone(@RequestParam("xuhao")int xuhao) {
        return new ResultVo(ResutEnum.OK,loginService.findone(xuhao));
    }

    @GetMapping("/deleteWriter")
    public ResultVo deleteWriter(@RequestParam("xuhao")int xuhao) {
        return new ResultVo(ResutEnum.OK,loginService.deleteWriter(xuhao));
    }

    @PostMapping("/updateWriter")
    public ResultVo updateWriter(@RequestBody Writer writer) {
        return new ResultVo(ResutEnum.OK,loginService.updateWriter(writer));
    }








}

