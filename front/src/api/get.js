// 导入axios配置service
import service from '../utils/request'


// 修改时查找该作者的各项信息
export function findone(xuhao) {
  return service.get('/login/findone', {
    headers: { 'Content-Type': 'application/json' },
    params: {
      xuhao: xuhao
      // 传到后端的序号
    }
  })
}


// 删除作者的各项数据
export function deleteWriter(xuhao) {
  return service.get('/login/deleteWriter', {
    headers: { 'Content-Type': 'application/json' },
    params: {
      xuhao: xuhao
      // 传到后端的序号
    }
  })
}


//获取作者的各项数据
export function findWriter() {
  return service.get('/login/findWriter', {
    headers: { 'Content-Type': 'application/json' },
  })
}
// 分页获取作者数据
export function findWriter1(pagenow, pagesize) {
  return service.get('/login/findWriter1', {
    headers: { 'Content-Type': 'application/json' },
    params: {
      pagenow: pagenow,
      pagesize: pagesize
      // 传到后端的序号
    }
  })
}

// 获取分页查询数据

export function findWriter2(pagenow, pagesize, name) {
  return service.get('/login/findWriter2', {
    headers: { 'Content-Type': 'application/json' },
    params: {
      pagenow: pagenow,
      pagesize: pagesize,
      name: name
      // 传到后端的序号
    }
  })
}


// 获取登录人员各项信息
export function findMsg(username) {
  return service.get('/login/findMsg', {
    headers: { 'Content-Type': 'application/json' },
    params: {
      username: username
    }
  })
}

// 登录
export function loginTosystem(username, password) {
  return service.get('/login/loginTosystem', {
    headers: { 'Content-Type': 'application/json' },
    params: {
      username: username,
      password: password
    }
  })
}
//获取要修改人员的username
export function findName1(username) {
  return service.get('/forget/findName', {
    headers: { 'Content-Type': 'application/json' },
    params: {
      username: username
    }
  })
}
//获取注册用户名是否重复
export function findName2(username) {
  return service.get('/register/findName', {
    headers: { 'Content-Type': 'application/json' },
    params: {
      username: username
    }
  })
}
// 获取登录人员姓名
export function findName(username) {
  return service.get('/login/findName', {
    headers: { 'Content-Type': 'application/json' },
    params: {
      username: username
    }
  })
}

// 删除学生成绩信息
export function deleteStudentScore(studentId) {
  return service.get('/studentScore/deleteStudentScore', {
    headers: { 'Content-Type': 'application/json' },
    params: {
      studentId: studentId
      // 传到后端的studentId
    }
  })
}

// 查找所有学生成绩
export function findStudentScoreInfo() {
  return service.get('/studentScore/findStudentScoreInfo', {
    headers: { 'Content-Type': 'application/json' }
  })
}

// 判断学号是否存在
export function findStudentId(studentId) {
  return service.get('/studentScore/findStudentId', {
    headers: { 'Content-Type': 'application/json' },
    params: {
      studentId: studentId
    }
  })
}
