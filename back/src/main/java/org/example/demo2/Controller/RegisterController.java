package org.example.demo2.Controller;

import org.example.demo2.Service.RegisterService;
import org.example.demo2.Vo.ResultVo;
import org.example.demo2.constant.ResutEnum;
import org.example.demo2.dto.Account;

import org.example.demo2.dto.Writer;
import org.springframework.web.bind.annotation.*;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.multipart.MultipartFile;
import java.io.File;
import java.util.UUID;



import javax.annotation.Resource;


@RestController
@RequestMapping("/register/*")
public class RegisterController {
    @Resource
    private RegisterService registerService;

    // 注册
    @PostMapping("/registerAccount")
    public ResultVo registerAccount(@RequestBody Account account) {
        return new ResultVo(ResutEnum.OK,registerService.registerAccount(account));
    }

    @GetMapping("/findName")
    public ResultVo findName2(@RequestParam("username")String username) {
        return new ResultVo(ResutEnum.OK,registerService.findName2(username));
    }

    @PostMapping("/registerWriter")
    public ResultVo registerWriter(@RequestBody Writer writer) {
        return new ResultVo(ResutEnum.OK,registerService.registerWriter(writer));
    }




}
