// 增加分数信息
<template>
    <div>
        <el-container>
            <el-header>添加学生成绩 <span id="addScore_return" @click="addScore_return" :style="bgc" @mouseover="mouseOver" @mouseleave="mouseLeave">返回</span></el-header>
            <el-main>
                <div id="addScore_studentId">学生学号：<el-input placeholder="请输入学号" prefix-icon="el-icon-search" v-model="studentId" id="addScore_studentId_input"></el-input></div>
                <div id="addScore_studentName">学生姓名：<el-input placeholder="请输入姓名" prefix-icon="el-icon-search" v-model="studentName" id="addScore_studentName_input" @input="LengthLimit"></el-input></div>
                <div id="addScore_chineseScore">语文成绩：<el-input placeholder="请输入语文成绩" prefix-icon="el-icon-search" v-model="chineseScore" id="addScore_chineseScore_input" @input="LengthLimit"></el-input></div>
                <div id="addScore_mathScore">数学成绩：<el-input placeholder="请输入数学成绩" prefix-icon="el-icon-search" v-model="mathScore" id="addScore_mathScore_input" @input="LengthLimit"></el-input></div>
                <div id="addScore_englishScore">英语成绩：<el-input placeholder="请输入英语成绩" prefix-icon="el-icon-search" v-model="englishScore" id="addScore_englishScore_input" @input="LengthLimit"></el-input></div>
                <el-button id="addScore_submit" @click="addScore_submit">提交</el-button>
                <el-button id="addScore_reset" @click="addScore_reset">重置</el-button>
            </el-main>
            <el-footer>学生成绩管理</el-footer>
        </el-container>
    </div>
</template>
<script>
import {addStudentScore} from "../api/post";
import {findStudentId} from "../api/get";

export default {
    name: 'addScore',
    data () {
        return {
            name: '', // 传过来的姓名
            studentId: '', // 学号
            studentName: '', // 学生姓名
            chineseScore: '', //语文成绩
            mathScore: '', // 数学成绩
            englishScore: '', // 英语成绩
            bgc: '' // 改变样式
        }
    },
    methods: {
        // 返回主界面
        addScore_return () {
            this.$router.back(-1)
        },
        // 鼠标悬停变色
        mouseOver () {
            this.bgc = 'background-color: #cccccc;color: red'
        },
        mouseLeave () {
            this.bgc = ''
        },
        // 限制输入长度
        LengthLimit () {
            if (this.chineseScore.length > 3) {
                this.chineseScore = this.chineseScore.slice(0, 3)
            }
            if (this.englishScore.length > 3) {
                this.englishScore = this.englishScore.slice(0, 3)
            }
            if (this.mathScore.length > 3) {
                this.mathScore = this.mathScore.slice(0, 3)
            }
            if (this.studentName.length > 4) {
                this.studentName = this.studentName.slice(0, 4)
            }
        },
        // 提交数据
        addScore_submit () {
            if (this.studentId.trim() === '') {
                alert('请输入学号')
                return
            }
            if (this.chineseScore.trim() === '') {
                alert('请输入语文成绩')
                return
            }
            if (this.englishScore.trim() === '') {
                alert('请输入数学成绩')
                return
            }
            // 定义一个对象接收
            const obj = {
                studentId: this.studentId,
                studentName: this.studentName,
                chineseScore: this.chineseScore,
                mathScore: this.mathScore,
                englishScore: this.englishScore
            }
            // 判断学号是否存在
            if (findStudentId(this.studentId).then(res => {
                if (res.data.data === null) {
                    // 不存在则创建
                    addStudentScore(obj).then(res => {
                        if (res.data.code === 2000) {
                            alert('添加成功')
                        } else {
                            alert('添加失败')
                        }
                    })
                } else {
                    alert('该学号已经存在')
                }
            }))


            this.studentId = ''
            this.studentName = ''
            this.chineseScore = ''
            this.mathScore = ''
            this.englishScore = ''
        },
        // 重置
        addScore_reset () {
            this.studentId = ''
            this.studentName = ''
            this.chineseScore = ''
            this.mathScore = ''
            this.englishScore = ''
        }
    },
    created () {
        this.name = this.$route.query.name
    },
    watch: {
        // 监听只能输入英文和数字
        studentId (newValue, oldValue) {
            this.studentId = newValue.replace(/[^A-Za-z0-9]/g, '')
        },
        // 只能输入汉字
        studentName (newValue, oldValue) {
          this.studentName = newValue.replace(/[^\4E00-\u9FA5]/g, '')
        },
        // 只能输入数字
        chineseScore (newValue, oldValue) {
            this.chineseScore = newValue.replace(/[^\d]/g, '')
        },
        mathScore (newValue, oldValue) {
            this.mathScore = newValue.replace(/[^\d]/g, '')
        },
        englishScore (newValue, oldValue) {
            this.englishScore = newValue.replace(/[^\d]/g, '')
        }
    }
}
</script>
<style scoped>
@import "../assets/css/addScore.css";
</style>
