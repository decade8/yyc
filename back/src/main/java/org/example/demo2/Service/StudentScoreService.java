package org.example.demo2.Service;

import org.example.demo2.Mapper.StudentScoreMapper;
import org.example.demo2.dto.StudentScoreManage;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.List;

@Service
public class StudentScoreService {
    @Resource
    private StudentScoreMapper studentScoreMapper;

    // 添加学生成绩信息 ssm是一个实例对象
    public String addStudentScore(StudentScoreManage ssm) {
        String message="";
        // 判断成绩表是否有该学生信息
        if (studentScoreMapper.findStudentId(ssm.getStudentId()) ==null) {
            studentScoreMapper.addStudentScore(ssm);
            message = "添加成功！";
        } else {
            message = "该学生成绩已存在!";
        }
        return message;
    }

    // 删除学生成绩
    public String deleteStudentByStudentId (String studentId) {
        String message="";
        // 判断该学生是否存在
        if (studentScoreMapper.findStudentId(studentId)==null) {
            message ="该学生成绩不存在";
        } else {
//            执行删除操作
            studentScoreMapper.deleteStudentByStudentId(studentId);
            message = "删除成功!";
        }
        return message;
    }

    //修改学生成绩
    public String updateStudentByStudentId(StudentScoreManage ssm){
        String message ="";
        // 判断该学生是否存在
        if(studentScoreMapper.findStudentId(ssm.getStudentId())==null){
            message = "该学生的成绩信息不存在";
        } else {
            studentScoreMapper.updateStudentScore(ssm);
        }
        return message;
    }

    // 显示所有学生的成绩
    public List<StudentScoreManage> findStudentScoreInfo(){
        // 使用集合接收数据
        List<StudentScoreManage> studentScoreManageList = studentScoreMapper.findStudentScoreInfo();
        return studentScoreManageList;
    }

    // 判断学号是否存在
    public String findStudentId(String studentId) {
        return studentScoreMapper.findStudentId(studentId);
    }
}
