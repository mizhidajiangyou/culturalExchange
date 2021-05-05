<template>
  <div class="newsgood">
    <div class="headline">
      <span class="line" style="font-weight:bold">{{title}}</span>
      <a target="_blank" :href=href class="more">更多&gt;&gt;</a>
    </div>
  </div>
</template>

<script>
    export default {
        name: "QtNewGood",
      props: {
        title: {
          type: String,
          default: '推荐'
        },
        href: {
          type: String,
          default: "/qtnews"
        },
      },
      data(){
          return{}
      },
    }
</script>

<style scoped>
  .newsgood{
    position: relative;
    width: 100%;
    margin: 0 auto;
    clear: both;
  }

  .headline{
    font-size: 18px;
    width:100%;
    border-bottom:2px solid #e6e6e6;
    /*position: relative;*/
  }
  .headline em{
    margin-left:10px;
    color:#666;
  }
  .line {
    /*margin-left: 0px;*/
    display: inline-block;
    padding:12px 0 10px 0;
    border-bottom:2px solid #871b21;
    margin-bottom:-2px;
    /*position: relative;
    left: -740px;*/

  }
  .more{
    float: right;
    color:#999999;
    font-size: 16px;
    position: relative;
    top:15px;
    right:10px;
  }



</style>
