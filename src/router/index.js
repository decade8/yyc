import Vue from 'vue'
import VueRouter from 'vue-router'
import Login from '@/views/login/index.vue'
import Layout from '@/views/layout/index.vue'
import Search from '@/views/search/index.vue'
import Searchlist from '@/views/search/list.vue'
import Prodetail from '@/views/prodetail/index.vue'
import Pay from '@/views/pay/index.vue'
import Myorder from '@/views/myorder/index.vue'
import User from '@/views/layout/user.vue'
import Cart from '@/views/layout/cart.vue'
import Category from '@/views/layout/category.vue'
import Home from '@/views/layout/home.vue'
import store from '@/store'

Vue.use(VueRouter)

// const routes = [
//   {
//     path: '/',
//     name: 'home',
//     component: HomeView
//   },
//   {
//     path: '/about',
//     name: 'about',
//     // route level code-splitting
//     // this generates a separate chunk (about.[hash].js) for this route
//     // which is lazy-loaded when the route is visited.
//     component: () => import(/* webpackChunkName: "about" */ '../views/AboutView.vue')
//   }
// ]

const router = new VueRouter({
  routes: [
    { path: '/login', component: Login },
    {
      path: '/',
      component: Layout,
      redirect: '/home',
      children: [
        { path: '/home', component: Home },
        { path: '/category', component: Category },
        { path: '/cart', component: Cart },
        { path: '/user', component: User }

      ]
    },
    { path: '/search', component: Search },
    { path: '/searchlist', component: Searchlist },
    // id确认哪一个商品
    { path: '/prodetail/:id', component: Prodetail },
    { path: '/pay', component: Pay },
    { path: '/myorder', component: Myorder }

  ]
})

// 全局前置导航守卫，所有路径访问之前，都会先经过全局前置守卫
// to到哪去  from从哪来 next是否放行
// 1.next（）放行到to去的路径 2.next（路径）进行拦截，拦截到next里面的路径
// 设置哪些是权限页面
const authUrl = ['/pay', '/myorder']
router.beforeEach((to, from, next) => {
  const token = store.getters.token
  // 如果跳转的路由不包需要权限的页面，则直接允许通过，next（）
  if (!authUrl.includes(to.path)) {
    next()
    return
  }
  // 进入到权限页面，判断用户是否有token
  if (token) {
    next()
  } else {
    // 如果没有权限，则跳转到登录页面
    next('/login')
  }
})

export default router
