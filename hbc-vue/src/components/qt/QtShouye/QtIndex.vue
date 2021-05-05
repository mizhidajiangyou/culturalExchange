<template>
  <div>
    <qt-toplunbo/>
    <qt-indexlist/>
    <qt-toplunbo style="margin: 100px 0 -45px 0"/>
  </div>

</template>

<script>
    import QtIndexlist from "./QtIndexlist";
    import QtToplunbo from "./QtToplunbo";
    export default {
        name: "QtIndex",
      components: {QtToplunbo, QtIndexlist}
    }
</script>

<style scoped>
/*.toplunbo{
  height: 20px;
}*/
</style>
