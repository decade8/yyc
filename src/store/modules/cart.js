import { changeCount, getCartList, delSelect } from "@/api/cart"
import { Toast } from "vant"
export default {
  namespaced: true,
  state() {
    return {
      // 购物车列表，里面包含商品对象
      cartList: []
    }
  },
  mutations: {
    //提供一个设置cartlist的mutation
    setCartList(state, newList) {
      state.cartList = newList
    },

    // 切换选中状态
    toggleCheck(state, goodsId) {
      //让对应id的项ischecked取反

      const goods = state.cartList.find(item => item.goods_id === goodsId)
      goods.isChecked = !goods.isChecked

    },
    toggleAllCheck(state, flag) {
      //让所有的小选框同步设置 
      state.cartList.forEach(item => {
        item.isChecked = flag
      })
    },
    changeCount(state, { goodsId, goodsNum }) {
      const obj = state.cartList.find(item => item.goods_id === goodsId)
      obj.goods_num = goodsNum
    }

  },
  actions: {

    // 将异步请求商品数据函数放在actions
    async getCartAction(context) {
      const { data } = await getCartList()

      // 后台返回的数据中，不包含复选框的状态，为了实现以后的功能
      //需要手动维护数据，给每一项添加一个ischecked状态
      data.list.forEach(item => {
        item.isChecked = true
      });

      console.log(data);
      context.commit('setCartList', data.list)

    },

    //请求更新购物车
    async changeCountAction(context, obj) {
      const { goodsNum, goodsId, goodsSkuId } = obj
      // 先本地修改，然后再同步到后台
      context.commit('changeCount', {
        goodsId,
        goodsNum
      })
      const res = await changeCount(goodsId, goodsNum, goodsSkuId)
      console.log(res);
    },

    // 删除购物车数据
    async delSelect(context) {
      const selCartList = context.getters.selCartList
      const cartIds = selCartList.map(item => item.id)
      await delSelect(cartIds)
      Toast('删除成功')

      // 重新拉取最新的购物车数据 (重新渲染)
      context.dispatch('getCartAction')
    }



  },
  getters: {

    //求所有商品累加总数
    cartTotal(state) {
      return state.cartList.reduce((sum, item) => sum + item.goods_num, 0)

    },
    //  选中的商品项
    selCartList(state) {
      return state.cartList.filter(item => item.isChecked)
    },

    //选中的总数
    selCount(state, getters) {
      return getters.selCartList.reduce((sum, item) => sum + item.goods_num, 0)
    },

    //选中的总价
    selPrice(state, getters) {
      return getters.selCartList.reduce((sum, item) => {
        return sum + item.goods_num * item.goods.goods_price_min
      }, 0).toFixed(2)
    },

    // 是否全选
    isAllChecked(state) {
      return state.cartList.every(item => item.isChecked)
    }

  }
}