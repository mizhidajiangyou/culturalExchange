<template>

  <div style="min-width: 1000px">
    <!--<H1>这是首页</H1>-->
    <QtTop/>
    <QtMenu/>
    <router-view/>
    <!--<qt-toplunbo></qt-toplunbo>-->
    <div class="clear" style="height: 50px"> </div>
    <QtYedishengming/>
  </div>

</template>

<script>
    import QtYedishengming from "./QtYedishengming";
    import QtTop from "./QtTop";
    import QtToplunbo from "./QtShouye/QtToplunbo";
    import QtMenu from "./QtMenu";
    export default {
        name: "QtHome",
      components: {QtMenu, QtToplunbo, QtTop, QtYedishengming},
      mounted() {
          this.look();
      },
      methods:{
        look(){
          console.log("作者ZTX，如有疑问，联系QQ10000")
        }
      }


    }
</script>

<style scoped>

</style>
