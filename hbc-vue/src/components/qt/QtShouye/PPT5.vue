<template>

</template>

<script>
    export default {
        name: "PPT5"
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






  .img-fix {
    margin-top: -40%;
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


  .ups-icon-videoplay {
    margin-right: 10px;
  }
</style>
