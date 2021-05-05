<template>
  <el-menu
    :default-active="this.$route.path"
    router
    mode="horizontal"
    background-color="white"
    text-color="#222"
    active-text-color="red"
    style="min-width: 1300px">
    <el-menu-item v-for="(item,i) in gbcht" :key="i" :index="item.name">
      {{ item.navItem }}
    </el-menu-item>

   <!-- <a  style="color: #222;float: right;padding: 20px;">-->
    <!--</a>-->

    <i class="el-icon-switch-button" style="cursor: pointer; float:right;font-size: 30px;color: #222;padding-top: 18px" @click="logout"> </i>
    <i class="el-icon-user-solid" style="float:right;font-size: 30px;color: #222;padding-top: 18px">
      <a style="font-size: 20px">{{user.username}}</a>&nbsp;&nbsp;
    </i>
    <span style="position: absolute;padding-top: 10px;right: 42%;font-size: 30px;font-weight: bold">杭帮菜文化交流网后台管理</span>
  </el-menu>
</template>

<script>
  import store from '../../store';
    export default {
      name: "Menu",
      data () {
        return {
          gbcht: [
            {name: '/htindex', navItem: '首页'},
            {name: '/newslist', navItem: '资讯管理'},
            {name: '/foodslist', navItem: '菜品管理'},
            {name: '/feedbackgl', navItem: '反馈管理'}
          ],
          user:{
            username:store.state.user.username,
          }
        }
      },
      mounted(){
        this.loadmenu();
      },
      methods: {
        loadmenu(){
          var _this=this;
          this.$axios.post('/getuserpower', {                                   //这里写的是接口url
            username:store.state.user.username,
          }).then(r=>{
            if(r.data>0){
              _this.gbcht=[
                {name: '/htindex', navItem: '首页'},
                {name: '/newslist', navItem: '资讯管理'},
                {name: '/foodslist', navItem: '菜品管理'},
                {name: '/feedbackgl', navItem: '反馈管理'},
                {name: '/usergl', navItem: '用户管理'},
              ]
            }
          })
        },
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
  a{
    text-decoration: none;
    color: #000000;
  }


  span {
    /*pointer-events: none;*/
    /*鼠标事件*/
  }
/*  .el-dropdown-link {
    cursor: pointer;
    color: #000000;
  }
  .el-icon-arrow-down {
    font-size: 12px;
  }*/
</style>
