<template>
  <div>
    <div class="banner">
      <div class="item">
        <img :src="dataList[currentIndex]">
      </div>
      <div class="page" v-if="this.dataList.length > 1">
        <ul>
          <li @click="gotoPage(prevIndex)">&lt;</li>
          <li v-for="(item,index) in dataList" @click="gotoPage(index)" :class="{'current':currentIndex == index}">  {{index+1}}</li>
          <li @click="gotoPage(nextIndex)">&gt;</li>
        </ul>
      </div>
    </div>
    <li v-for="(item,index) in dataList" @click="gotoPage(index)" :class="{'current':currentIndex == index}">{{index+1}}</li>
    <li @click="gotoPage(prevIndex)">&lt;</li>
    <li v-for="(item,index) in dataList" @click="gotoPage(index)" :class="{'current':currentIndex == index}">{{index+1}}</li>
    <li @click="gotoPage(nextIndex)">&gt;</li>
  </div>

</template>

<script>
    export default {
        name: "PPT2",
      data(){
        return{
          dataList:["https://i1.mifile.cn/a4/xmad_15535933141925_ulkYv.jpg","https://i1.mifile.cn/a4/xmad_15532384207972_iJXSx.jpg","https://i1.mifile.cn/a4/xmad_15517939170939_oiXCK.jpg"],
          currentIndex: 0,   //默认显示图片
          timer: null    //定时器

        }
      },
      methods: {
        gotoPage(index) {
          this.currentIndex = index;
        }
      },
      computed: {
        //上一张
        prevIndex() {
          if(this.currentIndex == 0) {
            return this.dataList.length - 1;
          }else{
            return this.currentIndex - 1;
          }
        },
        //下一张
        nextIndex() {
          if(this.currentIndex == this.dataList.length - 1) {
            return 0;
          }else {
            return this.currentIndex + 1;
          }
        },
        runInv() {
          this.timer = setInterval(() => {
            this.gotoPage(this.nextIndex)
          }, 1000)
        }
      },
      //定时器

    }
</script>

<style scoped>

</style>
