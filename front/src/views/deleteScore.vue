// 删除分数信息
<template>
    <div>
        <el-container>
            <el-header>删除学生成绩<span id="deleteScore_retruen" @click="deleteScore_return" @mouseover="mouseOver" @mouseleave="mouseLeave" :style="bgc">返回</span></el-header>
            <el-main>
                <div id="delteScore_studentId">学生学号：<el-input placeholder="请输入学号" prefix-icon="el-icon-search" v-model="studentId" id="deleteScore_studentId_input"></el-input></div>
                <el-button id="deleteScore_submit" @click="deleteScore_submit">提交</el-button>
                <el-button id="deleteScore_reset" @click="deleteScore_reset">重置</el-button>
            </el-main>
            <el-footer>学生成绩管理</el-footer>
        </el-container>
    </div>
</template>
<script>
    import {deleteStudentScore, findStudentId} from "../api/get";

export default {
    name: 'deleteScore',
    data () {
        return {
            studentId: '', // 学生学号
            bgc: '' // 样式
        }
    },
    methods: {
        // 鼠标悬停变色
        mouseOver () {
            this.bgc = 'background-color: #cccccc;color: red'
        },
        mouseLeave () {
            this.bgc = ''
        },
        // 返回页面
        deleteScore_return () {
            this.$router.back(-1)
        },
        // 提交
        deleteScore_submit () {
            if (this.studentId.trim() === '') {
                alert('请输入学号')
            }
            findStudentId(this.studentId).then(res => {
                if (res.data.data === null) {
                    alert('该学号不存在')
                } else {
                    deleteStudentScore(this.studentId).then(res => {
                        if (res.data.code === 2000) {
                            alert('删除成功')
                        } else {
                            alert('删除失败')
                        }
                    })
                }
            })
            this.studentId = ''
        },
        // 重置
        deleteScore_reset () {
            this.studentId = ''
        }
    },
    watch: {
        // 监听只能输入英文和数字
        studentId (newValue, oldValue) {
            this.studentId = newValue.replace(/[^A-Za-z0-9]/g, '')
        },
    }
}
</script>
<style scoped>
@import "../assets/css/deleteScore.css";
</style>
