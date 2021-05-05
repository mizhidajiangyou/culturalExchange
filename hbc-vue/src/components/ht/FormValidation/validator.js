export default{
  data() {
    return {
      dialogFormVisible: false,
      isShow: true,
      btnText: "隐藏",
      thegood:false,
      thegoodimg:false,

      ztestname:"",
      comment:"",
      username: "",
      password: "",
      newpassword:"",
      matchPassword:false,


      numValue:'',
      nameValue:'',
      tipValue:'',

      zk:false
    }
  },


  methods: {
    changeNameFun(){
      if(!this.nameValue){
        this.tipValue="姓名不为空"
      }else{
        this.tipValue = this.nameValue;
      }
    },
    changeNumFun(){
      if(!this.numValue){

      }else{
        this.tipValue = this.numValue;
      }
    },
    ztt(){
      if(!this.ztestname){
        this.zk=true;
      }
      else{
        this.zk=false;
      }
    },


    showToggle() {
      this.isShow = !this.isShow
      if (this.isShow) {
        this.btnText = "隐藏"
      } else {
        this.btnText = "显示"
      }
    },
    test111(){
      this.thegoodimg=!this.thegoodimg
    },
    loginMethods:function () {
      var self = this;
      /**
       * 验证目标表单元素。
       * true:验证所有
       */
      self.$validate(true,function () {
        /*如果所有条件都是false*/
        if(!self.$validatorMethod.invalid){
          alert("登录成功");
        }
      })
    }
  }

}
