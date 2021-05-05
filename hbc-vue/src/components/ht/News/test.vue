<template>
  <div class="demo-image__error">
    <div class="block">
      <span class="demonstration">默认</span>
      <el-image></el-image>
    </div>
    <div class="block">
      <span class="demonstration">自定义</span>
      <el-image>
        <div slot="error" class="image-slot">
          <i class="el-icon-picture-outline"></i>
        </div>
      </el-image>
    </div>
  </div>

</template>

<script>




  import FullText from "../FullText";
  import Test2 from "./test2";
  export default {
    name: "other",
    components: {Test2, FullText},
    data() {
      return {


      }

    },
    created() {},
    mounted() {


    },
    methods: {
      t11(){
        alert("标题不能为空")
      }


    },

  }
</script>

<style>



</style>

