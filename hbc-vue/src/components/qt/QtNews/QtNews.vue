<template>
  <div>
    <div style="margin: 20px 200px 0 200px;padding-left:28px;text-align: left">
      <span style="font-size: 22px;font-weight: 800">当前位置</span>&nbsp;
      <a style="font-size: 18px;font-weight: 500">资讯&nbsp;>&nbsp;资讯列表</a>
    </div>
    <div style="margin: 30px 200px">
      <qt-news-list style="padding: 20px"/>
    </div>
  </div>

</template>

<script>
    import QtNewsList from "./QtNewslist";
    export default {
        name: "QtNews",
      components: {QtNewsList}
    }
</script>

<style scoped>

</style>
