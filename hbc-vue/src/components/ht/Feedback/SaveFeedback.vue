<template>
  <div class="save">
    <el-button size="small" v-show="power"  icon="el-icon-circle-plus-outline" @click="openfeedback" round>添加</el-button>
    <el-dialog
      customClass="addfeedback"
      :title="title"
      :visible.sync="dialogFormVisible"
      id="addfeedback"
      @close="clear">
      <el-form ref="forma" :model="feedbackfrom"  label-width="80px"  :rules="rules">
        <el-form-item label="标题：" prop="feedbacktitle">
          <el-input v-model="feedbackfrom.feedbacktitle" :disabled="users"  placeholder="请输入反馈标题不超过20字"/>
        </el-form-item>
        <el-form-item label="作者：" prop="feedbackauthor">
          <el-input v-model="feedbackfrom.feedbackauthor"  :disabled="users" placeholder="请输入您的名称"/>
        </el-form-item>
        <el-form-item label="详情：" prop="feedbackall">
          <el-input type="textarea"  :rows="5" v-model="feedbackfrom.feedbackall" :disabled="users" placeholder="请输入您要反馈的详细内容" />
        </el-form-item>
       <div v-if="power">
         <el-form-item label="赞数："  >
           <el-input v-model="feedbackfrom.feedbacklike"   placeholder="获赞数，这是管理员权限"/>
         </el-form-item>
       </div>
        <div v-if="users">
          <el-form-item label="回复："  >
            <el-input v-model="user.username" :disabled="!power"  placeholder="回复人"/>
          </el-form-item>
          <el-form-item label="内容："  >
            <el-input v-model="feedbackfrom.feedbackbackall" type="textarea"  :rows="5"  placeholder="回复详情"/>
          </el-form-item>
        </div>

        <el-form-item prop="id" style="height: 0">
          <el-input type="hidden" v-model="feedbackfrom.feedbackid" autocomplete="off"/>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" v-on:click="savefeedback">保存</el-button>
          <el-button @click="dialogFormVisible = false" >取 消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
  import ImgUpload from "../ImgUpload";
  import store from '../../../store';
  export default {
    props:{
      power:{
        type:Boolean,
        default:false,
      },
    },

    name: "SaveFeedback",
    components: {ImgUpload},
    data() {
      return {
        rules:{
          feedbacktitle:[
            { required: true, message: '请输入反馈标题', trigger: 'blur' },
            { min: 1, max: 30, message: '请输入不超过30个字符', trigger: 'blur' }
          ],
          feedbackauthor:[
            {required: true,message:'请输入您的称呼',trigger:'blur'},
            { min: 1, max: 20, message: '请输入不超过20个字符', trigger: 'blur' }
          ],
          feedbackall:[
            {required: true,message:'请输入反馈内容',trigger:'blur'},
          ],

        },
        dialogFormVisible: false,
        user:{
          username:store.state.user.username,
          username2:'',
        },
        feedbackfrom: {
          feedbackid:'',
          feedbacklike:'',
          feedbackauthor:'',
          feedbackgood:0,
          feedbacktitle:'',
          feedbackall:'',
          feedbackbackauthor:'',
          feedbackbackall:'',
          feedbackftime:'',
          feedbackltime:'',
        },
        thegood:false,
        thegoodimg:false,
        titlenull:false,   //验证标题为空的提示
        responseResult: [],
        title:'保存反馈',
        users:true,
      }
    },

    methods: {

      openfeedback(){ this.dialogFormVisible = true; this.users=false},
      clear () {
        this.feedbackfrom = {
          feedbackid:'',
          feedbacklike:'',
          feedbackauthor:'',
          feedbackgood:0,
          feedbacktitle:'',
          feedbackall:'',
          feedbackbackauthor:'',
          feedbackbackall:'',
          feedbackftime:'',
          feedbackltime:'',
        };
        this.$refs.forma.resetFields();
       /* console.log("Test")*/

      },



      savefeedback(){
       this.$refs.forma.validate((valid)=>{
         if(valid){
           var ndate=new Date();
           let yy = ndate.getFullYear();
           let mm = ndate.getMonth()+1;
           let dd = ndate.getDate();
           let hh = ndate.getHours();
           let mf = ndate.getMinutes()<10 ? '0'+ndate.getMinutes() : ndate.getMinutes();
           let ss = ndate.getSeconds()<10 ? '0'+ndate.getSeconds() : ndate.getSeconds();
           if(this.feedbackfrom.feedbackftime===''||this.feedbackfrom.feedbackid===''){
             this.feedbackfrom.feedbackftime=yy+'-'+mm+'-'+dd+' '+hh+':'+mf+':'+ss;
           }
           this.feedbackfrom.feedbackltime=yy+'-'+mm+'-'+dd+' '+hh+':'+mf+':'+ss;
           var _this = this;
           this.$axios
             .post('/savefeedback', {                                   //这里写的是接口url
               feedbackid:this.feedbackfrom.feedbackid,
               feedbacklike:this.feedbackfrom.feedbacklike,
               feedbackauthor:this.feedbackfrom.feedbackauthor,
               feedbackgood:this.feedbackfrom.feedbackgood,
               feedbacktitle:this.feedbackfrom.feedbacktitle,
               feedbackall:this.feedbackfrom.feedbackall,
               feedbackbackauthor:this.user.username,
               feedbackbackall:this.feedbackfrom.feedbackbackall,
               feedbackftime:this.feedbackfrom.feedbackftime,
               feedbackltime:this.feedbackfrom.feedbackltime,
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
         }else {
           console.log('请填写后再提交');
         }
       })
      },
    }
  }
</script>

<style scoped>


  #addfeedback{
    /*margin: 0!important;
    width: 1000px;*/
  }

</style>
