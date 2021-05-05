<template>
  <div>
   <!-- <div id="v-content" v-bind:style="{minHeight: Height+'px'}"></div>-->
    <div class="t_footer" >
      <div class="wrap">
        <div class="nav-foot">
          <a href="/about/index.html" target="_blank">关于杭帮菜文化交流网</a>
          <a href="/about/Thinktank.html" target="_blank">填充字数 </a>
          <a href="/about/xueshu.html" target="_blank">战术指导</a>
          <a href="/sitemap.html" target="_blank">百度地图</a>
          <a href="/about/copyright.html" target="_blank">版权与免责声明</a>
          <a href="/about/contact.html" target="_blank">联系我们</a>
        </div>
        <p>UI设计ztx</p>
        <p><a href="http://www.cac.gov.cn/2016-12/28/c_1120206849_4.htm" target="_blank"></a>&nbsp;框架选定ztx&nbsp;&nbsp;<a href="http://www.gov.cn/xinwen/2015-12/25/content_5027760.htm" target="_blank">前端用vue+后端用springboot</a></p>
        <p>前端代码编写ztx</p>
        <p>后台代码编写ztx</p>
        <p>接口测试ztx</p>
        <p v-on:click="gotologin">后台入口</p>
        <p>出版物经营许可证：暂时没有10000000969号</p>
        <p>Copyright © 2020-2020 <a href="/">www.whjlw.com</a>杭帮菜文化交流网 中视媒资 版权所有  <a href="http://beian.miit.gov.cn/" target="_blank">京ICP备675696325号-63</a></p>

      </div>
    </div>

  </div>
</template>

<script>
    export default {
        name: "QtYedishengming",

        methods:{
          gotologin(){
            this.$router.replace({path: '/login'})
        },
      },
      data(){
        return{
          Height: 0
        }
      },
      mounted(){
        //动态设置内容高度 让footer始终居底   header+footer的高度是100
        this.Height = document.documentElement.clientHeight - 100;
        //监听浏览器窗口变化　
        window.onresize = ()=> {this.Height = document.documentElement.clientHeight -100}
      },

    }
</script>

<style scoped>
 /* @media screen and (max-width: 767px),*/
    .t_footer {
      /*position: fixed;*/
      /*bottom:0;   */             //置于底部
      /*line-height: 26px;*/
      text-align: center;
      padding: 10px;
      margin: 0px 0 0px 0;
      border-top: 3px solid #d30b15;
      font-size: 12px;
      /*display: inline-block;*/
      /*width: auto;
      height: auto;*/
      /*float: end;*/

    }
    .wrap {
      width: 100%;
      margin: 0 auto;
    }
    .nav-foot {
      padding: 20px 0 20px;
      /*display: inline-block;*/

    }

</style>
