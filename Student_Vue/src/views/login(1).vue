<template>
<div class="wrapper" style="display: flex">
  <div class="login_box_left">
    <div style="height: 40px; width:220px;border-bottom: solid;margin-top: 35%;margin-left: 20%;padding-left: 15px;color:#fff">
      <h2 style="color:#fff;">在线考试系统</h2>
    </div>
  </div>
  <div class="login_box_right">
    <div class="title">登录</div>
    <div class="loginForm">
    <div>
      <el-input size="large" style="margin: 13px 0" prefix-icon="el-icon-user" v-model="student.username" placeholder="请输入用户名"></el-input>
      <el-input size="large" style="margin: 13px 0" prefix-icon="el-icon-lock" show-password v-model="student.password" placeholder="请输入密码"></el-input>
      <a style="font-size:14px ;color: dodgerblue;" href="http://localhost:8060/login">切换到管理员端登录</a>
    <div style="margin-top: 80px; display: flex">
      <el-button type="primary" aria-autocomplete="off" @click="login" style=" width:170px;
  height:50px;">登录</el-button>
      <el-button type="warning" aria-autocomplete="off" style=" width:170px;
  height:50px;"  @click="register">注册</el-button>
    </div>
    </div>
  </div>
  </div>

</div>
</template>

<script>
import request from "@/utils/request";

export default {
  name:"Login",
  data(){
    return {
      student:{
        username:'',
        password:''
      }
    }
  },
  methods: {
    login(){
      console.log(this.student.username);
      console.log(this.student.password);
      request.post("http://localhost:9090/Student/login",this.student).then(res=>{

        if(!res.token){
          console.log(res)
          this.$message.error("用户名或密码错误")
        }else {
          sessionStorage.setItem("token",'true')
          this.$message.success("登陆成功")
          localStorage.setItem("student",JSON.stringify(res))//存储数据
          this.$router.push("/home")

        }
      })
  },
    register(){
      this.$router.push("/register")
    }
  }
}
</script>

<style>
.wrapper{
  height: 100vh;
  background: url('../assets/Student_login_background.jpeg') no-repeat center;
  overflow: hidden;
}
.login_box_left{
  width:500px;
  height:450px;
  background-color: rgba(255, 255, 255, 0.3);
  border-radius: 3px;
  position: absolute;
  top:50%;
  left: 40%;
  transform: translate(-50%,-50%);
  box-shadow: 0 0 20px gray;
  flex: 1;
}
.login_box_right{
  width:420px;
  height:450px;
  background-color: #fff;
  border-radius: 3px;
  position: absolute;
  top:50%;
  left: 70%;
  transform: translate(-50%,-50%);
  box-shadow: 0 0 20px gray;
  flex: 1;
}
.title{
  font-weight: bold;
  font-size: 30px;
  position:  absolute;
  top:8%;
  left:50%;
  transform: translate(-50%,0%);
}
.loginForm{
  position: absolute;
  top:25%;
  padding:0 40px;
  box-sizing: border-box;
}

</style>