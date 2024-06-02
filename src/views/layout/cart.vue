<template>
  <div class="cart">
    <van-nav-bar title="购物车" fixed />
    <div v-if="isLogin&&cartList.length>0">
    <!-- 购物车开头 -->
    <div class="cart-title">
      <span class="all">共<i>{{cartTotal}}</i>件商品</span>
      <span class="edit" @click="isEdit=!isEdit">
        <van-icon name="edit" />
        编辑
      </span>
    </div>

    <!-- 购物车列表 -->
    <div class="cart-list">
      <div class="cart-item" v-for="item in cartList" :key="item.goods_id">

        <van-checkbox :value="item.isChecked" @click="toggleCheck(item.goods_id)">
           
        </van-checkbox>
        <div class="show">
          <img :src="item.goods.goods_image" alt="">
        </div>
        <div class="info">
          <span class="tit text-ellipsis-2">{{item.goods.goods_name}}</span>
          <span class="bottom">
            <div class="price">¥ <span>{{item.goods.goods_price_min}}</span></div>
            <!-- 既希望保留原本的形参，又需要通过调用函数传参，可以用箭头函数改写 -->
            <CountBox @input="(value)=>changeCount(value,item.goods_id,item.goods_sku_id)" :value="item.goods_num"></CountBox>
          </span> 
        </div>
      </div>
    </div>
    <!-- 购物车底部 -->
    <div class="footer-fixed">
      <div  class="all-check" @click="toggleAllCheck">
        <van-checkbox  icon-size="18" :value="isAllChecked"></van-checkbox>
        全选
      </div>

      <div class="all-total">
        <div class="price">
          <span>合计：</span>
          <span>¥ <i class="totalPrice">{{selPrice}}</i></span>
        </div>
        <div v-if="!isEdit" @click="goPay" class="goPay" :class="{disabled:selCount===0}">结算({{selCount}})</div>
        <div v-else @click="handleDel" class="delete" :class="{disabled:selCount===0}">删除</div>
      </div>
    </div>
  </div>

  <div class="empty-cart" v-else>
    <img src="@/assets/nav1.png" alt="">
  <div class="tips">
    您的购物车是空的, 快去逛逛吧
  </div>
  <div class="btn" @click="$router.push('/')">去逛逛</div>
  </div>

  </div>
</template>

<script>
import { mapState } from 'vuex/dist/vuex.common';
import { mapGetters } from 'vuex/dist/vuex.common';
import CountBox from '@/components/CountBox.vue';
export default {
  name: 'CartPage',
  data(){
    return{
      isEdit:false
    }

  },
  components:{
    CountBox
  },
  computed:{
    // state和getters放在计算属性中
    ...mapState('cart',['cartList']),
    ...mapGetters('cart',['cartTotal','selCartList','selCount','selPrice']),
    ...mapGetters('cart', ['isAllChecked']),
    isLogin(){
      return this.$store.getters.token
    }
  },

  created(){
    //先判断用户是否登录过
    if(this.$store.getters.token){
      this.$store.dispatch('cart/getCartAction')
    }
  },
  methods:{
    toggleCheck(goodsId){
      //发给vuex中的mutation，请求切换选中状态
      this.$store.commit('cart/toggleCheck',goodsId)

    },
    toggleAllCheck(){
      this.$store.commit('cart/toggleAllCheck',!this.isAllChecked)
    },
    changeCount(goodsNum,goodsId,goodsSkuId){
      // console.log(goodsNum,goodsId,goodsSkuId);
      // 调用vuex的action来进行数量的修改

      this.$store.dispatch('cart/changeCountAction',{
        goodsNum,
        goodsId,
        goodsSkuId
      })
    },
    async handleDel(){
      if(this.selCount===0){
        return
      }
      await this.$store.dispatch('cart/delSelect')
      this.isEdit = false
    },
    // 购物车结算购买
    goPay () {
    if (this.selCount > 0) {
    this.$router.push({
      path: '/pay',
      query: {
        mode: 'cart',
        cartIds: this.selCartList.map(item => item.id).join(',')
      }
    })
  }
}


  },
  watch:{
    //监听编辑值的变化，如果为假则去vuex修改ischecked值
    isEdit(value){
      if(value){
        this.$store.commit('cart/toggleAllCheck',false)
      }else{
        this.$store.commit('cart/toggleAllCheck',true)
      }
    }

  }
}
</script>

<style lang="less" scoped>

.empty-cart {
  padding: 80px 30px;
  img {
    width: 140px;
    height: 92px;
    display: block;
    margin: 0 auto;
  }
  .tips {
    text-align: center;
    color: #666;
    margin: 30px;
  }
  .btn {
    width: 110px;
    height: 32px;
    line-height: 32px;
    text-align: center;
    background-color: #fa2c20;
    border-radius: 16px;
    color: #fff;
    display: block;
    margin: 0 auto;
  }
}


.cart {
  padding-top: 46px;
  padding-bottom: 100px;
  background-color: #f5f5f5;
  min-height: 100vh;
  .cart-title {
    height: 40px;
    display: flex;
    justify-content: space-between;
    align-items: center;
    padding: 0 10px;
    font-size: 14px;
    .all {
      i {
        font-style: normal;
        margin: 0 2px;
        color: #fa2209;
        font-size: 16px;
      }
    }
    .edit {
      .van-icon {
        font-size: 18px;
      }
    }
  }

  .cart-item {
    margin: 0 10px 10px 10px;
    padding: 10px;
    display: flex;
    justify-content: space-between;
    background-color: #ffffff;
    border-radius: 5px;

    .show img {
      width: 100px;
      height: 100px;
    }
    .info {
      width: 210px;
      padding: 10px 5px;
      font-size: 14px;
      display: flex;
      flex-direction: column;
      justify-content: space-between;

      .bottom {
        display: flex;
        justify-content: space-between;
        .price {
          display: flex;
          align-items: flex-end;
          color: #fa2209;
          font-size: 12px;
          span {
            font-size: 16px;
          }
        }
        .count-box {
          display: flex;
          width: 110px;
          .add,
          .minus {
            width: 30px;
            height: 30px;
            outline: none;
            border: none;
          }
          .inp {
            width: 40px;
            height: 30px;
            outline: none;
            border: none;
            background-color: #efefef;
            text-align: center;
            margin: 0 5px;
          }
        }
      }
    }
  }
}

.footer-fixed {
  position: fixed;
  left: 0;
  bottom: 50px;
  height: 50px;
  width: 100%;
  border-bottom: 1px solid #ccc;
  background-color: #fff;
  display: flex;
  justify-content: space-between;
  align-items: center;
  padding: 0 10px;

  .all-check {
    display: flex;
    align-items: center;
    .van-checkbox {
      margin-right: 5px;
    }
  }

  .all-total {
    display: flex;
    line-height: 36px;
    .price {
      font-size: 14px;
      margin-right: 10px;
      .totalPrice {
        color: #fa2209;
        font-size: 18px;
        font-style: normal;
      }
    }

    .goPay, .delete {
      min-width: 100px;
      height: 36px;
      line-height: 36px;
      text-align: center;
      background-color: #fa2f21;
      color: #fff;
      border-radius: 18px;
      &.disabled {
        background-color: #ff9779;
      }
    }
  }

}
</style>