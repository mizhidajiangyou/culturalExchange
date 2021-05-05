<template>
  <div>
    <div>
      <el-dialog
        customClass="fulltext"
        :title="title"
        :visible.sync="dialogFormVisible"
        id="fulltext"
        width="1500px"


      ><!--@close="clear"-->
        <el-card style="height: 610px;width: 100%">
          <quill-editor v-model="text" ref="myQuillEditor" style="height: 500px;" :options="editorOption">
            <!-- 自定义toolar -->
            <div id="toolbar" slot="toolbar">
              <!-- Add a bold button -->
              <button class="ql-bold" title="加粗">Bold</button>
              <button class="ql-italic" title="斜体">Italic</button>
              <button class="ql-underline" title="下划线">underline</button>
              <button class="ql-strike" title="删除线">strike</button>
              <button class="ql-blockquote" title="引用"/>
              <button class="ql-code-block" title="代码"/>
              <button class="ql-header" value="1" title="标题1"/>
              <button class="ql-header" value="2" title="标题2"/>
              <!--Add list -->
              <button class="ql-list" value="ordered" title="有序列表"/>
              <button class="ql-list" value="bullet" title="无序列表"/>
              <!-- Add font size dropdown -->
              <select class="ql-header" title="段落格式">
                <option selected>段落</option>
                <option value="1">标题1</option>
                <option value="2">标题2</option>
                <option value="3">标题3</option>
                <option value="4">标题4</option>
                <option value="5">标题5</option>
                <option value="6">标题6</option>
              </select>
              <select class="ql-size" title="字体大小">
                <option value="16px">16px</option>
                <option value="18px" selected>18px</option>
                <option value="20px">20px</option>
                <option value="22px" >22px</option>
                <option value="24px">24px</option>
                <option value="26px">26px</option>
              </select>
              <select class="ql-font" title="字体">
                <option value="SimSun">宋体</option>
                <option value="SimHei">黑体</option>
                <option value="Microsoft-YaHei">微软雅黑</option>
                <option value="KaiTi">楷体</option>
                <option value="FangSong">仿宋</option>
                <option value="Arial">Arial</option>
              </select>
              <!-- Add subscript and superscript buttons -->
              <select class="ql-color" value="color" title="字体颜色"/>
              <select class="ql-background" value="background" title="背景颜色"/>
              <select class="ql-align" value="align" title="对齐"/>
              <button class="ql-clean" title="还原"/>
              <!-- You can also add your own -->
            </div>
          </quill-editor>



        </el-card>
        <div style="margin: 20px 0 ">
          <el-button type="primary" @click="tj">保存</el-button>
          <el-button @click="dialogFormVisible = false">取 消</el-button>
        </div>


      </el-dialog>

    </div>

  </div>

</template>

<script>

  import { Quill, quillEditor } from 'vue-quill-editor'
  import 'quill/dist/quill.core.css'
  import 'quill/dist/quill.snow.css'
  import 'quill/dist/quill.bubble.css'
  import './font.css'

  // 自定义字体大小
  let Size = Quill.import('attributors/style/size');
  Size.whitelist = ['16px', '18px', '20px', '22px', '24px', '26px'];
  Quill.register(Size, true);
  // 自定义字体类型
  var fonts = ['SimSun', 'SimHei', 'Microsoft-YaHei', 'KaiTi', 'FangSong', 'Arial', 'Times-New-Roman', 'sans-serif',
    '宋体', '黑体'
  ];
  var Font = Quill.import('formats/font');
  Font.whitelist = fonts;
  Quill.register(Font, true);


  export default {

    /**
     *直接用ref传值，props暂不需要
     */
   /* props:{
      title:{
        type:String,
        default:'富文本'
      },
      type:{
        type:String,
        default:'news'
      },
      box:{
        type:Object,
        required:true,
      }
    },*/
    name: 'FullText',
    components: {
      quillEditor
    },

    data() {
      return {
        title:'富文本',
        box:{},
        type:'news',
        text:'',
        time:'',
        dialogFormVisible: false,
        content: null,
        editorOption: {
          placeholder: "请输入",
          theme: "snow", // or 'bubble'
          modules: {
            toolbar: {
              container: '#toolbar'
            }
          }
        },
      };
    },
    created() {},
    mounted() {

     /* Object.assign({},this.box)
      this.test();*/

    },
    methods: {
      test(){
       /* JSON.parse(JSON.stringify(this.box));*/
        /*this.fbox= JSON.parse(JSON.stringify(this.box));*/
        console.log(this.box);
       /* console.log(this.fbox);*/
        console.log(this.box.newsall);
        this.text=this.box.newsall;
      },
      /**
       *懒得重写接口save只能全部保存，有空再优化
       */
      tj(){
        var ndate=new Date();
        let yy = ndate.getFullYear();
        let mm = ndate.getMonth()+1;
        let dd = ndate.getDate();
        let hh = ndate.getHours();
        let mf = ndate.getMinutes()<10 ? '0'+ndate.getMinutes() : ndate.getMinutes();
        let ss = ndate.getSeconds()<10 ? '0'+ndate.getSeconds() : ndate.getSeconds();
        this.time=yy+'-'+mm+'-'+dd+' '+hh+':'+mf+':'+ss; /*仅修改修改时间*/
        switch (this.type) {
          case  'news':{this.news();break;}
          case  'foodsall':{this.foodsall(); break;}
          case  'foodshistory':{this.foodshistory(); break;}
          case  'foodsmake':{this.foodsmake(); break;}
          default:{alert("notype");break;}
        }

      },

      //资讯
      news(){
        var _this = this;
        this.$axios
          .post('/addnews', {                                   //这里写的是接口url
            newsid: this.box.newsid,
            newstitle: this.box.newstitle,
            newsimg1:this.box.newsimg1,
            newsimg2:this.box.newsimg2,
            newsjj:this.box.newsjj,
            newsall:this.text,
            newskeyword:this.box.newskeyword,
            newsother:this.box.newsother,
            newsgood:this.box.newsgood,
            newsftime:this.box.newsftime,
            newsltime:this.time,
          })
          .then(successResponse => {
            if (successResponse.data.code === 200) {
              //this.$router.replace({path: '/htindex'})
              alert("添加成功");
              this.dialogFormVisible=false;
             /* location.reload();*/
            }
            else if (successResponse.data.code === 500) {
              alert("失败");
              this.dialogFormVisible=false;
            }
          })
          .catch(failResponse => {
          });
        this.$emit('fsx');
      },

      //菜品详情
      foodsall(){
        this.$axios
          .post('/savefoods', {                                   //这里写的是接口url
            foodsid:this.box.foodsid,
            foodsname:this.box.foodsname,
            foodsjj:this.box.foodsjj,
            foodsall:this.text,
            foodshistory:this.box.foodshistory,
            foodsmake:this.box.foodsmake,
            foodsimg1:this.box.foodsimg1,
            foodsimg2:this.box.foodsimg2,
            foodsgood:this.box.foodsgood,
            foodsftime:this.box.foodsftime,
            foodsltime:this.time,
            foodsother: this.box.foodsother,
          })
          .then(successResponse => {
            if (successResponse.data.code === 200) {
              alert("保存成功");
              this.dialogFormVisible=false;
            }
            else if (successResponse.data.code === 500) {
              alert("失败");
              this.dialogFormVisible=false;
            }
          })
          .catch(failResponse => {
          });
        this.$emit('fsx');
      },

      //菜品历史
      foodshistory(){
        this.$axios
          .post('/savefoods', {                                   //这里写的是接口url
            foodsid:this.box.foodsid,
            foodsname:this.box.foodsname,
            foodsjj:this.box.foodsjj,
            foodsall:this.box.foodsall,
            foodshistory:this.text,
            foodsmake:this.box.foodsmake,
            foodsimg1:this.box.foodsimg1,
            foodsimg2:this.box.foodsimg2,
            foodsgood:this.box.foodsgood,
            foodsftime:this.box.foodsftime,
            foodsltime:this.time,
            foodsother: this.box.foodsother,
          })
          .then(successResponse => {
            if (successResponse.data.code === 200) {
              alert("保存成功");
              this.dialogFormVisible=false;
            }
            else if (successResponse.data.code === 500) {
              alert("失败");
              this.dialogFormVisible=false;
            }
          })
          .catch(failResponse => {
          });
        this.$emit('fsx');
      },

      //菜品过程
      foodsmake(){
        this.$axios
          .post('/savefoods', {                                   //这里写的是接口url
            foodsid:this.box.foodsid,
            foodsname:this.box.foodsname,
            foodsjj:this.box.foodsjj,
            foodsall:this.box.foodsall,
            foodshistory:this.box.foodshistory,
            foodsmake:this.text,
            foodsimg1:this.box.foodsimg1,
            foodsimg2:this.box.foodsimg2,
            foodsgood:this.box.foodsgood,
            foodsftime:this.box.foodsftime,
            foodsltime:this.time,
            foodsother: this.box.foodsother,
          })
          .then(successResponse => {
            if (successResponse.data.code === 200) {
              alert("保存成功");
              this.dialogFormVisible=false;
            }
            else if (successResponse.data.code === 500) {
              alert("失败");
              this.dialogFormVisible=false;
            }
          })
          .catch(failResponse => {
          });
        this.$emit('fsx');
      },



    }

  };
</script>

<style>

  #fulltext{
    margin: 0;
  }

  .ql-container {
    box-sizing: border-box;
    font-family: Helvetica, Arial, sans-serif;
    font-size: 18px!important;
    height: 100%;
    margin: 0;
    position: relative;
  }


</style>

