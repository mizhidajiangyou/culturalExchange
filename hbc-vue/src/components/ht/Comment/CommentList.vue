<template>
  <div v-loading="loadcomment">
    <el-dialog
      customClass="fulltext"
      :title="title"
      :visible.sync="dialogFormVisible"
      id="fulltext"
      @close="clear"
      width="1500px">
     <el-card style="min-height: 100px">
       <div style="margin-top: 20px" v-show="nocomment"><span>暂无评论</span></div>
       <div v-for="item in commentlist" >
         <div style="display: flex">
           <h2>{{item.commentauthor}}</h2>
           <a style="font-size: small;color: #666666;margin:25px 3px 0 5px">{{item.commentftime}}</a>  <h2>:</h2>
           <p style="margin: 20px">{{item.commentall}}</p>

         </div>
       </div>

     </el-card>
     <save-comment :workid="workid" @reflesh="sx"/>
    </el-dialog>

  </div>

</template>

<script>
    import store from '../../../store';
    import SaveComment from "./SaveComment";
    export default {
        name: "CommentList",
      components: {SaveComment},
      data(){
          return{
            loadcomment:false,
            workid:0,
            nocomment:true,
            username:store.state.user.username,
            title:'评论',
            dialogFormVisible:false,
            commentlist:[],
          }
      },
      mounted(){


      },
      methods:{
        clear(){
          this.commentlist=[];
          this.dialogFormVisible=false;
          this.nocomment=true;
        },
        sx(){
          this.loadcomment=true;
          this.nocomment=false;
          setTimeout(() => {this.getcomment(); this.loadcomment=false;},700)
        },
        getcomment(){
          var _this=this;
          this.$axios.get('/getbyworkid', {
            params: {
              workid: this.workid
            }
          }).then(r=>{
            _this.commentlist=r.data;
           /* console.log(_this.commentlist);*/
          })
        },



      },
    }
</script>

<style scoped>

</style>
