<template>
  <div class="login">
    <!-- 头部navbar -->
    <van-nav-bar
  title="会员登录"
  left-arrow
  @click-left="$router.go(-1)"
/>
    <!-- 主体 -->
    <div class="container">
      <div class="title">
        <h3>手机号登录</h3>
        <p>未注册的手机号登录后将自动注册</p>
      </div>

      <div class="form">
        <div class="form-item">
          <input v-model="mobile" class="inp" maxlength="11" placeholder="请输入手机号码" type="text">
        </div>
        <div class="form-item">
          <input v-model="picCode" class="inp" maxlength="5" placeholder="请输入图形验证码" type="text">
          <img :src="picUrl" alt="" @click="getPicCode">
        </div>
        <div class="form-item">
          <input v-model="smsCode" class="inp" placeholder="请输入短信验证码" type="text">
          <button @click="getCode">{{second===totalSecond?'获取验证码':second+'秒后重新发送'}}</button>
        </div>
      </div>
    
    <div @click="login" class="login-btn">登录</div>
  </div>
  </div>

  
</template>

<script>
import {Toast} from 'vant'
import request from '@/utils/request'
import {getPicCode,getCode, codeLogin} from '@/api/login'

export default {
  name:'Login',
  data() {
    return {
      picCode:'',//用户输入的图形验证码
      picKey:'',//将来请求传递的图形验证码唯一标识
      picUrl:'',//存储请求渲染的图片地址
      totalSecond:60,//总秒数
      second:60 ,//当前秒数
      timer:null, //定时器id
      smsCode:'',//短信验证码

      mobile:'',//手机号


    }
  },
  async created(){
    this.getPicCode()
    // console.log(this.picCode);
    // console.log(this.picKey);
  },
  methods: {
    //获取图形验证码
    async getPicCode(){
      try{
    const {data:{base64,key}}=await getPicCode()
    // const res=await getPicCode()
    // console.log(res);
    this.picUrl=base64//存储地址
    this.picKey=key//存储唯一标识
    
    // 刚开始创建时，piccode为空，其他能正常打印
    // console.log('111');
    // console.log(this.picCode);
    // console.log(this.picKey);

    Toast('获取图形验证码成功')
  }
    catch(error){ 
      console.log(error);
    }
    },
    //倒计时函数,获取短信验证码，并且要将图形验证码提交给后台进行校验
   async getCode(){
      if(!this.validFn()){
        // 如果没通过校验则没必要继续下面的步骤
        return 
      }
      // 没有定时器开着，且两者一致，则可以倒计时
      if(!this.timer&&this.second===this.totalSecond){

        // console.log('111');
        // console.log(this.picCode);
        // console.log(this.picKey);
        
        //如果响应返回的不是200，应该抛出一个promise错误，在响应拦截器中处理
        const res=await getCode(this.picCode,this.picKey,this.mobile)
        // 提交post请求到后端，校验图形验证码是否正确
        console.log(res);
        this.$toast('短信发送成功')
      this.timer=setInterval(()=>{
        this.second--
        if(this.second<=0){
          clearInterval(this.timer)
          this.timer=null
          this.second=this.totalSecond
        }
      },1000)

    }},
    // 校验手机号和图形验证码是否合法,通过校验返回true
    validFn(){
      if(!/^1[3-9]\d{9}$/.test(this.mobile)){
        this.$toast('请输入正确的手机号')
         return false
      }
      if(!/^\w{4}$/.test(this.picCode)){
        this.$toast('请输入正确的图形验证码')
        return false
      }
      return true

    },
    //登录操作，先进行校验，然后再调用接口函数进行登录
    async login(){
      if(!this.validFn()){
        return
      }
      if(!/^\d{6}$/.test(this.smsCode)){
        this.$toast('请输入正确的短信验证码')
        return
        
      }
      const res=await codeLogin(this.mobile,this.smsCode)
      //将登录成功返回的信息存入vuex
      this.$store.commit('user/setUserInfo',res.data)
      //检查是否存入vuex
      // console.log(this.$store.state.user.userInfo);
      console.log(res);
      this.$toast('登录成功')
      //进行判断，判断地址栏有无回跳地址
      //如果有，则说明是其他页面拦截到登录页面来的
      //如果没有，则正常去到首页
      const url =this.$route.backUrl ||'/'
      this.$router.push(url)
    },

  },
  destroyed(){
    // 离开页面清除定时器  
    clearInterval(this.timer)
  }


}
</script>

<style  lang="less" scoped>
.container {
  padding: 49px 29px;

  .title {
    margin-bottom: 20px;
    h3 {
      font-size: 26px;
      font-weight: normal;
    }
    p {
      line-height: 40px;
      font-size: 14px;
      color: #b8b8b8;
    }
  }

  .form-item {
    border-bottom: 1px solid #f3f1f2;
    padding: 8px;
    margin-bottom: 14px;
    display: flex;
    align-items: center;
    .inp {
      display: block;
      border: none;
      outline: none;
      height: 32px;
      font-size: 14px;
      flex: 1;
    }
    img {
      width: 94px;
      height: 31px;
    }
    button {
      height: 31px;
      border: none;
      font-size: 13px;
      color: #cea26a;
      background-color: transparent;
      padding-right: 9px;
    }
  }

  .login-btn {
    width: 100%;
    height: 42px;
    margin-top: 39px;
    background: linear-gradient(90deg,#ecb53c,#ff9211);
    color: #fff;
    border-radius: 39px;
    box-shadow: 0 10px 20px 0 rgba(0,0,0,.1);
    letter-spacing: 2px;
    display: flex;
    justify-content: center;
    align-items: center;
  }
}

</style>