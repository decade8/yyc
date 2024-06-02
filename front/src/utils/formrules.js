export const required = {
  required: true,
  message: '请填写此项内容',
  trigger: 'blur'
}
export const email = {
  type: 'email',
  message: '请输入正确的邮箱地址',
  trigger: 'blur'
}
export const phone = {
  pattern: /^(13[0-9]|14[01456879]|15[0-3,5-9]|16[2567]|17[0-8]|18[0-9]|19[0-3,5-9])\d{8}$/,
  message: '请输入正确的手机号',
  trigger: 'blur'
}
export function len(max = 255, min = 0) {
  return {
    min,
    max,
    message: `长度在 ${min} 到 ${max} 个字符`,
    trigger: 'blur'
  }
}
export function len1(min = 6, max = 6) {
  return {
    min,
    max,
    message: `长度只能为${max}个字符`,
    trigger: 'blur'
  }
}

export const date = {
  type: 'date',
  message: '请选择日期',
  trigger: 'blur'
}

export const integer = {
  pattern: /^(\-|\+)?\d+?$/,
  message: '请输入正确的数字',
  trigger: 'blur'
}
export const Chinese = {
  // 正则匹配非中英文及数字的字符
  pattern: /[\u4e00-\u9fa5]/,
  message: '请输入汉字',
  trigger: 'blur'
}
