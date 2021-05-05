<template>
  <div>
    <h1 v-if="power">对不起您没有权限</h1>
    <user-list v-if="!power"/>
  </div>

</template>

<script>
    import UserList from "./User/UserList";
    import store from '../../store';
    export default {
        name: "UserGL",
      components: {UserList},
      data(){
          return{
            power:true
          }
      },
      mounted(){
          this.userpower();
      },
      methods:{
          userpower(){
            var _this=this;
            this.$axios.post('/getuserpower', {
              username:store.state.user.username,
            }).then(r=>{
              if(r.data>0){
                _this.power=false;
              }
            })
          }
      }
    }
</script>

<style scoped>

</style>
