<template>
   <div>
     <div style="margin: 20px">
       <h-t-feedback-list/>
     </div>

   </div>
</template>

<script>
    import HTFeedbackList from "./Feedback/HtFeedbackList";
    export default {
      props:{

      },
        name: "FeedbackGL",
      components: {HTFeedbackList}
    }
</script>

<style scoped>

</style>
