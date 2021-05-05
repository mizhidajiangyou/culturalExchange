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
        },
        title:{
          type:String,
          default:'推荐新闻状态南丁格尔玫瑰图'
        },
      },
        name: "HtPie",
      mounted() {
       /* console.log(this.data);*/
        let option = {
          title: {
            text: this.title,
            subtext: '@Made by ztx',
            left: 'left'
          },
          tooltip: {
            trigger: 'item',
            formatter: '{a}{b} : <br/>{c}个，占比{d}%'
          },
          legend: {
            left: 'left',
            top: 'bottom',
            data: this.data.map(r=>r.name)
          },
        /*  toolbox: {
            show: true,
            feature: {
              mark: {show: true},
              dataView: {show: true, readOnly: false},
              magicType: {
                show: true,
                type: ['pie', 'funnel']
              },
              restore: {show: true},
              saveAsImage: {show: true}
            }
          },*/
          series: [
            {
              name: '类型-',
              type: 'pie',
              radius: [35, 180],
              /*center: ['25%', '50%'],*/
              roseType: 'radius',
            /*  label: {
                show: false
              },*/
              emphasis: {
                label: {
                  show: true
                }
              },
              labelLine:{
                show:true,
                length:3,
                lineStyle:{
                  width:0.8
                }
              },
              data: this.data.map(r=>r)
            },
          ]
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
