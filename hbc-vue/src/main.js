import Vue from 'vue'
import App from './App'
import router from './router'
import ElementUI from 'element-ui'
import store from './store';
import 'element-ui/lib/theme-chalk/index.css'
import VueResource from 'vue-resource'
import resource from "vue-resource/src/resource";
import Swiper from "swiper";
import "swiper/css/swiper.min.css";
import 'swiper/css/font.css';
import "../Reset.css"
/*import myCharts from './comm/js/myCharts.js'*/
import  echarts from 'echarts';
/*import ztxchart from '@/components/FZchart/Mychart';*/


// 设置反向代理，前端请求默认发送到 http://localhost:8443/api
var axios = require('axios');
axios.defaults.baseURL = 'http://localhost:8443/api';
// 全局注册，之后可在其他组件中通过 this.$axios 发送数据
Vue.prototype.$axios = axios;
Vue.config.productionTip = false;
Vue.prototype.$echarts=echarts;

/*Vue.use(ztxchart);*/
Vue.use(ElementUI);
Vue.use(VueResource);
/* eslint-disable no-new */

router.beforeEach((to, from, next) => {
    if (to.meta.requireAuth===true) {
      if (store.state.user.username) {
        next()
      } else {
        next({
          path: 'login',
          query: {redirect: to.fullPath}
        })
      }
    } else {
      next()
    }
  }
);

Vue.prototype.initChart=function (container,option,onclick) {
  const myChart = echarts.init(container);
  option.color=["#2AB414","#986325", "#236584", "#566843",'#dccf0f',"#b42d22"];
  myChart.setOption(option);
  if (onclick) myChart.on("click", onclick);
};






new Vue({
  el: '#app',
  render: h => h(App),
  router,
  store,
  components: { App },
  template: '<App/>'
})

