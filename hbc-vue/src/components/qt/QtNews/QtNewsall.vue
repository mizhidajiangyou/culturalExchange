<template>
<div class="newsall">

  <!-- 内容 -->
  <div class="newsall-main">

    <h1 class="newsall-title">{{news.newstitle}}</h1>
    <!--资讯时间-->
    <div class="newsall-ftime">
      <span >发布时间:{{news.newsftime}}</span>
    </div>
    <!--简介-->
    <div class="newsall-jj">{{news.newsjj}}</div>
   <!-- 关键词-->
    <div class="newsall-keyword">
      关键词:&nbsp;&nbsp;<a class="keyword">{{news.newskeyword}}</a>
    </div>
    <div class="clear"> </div>
    <!-- 图片-->
    <div class="newsall-img1"><img :src=news.newsimg1 width="500px" height="300px" alt=""></div>

    <!--详情-->
    <div class="newsall-all">
      <p class="newsall-all-p" v-html="news.newsall"> </p>
    </div>

    <!--其他-->
    <div class="newsall-other" v-show="noother=false">{{news.newsother}}</div>

    <div class="newsall-yd">
      <strong>更多精彩资讯，欢迎关注杭帮菜文化交流网 <a class="newsall-yd-a" href="/" target="_blank">&nbsp;&nbsp;www.whjlw.com</a></strong>
    </div>

    <div class="show_adtxt clearfix">
      <p><span class="sm">免责声明：</span>本文仅代表作者个人观点，与杭帮菜文化交流网无关。其原创性以及文中陈述文字和内容未经本站证实，对本文以及其中全部或者部分内容、文字的真实性、完整性、及时性本站不作任何保证或承诺，请读者仅作参考，并请自行核实相关内容。</p>
      <div class="clear"></div>
    </div>

  </div>

  <!--<p><img :src=news.newsimg1 width="300" height="120" alt=""></p>
  <p><img :src=news.newsimg2 width="300" height="120" alt=""></p>-->


</div>

</template>

<script>
    export default {
        name: "QtNewsall",
      data(){
          return{
            news:{
              newsid: '',
              newstitle:'',
              newsimg1:'',
              newsimg2:'',
              newsjj:'',
              newsall:'',
              newskeyword:'',
              newsother:'',
              newsgood:'',
              newsftime:'',
            }
          }
      },
      mounted: function () {
        //this.nid=this.$route.query.newsid,
        this.loadNews()
      },

      methods:{
        loadNews () {
          var _this=this;
          this.$axios
            .get('/findnewsforid',{
              params: {
                newsid:this.$route.query.newsid,
              }})
            .then(resp => {
              if (resp && resp.status === 200) {
                _this.news = resp.data;
                _this.news.newsall='<p>' + resp.data.newsall.replace(/\n*$/g, '').replace(/\n/g, '</p> <p>') + '</p>'
              }
            })
        },
        /*loadNews (nid) {
          this.$http.get('http://localhost:8443/api/findnewsforid',{newsid:3})

        },*/

        /*alerttt(){
          alert(this.nid)
        }*/
      },

    }
</script>

<style scoped>
  /*最外层*/
  .newsall{
    margin: 20px;
    border-top-color: #aa0000;
    border-top-width: 3px;
    border-top-style: solid;
    /*border-left: 1px solid #666666;
    border-right:1px solid #666666;*/
  }

  .newsall-main{
    padding: 10px 15px 5px;
  }
  .newsall-title{
    min-width: 20px;
    text-align: center;
    color: rgb(0, 0, 0);
    line-height: 35px;
    overflow: hidden;
    /*font-family: "Microsoft Yahei","微软雅黑", "黑体";*/
    font-size: 28px;
    font-weight: normal;
  }
  .newsall-ftime{
    padding: 10px 0px;
    text-align: center;
    color: rgb(153, 153, 153);
    border-bottom-color: rgb(204, 204, 204);
    border-bottom-width: 1px;
    border-bottom-style: solid;
    position: relative;
    font:  15px "Microsoft YaHei", "微软雅黑", "宋体", "黑体";
  }
  .newsall-jj{
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
  .newsall-keyword{
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
  .keyword{
    COLOR: #FF0000;
    MARGIN-right: 10px;
    font: 700 19px "Microsoft YaHei", "微软雅黑", "宋体", "黑体";
  }
  .newsall-img1{
    float: left;
   /* padding: 15px 5px 20px 20px;*/
    margin: 20px 15px 3px 15px ;
  }
  .newsall-all{
    min-height: 1000px;
  }
  p{
    margin: 0 20px;
  }
  .newsall-all-p{
    margin: 20px;
    font-size:18px;
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
  strong{
    font-weight: normal;
    color: #999;
    font-size: 16px;
  }
  .newsall-yd-a{
    text-decoration: none;
    outline: none;
    color: #222222;
    font-size: 17px;
  }

</style>
