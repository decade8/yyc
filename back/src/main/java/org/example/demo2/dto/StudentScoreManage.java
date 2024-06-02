package org.example.demo2.dto;

import lombok.Data;


@Data
public class StudentScoreManage {
    // 主键
    private Integer id;
    // 学生学号
    private String studentId;
    // 学生姓名
    private String studentName;
    // 语文成绩
    private Integer chineseScore;
    // 数学成绩
    private Integer mathScore;
    //英语成绩
    private Integer englishScore;
}


