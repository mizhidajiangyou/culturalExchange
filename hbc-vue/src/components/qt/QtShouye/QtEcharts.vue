<template>
  <div style="position: relative;min-height: 700px">
    <div class="left">
      <ht-line :data="qtbox" :style="qtstyle" title="近一周网站资讯新增状况统计图"/>

    </div>
    <div class="right">
      <ul>
        <li><p>本网站当前收录资讯：218</p></li>
        <li><p>本网站当前收录菜品：108</p></li>
      </ul>
    </div>

  </div>

</template>

<script>
    import HtPie from "../../ht/HtEcharts/HtPie";
    import HtLine from "../../ht/HtEcharts/HtLine";
    export default {
        name: "QtEcharts",
      components: {HtLine, HtPie},
      data(){
          return{

            qtbox:[
              {add :14, date :4.1,},
              {add :24, date :4.2,},
              {add :24, date :4.3,},
              {add :11, date :4.4,},
              {add :5, date :4.5,},
              {add :5, date :4.6,},
              {add :24, date :4.7,},
            ],
            qtstyle:{
              width:'800px',
              height:'650px'
            },
          }
      }

    }
</script>

<style scoped>
  .left{
    position: absolute;
    left: 30px;
    top:50px;

    z-index: 20;



  }
  .right{
    position: absolute;
    right: 200px;
    top:50px;

  }

</style>
