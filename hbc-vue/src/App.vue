<template>
  <div id="app">
    <!-- <img src="./assets/logo.png"> 诡异V-->
    <!--<h5>首页</h5>
    <a href="http://localhost:8080/#/login"><button value="login" >登录</button></a>-->
    <router-view/>
  </div>
</template>

<script>
export default {
  name: 'App',
}
</script>

<style>
#app {
  font-family: 'Avenir', Helvetica, Arial, sans-serif;
  -webkit-font-smoothing: antialiased;
  -moz-osx-font-smoothing: grayscale;
  text-align: center;
  color: #2c3e50;
  /* ↓坑爹*/
  /*margin-top: 60px;*/
}
.clear{
  clear: both;
}
</style>
