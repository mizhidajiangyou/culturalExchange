<template>
  <div ref="chart" :style="{width,height}" > </div>
</template>

<script>


    export default {
    props:{
      width:{
        type:String,
        default:'500px'
      },
      title:{
        type:String,
        default:'这是张折线图'
      },
      height:{
        type:String,
        default:'300px'
      },
      data:{
        type:Array,
        required:true
      }
    },
        name: "HtLine",
      mounted() {

        let option = {
          title: {
            text: this.title,
            subtext: '@Made by ztx',
            left: 'left'
          },
         /* legend:{},*/
          tooltip: {
            formatter(data){
              /*console.log(data);*/
              return `${data.seriesName}了${data.value}条资讯`
            }
          },
          xAxis: {
            type: 'category',
            data:  this.data.map(r=>r.date),
          },
          yAxis: {
            type: 'value'
          },


          series: [{
            name:"新增",
            data: this.data.map(r=>r.add),
            type: 'line',
            color:("#ca0500"),
          }]
        };
        this.initChart(this.$refs.chart,option,data=>{});

      },
      methods:{
       /* initChart(container,option,onclick){
          let myChart=echarts.init(container);
          myChart.setOption(option);
          if(onclick) myChart.on("click",onclick);
        }*/
      }
    }
</script>

<style scoped>

</style>
