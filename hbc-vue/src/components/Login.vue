<template>
  <body id="paper">
  <h1 style="color: white;position: absolute;left: 20px;">登录杭帮菜文化交流网后台</h1>
  <el-form :model="loginForm" :rules="rules" class="login-container" label-position="left"
            v-loading="loading" ref="hbclogin">
    <h3 class="login_title">系统登录</h3>
    <el-form-item prop="username" label="帐号">
      <el-input type="text" v-model="loginForm.username"
                auto-complete="off" placeholder="请输入账号"/>
    </el-form-item>
    <el-form-item prop="userpassword" label="密码">
      <el-input type="userpassword" v-model="loginForm.userpassword"
                auto-complete="off" placeholder="请输入密码"/>
    </el-form-item>
    <!-- <el-checkbox class="login_remember" v-model="checked"
                  label-position="left"><span style="color: #505458">记住密码</span></el-checkbox>-->
    <el-form-item style="margin-top: 100px;width: 100%">
      <el-button type="primary" style="width: 40%;background: #505458;border: none" v-on:click="login">登录</el-button>
      <!-- <router-link to="register"><el-button type="primary" style="width: 40%;background: #505458;border: none">注册</el-button></router-link>-->
    </el-form-item>
  </el-form>
  <p style="color: white;position: absolute;bottom: 100px;left:1000px;clear: both;">版权所有ztx</p>

  </body>
</template>
<script>
  export default{
    name: 'Login',
    data () {
      return {
        rules: {
          username: [{required: true, message: '用户名不能为空', trigger: 'blur'}],
          userpassword: [{required: true, message: '密码不能为空', trigger: 'blur'}]
        },
        checked: true,
        loginForm: {
          username: '',
          userpassword: ''
        },
        loading: false
      }
    },
    methods: {
      login () {
        var  _this=this;
        this.$refs.hbclogin.validate(valid => {
          if (valid) {
            this.$axios
              .post('/login', {                                   //这里写的是接口url
                username: this.loginForm.username,
                userpassword: this.loginForm.userpassword
              })
              .then(successResponse => {
                if (successResponse.data.code === 200) {
                  _this.$store.commit('login', _this.loginForm)
                  var path = this.$route.query.redirect
                  this.$router.replace({path: path === '/' || path === undefined ? '/htindex' : path})
                  alert("登录成功");
                  /*this.$router.replace({path: '/htindex'})*/
                }
                else if (successResponse.data.code === 400) {
                  alert(successResponse.data.message);
                }

              })
              .catch(failResponse => {
              });
          } else {
            alert("请输入所有必填项。")
            return false;
          }
        }).then();
       /* console.log(this.$store.state)*/

      }
    }
  }
</script>
<style>
  #paper {
    background: url("http://localhost:8443/api/file/ loginbackground.jpg") no-repeat center;
    height: 110%;
    width: 100%;
    background-size: cover;
    position: fixed;
  }
  body{
    margin: 0px;
  }
  .login-container {
    border-radius: 15px;
    background-clip: padding-box;
    margin: 90px auto;
    width: 550px;
    height: 450px;
    padding: 35px 35px 15px 35px;
    background: #fff;
    border: 1px solid #eaeaea;
    box-shadow: 0 0 25px #cac6c6;
    position: absolute;
    left: 100px;
    top:200px
  }
  .login_title {
    margin: 0px auto 40px auto;
    text-align: center;
    color: #505458;
  }
  .login_remember {
    margin: 0px 0px 35px 0px;
    text-align: left;
  }
  /*.login_button {*/
  /*background: #505458;*/
  /*}*/
  /*el_checkbox {*/
  /*background: #505458;*/
  /*}*/
</style>
