<template>
  <div class="save">
    <el-button size="small"  icon="el-icon-circle-plus-outline" @click="openfoods" round>添加</el-button>
    <el-dialog
      customClass="addfoods"
      title="保存菜品"
      :visible.sync="dialogFormVisible"
      id="addfoods"
      @close="clear">
      <el-form ref="form" :model="foodsfrom" label-width="80px"  >
        <el-form-item label="名称：" >
          <el-input v-model="foodsfrom.foodsname" placeholder="请输入不超过20字"/>
        </el-form-item>
        <el-form-item label="简介：">
          <el-input v-model="foodsfrom.foodsjj" placeholder="请输入不超过100字"/>
        </el-form-item>
        <el-form-item label="详情：" >
          <el-input type="textarea"  :rows="5" v-model="foodsfrom.foodsall" placeholder="请输入菜品详情" />
        </el-form-item>
        <el-form-item label="过程：" >
          <el-input type="textarea"  :rows="5" v-model="foodsfrom.foodsmake"  placeholder="请输入菜品制作过程" />
        </el-form-item>
        <el-form-item label="历史：" >
          <el-input type="textarea"  :rows="5" v-model="foodsfrom.foodshistory"   placeholder="请输入菜品历史"/>
        </el-form-item>
        <el-form-item label="资讯图片"  prop="newsimg1">
          <el-input v-model="foodsfrom.foodsimg1" autocomplete="off" ref="p1url"  placeholder="图片 URL"/>
          <div class="block">
            <el-image :src=foodsfrom.foodsimg1 style="width: 80%;height: 80%;margin-top: 10px; ">
              <div slot="error" class="image-slot">
                <i class="el-icon-picture-outline"/>
              </div>
            </el-image>
          </div>
          <img-upload @onUpload="uploadImg" ref="imgUpload"/>
        </el-form-item>
        <el-form-item label="链接：">
          <el-input v-model="foodsfrom.foodsother" ref="foodsother"  placeholder="请输入相关链接，不超过100字"/>
        </el-form-item>
        <el-form-item  label="推荐：" >
          <el-switch class="g1" v-model="thegood" @change="showgood"/>
          <el-input v-model="foodsfrom.foodsgood" autocomplete="off" v-show="false" placeholder="推荐值"/>
        </el-form-item>
        <div v-if="thegoodimg" v-show="thegood">
          <el-form-item label="资讯图片"  prop="newsimg2">
            <el-input v-model="foodsfrom.foodsimg2" autocomplete="off" ref="p1url"  placeholder="图片 URL"/>
            <div class="block">
              <el-image :src=foodsfrom.foodsimg2 style="width: 80%;height: 80%;margin-top: 10px; ">
                <div slot="error" class="image-slot">
                  <i class="el-icon-picture-outline"/>
                </div>
              </el-image>
            </div>
            <img-upload @onUpload="uploadImg2" ref="imgUpload2"/>
          </el-form-item>
        </div>
        <el-form-item prop="id" style="height: 0">
          <el-input type="hidden" v-model="foodsfrom.foodsid" autocomplete="off"/>
        </el-form-item>

        <el-form-item>
          <el-button type="primary" v-on:click="savefoods">保存</el-button>
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

    name: "SaveFoods",
    components: {ImgUpload},
    data() {
      return {
        dialogFormVisible: false,
        user:{
          username:store.state.user.username,
        },
        foodsfrom: {
          foodsid:'',
          foodsname:'',
          foodsjj:'',
          foodsall:'',
          foodshistory:'',
          foodsmake:'',
          foodsimg1:'',
          foodsimg2:'',
          foodsgood:0,
          foodsftime:'',
          foodsltime:'',
          foodsother: '',
        },

        thegood:false,
        thegoodimg:false,
        titlenull:false,   //验证标题为空的提示
        responseResult: [],
      }
    },

    methods: {

      openfoods(){ this.dialogFormVisible = true;},
      clear () {
        this.foodsfrom = {
          foodsid:'',
          foodsname:'',
          foodsjj:'',
          foodsall:'',
          foodshistory:'',
          foodsmake:'',
          foodsimg1:'',
          foodsimg2:'',
          foodsgood:0,
          foodsftime:'',
          foodsltime:'',
          foodsother: '',
        };
        this.$refs.imgUpload.url='';
        this.$refs.imgUpload2.url='';
        this.$refs.imgUpload.fileList=[];
        this.$refs.imgUpload2.fileList=[];
        this.thegood=false;


      },

      savefoods(){

        if(!this.foodsfrom.foodsname){
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
          if(this.foodsfrom.foodsftime===''||this.foodsfrom.foodsid===''){
            this.foodsfrom.foodsftime=yy+'-'+mm+'-'+dd+' '+hh+':'+mf+':'+ss;
          }
          this.foodsfrom.foodsltime=yy+'-'+mm+'-'+dd+' '+hh+':'+mf+':'+ss;
          var _this = this;
          this.$axios
            .post('/savefoods', {                                   //这里写的是接口url
              foodsid:this.foodsfrom.foodsid,
              foodsname:this.foodsfrom.foodsname,
              foodsjj:this.foodsfrom.foodsjj,
              foodsall:this.foodsfrom.foodsall,
              foodshistory:this.foodsfrom.foodshistory,
              foodsmake:this.foodsfrom.foodsmake,
              foodsimg1:this.foodsfrom.foodsimg1,
              foodsimg2:this.foodsfrom.foodsimg2,
              foodsgood:this.foodsfrom.foodsgood,
              foodsftime:this.foodsfrom.foodsftime,
              foodsltime:this.foodsfrom.foodsltime,
              foodsother: this.foodsfrom.foodsother,
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
        }
      },
      uploadImg(){
        this.foodsfrom.foodsimg1=this.$refs.imgUpload.url;
      },
      uploadImg2(){
        this.foodsfrom.foodsimg2=this.$refs.imgUpload2.url;
      },
      showgood(){
        this.thegoodimg=this.thegood;
        if(this.thegood===false){
          this.foodsfrom.foodsgood=0;
        }else {
          this.foodsfrom.foodsgood=1;
        }
      }
    }
  }
</script>

<style scoped>


  #addfoods{
    /*margin: 0!important;
    width: 1000px;*/
  }
  .g1{
    position: absolute;
    left: 0;
    top: 10px;
    z-index: 5;
  }
</style>
