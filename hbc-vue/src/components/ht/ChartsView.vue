<template>
  <div>
    <div ref="chart" class="ectest1"> </div>
    <div ref="chart1" class="ectest1"> </div>
  </div>

</template>

<script>
    export default {
        name: "ChartsView.vue",
      return:{
        date(){
         return{
           ec1:[
             {shouru :1421, zhichu :2321,},
             {shouru :1321, zhichu :2312,},
             {shouru :31231, zhichu :2321312,},
             {shouru :32131, zhichu :32132,},
             {shouru :13213, zhichu :23123,},
             ],
           ec2:[],
         }
        },
      },
      mounted(){

/*
        let option={
          title: {
            text: 'ECharts 入门示例'
          },
          //图例
          legend:{},
          //提示
          tooltip: {},
          xAxis: {
            data: ['衬衫', '羊毛衫', '雪纺衫', '裤子', '高跟鞋', '袜子']
          },
          yAxis: {},
          series: [{
            name: '销量',
            type: 'bar',
            data: [5, 20, 99, 10, 10, 20]
          }]
        };
        this.initChart(this.$refs.chart,option);*/


      },
      methods:{
          /*initChart(container,option,onclick){
            let myChart=echarts.init(container);
            myChart.setOption(option);
            if(onclick) myChart.on("click",onclick);
          }*/
      }
    }
</script>

<style scoped>
  .ectest1{
    width: 800px;
    height: 600px;
  }

</style>
