<template>
  <!--<div class="swiper-container swiper-container-horizontal">
    <div class="arrow-left8 swiper-button-prev"></div>
    <div class="arrow-right8 swiper-button-next"></div>
    <div class="swiper-wrapper" style="transform: translate3d(-3900px, 0px, 0px); transition-duration: 0ms;"><div class="swiper-slide swiper-slide-duplicate swiper-slide-duplicate-active" data-swiper-slide-index="2" style="width: 1300px;"><script src="/ad/5.js" language="javascript"></script><a href="http://www.whjlw.com/news/ydyl/" target="_blank" title="讲好中国故事，助力一带一路。" id="img"><img src="/images/adi03.jpg" border="0"></a></div>
      <div class="swiper-slide swiper-slide-duplicate-next" data-swiper-slide-index="0" style="width: 1300px;"><script src="/ad/3.js" language="javascript"></script><a href="http://www.whjlw.com" target="_blank" title="智库观中国高质量发展论坛" id="img"><img src="/uploads/2019/12/31/23-191231142410918.jpg" border="0"></a></div>
      <div class="swiper-slide swiper-slide-prev" data-swiper-slide-index="1" style="width: 1300px;"><script src="/ad/4.js" language="javascript"></script><a href="http://www.whjlw.com/news/ydyl/" target="_blank" title="第二届“一带一路”国际合作高峰论坛" id="img"><img src="/images/adi02.jpg" border="0"></a></div>
      <div class="swiper-slide swiper-slide-active" data-swiper-slide-index="2" style="width: 1300px;"><script src="/ad/5.js" language="javascript"></script><a href="http://www.whjlw.com/news/ydyl/" target="_blank" title="讲好中国故事，助力一带一路。" id="img"><img src="/images/adi03.jpg" border="0"></a></div>
      <div class="swiper-slide swiper-slide-duplicate swiper-slide-next" data-swiper-slide-index="0" style="width: 1300px;"><script src="/ad/3.js" language="javascript"></script><a href="http://www.whjlw.com" target="_blank" title="智库观中国高质量发展论坛" id="img"><img src="/uploads/2019/12/31/23-191231142410918.jpg" border="0"></a></div></div>
    <div class="swiper-pagination swiper-pagination-clickable swiper-pagination-bullets"><span class="swiper-pagination-bullet"></span><span class="swiper-pagination-bullet"></span><span class="swiper-pagination-bullet swiper-pagination-bullet-active"></span></div>
  </div>-->
  <!-- <div class="block">
     <span class="demonstration">默认 Hover 指示器触发</span>
     <el-carousel height="150px">
       <el-carousel-item v-for="item in 4" :key="item">
         <h3>{{ item }}</h3>
       </el-carousel-item>
     </el-carousel>
   </div>
   <div class="block">
     <span class="demonstration">Click 指示器触发</span>
     <el-carousel trigger="click" height="150px">
       <el-carousel-item v-for="item in 4" :key="item">
         <h3>{{ item }}</h3>
       </el-carousel-item>
     </el-carousel>
   </div>-->
  <div id="slider">
    <div class="window" @mouseover="stop" @mouseleave="play">
      <ul class="container" :style="containerStyle">
        <li>
          <img :style="{width:imgWidth+'px'}" :src="sliders[sliders.length - 1].img" alt="">
        </li>
        <li  v-for="(item, index) in sliders" :key="index">
          <img :style="{width:imgWidth+'px'}" :src="item.img" alt="">
        </li>
        <li>
          <img :style="{width:imgWidth+'px'}" :src="sliders[0].img" alt="">
        </li>
      </ul>
      <ul class="direction">
        <li class="left" @click="move(600, 1, speed)">
          <svg class="icon" width="30px" height="30.00px" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg"><path fill="#ffffff" d="M481.233 904c8.189 0 16.379-3.124 22.628-9.372 12.496-12.497 12.496-32.759 0-45.256L166.488 512l337.373-337.373c12.496-12.497 12.496-32.758 0-45.255-12.498-12.497-32.758-12.497-45.256 0l-360 360c-12.496 12.497-12.496 32.758 0 45.255l360 360c6.249 6.249 14.439 9.373 22.628 9.373z"  /></svg>
        </li>
        <li class="right" @click="move(600, -1, speed)">
          <svg class="icon" width="30px" height="30.00px" viewBox="0 0 1024 1024" version="1.1" xmlns="http://www.w3.org/2000/svg"><path fill="#ffffff" d="M557.179 904c-8.189 0-16.379-3.124-22.628-9.372-12.496-12.497-12.496-32.759 0-45.256L871.924 512 534.551 174.627c-12.496-12.497-12.496-32.758 0-45.255 12.498-12.497 32.758-12.497 45.256 0l360 360c12.496 12.497 12.496 32.758 0 45.255l-360 360c-6.249 6.249-14.439 9.373-22.628 9.373z"  /></svg>
        </li>
      </ul>
      <ul class="dots">
        <li v-for="(dot, i) in sliders" :key="i"
            :class="{dotted: i === (currentIndex-1)}"
            @click = jump(i+1)
        >
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
  export default {
    name: "PPT1",
    props: {
      initialSpeed: {
        type: Number,
        default: 30
      },
      initialInterval: {
        type: Number,
        default: 3
      },
    },
    data () {
      return {
        sliders:[
          {
            img:'../../../assets/1 (47).jpg'
          },
          {
            img:'../../../assets/1 (6).jpg'
          },
          {
            img:'../../../assets/1 (12).jpg'
          },
          {
            img:'../../../assets/1 (6).jpg'
          },
          {
            img:'../../../assets/1 (47).jpg'
          },
        ],
        imgWidth:600,
        currentIndex:1,
        distance:-600,
        transitionEnd: true,
        speed: this.initialSpeed
      }
    },
    computed:{
      containerStyle() {
        return {
          transform:`translate3d(${this.distance}px, 0, 0)`
        }
      },
      interval() {
        return this.initialInterval * 1000
      }
    },
    mounted() {
      this.init()
    },
    methods:{
      init() {
        this.play()
        window.onblur = function() { this.stop() }.bind(this)
        window.onfocus = function() { this.play() }.bind(this)
      },
      move(offset, direction, speed) {
        console.log(speed)
        if (!this.transitionEnd) return
        this.transitionEnd = false
        direction === -1 ? this.currentIndex += offset/600 : this.currentIndex -= offset/600
        if (this.currentIndex > 5) this.currentIndex = 1
        if (this.currentIndex < 1) this.currentIndex = 5

        const destination = this.distance + offset * direction
        this.animate(destination, direction, speed)
      },
      animate(des, direc, speed) {
        if (this.temp) {
          window.clearInterval(this.temp);
          this.temp = null ;
        }
        this.temp = window.setInterval(() => {
          if ((direc === -1 && des < this.distance) || (direc === 1 && des > this.distance)) {
            this.distance += speed * direc
          } else {
            this.transitionEnd = true
            window.clearInterval(this.temp)
            this.distance = des
            if (des < -3000) this.distance = -600
            if (des > -600) this.distance = -3000
          }
        }, 20)
      },
      jump(index) {
        const direction = index - this.currentIndex >= 0 ? -1 : 1;
        const offset = Math.abs(index - this.currentIndex) * 600;
        const jumpSpeed = Math.abs(index - this.currentIndex) === 0 ? this.speed : Math.abs(index - this.currentIndex) * this.speed ;
        this.move(offset, direction, jumpSpeed)
      },
      play() {
        if (this.timer) {
          window.clearInterval(this.timer)
          this.timer = null
        }
        this.timer = window.setInterval(() => {
          this.move(600, -1, this.speed)
        }, this.interval)
      },
      stop() {
        window.clearInterval(this.timer)
        this.timer = null
      }
    }
  }
</script>

<style scoped>
  .el-carousel__item h3 {
    color: #475669;
    font-size: 14px;
    opacity: 0.75;
    line-height: 150px;
    margin: 0;
  }

  .el-carousel__item:nth-child(2n) {
    background-color: #99a9bf;
  }

  .el-carousel__item:nth-child(2n+1) {
    background-color: #d3dce6;
  }

  *{
    box-sizing: border-box;
    margin:0;
    padding:0;
  }
  ol,ul{
    list-style: none;
  }
  #slider{
    text-align: center;
  }
  .window{
    position:relative;
    width:600px;
    height:400px;
    margin:0 auto;
    overflow:hidden;
  }
  .container{
    display:flex;
    position:absolute;
  }
  .left, .right{
    position:absolute;
    top:50%;
    transform:translateY(-50%);
    width:50px;
    height:50px;
    background-color:rgba(0,0,0,.3);
    border-radius:50%;
    cursor:pointer;
  }
  .left{
    left:3%;
    padding-left:12px;
    padding-top:10px;
  }
  .right{
    right:3%;
    padding-right:12px;
    padding-top:10px;
  }
  img{
    user-select: none;
  }
  .dots{
    position:absolute;
    bottom:10px;
    left:50%;
    transform:translateX(-50%);
  }
  .dots li{
    display:inline-block;
    width:15px;
    height:15px;
    margin:0 3px;
    border:1px solid white;
    border-radius:50%;
    background-color:#333;
    cursor:pointer;
  }
  .dots .dotted{
    background-color:orange;
  }

</style>
