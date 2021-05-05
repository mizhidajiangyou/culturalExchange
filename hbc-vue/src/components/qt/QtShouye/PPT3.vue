<template>
  <div id="ups-banner" class="toplunbo">
    <div class="swiper-container" ref="top">
      <div class="swiper-wrapper">
        <div class="swiper-slide">
          <div class="img-fix"><div class="img-inner"><a href="https://www.baidu.com"> <img src="../../../assets/top_1.jpg"  alt="" class="imga"></a></div></div>
        </div>
        <div class="swiper-slide">
          <div class="img-fix"><div class="img-inner"><a href="https://www.baidu.com"><img src="../../../assets/top_2.jpg" class="imga"></a></div></div>
        </div>
        <div class="swiper-slide">
          <div class="img-fix"><div class="img-inner"><a href="https://www.baidu.com"><img src="../../../assets/222.jpg" class="img"></a></div></div>
        </div>
      </div>
      <div class="bottom-nav"><div class="ups-icon-videoplay"></div><div class="swiper-pagination"></div></div>
      <!--<div class="swiper-button-next"></div>
      <div class="swiper-button-prev"></div>-->
    </div>
  </div>
</template>

<script>
  import Swiper from "swiper";

  export default {
    name: "PPT3",
    mounted: function () {
      this.swiper()
    },
    methods:{
      swiper(){
        var upsSwiper = new Swiper(this.$refs.top,  {
          speed: 1000,
          longSwipes: false,
          loop: true,
          autoplay: {
            disableOnInteraction: false,
          },
          navigation: {
            nextEl: '.toplunbo .swiper-button-next',
            prevEl: '.toplunbo .swiper-button-prev',
          },
          pagination: {
            el: '.toplunbo .swiper-pagination',
            clickable: true,
          },
          on: {
            autoplayStop: function() {
              this.$el.find(".ups-icon-videoplay").addClass('stop-status');
            },
            autoplayStart: function() {
              this.$el.find(".ups-icon-videoplay").removeClass('stop-status');
            },
          }
        });
        upsSwiper.$el.find(".ups-icon-videoplay").on('click', function() {
          if (upsSwiper.autoplay.running) {
            upsSwiper.autoplay.stop();
          } else {
            upsSwiper.autoplay.start();
          }
        });

       /* swiperHeight = upsSwiper.height;

        window.onscroll = function scroll() {
          if (window.pageYOffset / upsSwiper.height < 1) {
            scrollScale = window.pageYOffset / swiperHeight;
          } else {
            scrollScale = 1;
          }

          /!*upsSwiper.slides.find(".img").transform('translateY(-' + 18 * scrollScale + '%)')*!/ //滚动一屏swiper高度则图片向上18%（范围0-40）

        }
*/
      }
    }
  }
</script>

<style scoped>
  #ups-banner {
    /*background: #bebebe;*/

    float: top;
    height: 100%;
  }

  .swiper-container {
    width: 100%;
    max-width:3000px;
    /*margin: 0 auto;*/
  }

  .swiper-slide {
    position: relative;
  }

.imga{
  position: absolute;
  top:800px
}




  .img-fix {
    margin-top: -40%; //图片大小
    /*margin-left: -25%;*/
    /*margin: auto;*/
    /* overflow 属性规定当内容溢出元素框时发生的事情。*/
    overflow: hidden;

  }
  /*图片位置*/
  .img-inner {
    transform: translateY(25%);
    height: 100%;
    width: 100%;
    display: block;
    margin: auto;
  }

  .swiper-container img {
    width: 100%;
    display: block;
  }



  .bottom-nav {
    width: 100%;
    text-align: center;
    position: absolute;
    bottom: 30px;
    z-index: 10;
  }

  .ups-icon-videoplay {
    display: inline-block;
    vertical-align: middle;
    margin-right: 15px;
    cursor: pointer;
  }

  .ups-icon-videoplay:before {
    font-family: "upsicons";
    content: "\e680";
    font-size: 28px;
    color: white;
  }


  .swiper-pagination {
    position: relative;
    display: inline-block;
    height: 29px;
    vertical-align: middle;
  }

  .stop-status.ups-icon-videoplay:before {
    content: "\e681";
  }
  .ups-icon-videoplay {
    margin-right: 10px;
  }


  @media (max-width: 767px){
    .swiper-button-prev:before {
      content: '\e627';
    }

    .swiper-button-next:before {
      content: '\e629';
    }
    .swiper-button-next,.swiper-button-prev {
      bottom: 10px;
    }
    .swiper-button-next:before,.swiper-button-prev:before {
      font-size: 32px;
    }
    .bottom-nav {
      bottom: 10px;
    }
    #ups-banner .swiper-pagination-bullet {
      width: 12px;
      height: 12px;
      border-width: 2px;
      margin:0 10px;
    }
    .ups-icon-videoplay {
      margin-right: 10px;
    }
  }

</style>
