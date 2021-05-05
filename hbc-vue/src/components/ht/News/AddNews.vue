<template>
  <div>
   <!-- type="primary"-->
    <el-button size="small"  icon="el-icon-circle-plus-outline" @click="openadd" round>添加</el-button>
    <el-dialog
      style="min-width: 750px"
      title="添加资讯"
      :visible.sync="dialogFormVisible"
      @close="clear">
     <!-- @change="timechange"-->
      <el-form ref="form" :model="Addnewsfrom" label-width="80px" >
        <el-form-item label="资讯标题">
          <el-input
            @blur="validatornewstitle"
            v-model="Addnewsfrom.newstitle"
            placeholder="请输入标题不超过100字"/>
          <a class="warning" v-show="titlenull">标题不能为空</a>
        </el-form-item>
        <el-form-item label="资讯简介">
          <el-input v-model="Addnewsfrom.newsjj" placeholder="请输入资讯简介不超过250字"/>
        </el-form-item>
        <el-form-item label="资讯关键字">
          <el-input v-model="Addnewsfrom.newskeyword" placeholder="请输入资讯关键字不超过50字"/>
        </el-form-item>
        <el-form-item label="资讯详情">
          <el-input type="textarea" :rows="15" autocomplete="off" v-model="Addnewsfrom.newsall" placeholder="请输入资讯详情"/>
        </el-form-item>
        <!--:label-width="formLabelWidth"-->
        <el-form-item label="资讯图片"  prop="newsimg1">
          <el-input v-model="Addnewsfrom.newsimg1" autocomplete="off" ref="p1url" v-show="false" placeholder="图片 URL"/>
          <img-upload @onUpload="uploadImg" ref="imgUpload"/>
        </el-form-item>
        <el-form-item  label="推荐" >
          <el-switch class="thegood" v-model="thegood" @change="showgood"/>
        </el-form-item>
        <el-form-item label="推荐选项" v-show="thegoodimg">
          <el-select  @change="changegood" v-model="value"  placeholder="请选择" style="float: left"  ref="goodselect">
            <el-option
              v-for="item in options"
              :key="item.id"
              :label="item.label"
              :value="item.id">
            </el-option>
          </el-select>
        </el-form-item>
        <el-form-item label="推荐值"  v-show="false" prop="goodnews">
          <el-input v-model="Addnewsfrom.newsgood" autocomplete="off" placeholder="推荐值"/>
        </el-form-item>
        <el-form-item label="推荐图片"  prop="newsimg2" v-show="thegoodimg">
          <el-input v-model="Addnewsfrom.newsimg2" autocomplete="off" v-show="false" placeholder="推荐图片 URL"/>
          <img-upload @onUpload="uploadImg2" ref="imgUpload2"/>
        </el-form-item>
        <el-form-item label="创建时间"  prop="newsftime" v-show="newsftime=false">
          <el-input v-model="Addnewsfrom.newsftime" autocomplete="off" placeholder="创建时间"/>
        </el-form-item>
        <el-form-item label="修改时间"  prop="newsltime" v-show="newsltime=false">
          <el-input v-model="Addnewsfrom.newsltime" autocomplete="off" placeholder="修改时间"/>
        </el-form-item>
        <el-form-item prop="id" style="height: 0">
          <el-input type="hidden" v-model="Addnewsfrom.newsid" autocomplete="off"/>
        </el-form-item>
        <el-form-item>
          <el-button type="primary" v-on:click="addnews">立即创建</el-button>
          <el-button @click="dialogFormVisible = false">取 消</el-button>
        </el-form-item>
      </el-form>
    </el-dialog>
  </div>
</template>

<script>
  import ImgUpload from "../ImgUpload";
  export default {

    name: "AddNews",
    components: {ImgUpload},
    data() {
      return {
        dialogFormVisible: false,
        Addnewsfrom: {
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
        },
        options: [
          {id:0,label:'默认推荐',good:1},
          {id:1,label:'头条推荐',good:99},
          {id:2,label:'上部推荐',good:2},
          {id:3,label:'下部推荐',good:3},
          {id:4,label:'轮播推荐',good:4}
        ],
        value: '默认推荐',
        newsftime: true, //创建时间列表不显示
        newsltime: true,//修改不显示
        thegood:false,
        thegoodimg:false,
        titlenull:false,   //验证标题为空的提示
        responseResult: [],
      }
    },

    methods: {

      openadd(){
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
      },
      clear () {
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
        this.$refs.imgUpload2.fileList=[];
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

        /*console.log(obj.name);//我这边的name就是对应label的
        console.log(obj.id);*/
      },
      uploadImg () {
        this.Addnewsfrom.newsimg1=this.$refs.imgUpload.url
      },
      uploadImg2 () {
        this.Addnewsfrom.newsimg2=this.$refs.imgUpload2.url
      },
      addnews(){
        if(!this.Addnewsfrom.newstitle){
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
          this.Addnewsfrom.newsftime=yy+'-'+mm+'-'+dd+' '+hh+':'+mf+':'+ss;
          this.Addnewsfrom.newsltime=yy+'-'+mm+'-'+dd+' '+hh+':'+mf+':'+ss;
          var _this = this;
          this.$axios
            .post('/addnews', {                                   //这里写的是接口url
              newstitle: this.Addnewsfrom.newstitle,
              newsimg1:this.Addnewsfrom.newsimg1,
              newsimg2:this.Addnewsfrom.newsimg2,
              newsjj:this.Addnewsfrom.newsjj,
              newsall:this.Addnewsfrom.newsall,
              newskeyword:this.Addnewsfrom.newskeyword,
              newsother:this.Addnewsfrom.newsother,
              newsgood:this.Addnewsfrom.newsgood,
              newsftime:this.Addnewsfrom.newsftime,
              newsltime:this.Addnewsfrom.newsltime,
            })
            .then(successResponse => {
              if (successResponse.data.code === 200) {
                //this.$router.replace({path: '/htindex'})
                alert("添加成功");
                this.dialogFormVisible=false;
                /*this.loadNews();*/
                location.reload();
              }
              else if (successResponse.data.code === 500) {
                alert("失败");
                this.dialogFormVisible=false;
              }
            })
            .catch(failResponse => {
            })
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
</style>
