<template>
  <div>
    <div style="float: left;width: 30%">
      <span class="ht-title"><h1>杭帮菜文化交流网后台管理</h1></span>
    </div>
   <!-- <div style="float: left"></div>-->
    <div style="position:relative;">
      <div style="position: absolute;right: 0">
        <i class="el-icon-switch-button" style="float:right;font-size: 30px;color: #222;padding-top: 18px" @click="logout"> </i>
        <i class="el-icon-user-solid" style="float:right;font-size: 30px;color: #222;padding-top: 18px"><a style="font-size: 20px">{{user.username}}</a>&nbsp;&nbsp;</i>
      </div>
    </div>

  </div>
</template>

<script>
  import store from '../../store';
    export default {
        name: "HtHeader",
      data () {
        return {
          user:{
            username:store.state.user.username,
          }
        }
      },
      methods: {

        logout() {
          this.$confirm('此操作将注销, 是否继续?', '提示', {
            customClass:'logout',
            confirmButtonText: '确定',
            cancelButtonText: '取消',
            type: 'warning'
          }).then(() => {
            this.$message({
              type: 'success',
              message: '注销成功!'
            });
            this.$store.commit('logout');
            location.reload();
          }).catch(() => {
            this.$message({
              type: 'info',
              message: '已取消注销'
            });
          });
        }
      }


    }
</script>

<style scoped>
  .ht-title{
   /* text-align: left;
    clear: both;
    position: relative;
    left: 0px;
    width:470px;
    height: 100%;
    margin: 0px;*/
  }

  .ht-title h1{
   /* position: absolute;*/
    font-family: 楷体,serif;
    margin: 10px 0px;
    font-size: 37px;
    width: 470px;
  }

  .logout{
    width: 500px;
    height: auto;
    /*font-size: 300px;*/
    position: absolute;
    top: 100px;
    left: 800px;
    font-size: x-large;
  }

  .el-message-box{
    width: 500px;
    height: auto;
    /*font-size: 300px;*/
    position: absolute;
    top: 100px;
    left: 800px;
    font-size: x-large;
  }

</style>
