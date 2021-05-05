<template>
    <div>
      <!--导航栏-->
      <!--<Menu></Menu>-->
      <Menu style="min-width: 2000px"/>
      <router-view/>
    </div>
</template>

<script>
    import Menu from './Menu'
    export default {
        name: "Home",
      components:{Menu}
    }
</script>

<style scoped>

</style>
