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
      },
      title:{
        type:String,
        default:'这是张柱状图'
      },
      seriesname:{
        type:String,
        default:'名称'
      },
    },
    name: "HtBar",
    mounted() {
      /* console.log(this.data);*/
      let option = {
        title: {
          text: this.title,
          subtext: '@Made by ztx',
          left: 'left'
        },
        tooltip: {},
        /*legend: {
          left: 'center',
          top: 'bottom',
         /!* data: this.data.map(r=>r.name)*!/
        },*/

        xAxis: {
          type: 'category',
          data: this.data.map(r=>r.name),
        },
        yAxis: {
          type: 'value'
        },
        series: [{
          name: this.seriesname,
          data: this.data.map(r=>r.value),
          type: 'bar',
          itemStyle: {
            //通常情况下：
            normal: {
              //每个柱子的颜色即为colorList数组里的每一项，如果柱子数目多于colorList的长度，则柱子颜色循环使用该数组
              color: function (params) {
                var colorList = ['#06c42b', '#E29907', '#32b8bb', '#11e054','#CD7ABB','#c20003','#87B0BB'];
                return colorList[params.dataIndex];
              }
            },
          }
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
