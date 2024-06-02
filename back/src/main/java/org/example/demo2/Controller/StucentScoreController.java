package org.example.demo2.Controller;

import org.example.demo2.Service.StudentScoreService;
import org.example.demo2.Vo.ResultVo;
import org.example.demo2.constant.ResutEnum;
import org.example.demo2.dto.StudentScoreManage;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Map;

@RestController
@RequestMapping("/studentScore/*")
public class StucentScoreController {
    @Resource
    private StudentScoreService studentScoreService;

    // 添加学生成绩信息
    @PostMapping("/addStudentScore")
    public ResultVo addStudentScore(@RequestBody StudentScoreManage ssm){
        return new ResultVo(ResutEnum.OK,studentScoreService.addStudentScore(ssm));
    }

    // 删除学生信息  呼应前端get.js文件中的get请求
    @GetMapping("/deleteStudentScore")
    public ResultVo deleteStudentScore(@RequestParam("studentId")String studentId) {
        return new ResultVo(ResutEnum.OK,studentScoreService.deleteStudentByStudentId(studentId));
    }

    // 修改学生成绩
    @PostMapping("/updateStudentScore")
    public ResultVo updateStudentScore(@RequestBody StudentScoreManage ssm) {
        return new ResultVo(ResutEnum.OK,studentScoreService.updateStudentByStudentId(ssm));
    }

    //显示所有学生成绩信息
    @GetMapping("/findStudentScoreInfo")
    public ResultVo findStudentScoreInfo() {
        return new ResultVo(ResutEnum.OK,studentScoreService.findStudentScoreInfo());
    }

    @GetMapping("/findStudentId")
    public ResultVo findStudentId(@RequestParam("studentId")String studentId) {
        return new ResultVo(ResutEnum.OK,studentScoreService.findStudentId(studentId));
    }
}
