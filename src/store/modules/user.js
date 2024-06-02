import { getInfo, setInfo } from '@/utils/storage'
export default {
  namespaced: true,
  state() {
    return {
      // 个人权证相关
      //去本地拿数据，本地数据会给定默认值
      userInfo: getInfo()

    }
  },
  mutations: {
    setUserInfo(state, obj) {
      state.userInfo = obj
      //往本地也存一份数据
      setInfo(obj)

    }

  },
  actions: {
    logout(context) {
      //个人信息重置
      context.commit('setUserInfo', {})
      //购物车信息重置，需要跨模块调用mutations
      context.commit('cart/setCartList', [], { root: true })
    }
  },
  getters: {

  }
}