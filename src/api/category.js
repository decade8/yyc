import request from '@/utils/request'

// 获取分类数据
export const getCategoryData = () => {
  return request.get('/category/list')
}

// 1. 箭头函数 基本语法
// const fn = () => {
//   console.log(123)
// }
