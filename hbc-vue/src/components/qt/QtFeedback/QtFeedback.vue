<template>
  <div>
    <div style="margin: 20px 200px 0 200px;padding-left:30px;text-align: left">
      <span style="font-size: 22px;font-weight: 800">当前位置</span>&nbsp;
      <a style="font-size: 18px;font-weight: 500">反馈&nbsp;>&nbsp;反馈列表</a>
    </div>
    <div style="float: left;margin: -50px 0 0 1px;text-align:left;padding: 20px;min-height: 1140px;max-width:180px;box-shadow: 0 0  10px #cac6c6;">
      <i class="el-icon-s-unfold" v-show="!side" style="font-size: 30px" @click="sidechange"/>
      <i class="  el-icon-s-comment" v-show="side" style="font-size: 30px;text-align: right" @click="opensavefeedback"/>
      <i class="el-icon-s-fold" v-show="side" style="font-size: 30px;text-align: right" @click="sidechange"/>
      <div v-show="side">
        <p style="font-size: 12px;margin-bottom: 30px">点击此处反馈建议</p>
        <save-feedback :power=false  style="text-align: center"  ref="savefeedback"/>  <!--@reflesh="sx"-->
        <div style="min-height: 250px">
          <a style="  font-size: 16px;font-weight: 600;">近期提交反馈:</a>
          <qtnewfeedback style="width: 180px; font-size: 15px;" />
        </div>

        <div style="min-height: 250px">
          <a style="  font-size: 16px;font-weight: 600;">近期提交反馈:</a>
          <qtnewfeedback style="width: 180px; font-size: 15px;" />
        </div>
        <div style="min-height: 250px">
          <a style="  font-size: 16px;font-weight: 600;">近期提交反馈:</a>
          <qtnewfeedback style="width: 180px; font-size: 15px;" />
        </div>
        <div >
          <a style="  font-size: 16px;font-weight: 600;">近期提交反馈:</a>
          <qtnewfeedback style="width: 180px; font-size: 15px;" />
        </div>
      </div>

    </div>
   <!-- <qt-feedback-good/>-->
    <div >

      <div style="margin: 10px 200px">
        <qt-feedbacklist style="padding: 20px"/>
      </div>
    </div>


  </div>
</template>

<script>
    import QtFeedbacklist from "./QtFeedbacklist";
    import QtFeedbackGood from "../QtShouye/QtFeedbackGood";
    import Qtnewfeedback from "../QtShouye/Qtnewfeedback";
    import SearchNews from "../../ht/News/SearchNews";
    import SaveFeedback from "../../ht/Feedback/SaveFeedback";
    export default {
        name: "QtFeedback",
      components: {SaveFeedback, SearchNews, Qtnewfeedback, QtFeedbackGood, QtFeedbacklist},
      data(){
          return{
            side:true,
          }
      },
      methods:{
          sidechange(){
            this.side=!this.side
          },
        opensavefeedback(){
          this.$refs.savefeedback.dialogFormVisible=true;
          this.$refs.savefeedback.title="反馈建议";
          this.$refs.savefeedback.users=false;
        }
      }

    }
</script>

<style scoped>

</style>
