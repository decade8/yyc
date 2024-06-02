package org.example.demo2.Mapper;

import org.example.demo2.dto.StudentScoreManage;
import org.apache.ibatis.annotations.Param;

import java.util.List;


public interface StudentScoreMapper {
    // 添加学生成绩
    void addStudentScore(@Param("ssm")StudentScoreManage ssm);
    // 根据学号判断学生成绩信息是否存在
    String findStudentId(@Param("studentId")String studentId);
    // 根据学生学号删除成绩信息
    void deleteStudentByStudentId(@Param("studentId")String studentId);
    // 根据学号修改学生成绩
    void updateStudentScore(@Param("ssm")StudentScoreManage ssm);
    //显示所有学生信息
    List<StudentScoreManage> findStudentScoreInfo();
}
