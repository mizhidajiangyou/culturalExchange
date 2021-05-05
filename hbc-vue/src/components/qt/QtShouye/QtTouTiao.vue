<template>
  <div class="toutiao_index ">
    <span class="plus"></span>
    <h2 class="toutiaoh2"><a class="toutiaoa" href="/qtnews/qtnewsall?newsid=1" target="_blank" title="头条">双灵大院开张啦</a></h2>
    <p class="toutiaop">西湖区新开的菜馆双灵大院，地点坐落于双浦镇双灵村上堡67号，是一家地地道道的杭帮菜菜馆；价格优惠，味道极佳。杭帮菜，是浙江饮食文化的重要组成部分，属于浙江菜的重要流派，它与宁波菜、温州菜、绍兴菜共同构成传统的浙江菜系。杭帮菜的口味以咸为主，略有甜头。</p>

    <div class="titbg"></div>
  </div>
</template>

<script>
    export default {
        name: "QtTouTiao"
    }
</script>

<style scoped>
   .plus {
    position: absolute;
    left: 0;
    top: 0;
    width: 72px;
    height: 72px;
    background: url(http://localhost:8443/api/file/tt.png) no-repeat;
    z-index: 99;
  }
  .toutiao_index {
    margin: 40px auto 0;
    clear: both;
    height: auto;
    border: 1px solid #e6e6e6;
    background-color: #ffffff;
    position: relative;
    box-shadow:2px 2px 5px rgba(0, 0, 0, 0.2);
  }
  .toutiaoh2 {
    height: 90px;
    font-size: 42px;
    color: #a11e28;
    font-weight: bold;
    line-height: 90px;
    padding: 0 4%;
    text-align: center;
    white-space: nowrap;
    text-overflow: ellipsis;
    overflow: hidden;
  }
  .toutiaoa {
    color: #e9252c;
    text-decoration: none;
  }
  .toutiaop{
    margin: 20px;
    border-collapse: separate;
    border-spacing: 10px 30px;
    border-top: 1px solid #e6e6e6;
    font-size: 18px;
    text-indent: 3em;
    color: #999;
    background-color: #ffffff;
    padding: 12px 2% 12px;
  }
</style>
