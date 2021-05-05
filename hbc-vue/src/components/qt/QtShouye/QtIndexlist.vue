<template>
    <div>
      <div class="content1">
        <div class="wrap">
          <!--//头条-->
          <qt-tou-tiao/>
          <!--//资讯推荐-->
          <div class="news">
            <qt-new-good :title="title"/>
            <qt-good-news-list class="n-l"/>
            <qt-goodnews-lunbo class="n-r"/>
            <!--//这个组件封装了一下，懒得改名字-->
          </div>
          <qt-new-good style="padding-top: 10px" :title="title2" :href="href2"/>
          <qt-good-foods/>
          <qt-new-good style="padding-top: 10px" :title="title4" :href="href4"/>
          <qt-feedback-good/>

          <qt-new-good style="padding-top: 10px" :title="title3" :href="href3"/>
          <qt-echarts />

          <!--<other class="n-r"/>-->
        </div>
      </div>

    </div>




</template>

<script>
    import QtNewsList from "../QtNews/QtNewslist";
    import QtTouTiao from "./QtTouTiao";
    import QtNewGood from "./QtNewGood";
    import QtTest from "./QtTest";
    import QtGoodNewsList from "./QtGoodnewsList";
    import QtGoodnewsLunbo from "./QtGoodnewsLunbo";
    import Other from "../../ht/News/test";
    import QtGoodFoods from "./QtGoodFoods";
    import QtEcharts from "./QtEcharts";
    import QtFeedbackGood from "./QtFeedbackGood";

    export default {
        name: "QtIndexlist",
      components: {
        QtFeedbackGood,
        QtEcharts,
        QtGoodFoods, Other, QtGoodnewsLunbo, QtGoodNewsList, QtTest, QtNewGood, QtTouTiao, QtNewsList},
      data(){
          return{
            title:'推荐资讯',
            title2:'菜品推荐',
            href2:'/qtfoods',
            title3:'数据可视化',
            href3:'/htindex',
            title4:'反馈推荐',
            href4:'/qtfeedback'

          }
      }
    }
</script>

<style scoped>

  .content1 {
    width: 100%;
    overflow: hidden;
  }
  .wrap {
    width: auto;
    max-width: 1600px;
    margin: 0 auto;
    text-align: left;
  }
  .clearfix {
    clear: both;
  }
  .n-l{
    width: 48%;
    float: left;
    padding-top: 0px;
  }
  .n-r{
    width: 50%;
    float: right;
    height: auto;
    position: relative;

  }

</style>
