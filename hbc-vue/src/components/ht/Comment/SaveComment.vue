<template>
  <div style="display: flex;margin-top: 20px">
    <el-avatar size="large" style="margin:22px 10px 2px 11px">{{username}} </el-avatar>
    <el-input v-model="comment.commentall" placeholder="请输入回复内容 " type="textarea" :rows="3" style="padding: 10px"/>
    <el-button style="margin: 10px;" @click="savecomment">提交</el-button>
  </div>

</template>

<script>
  import store from '../../../store';
    export default {
      props: {
        workid: {
          type: Number,
          default: 0,
        },
      },
        name: "SaveComment",
      data(){
          return{
            username:store.state.user.username,
            comment:{
             /* commentid:'',*/
              commentall:'',
             /* commentauthor:'',*/
              commentftime:'',
             /* commentltime:'',*/
             /* cworkid:0,*/
              backid:0,
            }
          }
      },
      mounted(){
      },
      methods:{
        savecomment(){
          var ndate=new Date();
          let yy = ndate.getFullYear();
          let mm = ndate.getMonth()+1;
          let dd = ndate.getDate();
          let hh = ndate.getHours();
          let mf = ndate.getMinutes()<10 ? '0'+ndate.getMinutes() : ndate.getMinutes();
          let ss = ndate.getSeconds()<10 ? '0'+ndate.getSeconds() : ndate.getSeconds();
          this.comment.commentftime=yy+'-'+mm+'-'+dd+' '+hh+':'+mf+':'+ss;
          var _this = this;
          this.$axios
            .post('/savecomment', {                                   //这里写的是接口url
              //自增，不保存commentid:'',
              commentall:this.comment.commentall,
              commentauthor:this.username,
              commentftime: this.comment.commentftime,
              commentltime: this.comment.commentftime,
              cworkid: this.workid,
              backid:this.comment.backid,
            })
            .then(successResponse => {
              if (successResponse.data.code === 200) {
                //this.$router.replace({path: '/htindex'})
                alert("保存成功");
                this.dialogFormVisible=false;
                /*this.loadNews();*/
                /* location.reload();*/
              }
              else if (successResponse.data.code === 500) {
                alert("失败");
                this.dialogFormVisible=false;
              }
            })
            .catch(failResponse => {
              alert("接口错误");
            });
          /*console.log('test')*/
          this.$emit('reflesh');
          this.clear();
        },
        clear(){
          this.comment={
              commentall:'',
              commentftime:'',
              backid:0,
          }
        }
      },
    }
</script>

<style scoped>

</style>
