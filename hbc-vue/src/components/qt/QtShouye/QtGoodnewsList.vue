<template>
  <div class="qtgoodnews">
    <div class="tianchong"></div>
    <div class="qtgoodnews-list"
        v-for="item in news2"
        :key="item.newsid">
        <div class="newstitle" @click="tznews(item.newsid)">
          <ul class="qtgoodnews-ul">
            <li class="qtgoodnews-li">
              <a class="qtgoodnews-a">{{item.newstitle}}</a>
              <!--<div class="xian"/>-->
            </li>
          </ul>
        </div>
      </div>
    <div class="xian"/>
    <div class="qtgoodnews-list"
         v-for="item in news3"
         :key="item.newsid">
      <div class="newstitle" @click="tznews(item.newsid)">
        <ul class="qtgoodnews-ul">
          <li class="qtgoodnews-li">
            <a class="qtgoodnews-a">{{item.newstitle}}</a>
            <!--<div class="xian"/>-->
          </li>
        </ul>
      </div>
    </div>

  </div>
</template>

<script>

  export default {
    name: 'QtGoodNewsList',
    data () {
      return {
        news2: [],
        news3: [],

        nonews:false,
      }
    },
    /* 钩子函数*/
    mounted: function () {
      this.loadNews()
    },

    methods: {
      loadNews () {
        var _this = this;
        this.$axios.get('/newstopqt').then(resp => {
          if (resp && resp.status === 200) {
            _this.news2 = resp.data;
          }
        });
        this.$axios.get('/newsbottomqt').then(resp => {
          if (resp && resp.status === 200) {
            _this.news3 = resp.data;
          }
        });
      },
      tznews(newsid){
        this.$router.push({ path:'/qtnews/qtnewsall', query:{newsid:newsid}}); //如果用query  就用path
      }


    }
  }
</script>
<style scoped>
  .qtgoodnews{
    height: 520px;
  }
  .tianchong{
    height: 5px;
    clear: both;
  }

  .xian {
    width: 100%;
    border: 1px dashed #ccc;
    margin: 10px 0 10px;

  }
  .qtgoodnews-ul{
    margin-left: 0px;
    padding: 0px;

  }

  .qtgoodnews-li{
    font-size: 18px;
    padding: 10px 0px 10px 5px;
    position: relative;
    line-height: 26px;
    white-space: nowrap;
    text-overflow: ellipsis;
    /*overflow: hidden;*/
    margin: 0px;
    list-style: none;

  }
  .qtgoodnews-li::before {
    content: "";
    width: 3px;
    height: 3px;
    background: #e9252c;
    left: 0;
    top: 22px;
    z-index: 1;
    position: absolute;
  }

  .qtgoodnews-a{
    color: #222222;
    -webkit-line-clamp: 1;
    overflow: hidden;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    white-space: normal;
    text-align: left;

  }

</style>

