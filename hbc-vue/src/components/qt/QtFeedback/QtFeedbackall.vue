<template>
  <div class="feedbackall">

    <!-- 内容 -->
    <div class="feedbackall-main">

      <h1 class="feedbackall-title">{{feedback.feedbacktitle}}</h1>
      <!--资讯时间-->
      <div class="feedbackall-ftime">
        <span >反馈时间:{{feedback.feedbackftime}}&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;当前获赞：&nbsp;{{feedback.feedbacklike}}&nbsp;&nbsp;&nbsp;&nbsp;</span>
        <i @click="good" class="el-icon-star-off" title="点赞" style="cursor: pointer" v-if="gg">点赞</i>
        <i @click="bad" class="el-icon-star-on" title="取消点赞" style="cursor: pointer" v-if="!gg">点赞</i>
      </div>
      <div class="clear"> </div>

      <div style="text-align: left;margin-top: 50px">
        <h3 style="font-weight: 600;">反馈人：&nbsp;{{feedback.feedbackauthor}}</h3>
        <span class="ac">反馈时间:&nbsp;&nbsp;{{feedback.feedbackftime}}</span>
      </div>

      <div class="feedbackall-all">
        <p class="feedbackall-all-p" v-html="feedback.feedbackall"/>
      </div>

      <div style="text-align: left">
        <h3 style="font-weight: 600">回复人：&nbsp;网站管理者A</h3>
        <span class="ac">回复时间:&nbsp;&nbsp;{{feedback.feedbackltime}}</span>
      </div>

      <div class="feedbackall-all">
        <p class="feedbackall-all-p" v-html="feedback.feedbackbackall"> </p>
      </div>




      <div class="feedbackall-yd">
        <strong>更多精彩资讯，欢迎关注杭帮菜文化交流网 <a class="feedbackall-yd-a" href="/" target="_blank">&nbsp;&nbsp;www.whjlw.com</a></strong>
      </div>

      <div class="show_adtxt clearfix">
        <p><span class="sm">免责声明：</span>本文仅代表作者个人观点，与杭帮菜文化交流网无关。其原创性以及文中陈述文字和内容未经本站证实，对本文以及其中全部或者部分内容、文字的真实性、完整性、及时性本站不作任何保证或承诺，请读者仅作参考，并请自行核实相关内容。</p>
        <div class="clear"></div>
      </div>

    </div>

    <!--<p><img :src=feedback.feedbackimg1 width="300" height="120" alt=""></p>
    <p><img :src=feedback.feedbackimg2 width="300" height="120" alt=""></p>-->


  </div>

</template>

<script>
  export default {
    name: "QtFeedbackall",
    data(){
      return{
        gg:true,
        feedback:{
          feedbackid:'',
          feedbacklike:'',
          feedbackauthor:'',
          feedbackgood:0,
          feedbacktitle:'',
          feedbackall:'',
          feedbackbackauthor:'',
          feedbackbackall:'',
          feedbackftime:'',
          feedbackltime:'',
        }
      }
    },
    mounted: function () {
      //this.nid=this.$route.query.feedbackid,
      this.loadfeedback()
    },

    methods: {
      loadfeedback() {
        var _this = this;
        this.$axios
          .get('/getfeedbackbyid', {
            params: {
              feedbackid: this.$route.query.feedbackid,
            }
          })
          .then(resp => {
            if (resp && resp.status === 200) {
              _this.feedback = resp.data;
              _this.feedback.feedbackall = '<p>' + resp.data.feedbackall.replace(/\n*$/g, '').replace(/\n/g, '</p> <p>') + '</p>'
            }
          })
      },
      good(){
        this.feedback.feedbacklike+=1;
        var _this = this;
        this.$axios
          .post('/savefeedback', {                                   //这里写的是接口url
            feedbackid:this.feedback.feedbackid,
            feedbacklike:this.feedback.feedbacklike,
            feedbackauthor:this.feedback.feedbackauthor,
            feedbackgood:this.feedback.feedbackgood,
            feedbacktitle:this.feedback.feedbacktitle,
            feedbackall:this.feedback.feedbacktitle,
            feedbackbackauthor:this.feedback.feedbackbackauthor,
            feedbackbackall:this.feedback.feedbackbackall,
            feedbackftime:this.feedback.feedbackftime,
            feedbackltime:this.feedback.feedbackltime,
          })
          .then(successResponse => {
            if (successResponse.data.code === 200) {
              alert("谢谢您的点赞");
            }
            else if (successResponse.data.code === 500) {
              alert("失败");
            }
          })
          .catch(failResponse => {
            alert("接口错误");
          });
        this.gg=!this.gg;
      },
      bad(){
        this.feedback.feedbacklike-=1;
        this.gg=!this.gg;
        alert("已取消点赞");
      }
    }

  }
</script>

<style scoped>
  .ac{
    padding-left: 5px;
    color: rgb(153, 153, 153);
    font:  15px "Microsoft YaHei", "微软雅黑", "宋体", "黑体";
  }
  /*最外层*/
  .feedbackall{
    margin: 20px;
    border-top-color: #aa0000;
    border-top-width: 3px;
    border-top-style: solid;
    /*border-left: 1px solid #666666;
    border-right:1px solid #666666;*/
  }

  .feedbackall-main{
    padding: 10px 15px 5px;
  }
  .feedbackall-title{
    min-width: 20px;
    text-align: center;
    color: rgb(0, 0, 0);
    line-height: 35px;
    overflow: hidden;
    /*font-family: "Microsoft Yahei","微软雅黑", "黑体";*/
    font-size: 28px;
    font-weight: normal;
  }
  .feedbackall-ftime{
    padding: 10px 0px;
    text-align: center;
    color: rgb(153, 153, 153);
    border-bottom-color: rgb(204, 204, 204);
    border-bottom-width: 1px;
    border-bottom-style: solid;
    position: relative;
    font:  15px "Microsoft YaHei", "微软雅黑", "宋体", "黑体";
  }
  .feedbackall-jj{
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
  .feedbackall-keyword{
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
  .feedbackall-img1{
    float: left;
    /* padding: 15px 5px 20px 20px;*/
    margin: 20px 15px 3px 15px ;
  }
  .feedbackall-all{
    min-height: 100px;
    margin-bottom: 30px;
   /* display: flex;*/
  }
  p{
    margin: 0 20px;
  }
  .feedbackall-all-p{
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
  .feedbackall-yd-a{
    text-decoration: none;
    outline: none;
    color: #222222;
    font-size: 17px;
  }

</style>
