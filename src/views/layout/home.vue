<template>
  <div class="home">
      <!-- 导航条 -->
      <van-nav-bar title="智慧商城" fixed />

      <!-- 搜索框 -->
      <van-search
        readonly
        shape="round"
        background="#f1f1f2"
        :placeholder=this.placeholder
        @click="$router.push('/search')"
      />
  
      <!-- 轮播图 -->
      <van-swipe class="my-swipe" :autoplay="3000" indicator-color="white">
        <van-swipe-item  v-for="item in bannerList" :key="item.imgUrl" >
          <img :src="item.imgUrl" alt="">
        </van-swipe-item>
      </van-swipe>
  
      <!-- 导航 -->
      <van-grid column-num="5" icon-size="40">
        <van-grid-item
          v-for="item in navList" :key="item.imgUrl"
          :icon="item.imgUrl"
          text="新品首发"
          @click="$router.push('/category')"
        />
      </van-grid>
  
      <!-- 主会场 -->
      <div class="main">
        <img src="@/assets/main.png" alt="">
      </div>
  
      <!-- 猜你喜欢 -->
      <div class="guess">
        <p class="guess-title">—— 猜你喜欢 ——</p>
  
        <div class="goods-list">
          <GoodsItem v-for="item in proList"  :item="item" :key="item.goods_id"></GoodsItem>
        </div>
      </div>
  </div>
</template>

<script>
import GoodsItem from '@/components/GoodsItem'
import{getHomeData} from'@/api/home'

export default {

 name:'Home',
 data(){
  return{
    placeholder:'',
    bannerList: [],//轮播图
    navList: [],//导航栏
    proList: []//商品数据
  }

 },
 components: {
    GoodsItem
  },
  async created(){
    // 去服务器请求首页数据
     const res=await getHomeData()
     this.placeholder=res.data.pageData.items[0].params.placeholder
     this.bannerList=res.data.pageData.items[1].data
     this.navList=res.data.pageData.items[3].data
     this.proList=res.data.pageData.items[6].data
    //  console.log(this.proList);
     console.log(res);
  }
}
</script>

<style lang="less" scoped>

.home {
  padding-top: 100px;
  padding-bottom: 50px;
}


.van-nav-bar {
  z-index: 999;
  background-color: #c21401;
  ::v-deep .van-nav-bar__title {
    color: #fff;
  }
}


.van-search {
  position: fixed;
  width: 100%;
  top: 46px;
  z-index: 999;
}


.my-swipe .van-swipe-item {
  height: 185px;
  color: #fff;
  font-size: 20px;
  text-align: center;
  background-color: #39a9ed;
}
.my-swipe .van-swipe-item img {
  width: 100%;
  height: 185px;
}


.main img {
  display: block;
  width: 100%;
}


.guess .guess-title {
  height: 40px;
  line-height: 40px;
  text-align: center;
}


.goods-list {
  background-color: #f6f6f6;
}


</style>