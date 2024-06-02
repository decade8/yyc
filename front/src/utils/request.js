import axios from 'axios'

// 创建axios实例service
// eslint-disable-next-line no-unused-vars
const service = axios.create({
  // baseURL: '/', // api的base_Url
  // 后端的请求路径
  baseURL: 'http://localhost:8081/student', // api的base_Url
  timeout: 50000 // 请求超时时间
})

// 请求拦截器,这是初始axios实例的拦截器
axios.interceptors.request.use(
  function (config) {
    // 在发送请求之前做些什么
    return config
  },
  function (error) {
    // 对请求错误做些什么
    return Promise.reject(error)
  }
)

// 响应拦截器
axios.interceptors.response.use(
  (response) => {
    let res = response.data;
    if (res.code != 200) {
      return Promise.reject(res.data);
    } else {
      return res;
    }
  },
  (error) => Promise.reject(error)
  // function (config) {
  //   // 对响应数据做点什么
  //   return config
  // },
  // function (error) {
  //   // 对响应错误做点什么
  //   return Promise.reject(error)
  // }
)

export default service

