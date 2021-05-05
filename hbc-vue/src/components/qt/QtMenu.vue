<template>
  <div>
    <!--<div v-show="true">暂无内容</div>-->
    <div class="nav">
      <div class="navall">
        <a v-for="(item,i) in qtmenu"  :key="i" @click="go(item)" ref="goto">
          {{item.navItem }}
        </a>
        <!--<a href="http://www.whjlw.com/" class="navi current">首页</a>
        <a href="http://www.whjlw.com/news/">资讯</a>
        <a href="http://www.whjlw.com/xueshu/">学术中心</a>
        <a href="http://www.whjlw.com/chanye/">产业</a>-->
        <div class="clear"></div>
      </div>
    </div>
  </div>


</template>

<script>
  export default {
    name: "QtMenu",
    data() {
      return {
        qtmenu:[
          {name: '/qtindex', navItem: '首页'},
          {name: '/qtnews', navItem: '资讯'},
          {name: '/qtfoods', navItem: '菜品'},
          {name: '/qtfeedback', navItem: '反馈'}
        ]

      }
    },
    mounted: function() {


    },

    methods: {
      go(item){
        /*this.$router.replace({path: item.name });*/
        this.$router.push({path: item.name });
      }


    }

  }
</script>

<style scoped>
  /*nav*/
  .nav {
    height: 60px;
    line-height: 60px;
    background: -webkit-linear-gradient(left, #ee3333 , #aa0000); /* Safari 5.1 - 6.0 */
    background: -o-linear-gradient(right, #ee3333 , #aa0000); /* Opera 11.1 - 12.0 */
    background: -moz-linear-gradient(right, #ee3333 , #aa0000); /* Firefox 3.6 - 15 */
    background: linear-gradient(to right, #ee3333 , #aa0000); /* 标准的语法 */
    font-size: 0;
    text-align: center;
    overflow: hidden;
    display: flex;
  }
  .navall{
    width: 100%;
    height: 100%;
    display: flex;
  }
  .nav a {
    margin-left: 40px;
    display: block;
    float: left;
    color: #ffffff;
    font-size: 20px;
    /* background: url("img-02.png") no-repeat right center;*/
   /* max-width: 22%;*/
    min-width: 22%;
    text-decoration: none;
    /*position: relative;*/
  }
  /* .nav a:last-child {
     background: none;
   }*/
  .nav a:hover, .nav a.current {
    background: #871b21;
    color: darkorange;
  }



</style>
