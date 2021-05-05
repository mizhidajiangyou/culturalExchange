import HtLine from '../ht/HtEcharts/HtLine'
import  echarts from 'echarts';


export default {
  install(Vue){
    Vue.mixin({
      methods:{
        initChart(container,option,onclick){
          const myChart=echarts.init(container);
          myChart.setOption(option);
          if(onclick) myChart.on("click",onclick);
        }
      }
    });

    Vue.components('Mychart',HtLine)
  }
}
