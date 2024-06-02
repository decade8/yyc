<!--// 综合-->
<template>
  <div>
      <el-container style="border: 1px solid #eee" class="firstcontainer">
        <el-aside width="" id="aside1" >
          <el-menu :default-openeds="['1', '3']">
            <el-submenu index="1">
                <template slot="title" ><i class="el-icon-message "></i>收起</template>
              <el-menu-item-group >
                  <el-menu-item index="1-1" @click="Homepage">首页</el-menu-item>
                <el-submenu index="1-2">
                    <template slot="title">功能菜单</template>
                    <el-menu-item index="1-2-1" @click='Writer'>作者管理</el-menu-item>
                    <el-menu-item index="1-2-2" @click='User'>用户管理</el-menu-item>
                  </el-submenu>
                  <el-submenu index="1-3">
                    <template slot="title">主题切换</template>
                    <el-menu-item index="1-3-1" @click="ChangeColor1">默认主题</el-menu-item>
                    <el-menu-item index="1-3-2" @click="ChangeColor2">蓝色主题</el-menu-item>
                    <el-menu-item index="1-3-3" @click="ChangeColor3">粉色主题</el-menu-item>
                     </el-submenu>
               
                <el-menu-item index="1-4">导航三</el-menu-item>
                <el-menu-item index="1-5">导航四</el-menu-item>
               
              </el-menu-item-group>
            </el-submenu>
          </el-menu>
        </el-aside>
        
        <el-container>

          <el-header style="text-align: right; font-size: 12px" id="elheader">
            <el-dropdown>
              <i class="el-icon-setting" style="margin-right: 15px"></i>
              <el-dropdown-menu slot="dropdown">
                <el-dropdown-item><el-button @click="Homepage">日历</el-button></el-dropdown-item>
                <el-dropdown-item><el-button @click="back">退出</el-button></el-dropdown-item>
              </el-dropdown-menu>
            </el-dropdown>
            <span>{{name}}</span>
          </el-header>
          
          <el-main id="elmain">
            <router-view :name1="name" :username1="username" :email1="email" :year1="year" ></router-view>
          </el-main>
        </el-container>

      </el-container>
  </div>
</template>
<script>
import {findName} from "../api/get";
import {findMsg} from "../api/get"

export default {
  name: 'maintry',
  data () {
      return {
          username: '', // 登陆人员的username
          name: '' ,// 登录人员的姓名
          email:'',//登录人员邮箱
          date:''//登录人员生日
          
      }
      }
  ,
  methods: {
    // 跳转到用户管理,通过router-view更新局部组件
    User(){
      this.$router.push({
          path: '/user',
      })
    },
    // 跳转到作者管理
    Writer(){
      this.$router.push({
          path: '/writer',
      })
    },
    //  跳转到首页
    Homepage(){
      this.$router.push({
          path: '/homepage',
      })
    },
    // 切换主题颜色
      ChangeColor1(){//默认主题

        document.getElementById("aside1").style.backgroundColor=' #E9EEF3';
        document.getElementById("elheader").style.backgroundColor='#B3C0D1';
        document.getElementById("elmain").style.backgroundColor=' #E9EEF3';
        },
      ChangeColor2(){//蓝色主题
        document.getElementById("aside1").style.backgroundColor=' #a7c9ea';
        document.getElementById("elheader").style.backgroundColor='#0087cd';
        document.getElementById("elmain").style.backgroundColor=' #a7c9ea';
        // js中的颜色要加引号
        },
      ChangeColor3(){//粉色主题
        document.getElementById("aside1").style.backgroundColor='#c93384';
        document.getElementById("elheader").style.backgroundColor='#930058';
        document.getElementById("elmain").style.backgroundColor='#c93384';
        // js中的颜色要加引号
        },

      //返回上一页
      back(){
        this.$router.push('/login')
        // 跳转到登录页
      },
      // 获取显示登录人员的姓名
      getName (username) {
          findName(username).then(res => {
              this.name = res.data.data
              // console.log(res.data);
          })
      },
      // 获取显示登录人员的各项信息
      getmMsg(username){
        findMsg(username).then(res => {
              this.name = res.data.data.name
              this.username=res.data.data.username
              this.email=res.data.data.email
              this.year=res.data.data.year
              // console.log(res.data.data);
          })

      },
      // 前往添加页面
      gotoAdd () {
          this.$router.push('/addScore')
      },
      // 前往删除页面
      gotoDelete () {
          this.$router.push('/deleteScore')
      },
      // 前往修改页面
      gotoUpdate () {
          this.$router.push('/updateScore')
      },
      // 前往查询页面
      gotoFind () {
          this.$router.push('/showScore')
      }
  },
  // 页面创造时自动执行·
  created() {
      // 接收传过来的username的值
      this.username =this.$route.query.username
      // 获取姓名
      this.getName(this.username)
      //获取用户各项数据
      this.getmMsg(this.username)
  }
}
</script>
<style >
@import "../assets/css/maintry.css";
</style>
