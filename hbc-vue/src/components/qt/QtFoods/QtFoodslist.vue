<template>
  <div class="foodslist">
    <div v-for="item in foods" :key="item.foodsid">

      <div class="foods" @click="tzfoods(item.foodsid)">
        <a >
          <img :src="item.foodsimg1" >
          <p class="bg"> </p>
          <p class="name" >{{item.foodsname}}</p>
        </a>
      </div>
     <!-- <div v-show="false" v-mode="item.foodsid"/>-->

    </div>

  </div>

</template>

<script>
    export default {
        name: "QtFoodslist",
      data(){
          return{
            foods:[],

          }
      },
      mounted(){
          this.loadfoods();

      },
      methods:{
        loadfoods(){
          var _this=this;
          this.$axios.get('getgoodslistqt').then(r=>{
            _this.foods=r.data;
          })
        },
        tzfoods(foodsid){
          this.$router.push({ path:'/qtfoods/qtfoodsall', query:{foodsid:foodsid}});
        }
      }
    }
</script>

<style scoped>

  .foodslist{
    margin: 20px 0;
    border-top: #e6e6e6 solid 1px;
    display: block;
    padding-left: 12px;

  }

  .foods{
    margin: 10px;
    padding: 0;
    border: #e6e6e6 solid 1px;
    height: 200px;
    width: 300px;
    float: left;
    position: relative;
  }
  .foods img{
    width: 100%;
    height: 100%;
  }

  .bg{
    height: 60px;
    background: #000;
    /*height: 30px;*/
    left: 0;
    padding: 0;

    bottom: -16px;
    opacity: 0.4;
    /* filter: alpha(opacity=40);*/
    position: absolute;
    width: 100%;
    /* z-index: 10;*/

  }

  .name {
    font-size: 16px;
    bottom: 0;
    color: #FFFFFF;
    height: 30px;
    left: 0;
    line-height: 30px;
    overflow: hidden;
    position: absolute;
    text-align: center;
    width: 100%;
    /* z-index: 11;*/
    white-space: nowrap;
    text-overflow: ellipsis;
  }

</style>
