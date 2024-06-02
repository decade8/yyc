// 查看分数信息
<template>
    <div>
        <el-container>
            <el-header>查看学生成绩<span id="showScore_return" :style="bgc" @click="showScore_return" @mouseover="mouseOver" @mouseleave="mouseLeave">返回</span></el-header>
            <el-main>
                <el-table
                        id="showScore_table"
                        :data="studentScore"
                        stripe
                        style="width: 100%">
                    <el-table-column
                            prop="studentId"
                            label="学号"
                            width="180">
                    </el-table-column>
                    <el-table-column
                            prop="studentName"
                            label="姓名"
                            width="180">
                    </el-table-column>
                    <el-table-column
                            prop="chineseScore"
                            label="语文"
                            width="180">
                    </el-table-column>
                    <el-table-column
                            prop="mathScore"
                            label="数学"
                            width="180">
                    </el-table-column>
                    <el-table-column
                            prop="englishScore"
                            label="英语"
                            width="180">
                    </el-table-column>
                </el-table>
            </el-main>
            <el-footer>学生成绩管理</el-footer>
        </el-container>
    </div>
</template>
<script>
import {findStudentScoreInfo} from "../api/get";

export default {
    name: 'showScore',
    data () {
        return {
            bgc: '', //样式
            studentScore: [{
                studentId: '',
                studentName: '',
                chineseScore: '',
                mathScore: '',
                english: ''
            }], // 接收查找的数据
        }
    },
    methods: {
        // 返回
        showScore_return () {
            this.$router.back(-1)
        },
        // 鼠标悬停变色
        mouseOver () {
            this.bgc = 'background-color: #cccccc;color: red'
        },
        mouseLeave () {
            this.bgc = ''
        },
        // 获取学生成绩数据
        findStudentScoreInfo() {
            findStudentScoreInfo().then(res => {
                this.studentScore = res.data.data
            })
        }
    },
    created() {
        this.findStudentScoreInfo()
    }
}
</script>
<style scoped>
@import "../assets/css/showScore.css";
</style>
