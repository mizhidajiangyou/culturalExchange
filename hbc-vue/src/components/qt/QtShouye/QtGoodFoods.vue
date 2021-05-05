<template>
  <div style="overflow: hidden;padding-left: 20px;display: flex"  >
    <!--<div>
      <span><li>西湖醋鱼</li></span>
    </div>-->
    <div class="goodfoodsimg">
      <a>
        <img src="../../../assets/food_1.jpg" class="img">
        <p class="bg"> </p>
        <p class="name" >西湖醋鱼</p>
      </a>
    </div>
    <div class="goodfoodsimg">
      <a>
        <img src="../../../assets/food_2.jpg" class="img">
        <p class="bg"> </p>
        <p class="name" >东坡肉</p>
      </a>
    </div>
    <div class="goodfoodsimg">
      <a>
        <img src="../../../assets/food_3.jpg" class="img">
        <p class="bg"> </p>
        <p class="name" >叫花鸡</p>
      </a>
    </div>
    <div class="goodfoodsimg">
      <a>
        <img src="../../../assets/food_4.gif" class="img">
        <p class="bg"> </p>
        <p class="name" >狮子头</p>
      </a>
    </div>



  </div>

</template>

<script>
    export default {
        name: "QtGoodFoods",
      data(){
          return{
            img:'http://localhost:8443/api/file/xhcytest.jfif'
          }
      }
    }
</script>

<style scoped>
  .goodfoodsimg{
    padding:20px 2% 0 1%;
    width: 22%;
    height: 340px;
    float: left;
  }
  .goodfoodsimg img{
    width: 100%;
    height: 100%;
  }

  .goodfoodsimg a{
    position: relative;
    overflow: hidden;
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
  }

</style>
