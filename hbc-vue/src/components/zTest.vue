<template>
  <div >
    <div v-if=this.look>
      <p  >{{this.show}}  </p>
      <button @click="click1">{{this.case1}}</button>
      <button @click="click2">{{this.case2}}</button>
      <button @click="click3">{{this.case3}}</button>
      <button @click="click4">{{this.case4}}</button>
      <button @click="click5">{{this.case5}}</button>
    </div>
    <div v-if=!this.look>
      <h1>test</h1>
    </div>

  </div>
</template>

<script>


  export default {
    name: "zTest",
    data() {
      return {
        testbox: [],
        mil : {},
        show : "",
        case1 : "",
        case2 : "",
        case3 : "",
        case4 : "",
        case5 : "",
        sum : 0,
        i : 0,
        look : true,

      }
    },
    mounted() {
      this.testboxload()
    },
    methods:{
      testboxload() {
        this.testbox[0]= {"title": "外貌", "c1":"丑", "c2":"一般", "c3":"还不错", "c4":"是我喜欢的类型","c5":"惊艳","power": 5};
        this.testbox[1]= {"title": "身材", "c1":"胖得离谱", "c2":"胖", "c3":"一般", "c4":"不错","c5":"完美身材","power": 5};
        this.testbox[2]= {"title": "经济", "c1":"不独立", "c2":"月光", "c3":"能余留一些", "c4":"略富裕","c5":"求包养","power": 20};
        this.testbox[3]= {"title": "性格", "c1":"差", "c2":"无感", "c3":"还不错", "c4":"很好","c5":"我喜欢","power": 10};
        this.testbox[4]= {"title": "孝顺", "c1":"差", "c2":"从不关注", "c3":"一般", "c4":"孝顺","c5":"很孝顺","power": 10};
        this.testbox[5]= {"title": "爱好", "c1":"话不投机", "c2":"各玩各的", "c3":"有1至2个共同爱好", "c4":"很多","c5":"可以为了对方增加/放弃","power": 10};
        this.testbox[6]= {"title": "礼貌", "c1":"无", "c2":"不太注意", "c3":"一般", "c4":"有礼貌","c5":"互相尊重","power": 10};
        this.testbox[7]= {"title": "test3", "c1":"t1", "c2":"t2", "c3":"t3", "c4":"t4","c5":"t5","power": 4};
        this.testbox[8]= {"title": "test3", "c1":"t1", "c2":"t2", "c3":"t3", "c4":"t4","c5":"t5","power": 4};
        this.testbox[9]= {"title": "test3", "c1":"t1", "c2":"t2", "c3":"t3", "c4":"t4","c5":"t5","power": 4};
        this.testbox[10]= {"title": "test3", "c1":"t1", "c2":"t2", "c3":"t3", "c4":"t4","c5":"t5","power": 4};
        this.testbox[11]= {"title": "test3", "c1":"t1", "c2":"t2", "c3":"t3", "c4":"t4","c5":"t5","power": 4};
        this.testbox[12]= {"title": "test3", "c1":"t1", "c2":"t2", "c3":"t3", "c4":"t4","c5":"t5","power": 4};
        this.testbox[13]= {"title": "test3", "c1":"t1", "c2":"t2", "c3":"t3", "c4":"t4","c5":"t5","power": 4};
        this.testbox[14]= {"title": "test3", "c1":"t1", "c2":"t2", "c3":"t3", "c4":"t4","c5":"t5","power": 4};
        this.testbox[15]= {"title": "test3", "c1":"t1", "c2":"t2", "c3":"t3", "c4":"t4","c5":"t5","power": 4};
        this.testbox[16]= {"title": "test3", "c1":"t1", "c2":"t2", "c3":"t3", "c4":"t4","c5":"t5","power": 4};
        this.testbox[17]= {"title": "test3", "c1":"t1", "c2":"t2", "c3":"t3", "c4":"t4","c5":"t5","power": 4};
        this.testbox[18]= {"title": "test3", "c1":"t1", "c2":"t2", "c3":"t3", "c4":"t4","c5":"t5","power": 4};
        this.testbox[19]= {"title": "test3", "c1":"t1", "c2":"t2", "c3":"t3", "c4":"t4","c5":"t5","power": 4};
        this.testbox[20]= {"title": "test3", "c1":"t1", "c2":"t2", "c3":"t3", "c4":"t4","c5":"t5","power": 4};



        this.mil = this.testbox[this.i];
        this.show=this.mil.title;
        this.case1=this.mil.c1;
        this.case2=this.mil.c2;
        this.case3=this.mil.c3;
        this.case4=this.mil.c4;
        this.case5=this.mil.c5;
        this.i += 1;
        console.log(this.mil);
        console.log(this.case1);
        console.log(this.sum);
      },

     change(num){
        if(this.i<this.testbox.length){
          this.sum += 1*this.mil.power*num;
          this.mil = this.testbox[this.i];
          this.show=this.mil.title;
          this.case1=this.mil.c1;
          this.case2=this.mil.c2;
          this.case3=this.mil.c3;
          this.case4=this.mil.c4;
          this.case5=this.mil.c5;
          this.i += 1;
          console.log(this.mil);
          console.log(this.case1);
          console.log(this.sum);
        }
        else {
          this.sum += 1*this.mil.power*num;
          this.sum /= 100;
          alert("sum is " + this.sum );
          this.look = false;
        }

      },

      click1(){
        this.change(-1);

      },
      click2(){
        this.change(0);

      },
      click3(){
        this.change(1);

      },
      click4(){
        this.change(2);

      },
      click5(){
        this.change(3);

      },
    },



  }
</script>

<style scoped>


</style>
