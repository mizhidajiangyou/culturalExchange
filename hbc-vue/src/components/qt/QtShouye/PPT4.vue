<template>
  <div className="swiper-container">
    <div className="swiper-wrapper">
      <div className="swiper-slide"><img src="../../../assets/222.jpg" width="300">Slide 1</div>
      <div className="swiper-slide"><img src="../../../assets/123.png" width="300">Slide 2</div>
    </div>
    <!--&lt;!&ndash; 如果需要分页器 &ndash;&gt;
    <div class="swiper-pagination"></div>
    &lt;!&ndash; 如果需要导航按钮 &ndash;&gt;
    <div class="swiper-button-prev"></div>
    <div class="swiper-button-next"></div>
    &lt;!&ndash; 如果需要滚动条 &ndash;&gt;
    <div class="swiper-scrollbar"></div>-->
  </div>
</template>

<script>
  import Swiper from 'swiper';
  import 'swiper/css/swiper.min.css';

  export default {
    name: "PPT4",
    mounted: function () {
      this.swiper()
    },
    methods: {
      swiper() {
        var mySwiper = new Swiper('.swiper-container', {})
      }
    }
  }
</script>

<style scoped>
  .swiper-container {
    width: 600px;
    height: 300px;
  }
</style>
