// 存放登录相关的接口请求
// 1.获取图形验证码，导入axios实例request
import request from '@/utils/request'
// import { config } from 'vue/types/umd'
export const getPicCode = () => {
  return request.get('/captcha/image')
}
// 获取短信验证码
export const getCode = (captchaCode, captchKey, mobile) => {
  return request.post('/captcha/sendSmsCaptcha', {
    form: {
      captchaCode,
      captchKey,
      mobile
    }
  })
}
// 短信登录接口
export const codeLogin = (mobile, smsCode) => {
  return request.post('/passport/login', {
    Headers: {
      platformg: 'H5'
    },
    form: {
      isParty: false,
      mobile,
      partyData: {},
      smsCode
    }
  })
}
