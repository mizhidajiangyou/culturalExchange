<template>
  <div style="margin-bottom: 30px;display: flex;justify-content: center;align-items: center">
    <el-input
      @keyup.enter.native="searchClick"
      placeholder="通过资讯名称搜索..."
      prefix-icon="el-icon-search"
      size="small"
      style="width: 400px;margin-right: 10px"
      v-model="keywords">
    </el-input>
    <!--type="primary"-->
    <el-button size="small"  icon="el-icon-search" @click="searchClick" round>搜索</el-button>
  </div>
</template>

<script>
    export default {
      name: "SearchNews",
      data () {
        return {
          keywords: '',
          cardLoading: []
        }
      },
      methods: {
        searchClick () {
          this.$emit('onSearch')
        }
      }
    }
</script>

<style scoped>

</style>
