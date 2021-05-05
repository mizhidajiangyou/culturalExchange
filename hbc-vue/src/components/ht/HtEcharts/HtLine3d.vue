<template>
  <div ref="chart" :style="{width,height}" > </div>
</template>

<script>
  import {test} from "../Validate";

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
    name: "HtLine3d",
    mounted() {
      /* console.log(this.data);*/
      let option = {
        title: {
          text: '不知道放啥图帅就完事了',
          subtext: '@Made by echars官网',
          left: 'left'
        },
        tooltip: {},
        backgroundColor: '#fff',
        visualMap: {
          show: false,
          dimension: 2,
          min: 0,
          max: 30,
          inRange: {
            color: ['#313695', '#4575b4', '#74add1', '#abd9e9', '#e0f3f8', '#ffffbf', '#fee090', '#fdae61', '#f46d43', '#d73027', '#a50026']
          }
        },
        xAxis3D: {
          type: 'value'
        },
        yAxis3D: {
          type: 'value'
        },
        zAxis3D: {
          type: 'value'
        },
        grid3D: {
          viewControl: {
            projection: 'orthographic'
          }
        },
        series: [{
          type: 'line3D',
          data: this.data,
          lineStyle: {
            width: 4
          }
        }]
      };
      console.log(this.data);
      this.initChart(this.$refs.chart,option,data=>{});
      //console.log(this.data.map(r=>r))
    },

    methods:{

    }
  }
</script>

<style scoped>

</style>
