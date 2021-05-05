<template>
  <el-container>
    <el-aside style="width: 200px;margin-top: 20px">
      <switch/>
    </el-aside>
    <el-main>
      <router-view/>
    </el-main>
  </el-container>
</template>

<script>
    import FoodsList from "./Foods/HtFoodsList";
    export default {
        name: "FoodsGL",
      components: {FoodsList}
    }
</script>

<style scoped>

</style>
