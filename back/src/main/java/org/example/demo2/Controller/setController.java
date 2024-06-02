package org.example.demo2.Controller;

import org.example.demo2.Vo.ResultVo;
import org.example.demo2.constant.ResutEnum;
import org.example.demo2.dto.Account;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.UUID;//给pictureurl赋值


@RestController
@RequestMapping("/*")
public class setController {

    @Value("${file.upload-path}")
    private String pictureurl;
    @PostMapping("/setimg")
    @CrossOrigin
    public ResultVo setImg(@RequestBody MultipartFile file) {
        String fileName = file.getOriginalFilename();
        File saveFile = new File(pictureurl);
        //拼接url，采用随机数，保证每个图片的url不同
        UUID uuid = UUID.randomUUID();
        //重新拼接文件名，避免文件名重名
        int index = fileName.indexOf(".");
        String newFileName = "/avatar/" + fileName.replace(".", "") + uuid + fileName.substring(index);
        //存入数据库，这里可以加if判断
        Account user = new Account();
//        user.setId(id);
        user.setAvatar(newFileName);
//        sysUserMapper.updateById(user);
        try {
            //将文件保存指定目录
            file.transferTo(new File(pictureurl + newFileName));
        } catch (Exception e) {
            e.printStackTrace();
        }
        System.out.println("保存成功");
        return new ResultVo(ResutEnum.OK);
    }
}
