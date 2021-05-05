<template>
  <div class="good">
    <div class="swiper-container" >
      <div class="swiper-wrapper" >
        <div class="swiper-slide" v-for="item in news4" :key="item.newsid" @click="tznews(item.newsid)">
          <div class="picTitle">
            <a  :title=item.newstitle  >
              <p class="img"><img  :src=item.newsimg2 ></p>
              <p class="bg"> </p>
              <p class="name" >{{item.newstitle}}</p>
            </a>
          </div>
        </div>
      </div>

      <!-- 如果需要分页器 -->
      <div class="swiper-pagination" ></div>
      <!-- 如果需要导航按钮 -->
      <div class="swiper-button-prev" ></div>
      <div class="swiper-button-next"></div>



    </div>
  </div>

</template>

<script>
  import QtNewslistPic from "../../qt/QtNews/QtNewslist-pic";
  import Swiper from "swiper";
  export default {
    name: "QtGoodnewsLunbo",
    components: {QtNewslistPic},
    data() {
      return {
        news4:[],
        path:""
      }
    },
    mounted: function() {
      this.t2();
      this.$nextTick(() => { // 下一个UI帧再初始化swiper
        this.t1();
      });



    },
    methods: {
      t1(){
        var mySwiper = new Swiper ('.good .swiper-container', {
          direction: 'horizontal', // 垂直切换选项
          speed: 1000,
          longSwipes: false,
         /* observer:true,
          observeParents :true,   //要用vfor加这两条*/
         /* loop: true, // 循环模式选项*/
          initialSlide:0,
          observer:true,
       /*   autoplay:{
            delay:2000,
            disableOnInteraction: false,
          },*/
          // 如果需要分页器
          pagination: {
            el: '.good .swiper-pagination',
          },
          // 如果需要前进后退按钮
          navigation: {
            nextEl: '.good .swiper-button-next',
            prevEl: '.good .swiper-button-prev',
          },
          // 如果需要滚动条
          scrollbar: {
            el: '.good .swiper-scrollbar',
          },
        })
      },
      t2(){
        var _this = this;
        this.$axios.get('/newslunboqt').then(resp => {
          if (resp && resp.status === 200) {
            _this.news4 = resp.data;
          }
        });
      /*  this.$nextTick(()=>{
          this.setTimeout(function(){ this.t1();}, 2000);
        });*/
      },
      tznews(newsid){
        this.$router.push({ path:'/qtnews/qtnewsall', query:{newsid:newsid}}); //如果用query  就用path
      }
    }

  }
</script>

<style scoped>
  .swiper-container {
    width: 800px;
    height: 520px;
    position: relative;
  }


  .swiper-container img {
    width: 800px;
    height: 520px;
    /* display: block;*/
    /*object-fit: none;*/
  }
  .swiper-pagination {
    position: absolute;
    top:15px;
    padding-left: 360px;
  }


  .picTitle {
    /*position:relative;*/
  }
  .img{
  }
  .bg{
     height: 60px;
     background: #000;
     /*height: 30px;*/
     left: 0;
     bottom: -15px;
     opacity: 0.4;
     /* filter: alpha(opacity=40);*/
     position: absolute;
     width: 100%;
     /* z-index: 10;*/

   }

  .name {
    font-size: 16px;
    bottom: 0;
    color: #FFFFFF;
    height: 30px;
    left: 0;
    line-height: 30px;
    overflow: hidden;
    position: absolute;
    text-align: center;
    width: 100%;
    /* z-index: 11;*/
    white-space: nowrap;
    text-overflow: ellipsis;
    overflow: hidden;
  }
  .swiper-button-next{
    /*background: url(http://localhost:8443/api/file/ibg2a.png) center center no-repeat;*/
    opacity: .5;
    background-size: cover;

  }
  .swiper-button-prev{
    /*background: url(http://localhost:8443/api/file/ibg2.png) center center no-repeat;*/
    opacity: .5;
    background-size: cover;
    color: #FFFFFF;
  }







</style>
