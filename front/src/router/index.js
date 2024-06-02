//路由插件，导入自定义组件

import VueRouter from 'vue-router'
import Login from '@/components/Login'
import maintry from '@/views/maintry'
import homepage from '@/views/homePage.vue'
import writer from '@/views/writer.vue'
import user from '@/views/user.vue'
import addScore from '@/views/addScore'
import deleteScore from '@/views/deleteScore'
import showScore from '@/views/showScore'
import updateScore from '@/views/updateScore'
import Vue from 'vue'

Vue.use(VueRouter);


// 配置路由规则
const router = new VueRouter(
  {
    routes: [
      {
        path: '/',
        redirect: '/login'
      },
      {
        path: '/login',
        name: 'Login',
        component: Login
      },
      {
        path: '/maintry',
        redirect: '/homepage',
        name: 'maintry',
        component: maintry,
        children: [{
          path: '/homepage',
          name: 'homepage',
          component: homepage
        },
        {
          path: '/writer',
          name: 'writer',
          component: writer
        },
        {
          path: '/user',
          name: 'user',
          component: user
        }
        ]
      },
      // {
      //   path: '/homepage',
      //   name: 'homepage',
      //   component: homepage
      // },
      {
        path: '/addScore',
        name: 'addScore',
        component: addScore
      },
      {
        path: '/deleteScore',
        name: 'deleteScore',
        component: deleteScore
      },
      {
        path: '/showScore',
        name: 'showScore',
        component: showScore
      },
      {
        path: '/updateScore',
        name: 'updateScore',
        component: updateScore
      }
    ]

  }
)
export default router