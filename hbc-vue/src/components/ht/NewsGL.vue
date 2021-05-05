<template>
  <el-container>
    <el-aside style="width: 200px;margin-top: 20px">
      <switch/>
      <news-side-menu />

    </el-aside>
    <el-main>
      <router-view></router-view>
      <!--<news-list></news-list>-->
      <!--<add-news></add-news>-->
    </el-main>
  </el-container>

</template>

<script>
    import NewsList from "./News/NewsList";
    import AddNews from "./News/AddNews";
    import NewsSideMenu from "./News/NewsSideMenu";
    export default {
      name: "NewsGL",
      components: {NewsSideMenu, AddNews, NewsList},

    }
</script>

<style scoped>
.a1{
  float: left;
}
</style>
