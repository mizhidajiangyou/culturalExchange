<template>
  <div >
    <div class="feedbacktop"  >
      <div>
        <div style="min-width: 500px;" >
          <span style="text-align:left;float: left;font-size: 20px; font-weight: initial;">反馈列表:</span>
        </div>
        <div style="position: absolute;right: 0;height:auto;width: 45%;overflow: hidden">
          <div class="feedbacksearch">
            <el-input
              @keyup.enter.native="searchClick"
              placeholder="通过反馈名称搜索..."
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
          <save-feedback :power="power"   @reflesh="sx" ref="savefeedback"/>
          </div>
          <div class="clear"/>
        </div>
      </div>
    </div>
    <div class="feedbackmain" >
      <el-table
        v-loading="load"
        :data="feedback.slice((currentPage-1)*pagesize,currentPage*pagesize)"
        style="width: 100%;"
        border
        v-if="!loadfeedbacktable">
        <el-table-column
          prop="feedbackid"
          label="Id"
          width="80px">
        </el-table-column>
        <el-table-column
          prop="feedbacktitle"
          label="反馈标题"
          width="920px">
        </el-table-column>
        <el-table-column
          prop="feedbacklike"
          label="当前获赞数"
          sortable
          width="140px">
        </el-table-column>
        <el-table-column
          prop="feedbackstate"
          label="当前状态"
          sortable
          width="130px">
        </el-table-column>
        <el-table-column
          prop="feedbackftime"
          label="创建时间"
          sortable
          width="200px">
        </el-table-column>
        <el-table-column
          prop="feedbackltime"
          label="修改时间"
          sortable
          width="200px">
        </el-table-column>
        <el-table-column
          style="text-align: center;"
          min-width="200px"
          fixed="right"
          label="操作"
          width="auto">
          <template slot-scope="scope">
            <el-button
              class="cz"
              v-if="power"
              type="text">
              移除
            </el-button>
            <el-button
              class="cz"
              @click="back1(scope)"
              type="text">
              回复
            </el-button>
            <el-button
              class="cz"
              v-if="power"
              @click="back2(scope)"
              type="text">
              修改反馈
            </el-button>
          </template>

        </el-table-column>
      </el-table>
    </div>


    <div class="feedbackfooter">
      <el-pagination
        @current-change="handleCurrentChange"
        :current-page="currentPage"
        :page-size="pagesize"
        :total="feedback.length">
      </el-pagination>
      <!-- <span style="position: absolute;left: 35px;bottom: 23px;color:#606266;font-size:13px" >每页有{{pagesize}}条记录</span>-->
    </div>
  </div>



</template>

<script>
  import store from '../../../store';
  import SaveFeedback from "./SaveFeedback";
  export default {
    name: "HTFeedbackList",
    components: {SaveFeedback},
    data(){
      return{
        load:false,
        feedback:[],
        currentPage: 1,
        pagesize: 20,
        keywords:'',
        loadfeedbacktable:false,
        power:false,


      }
    },
    mounted(){
      this.loadfeedback();
      this.userpower();
    },
    methods:{
      handleCurrentChange(){
      },
      searchClick(){
      },
      refresh(){
      },

      sx(){
        this.load=true;
        setTimeout(()=>{
          this.loadfeedback();this.load=false;},500)
      },


      loadfeedback(){
        var _this=this;
        this.$axios.get('/feedbackall').then(r=>{
          _this.feedback=r.data;
          this.feedback.forEach(item => {
            if(item.feedbackftime===item.feedbackltime)
            {
              this.$set(item, 'feedbackstate', '待回复')
              //console.log(item)
            }else {
              this.$set(item, 'feedbackstate', '已回复')
              //console.log(item)
            }
          });
        })
      },

      //权限调用
      userpower(){
        var _this=this;
        this.$axios.post('/getuserpower', {
          username:store.state.user.username,
        }).then(r=>{
          if(r.data>0){
            _this.power=true;
          }
        })
      },

      //回复
      back1(scope){
        this.$refs.savefeedback.dialogFormVisible=true;
        this.$refs.savefeedback.users=true;
        this.$refs.savefeedback.title="回复反馈";
        /*this.$refs.savefeedback.title="test"*/
        this.$refs.savefeedback.feedbackfrom=scope.row;
      },
      back2(scope){
        this.$refs.savefeedback.dialogFormVisible=true;
        this.$refs.savefeedback.users=false;
        this.$refs.savefeedback.title="修改反馈";
        this.$refs.savefeedback.feedbackfrom=scope.row;

      },
    },


  }
</script>

<style scoped>
  .feedbacksearch{
    margin-bottom: 30px;
    display: flex;
    justify-content: center;
    align-items: center;
    float: right;
  }
  .feedbacktop{
    height: 60px;
    overflow: hidden;
    position: relative;
  }
  .feedbackfooter{
    margin-top: 10px;
  }
</style>
