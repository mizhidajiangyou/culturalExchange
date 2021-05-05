<template>
  <div class="nr">
    <div v-for="item in newbox">
      <a>{{item.feedbacktitle}}</a>
    </div>

  </div>
</template>

<script>
    export default {
        name: "Qtnewfeedback",
      data(){
          return{
            newbox:[],
       /* {feedbackid:1,feedbacktitle:'好高兴啊又吃成啊啊啊长快乐了'},
        {feedbackid:2,feedbacktitle:'界面调整'},
        {feedbackid:3,feedbacktitle:'首页数据绑定'},
        {feedbackid:4,feedbacktitle:'脑阔疼'},*/
          }
      },
      methods:{
        duFanKui(){
          var _this=this;
          this.$axios.get('/feedbackall').then( r=>{
            for(let i=0;i<4;i++) {
              let _r={};
              _r['feedbackid']=r.data[i].feedbackid;
              _r['feedbacktitle']=r.data[i].feedbacktitle;
              _this.newbox.push(_r);
            }
            console.log(_this.newbox)
          })
        }
      },
      mounted() {
          this.duFanKui();
      }
    }
</script>

<style scoped>
  .nr a{
    text-align: left;
    margin-top: 25px;
    /*width: 300px;*/
    -webkit-line-clamp: 1;
    overflow: hidden;
    display: -webkit-box;
    -webkit-box-orient: vertical;
    white-space: normal;

  }


</style>
