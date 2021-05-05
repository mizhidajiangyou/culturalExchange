<template>
  <div>

    <div class="feedbacklistdiv">

      <search-news style="position: absolute;right:10px;top: -40px"/>
      <div class="list-all">
        <div effect="dark" placement="right"
             v-for="item in feedback.slice((currentPage-1)*pagesize,currentPage*pagesize)"
             :key="item.feedbackid">
          <!--<p slot="content" style="font-size: 14px;margin-bottom: 6px;">Id:{{item.feedbackid}}</p>-->
          <div class="feedback-list" @click="feedback_luyou(item.feedbackid)">
            <ul class="list">

              <h3 class="list-title">{{item.feedbacktitle}}</h3>
              <p class="list-jj">
                <span class="list-time">{{item.feedbackftime}}&nbsp;-&nbsp;</span>
                {{item.feedbackall}}
              </p>

            </ul>
          </div>
        </div>
      </div>

      <div class="ym">
        <el-pagination
          @current-change="handleCurrentChange"
          :current-page="currentPage"
          :page-size="pagesize"
          :total="feedback.length">
        </el-pagination>
      </div>


    </div>
  </div>

</template>

<script>
 /* import Searchfeedback from "../../ht/feedback/Searchfeedback";*/
  import SearchNews from "../../ht/News/SearchNews";
 export default {
    name: "QtFeedbacklist",
   components: {SearchNews},
   /* components: {Searchfeedback},*/
    data () {
      return {
        feedback: [],
        currentPage: 1,
        pagesize:  10,


      }
    },
    /* 钩子函数*/
    mounted: function () {
      this.loadfeedback()
    },
    /* 很简单，就是利用 axios 发送了一个 get 请求，在接受到后端返回的成功代码后把
     data 里的数据替换为后端返回的数据。利用 data 和 template 里相应元素的双向绑定，实现页面的动态渲染。*/
    methods: {
      loadfeedback () {
        var _this = this;
        this.$axios.get('/feedbackall').then(resp => {
          if (resp && resp.status === 200) {
            _this.feedback = resp.data;
          }
        })
      },

      handleCurrentChange: function (currentPage) {
        this.currentPage = currentPage
        console.log(this.currentPage)
      },
      feedback_luyou:function(feedbackid){

        /* this.$router.push({ name:'qtfeedbackall', params:{feedbackid:feedbackid}});//如果用params 应用name*/
        this.$router.push({ path:'/qtfeedback/qtfeedbackall', query:{feedbackid:feedbackid}}); //如果用query  就用path
      }
    }
  }
</script>
<style scoped>
  .feedbacklistdiv{
   position: relative;
  }
  .onefeedback{
    border-top: #999999;
  }
  .list-all{
    min-height:1000px;
    height:auto;
    /*width: 800px;*/
    margin: 10px;
    border-bottom:1px solid #e6e6e6 ;
    box-shadow:0px 0px 3px rgba(0, 0, 0, 0.2);
  }
  .feedback-list{
    border-top: 1px solid #e6e6e6;
    font-size: 14px;
    /* margin: 10px;*/
    /*box-shadow:0px 0px 1px rgba(0, 0, 0, 0.2);*/
  }
  .list{
    position: relative;
    height: 80px;
  }
  li{
    list-style: none;
  }
  img{
    width:100%;
    height:100%;
  }

  .list-img{
    height: 80px;
    width: 120px;
    position: absolute;
    left: 5px;
    /* top: 10px;*/
    /*bottom: 10px;*/

  }
  .list-title{
    position: absolute;
    left: 20px;
    float: left;
    min-width: 20px;
    height: 40px;
    top:-10px;

    overflow: hidden;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    white-space: nowrap; /*强制不换行*/
  }
  .list-time{
    color: #666;
  }
  .list-jj{
    color: #222222;
    position: absolute;
    left: 20px;
    right: 40px;
    /*loat: left;*/
    width: auto;
    height: 39px;
    top:15px;

    /*line-clamp:2;*/
    -webkit-line-clamp: 2;
    overflow: hidden;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    white-space: normal;
    text-align: left;


  }
  /* .list-suolue{
     position: absolute;
     left: 250px;
   }*/







</style>

