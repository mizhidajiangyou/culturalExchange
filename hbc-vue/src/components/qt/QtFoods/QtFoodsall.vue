<template>
  <div class="foodsall">

    <!-- 内容 -->
    <div class="foodsall-main">

      <h1 class="foodsall-title">{{foods.foodsname}}</h1>
      <!--资讯时间-->
      <div class="foodsall-ftime">
        <!--<span>发布时间:{{foods.foodsftime}}</span>-->
      </div>
      <!--简介-->
      <div class="foodsall-jj">{{foods.foodsjj}}</div>
      <!-- 关键词-->
      <div class="foodsall-keyword">
        关键词:&nbsp;&nbsp;<a class="keyword">{{foods.foodskeyword}}</a>
      </div>
      <div class="clear"></div>
      <!-- 图片-->
      <div class="foodsall-img1"><img :src=foods.foodsimg1 width="500px" height="300px" alt=""></div>

      <!--详情-->
      <div class="foodsall-all">
        <p class="foodsall-all-p" v-html="foods.foodsall"/>
      </div>
     <!-- 历史-->
      <div class="foodsall-history">
        <h2>{{foods.foodsname}}的历史:</h2>
        <p class="foodsall-all-p" v-html="foods.foodshistory"/>
      </div>
    <!--  制作过程-->
      <div class="foodsall-make">
        <h2>{{foods.foodsname}}的制作过程:</h2>
        <p class="foodsall-all-p" v-html="foods.foodsmake"/>
      </div>

      <div class="foodsall-other">
        <p><a :href=foods.foodsother>点击此处跳转相关链接</a></p>

      </div>


      <!--其他-->
      <div class="foodsall-other" v-show="noother=false">{{foods.foodsother}}</div>

      <div class="foodsall-yd">
        <strong>更多精彩资讯，欢迎关注杭帮菜文化交流网 <a class="foodsall-yd-a" href="/"
                                       target="_blank">&nbsp;&nbsp;www.whjlw.com</a></strong>
      </div>

      <div class="show_adtxt clearfix">
        <p><span class="sm">免责声明：</span>本文仅代表作者个人观点，与杭帮菜文化交流网无关。其原创性以及文中陈述文字和内容未经本站证实，对本文以及其中全部或者部分内容、文字的真实性、完整性、及时性本站不作任何保证或承诺，请读者仅作参考，并请自行核实相关内容。
        </p>
        <div class="clear"></div>
      </div>

    </div>

    <!--<p><img :src=foods.foodsimg1 width="300" height="120" alt=""></p>
    <p><img :src=foods.foodsimg2 width="300" height="120" alt=""></p>-->


  </div>

</template>

<script>
  export default {
    name: "QtFoodsall",
    data() {
      return {
        foods: {
          foodsall: '',
          foodsftime: '',
          foodsgood: '',
          foodshistory: '',
          foodsid: '',
          foodsimg1: '',
          foodsimg2: '',
          foodsjj: '',
          foodsltime: '',
          foodsmake: '',
          foodsname: '',
          foodsother:'',
        },
      }
    },
    mounted: function () {
      //this.nid=this.$route.query.foodsid,
      this.loadfoods()
    },

    methods: {
      loadfoods() {
        var _this = this;
        this.$axios
          .get('/getfoodsbyid', {
            params: {
             foodsid: this.$route.query.foodsid,
            }
          })
          .then(resp => {
            if (resp && resp.status === 200) {
              _this.foods = resp.data;
              _this.foods.foodsall = '<p>' + resp.data.foodsall.replace(/\n*$/g, '').replace(/\n/g, '</p> <p>') + '</p>'
            }
          })
      },
      /*loadfoods (nid) {
        this.$http.get('http://localhost:8443/api/findfoodsforid',{foodsid:3})

      },*/

      /*alerttt(){
        alert(this.nid)
      }*/
    },

  }
</script>

<style scoped>
  /*最外层*/
  .foodsall {
    margin: 20px;
    border-top-color: #aa0000;
    border-top-width: 3px;
    border-top-style: solid;
    /*border-left: 1px solid #666666;
    border-right:1px solid #666666;*/
  }

  .foodsall-main {
    padding: 10px 15px 5px;
  }

  .foodsall-title {
    min-width: 20px;
    text-align: center;
    color: rgb(0, 0, 0);
    line-height: 35px;
    overflow: hidden;
    /*font-family: "Microsoft Yahei","微软雅黑", "黑体";*/
    font-size: 28px;
    font-weight: normal;
  }

  .foodsall-ftime {
    padding: 10px 0px;
    text-align: center;
    color: rgb(153, 153, 153);
    border-bottom-color: rgb(204, 204, 204);
    border-bottom-width: 1px;
    border-bottom-style: solid;
    position: relative;
    font: 15px "Microsoft YaHei", "微软雅黑", "宋体", "黑体";
  }

  .foodsall-jj {
    padding: 10px 10px;
    border: 1px dotted rgb(170, 170, 170);
    border-image: none;
    color: rgb(153, 153, 153);
    text-indent: 2em;
    margin-top: 20px;
    position: relative;
    line-height: 25px;
    text-align: left;
  }

  .foodsall-keyword {
    padding: 0px 0px 10px;
    border: 0px dotted rgb(170, 170, 170);
    border-image: none;
    color: rgb(153, 153, 153);
    text-indent: 10px;
    margin-top: 20px;
    float: left;
    position: relative;
    font: 700 19px "Microsoft YaHei", "微软雅黑", "宋体", "黑体";
  }

  .keyword {
    COLOR: #FF0000;
    MARGIN-right: 10px;
    font: 700 19px "Microsoft YaHei", "微软雅黑", "宋体", "黑体";
  }

  .foodsall-img1 {
    float: left;
    /* padding: 15px 5px 20px 20px;*/
    margin: 20px 15px 3px 15px;
  }

  .foodsall-all {
    min-height: 300px;
  }

  .foodsall-history h2{
    text-align: left;
    padding-left: 18px;
    font-size: 18px;
    color: #221804;

  }
  .foodsall-make{
    min-height: 200px;
  }

  .foodsall-make h2{
    text-align: left;
    padding-left: 18px;
    font-size: 18px;
    color: #221804;
  }

  .foodsall-other p{
    text-align: center;

  }

  p {
    margin: 0 20px;
  }

  .foodsall-all-p {
    margin: 20px;
    font-size: 18px;
    text-indent: 2em;
    line-height: 30px;
    text-align: left;
  }

  .show_adtxt {
    padding: 0px 0px 0px;
    margin-top: 20px;
    border-top: 1px solid #eee;
  }

  .clear {
    clear: both;
  }

  strong {
    font-weight: normal;
    color: #999;
    font-size: 16px;
  }

  .foodsall-yd-a {
    text-decoration: none;
    outline: none;
    color: #222222;
    font-size: 17px;
  }

</style>
