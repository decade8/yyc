// 导入axios配置service
import service from '../utils/request'

// 传递头像文件到后端
export function setImg(f) {
  return service.post('/login/setImg', JSON.stringify(f), {
    headers: { 'Content-Type': 'multipart/form-data' },

  })
}



// 将更改后的作者数据发送到后端
export function updateWriter(obj) {
  return service.post('/login/updateWriter', JSON.stringify(obj), {
    headers: { 'Content-Type': 'application/json' },
  })
}


// 将弹框的作者数据发送到后端
export function registerWriter(obj) {
  return service.post('/register/registerWriter', JSON.stringify(obj), {
    headers: { 'Content-Type': 'application/json' }
  })
}


// 注册账号,并且导出registerAccount函数，obj代表整个实例对象
export function registerAccount(obj) {
  return service.post('/register/registerAccount', JSON.stringify(obj), {
    headers: { 'Content-Type': 'application/json' }
  })
}

export function forgetAccount(obj) {
  return service.post('/forget/forgetAccount', JSON.stringify(obj), {
    headers: { 'Content-Type': 'application/json' }
  })
}
// 添加学生的成绩信息
export function addStudentScore(obj) {
  return service.post('/studentScore/addStudentScore', JSON.stringify(obj), {
    headers: { 'Content-Type': 'application/json' }
  })
}

// 更新学生成绩信息
export function updateStudentScore(obj) {
  return service.post('/studentScore/updateStudentScore', JSON.stringify(obj), {
    headers: { 'Content-Type': 'application/json' }
  })
}
