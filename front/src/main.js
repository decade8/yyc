import Vue from 'vue'
import App from './App.vue'
//导入组件库
import ElementUI from 'element-ui'
//导入组件相关样式
import 'element-ui/lib/theme-chalk/index.css'
//配置Vue插件 将El安装到Vue上
Vue.use(ElementUI)
import router from './router/index'
// 引入bootstrap弹框
import 'bootstrap/dist/css/bootstrap.css'


Vue.config.productionTip = false

new Vue({
  render: h => h(App),
  router: router,
}).$mount('#app')

