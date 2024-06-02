<template>
  <div>
    <!-- 进行切换的页面，二级路由出口 -->
    <router-view></router-view>
    
    <!-- 底部导航 -->
    <van-tabbar route  v-model="active" active-color="#ee0a24" inactive-color="#000">
      <van-tabbar-item replace to="/home" icon="home-o">首页</van-tabbar-item>
      <van-tabbar-item replace to="/category" icon="apps-o">分类</van-tabbar-item>
      <van-tabbar-item replace to="/cart" icon="cart-o">购物车</van-tabbar-item>
      <van-tabbar-item replace to="/user" icon="contact-o">我的</van-tabbar-item>
    </van-tabbar>
  </div>
     
</template>

<script>
export default {
  name:'Layout',
  data() {
    return {
      active: 2
    }
  },

}
</script>

<style>

</style>