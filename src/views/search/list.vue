<template>
  <div class="search">
    <van-nav-bar fixed title="商品列表" left-arrow @click-left="$router.go(-1)" />
    
    <!-- 如果没有传值则默认搜索商品 -->
    <van-search
      readonly
      shape="round"
      background="#ffffff"
      :value="querySearch || '搜索商品'"
      show-action
      @click="$router.push('/search')"
    >
      <template #action>
        <van-icon class="tool" name="apps-o" />
      </template>
    </van-search>

    <!-- 排序选项按钮 -->
    <div class="sort-btns">
      <div class="sort-item">综合</div>
      <div class="sort-item">销量</div>
      <div class="sort-item">价格 </div>
    </div>

    <div class="goods-list">
      <GoodsItem v-for="item in proList" :key="item.goods_id" :item="item"></GoodsItem>
    </div>
  </div>
</template>

<script> 
import GoodsItem from '@/components/GoodsItem.vue'
import {getProList} from '@/api/product'
export default {
  // name:'SearchList  ',
  components: {
    GoodsItem
  },
  computed: {

  querySearch () {
// 获取地址栏的搜索关键字
    return this.$route.query.search
  }
},
data(){
  return{
    // 页数
    page:1,
    proList:[]
  }
},
async created(){
  const { data: { list } }=await getProList({
    //调用计算属性获取路由参数
    categoryId:this.$route.query.categoryId,
    goodsName:this.querySearch,
    page:this.page
  })
  this.proList = list.data
  // console.log(res);

}

}
</script>

<style lang="less" scoped>
.search {
  padding-top: 46px;
  ::v-deep .van-icon-arrow-left {
    color: #333;
  }
  .tool {
    font-size: 24px;
    height: 40px;
    line-height: 40px;
  }

  .sort-btns {
    display: flex;
    height: 36px;
    line-height: 36px;
    .sort-item {
      text-align: center;
      flex: 1;
      font-size: 16px;
    }
  }
}

.goods-list {
  background-color: #f6f6f6;
}
</style>