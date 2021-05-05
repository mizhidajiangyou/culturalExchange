<template>
  <div class="t_logo_bg">
    <div class="t_logo_all">
      <div class="t_logo_txt">
        <a href="htindex" target="_blank">ztx</a>&nbsp;&nbsp;hbc.top1.0
      </div>
      <div class="t_logo">
        <a title="杭帮菜文化交流网" href="http://localhost:8080/qthome" target="_blank">
          <img class="t_img" src="http://localhost:8443/api/file/logo.jpg" alt="杭帮菜文化交流网"></a></div>
      <div class="clear"></div>
    </div>
  </div>
</template>

<script>
    export default {
        name: "QtTop"
    }
</script>

<style scoped>
  .t_logo_bg {

    WIDTH: 100%;
    BACKGROUND: url(http://localhost:8443/api/file/top-right1.jpg)  #fff no-repeat right 100%;
    BORDER-bottom: #ddd 1px solid;
    height: 120px;
   /* font-family: "Microsoft YaHei","微软雅黑",Helvetica,"黑体",Arial,Tahoma;*/
  }
  .t_logo_txt {
    margin: 0px ;
   /* color: rgb(88, 87, 87);*/
    height: 30px;
    line-height: 30px;
    font-size: 14px;
    font-weight: normal;
    clear: both;
    color: #dddddd;
    position: absolute;
    left: 50px;
    top: 0px;

  }
  .t_logo {
    margin: 0px ;
    height: 90px;
    position: absolute;
    left: 40px;
    top: 32px;

  }

  .t_logo_all {
    clear: both;
    position: relative;
  }
  .t_img{
    max-width:258px ;
    max-height: 80px;
  }
  div {
    display: block;
  }
</style>
