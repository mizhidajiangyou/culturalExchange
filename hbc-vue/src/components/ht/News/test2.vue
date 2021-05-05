<template>
    <div>
      <input v-model="t1"/>
      {{t2}}
      <input v-model="t1"/>
      <button @click="test1">test</button>
    </div>
</template>

<script>
    export default {
        name: "test2",
      data(){
          return{
            t1:'123',
            t2:'234'
          }
      },
      methods:{
        test1(){
          this.$emit('tt');
          console.log(this.t1+'and '+this.t2);
          this.t1=this.t2;


        }
      },
    }
</script>

<style scoped>

</style>
