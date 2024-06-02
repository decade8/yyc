const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  publicPath: './',
  transpileDependencies: true,

  lintOnSave: false
})
// module.exports = {

//   devServer: {
//     proxy: {
//       '/api': {
//         target: 'http://127.0.0.1:8182/api/',// 后端接口
//         changeOrigin: true, // 是否跨域
//         pathRewrite: {
//           '/api': ''
//         }
//       }
//     }
//   }
// }
