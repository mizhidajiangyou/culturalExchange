<template>
  <!--class="categories"
  default-active="0"
  @select="handleSelect"
  active-text-color="red"-->
  <el-menu
   active-text-color="red"
  >
    <el-menu-item index="0" @click="go1">
      <i class="el-icon-menu"/>
      <span  slot="title">全部资讯</span>
    </el-menu-item>
    <el-menu-item index="1" @click="go2">
      <i class="el-icon-menu"/>
      <span  slot="title">推荐资讯</span>
    </el-menu-item>

  </el-menu>

</template>

<script>
    export default {
        name: "NewsSideMenu",
      data () {
        return {
          cid: ''
        }
      },
      methods: {
       go1(){
         this.$router.replace({path: '/newslist'})
       },
        go2(){
          this.$router.replace({path: '/goodnewslist'})
        }
      }
    }
</script>

<style scoped>
  .categories {
    position: fixed;
    margin-left: 50%;
    left: -600px;
    top: 100px;
    width: 150px;
  }
</style>
