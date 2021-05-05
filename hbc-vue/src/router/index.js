import Vue from 'vue'
import Router from 'vue-router'
// 导入刚才编写的组件
//import AppIndex from '@/components/directory/AppIndex'
//import Appindex from "../components/directory/Appindex";
//import Login from '@/components/Login'
import Login from "../components/Login";
import Home from "../components/ht/Home";
import HtIndex from "../components/ht/HtIndex";
import NewsGL from "../components/ht/NewsGL";
import AddNews from "../components/ht/News/AddNews";
import QtHome from "../components/qt/QtHome";
import  other from  "../components/ht/News/test";
import QtIndex from "../components/qt/QtShouye/QtIndex";
import QtNews from "../components/qt/QtNews/QtNews";
import QtNewsall from "../components/qt/QtNews/QtNewsall";
import PPT3 from "../components/qt/QtShouye/PPT3";
import NewsList from "../components/ht/News/NewsList"
import GoodNewsList from "../components/ht/News/GoodNewsList"
import FoodsGL from "../components/ht/FoodsGL";
import FoodsList from "../components/ht/Foods/HtFoodsList";
import FeedbackGL from "../components/ht/FeedbackGL";
import QtFoods from "../components/qt/QtFoods/QtFoods";
import QtFoodsall from "../components/qt/QtFoods/QtFoodsall";
import UserGL from "../components/ht/UserGL"
import QtFeedback from "../components/qt/QtFeedback/QtFeedback"
import QtFeedbackall from "../components/qt/QtFeedback/QtFeedbackall"
import zTest from "../components/zTest"

Vue.use(Router);

export default new Router({
  mode:'history',
  routes: [
    // 下面都是固定的写法
    {
      path: '/login',
      name: 'Login',
      component: Login
    },
    {
      path:'/home',
      name:'Home',
      component:Home,
      redirect:'/htindex',
      meta:{requireAuth:true},
      children:[
        {
          path:'/htindex',
          name:'HtIndex',
          component:HtIndex,
          meta:{requireAuth:true},
        },
        {
          path:'/other',
          name:'other',
          component:other,
          meta:{requireAuth:true},
        },
        /**
         * 资讯管理路由
         */
        {
          path:'/newsgl',
          name:'NewsGL',
          component:NewsGL,
          redirect:'/newslist',
          meta:{requireAuth:true},
          children:[
            {
              path: '/newslist',
              name: 'NewsList',
              component: NewsList,
              meta:{requireAuth:true},
            },
            {
              path: '/goodnewslist',
              name: 'GoodNewsList',
              component: GoodNewsList,
              meta:{requireAuth:true},
            }
          ]
        },
        /**
         * 菜品管理路由
         */
        {
          path:'/foodsgl',
          name:'FoodsGL',
          component:FoodsGL,
          redirect:'/foodslist',
          meta:{
            requireAuth:false
          },
          children:[
            {
              path: '/foodslist',
              name: 'FoodsList',
              component: FoodsList,
              meta: {
                requireAuth: false
              }
            },
            {
              path: '/goodnewslistgl',
              name: 'GoodNewsListGL',
              component: GoodNewsList,
              meta: {
                requireAuth: false
              },
            }
          ]
        },
        /**
         * 反馈管理路由
         */
        {
          path:'/feedbackgl',
          name:'FeedbackGL',
          component:FeedbackGL,
        },
        /**
         * 用户管理路由
         */
        {
          path:'/usergl',
          name:'UserGL',
          component:UserGL,
          meta:{requireAuth:true},
        },


      ]
    },
    /**
     * 前台路由管理
     */
    {
      path:'/qthome',
      name:'QtHome',
      component:QtHome,
      redirect:'/qtindex',
      children:[
        {
          path: '/qtindex',
          name: 'QtIndex',
          component: QtIndex,
        },
        {
          path: '/qtnews',
          name: 'QtNews',
          component: QtNews,
        },
        {
          path: '/qtnews/qtnewsall',
          name: 'QtNewsall',
          component:QtNewsall,
        },
        {
          path: '/qtfoods',
          name: 'QtFoods',
          component: QtFoods,
        },
        {
          path: '/qtfoods/qtfoodsall',
          name: 'QtFoodsall',
          component:QtFoodsall,
        },
        {
          path:'/qtfeedback',
          name:'QtFeedback',
          component:QtFeedback,
        },
        {
          path:'/qtfeedback/qtfeedbackall',
          name:'QtFeedbackall',
          component:QtFeedbackall,
        }


      ]
    },
    {
      path: '/ppt',
      name: 'PPT3',
      component: PPT3,
    },
    {
      path: '/ztest',
      name: 'zTest',
      component: zTest,
    }





  ]
})

