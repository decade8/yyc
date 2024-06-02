package org.example.demo2.Controller;

import org.example.demo2.Service.ForgetService;
import org.example.demo2.Vo.ResultVo;
import org.example.demo2.constant.ResutEnum;
import org.example.demo2.dto.Account;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/forget/*")
public class ForgetController {
    @Resource
    private ForgetService forgetService;

    // 注册
    @PostMapping("/forgetAccount")
    public ResultVo forgetAccount(@RequestBody Account account) {
        return new ResultVo(ResutEnum.OK,forgetService.forgetAccount(account));
    }

    @GetMapping("/findName")
    public ResultVo findName1(@RequestParam("username")String username) {
        return new ResultVo(ResutEnum.OK,forgetService.findName1(username));
    }
}
