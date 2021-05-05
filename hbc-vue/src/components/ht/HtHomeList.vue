<template>
  <div style="overflow: hidden;">
    <i class="el-icon-refresh" @click="c3" style="position: absolute; top: 100px;left:70px;z-index:1000;font-size: 20px"/>
    <div class="hthomebox1" v-loading="load1" >
      <ht-bar  :data="boxdata1"  :style="htboxstyle1" title="后台任务状态统计柱形图" seriesname="状态：" v-if="loadbar"/>
      <i class="el-icon-pie-chart" id="c1" @click="c1" v-if="loadbar" v-show="!load1"/>
      <i class="el-icon-s-data" id="c2" @click="c2" v-if="!loadbar" v-show="!load1"/>
      <ht-pie :data="boxdata1"  :style="htboxstyle2" title="后台任务状态统计玫瑰图" v-show="!load1"  v-if="!loadbar"/>
     <!-- <button @click="refresh">test</button>-->
    </div>
    <div class="hthomebox2"  v-loading="!loadpie" >
      <ht-pie :data="boxdata2"  :style="htboxstyle2"   title="推荐新闻状态南丁格尔玫瑰图" v-if="loadpie"/>
    </div>
    <div class="hthomebox3" v-loading="!loadbar2">
      <ht-bar  :data="boxdata3"  :style="htboxstyle1" title="后台任务类型统计柱形图" seriesname="类型：" v-if="loadbar2"/>
    </div>
    <div class="hthomebox4">
      <span @click="change4" style="position: absolute; cursor: pointer;left: 37px;top:20px">change</span>
      <ht-scatter  :data="boxdata4"  :style="htboxstyle1" v-if="loadbox4" />
      <div v-if="!loadbox4">
        <p style="font-size: 22px;font-weight: bold">后台整体完成进度</p>
       <!-- <el-progress type="circle" :percentage="jd.number" v-show="jd.jd1"/>-->
        <el-progress type="circle" width="300" stroke-width="13" :percentage="jd.number" v-show="jd.jd2" style="margin-top: 30px"/>
        <!--<el-progress type="circle" :percentage="jd.number" status="success" v-show="jd.jd3"/>
        <el-progress type="circle" :percentage="jd.number" status="exception" v-show="jd.jd4"/>-->

       <!-- <input v-model="jd.number"/>
        <el-button @click="changejd">change</el-button>-->
      </div>

    </div>
    <div class="clear" style="clear: both;min-width:2000px "/>
    <div class="hthomebox5" v-show="false">
      <p v-loading="over1">看到这个说明屏幕太大</p>
    </div>



    <div class="hthometable">
      <ht-worklist/>
    </div>
  </div>

</template>

<script>
    import Other from "./News/test";
    import HtPie from "./HtEcharts/HtPie";
    import HtBar from "./HtEcharts/HtBar";
    import HtLine from "./HtEcharts/HtLine";
    import HtLine3d from "./HtEcharts/HtLine3d";
    import HtScatter from "./HtEcharts/HtScatter";
    import HtWorklist from "./HtWork/HtWorklist";
    export default {
        name: "HtHomeList",
      components: {HtWorklist, HtScatter, HtLine3d, HtLine, HtBar, HtPie, Other},
      data(){
          return{
            htboxstyle1:{
              width:'450px',
              height:'450px'
            },
            htboxstyle2:{
              width:'450px',
              height:'450px'
            },
            jd:{number:69,jd1:false,jd2:true,jd3:false,jd4:false},
            load1:true,
            load2:true,
            load3:true,
            load4:true,
            loadbar:false,
            loadbar2:false,
            loadpie:false,
            load3dline:false,
            loadbox4:true,
            over1:true,
            boxdata1:[],
            boxdata2:[],
            boxdata3:[],
            boxdata4:[],

          }
      },

      mounted() {
        this.roadbar();
        this.roadpie();
        this.roadbar2();


        /*this.shuai();*/
      },
      methods:{
        refresh(){
          this.loadbar=false;
          setTimeout( () => {
            this. roadbar();
          },800)
        },

        c3(){
          this.refresh();
        },

        roadbar(){
          var _this = this;
          this.$axios.get('/workall').then(resp => {
            if (resp && resp.status === 200) {
              _this.boxdata1 = resp.data;
            }
            let t1=0,t2=0,t3=0,t4=0,t5=0,t6=0;
            for(let i=0;i<this.boxdata1.length;i++)
            {
              if(this.boxdata1[i].workstate === '预置')
                t1+=1;
              if(this.boxdata1[i].workstate === '进行中')
                t2+=1;
              if(this.boxdata1[i].workstate === '已完成')
                t3+=1;
              if(this.boxdata1[i].workstate === '暂缓')
                t4+=1;
              if(this.boxdata1[i].workstate === '放弃')
                t5+=1;
              if(this.boxdata1[i].workstate === '优先')
                t6+=1;
            }
            this.boxdata1=[
              {value: t1, name: '预置'},
              {value: t2, name: '进行中'},
              {value: t3, name: '已完成'},
              {value: t4, name: '暂缓'},
              {value: t5, name: '放弃'},
              {value: t6, name: '优先'},
            ];
            this.loadbar=true;
            this.load1=false;
            const t=t3/(t1+t2+t3+t4+t5+t6)*100;
            this.jd.number=t.toFixed(2);
            /*console.log(this.boxdata1)*/
          })
        },
        roadpie(){
          var _this = this;
          this.$axios.get('/newsall').then(resp => {
            if (resp && resp.status === 200) {
              _this.boxdata2 = resp.data;
            }
            /*console.log(this.boxdata2);*/
            let t1=0,t2=0,t3=0,t4=0;
              for(let i=0;i<this.boxdata2.length;i++)
            {
             switch (this.boxdata2[i].newsgood) {
               case 2:{t1+=1;break;}
               case 3:{t2+=1;break;}
               case 4:{t3+=1;break;}
               case 99:{t4+=1;break;}
              /* default : {t5+=1;break;}*/
             }
            }
            this.boxdata2=[
              {value: t1, name: '上部推荐'},
              {value: t2, name: '下部推荐'},
              {value: t3, name: '轮播推荐'},
              {value: t4, name: '头条推荐'},

            ];
          /*  console.log(this.boxdata2);*/
            /* console.log(this.xx);*/
            this.loadpie=true;
          });
          /*console.log(this.boxdata2);*/
        },
        roadbar2(){
          var _this = this;
          this.$axios.get('/workall').then(resp => {
            if (resp && resp.status === 200) {
              _this.boxdata3 = resp.data;
            }
            let t1=0,t2=0,t3=0,t4=0,t5=0,t6=0,t7=0;
            for(let i=0;i<this.boxdata3.length;i++)
            {
             switch (this.boxdata3[i].workcategory) {
               case '界面' : {t1+=1;break;}
               case '接口' :{t2+=1;break;}
               case '算法' :{t3+=1;break;}
               case '功能' :{t4+=1;break;}
               case '数据库' :{t5+=1;break;}
               case '测试' :{t6+=1;break;}
               default :{t7+=1;break;}
             }
            }
            this.boxdata3=[
              {value: t1, name: '界面'},
              {value: t2, name: '接口'},
              {value: t3, name: '算法'},
              {value: t4, name: '功能'},
              {value: t5, name: '数据库'},
              {value: t6, name: '测试'},
              {value: t7, name: '其他'},
            ];
            this.loadbar2=true;

          })
        },
        change4(){
          this.loadbox4=!this.loadbox4;
        },
        changejd(){
          if(this.jd.number === 100){
            this.jd.jd1=false;
            this.jd.jd2=false;
            this.jd.jd3=true;
            this.jd.jd4=false;
          }
          else if(this.jd.number === 0){
            this.jd.jd1=true;
            this.jd.jd2=false;
            this.jd.jd3=false;
            this.jd.jd4=false;
          }
          else if(this.jd.number>100||this.jd.number<0){
            this.jd.jd1=false;
            this.jd.jd2=false;
            this.jd.jd3=false;
            this.jd.jd4=true;
          }
        },
        c1(){
          this.loadbar=false;
        },
        c2(){
          this.loadbar=true;

        }


      /*  shuai(){
          for (let t = 0; t < 25; t += 0.001) {
            let x = (1 + 0.25 * Math.cos(75 * t)) * Math.cos(t);
            let y = (1 + 0.25 * Math.cos(75 * t)) * Math.sin(t);
            let z = t + 2.0 * Math.sin(75 * t);
            this.boxdata4.push([x, y, z]);
          }
          this.load3dline=true;
         /!* console.log(this.boxdata4)*!/
        }*/


      },



    }
</script>

<style scoped>

  .hthomebox1{
    border-radius: 15px;
    background-clip: padding-box;
    margin: 20px 30px 20px 13px;
    width: 400px;
    height: 450px;
    padding: 35px 55px 15px 15px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 10px #cac6c6;
    position: absolute;
   /* left: 10px;*/
    /*top:40px*/
  }
  .hthomebox2{
    border-radius: 15px;
    background-clip: padding-box;
    margin: 20px 30px 20px 13px;
    width: 400px;
    height: 450px;
    padding: 35px 45px 15px 25px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 10px #cac6c6;
    position: absolute;
    left: 510px;
  }
  .hthomebox3{
    border-radius: 15px;
    background-clip: padding-box;
    margin: 20px 30px 20px 13px;
    width: 400px;
    height: 450px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 10px #cac6c6;
    position: absolute;
    left: 1020px;
  }
  .hthomebox4{
    border-radius: 15px;
    background-clip: padding-box;
    margin: 20px 30px 20px 13px;
    width: 400px;
    height: 450px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 10px #cac6c6;
    position: absolute;
    left: 1530px;
  }
  .hthomebox5{
    border-radius: 15px;
    background-clip: padding-box;
    margin: 20px 30px 20px 13px;
    width: 400px;
    height: 450px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 10px #cac6c6;
    float: right;
  }

  .hthometable{
    border-radius: 15px;
    background-clip: padding-box;
    margin: 20px 30px 20px 13px;
    /*min-width: 1900px;
    min-height: 450px;*/
    min-width:1900px;
    width: 95%;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 10px #cac6c6;
     position: absolute;
     left: 10px;
     top:600px;
  }
  #c1{
    cursor: pointer;
    position: absolute;
    left:20px;top:20px;
    font-size: 20px;
    color: #222;
  }
  #c2{
    cursor: pointer;
    position: absolute;
    left:20px;top:20px;
    font-size: 20px;
    color: #222;
  }
</style>
