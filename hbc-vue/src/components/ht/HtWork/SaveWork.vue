<template>
  <div>
    <el-button size="small"  icon="el-icon-circle-plus-outline" @click="openwork" round>添加</el-button>
    <el-dialog
      customClass="addwork"
      title="添加工作"
      :visible.sync="dialogFormVisible"
      id="addwork"
      style="min-width: 800px"
      ><!--@close="clear"-->
      <el-form ref="form" :model="Workfrom" label-width="80px"  >
        <el-form-item label="标题：">
          <el-input
            v-model="Workfrom.worktitle"
            placeholder="请输入标题不超过100字"/>
         <!-- @blur="validatornewstitle"-->
          <!--<a class="warning" v-show="titlenull">标题不能为空</a>-->
        </el-form-item>
        <el-form-item label="创建者：">
          <el-input v-model="user.username" ref="workauthor" disabled/>
        </el-form-item>
        <el-form-item label="类型：" style="overflow: hidden" >
          <el-select   v-model="Workfrom.workcategory"  placeholder="请选择" style="float: left"  ref="goodselect">
            <el-option
              v-for="item in options1"
              :key="item.id"
              :label="item.label"
              :value="item.label">
            </el-option>
          </el-select>
          <el-form-item  style="position: absolute;left: 250px;max-width: 400px" label="状态：">
            <el-select   v-model="Workfrom.workstate"  placeholder="请选择" style="float: left"  ref="goodselect">
              <el-option
                v-for="item in options2"
                :key="item.id"
                :label="item.label"
                :value="item.label">
              </el-option>
            </el-select>
          </el-form-item>
          <div class="clear"/>
        </el-form-item>



        <el-form-item label="详情：" >
          <el-input type="textarea"  :rows="5" v-model="Workfrom.workall" ref="workall" />
        </el-form-item>
        <el-form-item label="备注：">
          <el-input v-model="Workfrom.workaq" ref="workaq" />
        </el-form-item>


        <el-form-item label="创建时间"  prop="newsftime" v-show="false">
          <el-input v-model="Workfrom.workltime" autocomplete="off" placeholder="创建时间"/>
        </el-form-item>
        <el-form-item label="修改时间"  prop="newsltime" v-show="false">
          <el-input v-model="Workfrom.workltime" autocomplete="off" placeholder="修改时间"/>
        </el-form-item>
        <el-form-item prop="id" style="height: 0">
          <el-input type="hidden" v-model="Workfrom.workid" autocomplete="off"/>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" v-on:click="savework">立即创建</el-button>
          <el-button @click="dialogFormVisible = false">取 消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
  import ImgUpload from "../ImgUpload";
  import store from '../../../store';
  export default {

    name: "SaveWork",
    components: {ImgUpload},
    data() {
      return {
        dialogFormVisible: false,
        user:{
          username:store.state.user.username,
        },
        Workfrom: {
          workid:'',
          worktitle:'',
          workauthor:'',
          workall:'',
          workcategory:'',
          workstate:'',
          workaq:'',
          workftime:'',
          workltime:'',
        },
        options1: [
          {id:0,label:'界面'},
          {id:1,label:'接口'},
          {id:2,label:'算法'},
          {id:3,label:'功能'},
          {id:4,label:'数据库'},
          {id:5,label:'测试'},
          {id:6,label:'其他'},
        ],
        options2: [
          {id:0,label:'预置'},
          {id:1,label:'进行中'},
          {id:2,label:'已完成'},
          {id:3,label:'暂缓'},
          {id:4,label:'放弃'},
          {id:5,label:'优先'},
        ],
        newsftime: true, //创建时间列表不显示
        newsltime: true,//修改不显示
        thegood:false,
        thegoodimg:false,
        titlenull:false,   //验证标题为空的提示
        responseResult: [],
      }
    },

    methods: {

      openwork(){ this.dialogFormVisible = true;},

     /* openadd(){
        this.dialogFormVisible = true;
        if(this.Addnewsfrom.newsgood==0){
          this.thegood=false;
        }else {
          this.thegood=true;
        }
      },
      validatornewstitle(){
        if(!this.Addnewsfrom.newstitle){
          this.titlenull=true;
        }
        else{
          this.titlenull=false;
        }
      },
      timechange(){
        var ndate=new Date();
        let yy = ndate.getFullYear();
        let mm = ndate.getMonth()+1;
        let dd = ndate.getDate();
        let hh = ndate.getHours();
        let mf = ndate.getMinutes()<10 ? '0'+ndate.getMinutes() : ndate.getMinutes();
        let ss = ndate.getSeconds()<10 ? '0'+ndate.getSeconds() : ndate.getSeconds();
        this.Addnewsfrom.newsftime=yy+'-'+mm+'-'+dd+' '+hh+':'+mf+':'+ss;
        this.Addnewsfrom.newsltime=yy+'-'+mm+'-'+dd+' '+hh+':'+mf+':'+ss;
      },*/
     /* clear () {
        this.Addnewsfrom = {
          newsid: '',
          newstitle:'',
          newsimg1:'',
          newsimg2:'',
          newsjj:'',
          newsall:'',
          newskeyword:'',
          newsother:'',
          newsgood:0,
          newsftime:'',
          newsltime:'',
        };
        this.$refs.imgUpload.fileList=[];
        this.thegood=false;
        this.titlenull=false;
        this.thegoodimg=false;
        this.value='默认推荐';
      },
      showgood(){
        this.thegoodimg=!this.thegoodimg
        if (this.thegoodimg==true){
          this.Addnewsfrom.newsgood=1;
        }else {
          this.Addnewsfrom.newsgood=0;
        }
      },
      changegood(Gid){
        let obj = {};
        obj = this.options.find((item)=>{    //这里的selectList就是上面遍历的数据源
          return item.id === Gid;//筛选出匹配数据
        });
        this.Addnewsfrom.newsgood=obj.good;

        /!*console.log(obj.name);//我这边的name就是对应label的
        console.log(obj.id);*!/
      },
      uploadImg () {
        this.Addnewsfrom.newsimg1=this.$refs.imgUpload.url
          .then(this.Addnewsfrom.newsimg1=this.$refs.imgUpload.url)
        /!*this.from.img1=this.$refs.imgUpload.url*!/
      },
      uploadImg2 () {
        this.Addnewsfrom.newsimg2=this.$refs.imgUpload2.url
          .then(this.Addnewsfrom.newsimg2=this.$refs.imgUpload2.url)
        /!*this.from.img1=this.$refs.imgUpload.url*!/
      },*/
      savework(){
        if(!this.Workfrom.worktitle){
          alert("标题不能为空");
        }
        else {
          var ndate=new Date();
          let yy = ndate.getFullYear();
          let mm = ndate.getMonth()+1;
          let dd = ndate.getDate();
          let hh = ndate.getHours();
          let mf = ndate.getMinutes()<10 ? '0'+ndate.getMinutes() : ndate.getMinutes();
          let ss = ndate.getSeconds()<10 ? '0'+ndate.getSeconds() : ndate.getSeconds();
          this.Workfrom.workftime=yy+'-'+mm+'-'+dd+' '+hh+':'+mf+':'+ss;
          this.Workfrom.workltime=yy+'-'+mm+'-'+dd+' '+hh+':'+mf+':'+ss;
          var _this = this;
          this.$axios
            .post('/savework', {                                   //这里写的是接口url
              workid:this.Workfrom.workid,
              worktitle:this.Workfrom.worktitle,
              workauthor:this.user.username,
              workall:this.Workfrom.workall,
              workcategory:this.Workfrom.workcategory,
              workstate:this.Workfrom.workstate,
              workaq:this.Workfrom.workaq,
              workftime:this.Workfrom.workftime,
              workltime:this.Workfrom.workftime,
            })
            .then(successResponse => {
              if (successResponse.data.code === 200) {
                //this.$router.replace({path: '/htindex'})
                alert("添加成功");
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
            });
          this.$emit('reflesh');
        }
      }
    }
  }
</script>

<style scoped>
  .el-icon-circle-plus-outline {
    margin: 50px 0 0 20px;
    font-size: 100px;
    float: left;
    cursor: pointer;
  }
  /*绝对定位，re是相对*/
  .thegood{

    /*position: absolute;*/
    float: left;
  }
  .warning{
    font-size: 10px;
    color: #d30b15;
    float: left;
    height: 11px;
    height: auto;
  }

  #addwork{
    /*margin: 0!important;
    width: 1000px;*/
  }
</style>
