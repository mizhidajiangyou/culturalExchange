<template>
  <div class="newslistdiv" style="position: relative">
    <search-news style="position: absolute;right: -90px;top:-8px;height:auto;width: 45%;overflow: hidden"/>
    <div class="list-all">
      <div effect="dark" placement="right"
                  v-for="item in news.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                  :key="item.newsid">
        <!--<p slot="content" style="font-size: 14px;margin-bottom: 6px;">Id:{{item.newsid}}</p>-->
        <div class="news-list" @click="news_luyou(item.newsid)">
          <ul class="list">
            <div class="list-img">
              <img :src="item.newsimg1" >
            </div>


              <h3 class="list-title">{{item.newstitle}}</h3>
              <p class="list-jj">
                <span class="list-time">{{item.newsftime}}&nbsp;-&nbsp;</span>
                {{item.newsjj}}
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
        :total="news.length">
      </el-pagination>
    </div>


  </div>
</template>

<script>
  import SearchNews from "../../ht/News/SearchNews";
  export default {
    name: 'QtNewsList',
    components: {SearchNews},
    data () {
      return {
        news: [],
        currentPage: 1,
        pagesize:  10,


      }
    },
    /* 钩子函数*/
    mounted: function () {
      this.loadNews()
    },
    /* 很简单，就是利用 axios 发送了一个 get 请求，在接受到后端返回的成功代码后把
     data 里的数据替换为后端返回的数据。利用 data 和 template 里相应元素的双向绑定，实现页面的动态渲染。*/
    methods: {
      loadNews () {
        var _this = this;
        this.$axios.get('/newsall').then(resp => {
          if (resp && resp.status === 200) {
            _this.news = resp.data;
          }
        })
      },

      handleCurrentChange: function (currentPage) {
        this.currentPage = currentPage
        console.log(this.currentPage)
      },
      news_luyou:function(newsid){

       /* this.$router.push({ name:'qtnewsall', params:{newsid:newsid}});//如果用params 应用name*/
          this.$router.push({ path:'/qtnews/qtnewsall', query:{newsid:newsid}}); //如果用query  就用path
      }
    }
  }
</script>
<style scoped>
  .onenews{
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
  .news-list{
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
    left: 150px;
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
    left: 150px;
    right: 40px;
    /*loat: left;*/
    width: auto;
    height: 40px;
    top:15px;

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

