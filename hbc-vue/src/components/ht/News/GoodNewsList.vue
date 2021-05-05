<template>
  <div class="newslistdiv">
    <div>
      <AddNews class="a1" @addnews="loadNews()"/>
      <!--<span class="a3">新闻列表</span>-->
      <search-news class="a2" @onSearch="searchResult" ref="searchBar"/>
    </div>

    <el-row style="height: 840px;">
      <span v-show="nonews">搜索结果为空</span>
      <el-tooltip effect="dark" placement="right"
                  v-for="item in news.slice((currentPage-1)*pagesize,currentPage*pagesize)"
                  :key="item.newsid">
        <p slot="content" style="font-size: 14px;margin-bottom: 6px;">Id:{{item.newsid}}</p>
        <div class="news-id-title">
          <ul class="list">
            <li>
              <a>{{item.newstitle}}</a>
              <i class="el-icon-delete" v-on:click="deleteNews(item.newsid)"/>
              <i class="el-icon-edit" @click="editNews(item)" ref="editnews"/>

            </li>
          </ul>

        </div>
      </el-tooltip>
      <edit-news @addnews="loadNews()"  ref="test111"/>

    </el-row>
    <el-row>
      <el-pagination
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-size="pagesize"
        :total="news.length">
      </el-pagination>
    </el-row>

  </div>
</template>

<script>
  import AddNews from "./AddNews";
  import EditNews from "./EditNews";
  import SearchNews from "./SearchNews";
  /* import SearchBar from './SearchBar'*/
  export default {
    name: 'GoodNewsList',
    components: {SearchNews, EditNews, AddNews},
    data () {
      return {
        news: [
        ],
        currentPage: 1,
        pagesize: 15,
        nonews:false,
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
        this.$axios.get('/newsgoodall').then(resp => {
          if (resp && resp.status === 200) {
            _this.news = resp.data;
          }
        })

      },

      /* 搜索函数*/
      searchResult () {
        var _this = this;
        this.$axios
          .get('/newssearch?keywords=' + this.$refs.searchBar.keywords, {
          }).then(resp => {
          if (resp && resp.status === 200) {
            _this.news = resp.data
          }
        });
        /*if (_this.news.length==0){
          alert("搜索结果为空")
        };
        if (_this.news.length==0){
          this.nonews=true
        }*/
      },


      handleCurrentChange: function (currentPage) {
        this.currentPage = currentPage
        console.log(this.currentPage)
      },
      /* deleteNews (id) {
          this.$confirm('此操作将永久删除该资讯, 是否继续?', '提示', {
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
              this.$axios
                .post('/deletenews', {newsid:newsid})
                .then(resp => {
                if (resp && resp.status === 200) {
                  this.loadNews();
                }
              })
            }
          ).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消删除'
            })
          })
          // alert(id)
        },*/
      deleteNews (newsid){
        this.$axios
          .post('/deletenews', {newsid:newsid})
          .then(this.loadNews)
      },

      editNews (item) {
        this.$refs.test111.dialogFormVisible = true
        this.$refs.test111.Addnewsfrom= {
          newsid: item.newsid,
          newstitle:item.newstitle,
          newsimg1:item.newsimg1,
          newsimg2:item.newsimg2,
          newsjj:item.newsjj,
          newsall:item.newsall,
          newskeyword:item.newskeyword,
          newsother:item.newsother,
          newsgood:item.newsgood,
           newsftime:item.newsftime,
           newsltime:item.newsltime,
        };
        if(item.newsgood===0){
          this.$refs.test111.thegood=false;
          this.$refs.test111.thegoodimg=false;
        }else {
          this.$refs.test111.thegood=true;
          this.$refs.test111.thegoodimg=true;
        }

      }
    }
  }
</script>
<style scoped>

  .cover {
    width: 115px;
    height: 172px;
    margin-bottom: 7px;
    overflow: hidden;
    cursor: pointer;
  }

  img {
    width: 115px;
    height: 172px;
    /*margin: 0 auto;*/
  }

  .title {
    font-size: 14px;
    text-align: left;
  }

  .author {
    color: #333;
    width: 102px;
    font-size: 13px;
    margin-bottom: 6px;
    text-align: left;
  }

  .abstract {
    display: block;
    line-height: 17px;
  }

  .el-icon-delete {
    cursor: pointer;
    float: right;
  }

  .switch {
    display: flex;
    position: absolute;
    left: 780px;
    top: 25px;
  }

  a {
    text-decoration: none;
  }

  a:link, a:visited, a:focus {
    color: #3377aa;
  }

  ul {
    display: block;
    list-style-type: disc;
    margin-block-start: 1em;
    margin-block-end: 1em;
    margin-inline-start: 0px;
    margin-inline-end: 0px;
    padding-inline-start: 40px;
    text-align: left;
    font-size: 24px;
  }
  /*li {
    list-style-type: none;
  }*/
  .newslistdiv {
    /*多个空格*/
    white-space: pre;
    width: 100%;
    float: left;
    padding-top: 0px;
  }
  .edit{
    /*text-align: right;*/
    float: right;
    margin-right: auto;
    font-size: 18px;
    height: auto;
    width: auto;
  }
  .del{

    float: right;
    margin-right: auto;
    font-size: 18px;
    height: auto;
    width: auto;
  }
  .el-icon-delete{
    float: right;
    margin-right: auto;

  }
  .el-icon-edit{
    float: right;
    margin-right: auto;

  }
  .a1{
    float: left;
    width:100px;
    height:20px
  }
  .a2{
    float: right;
    width:auto;
    height:20px
  }
  .a3{
    width:auto;
    height:20px
  }

</style>

