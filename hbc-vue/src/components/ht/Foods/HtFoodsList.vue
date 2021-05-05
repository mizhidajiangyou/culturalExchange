<template>
  <div >
    <div class="foodstop"  >
      <div>
        <div style="min-width: 500px;" >
          <span style="text-align:left;float: left;font-size: 20px; font-weight: initial;">菜品列表:</span>
        </div>
        <div style="position: absolute;right: 0;height:auto;width: 55%;overflow: hidden">
          <div class="foodssearch">
            <el-input
              @keyup.enter.native="searchClick"
              placeholder="通过菜品名称搜索..."
              prefix-icon="el-icon-search"
              size="small"
              style="width: 400px;margin-right: 10px"
              v-model="keywords">
            </el-input>
            <!--type="primary"-->
            <el-button size="small"  icon="el-icon-search" @click="searchClick" round>搜索</el-button>
          </div>
          <div style="float: right;margin-right: 30px;display: flex">
            <el-button size="small"  icon="el-icon-refresh-right" @click="sx" round>刷新</el-button>
          </div>
          <div style="float: right;margin-right: 30px;display: flex">
            <save-foods ref="savefoods" @reflesh="sx"/>
          </div>
          <div>
            <full-text ref="fulltext" @fsx="sx"/>
          </div>
          <div class="clear"/>
        </div>
      </div>
    </div>
    <div class="foodsmain" >
      <el-table
        v-loading="loadfoodstable"
        element-loading-text = "数据正在加载中"
        element-loading-spinner = "el-icon-loading"
        :data="foods.slice((currentPage-1)*pagesize,currentPage*pagesize)"
        style="width: 100%;"
        border>
        <el-table-column
          prop="foodsid"
          label="Id"
          width="80px">
        </el-table-column>
        <el-table-column
          prop="foodsname"
          label="菜品名称"
          width="1140px">
        </el-table-column>
        <el-table-column
          prop="foodsltime"
          label="最后修改时间"
          sortable
          width="180px">
        </el-table-column>
        <el-table-column
          style="text-align: center;"
          min-width="300px"
          fixed="right"
          label="操作"
          width="auto">
          <template slot-scope="scope">
            <el-button
              class="cz"
              type="text">
              移除
            </el-button>
            <el-button
              class="cz"
              @click="openedit(scope)"
              type="text">
              修改
            </el-button>
            <el-button
              class="cz"
              @click="all(scope)"
              type="text">
              详情
            </el-button>
            <el-button
              class="cz"
              @click="make(scope)"
              type="text">
              过程
            </el-button>
            <el-button
              class="cz"
              @click="history(scope)"
              type="text">
              历史
            </el-button>
          </template>

        </el-table-column>
      </el-table>
    </div>



    <div class="foodsfooter">
      <el-pagination
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-size="pagesize"
        :total="foods.length">
      </el-pagination>
     <!-- <span style="position: absolute;left: 35px;bottom: 23px;color:#606266;font-size:13px" >每页有{{pagesize}}条记录</span>-->
    </div>
  </div>



</template>

<script>
    import SaveFoods from "./SaveFoods";
    import FullText from "../FullText";
    export default {
        name: "HTFoodsList",
      components: {FullText, SaveFoods},
      data(){
          return{
            foods:[],
            currentPage: 1,
            pagesize: 20,
            keywords:'',
            loadfoodstable:false,

          }
      },

      mounted(){
          this.loadfoods();
      },
      methods:{
        //刷新
        sx() {
          this.loadfoodstable = true;
          setTimeout(() => {
            this.loadfoods();
            this.loadfoodstable = false;
          }, 1000)

        },

        handleCurrentChange(){
        },
        searchClick(){
        },
        refresh(){
        },
        loadfoods(){
          var _this=this;
          this.$axios.get('/foodsall').then(r=>{
            _this.foods=r.data;
          })
        },
        /*编辑*/
        openedit(scope) {
          this.$refs.savefoods.dialogFormVisible = true;
          this.$refs.savefoods.foodsfrom = scope.row;
          if(scope.row.foodsgood===0){
            this.$refs.savefoods.thegood=false;
            this.$refs.savefoods.thegoodimg=false;
          }else {
            this.$refs.savefoods.thegood=true;
            this.$refs.savefoods.thegoodimg=true;
          }
          /*{
            foodsid:scope.row.foodsid,
            foodsname:scope.row.foodsname,
            foodsjj:scope.row.foodsjj,
            foodsall:scope.row.foodsall,
            foodshistory:scope.row.foodshistory,
            foodsmake:scope.row.foodsmake,
            foodsimg1:scope.row.foodsimg1,
            foodsimg2:scope.row.foodsimg1,
            foodsgood:scope.row.foodsgood,
            foodsftime:scope.row.foodsftime,
            foodsltime:scope.row.foodsltime,
            foodsother: scope.row.foodsother,
          };*/
        },
        //详情
        all(scope){
          this.$refs.fulltext.dialogFormVisible=true;
          this.$refs.fulltext.box=scope.row;
          this.$refs.fulltext.type='foodsall';
          this.$refs.fulltext.title='菜品详情编辑';
          this.$refs.fulltext.text=scope.row.foodsall;
          /* console.log(scope.row.foodsall)*/
        },
        history(scope){
          this.$refs.fulltext.dialogFormVisible=true;
          this.$refs.fulltext.box=scope.row;
          this.$refs.fulltext.type='foodshistory';
          this.$refs.fulltext.title='菜品历史编辑';
          this.$refs.fulltext.text=scope.row.foodshistory;
          /* console.log(scope.row.foodsall)*/
        },

        make(scope){
          this.$refs.fulltext.dialogFormVisible=true;
          this.$refs.fulltext.box=scope.row;
          this.$refs.fulltext.type='foodsmake';
          this.$refs.fulltext.title='菜品制作过程编辑';
          this.$refs.fulltext.text=scope.row.foodsmake;
          /* console.log(scope.row.foodsall)*/
        },
      },

    }
</script>

<style scoped>
  .foodssearch{
    margin-bottom: 30px;
    display: flex;
    justify-content: center;
    align-items: center;
    float: right;
  }
  .foodstop{
    height: 60px;
    overflow: hidden;
    position: relative;
  }
  .foodsfooter{
    margin-top: 10px;
  }
</style>
