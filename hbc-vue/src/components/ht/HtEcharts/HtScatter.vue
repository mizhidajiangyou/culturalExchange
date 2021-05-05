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
      height:{
        type:String,
        default:'300px'
      },
      data:{
        type:Array,
        required:true
      }
    },
    name: "HtScatter",
    mounted() {
      /* console.log(this.data);*/
      let option = {
        title: {
          text: '后台为了凑数之散点图',
          subtext: '@Made by ztx',
          left: 'left'
        },
        xAxis: {},
        yAxis: {},
        series: [{
          symbolSize: 20,
          data: [
            [10.0, 8.04],
            [8.0, 6.95],
            [13.0, 7.58],
            [9.0, 8.81],
            [11.0, 8.33],
            [14.0, 9.96],
            [6.0, 7.24],
            [4.0, 4.26],
            [12.0, 10.84],
            [7.0, 4.82],
            [5.0, 5.68]
          ],
          type: 'scatter'
        }]
      };


      this.initChart(this.$refs.chart,option,data=>{});
      //console.log(this.data.map(r=>r))
    },

    methods:{

    }
  }
</script>

<style scoped>

</style>
