<template>
  <div style="display: flex;margin: 5px; text-align: left;">
    <div class="feedbackbox">
      <a>近期提交反馈:</a>
      <qtnewfeedback class="f_box"/>
    </div>
    <div class="feedbackbox">
      <a>高评价反馈:</a>
      <qtnewfeedback class="f_box"/>
    </div>
    <div class="feedbackbox">
      <a>近期处理反馈:</a>
      <qtnewfeedback class="f_box"/>
    </div>
    <div class="feedbackbox">
      <a>值得推荐反馈:</a>
      <qtnewfeedback class="f_box"/>
    </div>
  </div>

</template>

<script>
    import Qtnewfeedback from "./Qtnewfeedback";
    export default {
        name: "QtFeedbackGood",
      components: {Qtnewfeedback}
    }
</script>

<style scoped>
  .feedbackbox{
    margin: 5px 5px 3px 3px;
    padding: 5px;
    min-width: 25%;
  }
  .feedbackbox a{
    font-size: 17px;
    font-weight: 600;
  }

  .f_box{
    margin-left: 15px;
   /* width: 200px;*/



  }

</style>
