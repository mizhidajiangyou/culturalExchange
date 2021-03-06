import Vue from 'vue'
import Vuex from 'vuex'

Vue.use(Vuex)

export default new Vuex.Store({
  //全局状态
  state: {
    user: {
      /*name: window.localStorage.getItem('user') == null ? '未登录' : JSON.parse(window.localStorage.getItem('user' || '[]')).name,*/
      username: window.localStorage.getItem('user') == null ? '' : JSON.parse(window.localStorage.getItem('user' || '[]')).username
    },
    adminMenus: []
  },
  mutations: {
    initAdminMenu (state, menus) {
      state.adminMenus = menus
    },
    login (state, data) {
      state.user = data;
      window.localStorage.setItem('user', JSON.stringify(data))
    },
    logout (state) {
      // 注意不能用 null 清除，否则将无法判断 user 里具体的内容
      state.user = [];
      window.localStorage.removeItem('user');
      state.adminMenus = []
    }
  },
  //业务逻辑
  actions: {
  },
  //辅助方法
  getters:{
  },
})
