<!-- // 这里给大家举一个例子：
// 登录和注册界面以及功能 -->
<template>
  <div v-show="loginShowControll">
    <!--登录界面-->
    <div v-show="loginShow" id="login_login">
      <el-container class="login">
        <el-header><strong>登录</strong></el-header>
        <div class="loader"></div>
        <el-main>
          <div class="login1">
            <div class="login_2">
              <a href="new.html"
                ><button class="QQ">
                  <img src="../assets/qq.png" alt="" id="qqlogo" />QQ 登录
                </button></a
              >
              <a href="new.html"
                ><button class="WX">
                  <img src="../assets/微信.png" alt="" id="wxlogo" />微信登录
                </button></a
              >
              <a href="new.html"
                ><button class="ZFB">
                  <img
                    src="../assets/支付宝支付.png"
                    alt=""
                    id="zfblogo"
                  />支付宝登录
                </button></a
              >
            </div>
            <!--                    输入框-->
            <div class="login3">
              <span id="login_usernameInfo">用户名:</span>
              <el-input
                v-model="username"
                placeholder="请输入用户名"
                id="login_input_username"
              ></el-input>
              <span id="login_passwordInfo">密码:</span>
              <el-input
                v-model="password"
                placeholder="请输入密码"
                id="login_input_password"
                type="password"
              ></el-input>
              <!--                    按钮-->
              <el-button
                type="success"
                round
                id="login_submit"
                class="circle"
                @click="loginButton"
                >登录</el-button
              >
              <!-- <button type="submit" id="login_submit" class="circle" @click="loginButton">登录</button> -->
              <el-button
                type="primary"
                round
                id="login_registerButton"
                class="circle"
                @click="registerButton"
                >注册</el-button
              >
              <!-- <button type="submit" id="login_registerButton" class="circle" @click="registerButton">注册</button> -->
              <span
                id="register_forget"
                @click="registerForget"
                @mouseover="mouseOver"
                @mouseleave="mouseLeave"
                :style="bgc"
                >忘记密码</span
              >
            </div>
          </div>
        </el-main>
        <el-footer><strong>登录</strong></el-footer>
      </el-container>
    </div>
    <!--注册界面-->
    <div v-show="registerShow" id="login_register">
      <el-container>
        <el-header><strong>注册新用户</strong></el-header>
        <div class="loader"></div>
        <el-main>
          <!--注册输入框-->
          <div >
            <el-form :model="obj1" :rules="rules" class="register1">
              <!-- :model保存表单的数据对象 form-->
              <el-form-item label="姓名" :label-width="formLabelWidth" prop="name">
                <el-input v-model="obj1.name" autocomplete="off" placeholder="请输入姓名" ></el-input>
              </el-form-item>

              <el-form-item label="用户名" :label-width="formLabelWidth" prop="registerUsername">
                <el-input v-model="obj1.registerUsername" autocomplete="off" placeholder="请输入用户名" ></el-input>
              </el-form-item>
    
              <el-form-item label="密码" :label-width="formLabelWidth" prop="registerPassword">
              <el-input v-model="obj1.registerPassword" autocomplete="off"  placeholder="请输入密码" ></el-input>
              </el-form-item>
    
              <el-form-item label="邮箱" :label-width="formLabelWidth" prop="registerEmail" >
                <el-input v-model="obj1.registerEmail" autocomplete="off" placeholder="请输入邮箱"  ></el-input>
              </el-form-item>
    
    
              <el-form-item label="生日"  :label-width="formLabelWidth" prop="year">
                <el-date-picker v-model="obj1.year"  type="date"  placeholder="选择日期" >
                  </el-date-picker>
    </el-form-item>

    <el-form-item label="头像" :label-width="formLabelWidth" >
      <el-upload
      ref="upload"
      class="avatar-uploader"
      action="/setimg"
      :http-request="picUpload"
      :show-file-list="false"
      :auto-upload="false"
      :on-success="handleAvatarSuccess"
      :before-upload="beforeAvatarUpload"
    >
    <el-button type="primary" @click="submitUpload">点击上传</el-button>
    </el-upload>
  </el-form-item>

    </el-form>
            <!--按钮-->
            <div class="button1">
              <el-button
              type="success"
              round
              id="register_submit"
              class="circle"
              @click="submitButton()"
              >提交</el-button
            >
            <el-button
              type="info"
              round
              id="register_registerButton"
              class="circle"
              @click="resetButton"
              >重置</el-button
            >
            <span
              id="register_return"
              @click="registerReturn"
              @mouseover="mouseOver"
              @mouseleave="mouseLeave"
              :style="bgc"
              >返回</span
            >

            </div>
            
          </div>
        </el-main>
        <el-footer><strong>注册新用户</strong></el-footer>
      </el-container>
    </div>
    <!-- 忘记密码页面 -->
    <div v-show="forgetShow" id="login_forget">
      <el-container>
        <el-header><strong>修改密码</strong></el-header>
        <div class="loader"></div>
        <el-main>
          <!-- 输入框-->
          <div class="forget1">
            <span id="forget_usernameInfo">用户名:</span>
            <el-input
              v-model="forgetUsername"
              placeholder="请输入用户名"
              id="forget_input_username"
            ></el-input>

            <span id="forget_passwordInfo0">旧密码:</span>
            <el-input
              v-model="forgetPassword0"
              placeholder="请输入旧密码"
              id="forget_input_password0"
              type="password"
            ></el-input>
          </div>
          <div class="forget2">
            <span id="forget_passwordInfo">新密码:</span>
            <el-input
              v-model="forgetPassword"
              placeholder="请输入新密码"
              id="forget_input_password"
              type="password"
            ></el-input>

            <span id="forget_passwordInfo1">确认密码:</span>
            <el-input
              v-model="forgetPassword1"
              placeholder="请确认密码"
              id="forget_input_password1"
              type="password"
            ></el-input>
            <!--按钮-->
            <!-- <button type="submit" id="forget_submit"  class="circle" @click="forgetButton">提交</button> -->
            <el-button
              type="success"
              round
              id="forget_submit"
              class="circle"
              @click="forgetButton"
              >提交</el-button
            >
            <el-button
              type="info"
              round
              id="forget_registerButton"
              class="circle"
              @click="resetButton1"
              >重置</el-button
            >
            <!-- <button type="submit" id="forget_registerButton" class="circle" @click="resetButton1">重置</button> -->
            <span
              id="register_return1"
              @click="registerReturn1"
              @mouseover="mouseOver"
              @mouseleave="mouseLeave"
              :style="bgc"
              >返回</span
            >
          </div>
        </el-main>
        <el-footer><strong>修改密码</strong></el-footer>
      </el-container>
    </div>
  </div>
</template>
<script>
import { setImg } from "../api/post";
import { loginTosystem } from "../api/get";
import { registerAccount } from "../api/post";
import { forgetAccount } from "../api/post";
import { findName2 } from "../api/get";
import axios from "axios";
import { len, required, email, Chinese,date } from "../utils/formrules";

export default {
  name: "Login",
  data() {
    return {
      loginShowControll: true, // 登录、注册界面显示控制
      loginShow: true, // 登录界面显示控制
      registerShow: false, // 注册界面显示控制
      forgetShow: false, //忘记密码页面控制

      username: "", // 用户名
      password: "", // 密码
      name: "", // 姓名
      email: "", //邮箱

      bgc: "", // 鼠标悬停变色

      // registerUsername: "", // 注册账号
      // registerPassword: "", // 注册密码
      // registerEmail: "", //注册邮箱
      // value1: "",//生日

      forgetUsername: "", //要找回的用户名
      forgetPassword: "", //新密码
      forgetPassword1: "", //确认密码
      forgetPassword0: "", //旧密码
      flag: 1, //标识忘记密码的用户名是否存在
      flag1: 1, //标识注册用户的用户名是否存在

      pictureurl: "",
      picturename: "",
      imageUrl: "",
      rules: {
        // name项必须填写内容，且字符长度在10之内,为汉字
        name: [required, len(10), Chinese],
        registerUsername:[required,len(10)],
        registerPassword: [required, len(10)],
        registerEmail: [required, email],
        year:[required,date]
      },
      obj1: {
        name:'',
        registerUsername: "", // 注册账号
        registerPassword: "", // 注册密码
        registerEmail: "", //注册邮箱
        year: "",

      },
      avatar:"http://localhost:8081/img/ldsa3412-61w5-4ddc-1sac-2cd835saod5a.jpg"
    };
  },
  methods: {
    //图片上传相关函数

    handleAvatarSuccess(res, file) {
      this.imageUrl = URL.createObjectURL(file.raw);
    },
    beforeAvatarUpload(file) {
      const isJPG = file.type === "image/jpeg";
      const isLt2M = file.size / 1024 / 1024 < 2;

      if (!isJPG) {
        this.$message.error("上传头像图片只能是 JPG 格式!");
      }
      if (!isLt2M) {
        this.$message.error("上传头像图片大小不能超过 2MB!");
      }
      return isJPG && isLt2M;
    },

    //触发请求
    picUpload(f) {
      let params = new FormData();
      //注意在这里一个坑f.file
      params.append("file", f.file);
      axios({
        method: "post",
        //这里的id是我要改变用户的ID值
        url: "/setimg/",
        data: params,
        headers: {
          "content-type": "multipart/form-data",
        },
      }).then((resp) => {
        //这里返回的是头像的url
        console.log(resp);
        this.imageUrl = resp.obj;
      });
    },
    //触发请求
    submitUpload() {
      this.$refs.upload.submit();
    },

    //提交忘记密码请求
    forgetButton() {
      if (this.forgetUsername.trim() === "") {
        alert("请输入用户名");
        return;
      }
      if (this.forgetPassword0.trim() === "") {
        alert("请输入旧密码");
        return;
      }
      if (this.forgetPassword.trim() === "") {
        alert("请输入新密码");
        return;
      }
      if (this.forgetPassword1.trim() === "") {
        alert("请确认新密码");
        return;
      }
      if (this.forgetPassword !== this.forgetPassword1) {
        alert("两次输入的密码不一致，请重新输入");
        return;
      }
      if (this.forgetPassword0 === this.forgetPassword) {
        alert("新密码和旧密码不能一样，请重新输入");
        return;
      }
      const obj = {
        username: this.forgetUsername,
        password: this.forgetPassword,
      };

      loginTosystem(this.forgetUsername, this.forgetPassword0).then((res) => {
        //异步操作
        // console.log(res.data.data);
        if (res.data.data === "登录失败") {
          this.flag = 0;
          alert("账号密码输入错误");
          // console.log(this.flag);
          // console.log(res.data.data);
          return;
        } else {
          // console.log(this.flag);//1
          this.forgetAccount(obj);
          this.forgetUsername = "";
          this.forgetPassword0="";
          this.forgetPassword = "";
          this.forgetPassword1 = "";
          return;
        }
      });
      //此处重点注意js代码的执行顺序，异步放在同步后面执行
      // console.log(this.flag);//1 出findname1 flag值就变为原来的1
      // if(this.flag===0){
      //     console.log(this.flag);//不执行
      //     alert('该用户名不存在')
      //     return}
      // else{
      //     console.log(this.flag);//1
      //     this.forgetAccount(obj)
      //     this.forgetUsername = ''
      //     this.forgetPassword = ''
      //     this.forgetPassword1 = ''
      //     return
      // }
    },
    //发送请求函数
    async forgetAccount(obj) {
      await forgetAccount(obj).then((res) => {
        // console.log(res.data)
        alert(res.data.data);
        // 上面一句用来显示操作成功
      });
    },
    //重置忘记密码页
    resetButton1() {
      this.forgetUsername = "";
      this.forgetPassword = "";
      this.forgetPassword1 = "";
    },
    // 跳转注册界面
    registerButton() {
      this.loginShow = false;
      // 改变显示类的值
      this.registerShow = true;
    },
    // 忘记密码改变页面
    registerForget() {
      this.loginShow = false;
      this.forgetShow = true;
    },

    // 登录学生成绩管理系统
    loginButton() {
      if (this.username.trim() == "") {
        alert("请输入用户名");
        return;
      }
      if (this.password.trim() == "") {
        alert("请输入密码");
        return;
      }
      loginTosystem(this.username, this.password).then((res) => {
        if (res.data.data == "登录失败") {
          alert("账号或密码错误！");
        } else {
          alert("登录成功");
          // console.log(res.data.data);
          //然后进行路由的跳转,路由传参
          this.$router.push({
            path: "/maintry",
            // 将username传到maintry组件，用于获取登陆人员的姓名
            query: { username: this.username },
          });
        }
      });
    },
    // 提交注册的按钮
    submitButton() {
      if (this.obj1.name === "") {
        alert("请输入姓名");
        return;
      }
      if (this.obj1.registerUsername === "") {
        alert("请输入用户名");
        return;
      }
      if (this.obj1.registerPassword === "") {
        alert("请输入密码");
        return;
      }
      if (this.obj1.registerEmail === "") {
        alert("请输入邮箱");
        return;
      }
      const obj={
        name:this.obj1.name,
        username: this.obj1.registerUsername,
        password: this.obj1.registerPassword,
        email:this.obj1.registerEmail,
        year:this.obj1.year,
        avatar:this.avatar
       
      }
      findName2(this.obj1.registerUsername).then((res) => {
        //异步操作
        // console.log(this.flag1);//1
        // console.log(res.data);//用户名不存在
        if (res.data.data === "用户名已存在") {
          this.flag1 = 0;
          alert("该用户名已存在");
          // console.log(this.flag1);//0
          // console.log(res.data);
          return;
        } else {
          // console.log(this.flag1);//1
          this.registerAccount(obj);
          //注册信息，然后将页面清空
          this.obj1.name = "";
          this.obj1.registerUsername = "";
          this.obj1.registerPassword = "";
          this.obj1.registerEmail = "";
          this.obj1.year=""
          return;
        }
      });
    },
    // 注册信息,这个函数是post.js文件导出的
    async registerAccount(obj) {
      await registerAccount(obj).then((res) => {
        console.log(res.data);
        alert(res.data.data);
      });
    },
    // 重置文本
    resetButton() {
      this.obj1.name = "";
      this.obj1.registerUsername = "";
      this.obj1.registerPassword = "";
      this.obj1.registerEmail = "";
      this.obj1.year = "";
    },
    // 从注册页面返回登录界面
    registerReturn() {
      this.loginShow = true;
      this.registerShow = false;
    },
    //从忘记密码页面返回登录页面
    registerReturn1() {
      this.loginShow = true;
      this.forgetShow = false;
    },
    // 鼠标悬停变色
    mouseOver() {
      this.bgc = "background-color: #cccccc;color: red";
    },
    mouseLeave() {
      this.bgc = "";
    },
  },
};
</script>

<style scoped>
@import "../assets/css/login.css";
</style>

