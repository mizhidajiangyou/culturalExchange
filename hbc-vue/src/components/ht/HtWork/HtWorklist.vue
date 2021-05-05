<template>

  <div >
    <div style="height: 60px;overflow: hidden;">
      <div style="min-width: 500px;" >
        <span style="text-align:left;float: left;font-size: 20px;font-weight: bold;">后台任务列表</span>
      </div>
      <div style="position: absolute;right: 20px;height:auto;width: 50%;overflow: hidden;">
        <div class="worksearch">
          <el-input
            @keyup.enter.native="searchClick"
            placeholder="通过任务名称搜索..."
            prefix-icon="el-icon-search"
            size="small"
            ref="search"
            style="width: 400px;margin-right: 10px"
            v-model="keywords">
          </el-input>
          <!--type="primary"-->
          <el-button size="small"  icon="el-icon-search" @click="searchClick" round>搜索</el-button>
        </div>
        <div style="float: right;margin-right: 30px">
          <save-work/>
        </div>
        <div>
          <comment-list ref="commentlist" />
        </div>
        <div style="float: right;margin-right: 30px">
          <el-button size="small"  icon="el-icon-refresh-right" @click="refresh" round>刷新</el-button>
        </div>
      </div>
    </div>
    <!--.slice((currentPage-1)*pagesize,currentPage*pagesize)-->
    <el-table
      v-loading="roadworktable"
      :data="work"
      style="width: 100%;"
      border
      default-expand-all
      v-if="worktable"
      height="450">
      <el-table-column
        prop="workid"
        label="Id"
        width="80px">
      </el-table-column>
      <el-table-column
        prop="worktitle"
        label="标题"
        width="800px">
      </el-table-column>
      <el-table-column
        prop="workauthor"
        label="创建人"
        width="100">
      </el-table-column>
      <el-table-column
        prop="workcategory"
        label="类型"
        :sortable="true"
        :filters="filtersworkcategory"
        :filter-method="filterWorkcategory"
        filter-placement="bottom-end"
        width="150">
      </el-table-column>
      <el-table-column
        prop="workstate"
        label="状态"
        :sortable="true"
        :filters="filtersworkstate"
        :filter-method="filterWorkstate"
        filter-placement="bottom-end"
        width="150">
      </el-table-column>
      <el-table-column
        prop="workftime"
        label="创建时间"
        :sortable="true"
        width="200">
      </el-table-column>
      <el-table-column
        prop="workltime"
        label="编辑时间"
        :sortable="true"
        width="200">
      </el-table-column>
      <el-table-column
        style="text-align: center;"
        min-width="140px"
        fixed="right"
        label="操作"
        width="auto">
        <template slot-scope="scope">
          <el-button
            class="cz"
            @click="deleteWork(scope.row.workid)"
            disabled
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
            @click="pinglun(scope)"
            type="text">
            评论
          </el-button>
        </template>

      </el-table-column>


    </el-table>
    <edit-work ref="editwork"/>
    <div style="margin: 30px 0 0 -15px">
      <el-pagination
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-size="pagesize"
        :total="work.length">
      </el-pagination>
      <span style="position: absolute;left: 35px;bottom: 23px;color:#606266;font-size:13px" >每页有{{pagesize}}条记录</span>

    </div>







  </div>

</template>


<script>
    import SaveWork from "./SaveWork";
    import RefreshWork from "./RefreshWork";
    import EditWork from "./EditWork";
    import CommentList from "../Comment/CommentList";
    export default {
        name: "HtWorklist",
      components: {CommentList, EditWork, RefreshWork, SaveWork},
      data() {
        return {

          worktable:true,
          currentPage: 1,
          pagesize: 20,
          keywords:'',
          work:[],
          roadworktable:false,
          listQuery:{
            status:''
          },
          filtersworkcategory:[
            {text:'界面',value:'界面'},
            {text:'接口',value:'接口'},
            {text:'算法',value:'算法'},
            {text:'功能',value:'功能'},
            {text:'数据库',value:'数据库'},
            {text:'测试',value:'测试'},
            {text:'其他',value:'其他'},
            ],
          filtersworkstate:[
            {text:'预置',value:'预置'},
            {text:'进行中',value:'进行中'},
            {text:'已完成',value:'已完成'},
            {text:'暂缓',value:'暂缓'},
            {text:'放弃',value:'放弃'},
            {text:'优先',value:'优先'},
            ]

        }
      },
      mounted() {
          this.roadwork();

      },
      methods: {
        //载入
        roadwork() {
          var _this = this;
          this.$axios
            .get('/workall').then(resp => {
            if (resp && resp.status === 200) {
              _this.work = resp.data;
            }
          })
        },
        //刷新
        refresh() {
          this.roadworktable = true;
          this.roadwork();
          setTimeout(() => {
            this.roadworktable = false;
          }, 500)

        },
        //搜索
        searchClick() {
          var _this = this;
          this.$axios
            .get('/worksearch?keywords=' + this.keywords, {
            }).then(resp => {
            if (resp && resp.status === 200) {
              _this.work = resp.data
            }
          });

        },
        //分页
        handleCurrentChange: function (currentPage) {
          this.currentPage = currentPage;
          console.log(this.currentPage)
        },
        /* //排序workstate
        sortByworkstate(){

        },*/
        //筛选
        filterWorkcategory(value, row) {

          return row.workcategory === value;
        },
        filterWorkstate(value, row) {
          return row.workstate === value;
        },

        //修改
        openedit(scope) {
          this.$refs.editwork.dialogFormVisible = true;
          this.$refs.editwork.Workfrom = scope.row;
          /*{
            workid: scope.row.workid,
            worktitle: scope.row.worktitle,
            workauthor: scope.row.workauthor,
            workall: scope.row.workall,
            workcategory: scope.row.workcategory,
            workstate: scope.row.workstate,
            workaq: scope.row.workaq,
            workftime: scope.row.workftime,
            workltime: scope.row.workltime,
          };*/
        },
        deleteWork(workid) {
          /*console.log(workid)*/
          this.$axios
            .post('/deletework', {workid: workid})
            .then(this.roadwork)
        },
        pinglun(scope) {
          this.loadcomment(scope.row.workid);
          this.$refs.commentlist.dialogFormVisible=true;
        },
        loadcomment(workid){
          var _this=this;
          _this.$axios.get('/getbyworkid', {
            params: {
              workid: workid
            }
          }).then(r=>{
            //console.log(r.data);
            this.$refs.commentlist.workid=workid;
            if(r.data.length>0){
              this.$refs.commentlist.commentlist=r.data;
              this.$refs.commentlist. nocomment=false;
            }
            //console.log( this.$refs.commentlist.commentlist);
          })
        },

      }

    }
</script>

<style scoped>
  .cz{float: left}
  .el-table .cell{padding: 0px;}
  .worksearch{
    margin-bottom: 30px;
    display: flex;
    justify-content: center;
    align-items: center;
    float: right;
  }

</style>
