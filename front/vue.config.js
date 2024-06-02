const { defineConfig } = require('@vue/cli-service')
module.exports = defineConfig({
  transpileDependencies: true
})
module.exports = {
  publicPath: '/',
  lintOnSave: false,
  // 代理服务器
  devServer: {
    historyApiFallback: true,
    allowedHosts: "all",
    open: true,
    port: 8080,
    proxy: {
      '/': {
        // 连接到后端的路径
        target: `http://127.0.0.1:8081/student`,
        changeOrigin: true,
        secure: false,
        ws: false,
        pathRewrite: {
          '^/': '/'
        }
      }
    }
  }
}

