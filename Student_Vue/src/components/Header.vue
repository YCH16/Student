<template>
<div style="height: 50px;line-height: 50px;border-bottom: 1px solid #ccc;display:flex">

  <div style="width:200px;padding-left:30px;font-weight: bold;color: dodgerblue">学生后台管理</div>
  <div style="flex:1"></div>
  <div style="width: 100px">
    <el-dropdown>
      <el-button type="info" @click="logout">
       退出
<!--        <i class="el-icon-arrow-down el-icon&#45;&#45;right"></i>-->
      </el-button>
<!--      <el-dropdown-menu slot="dropdown" >-->
<!--        <el-button type="primary" size="small" aria-autocomplete="off" @click="logout" style="height: 30px">登录</el-button>-->
<!--&lt;!&ndash;        <el-dropdown-item @click="logout">登出</el-dropdown-item>&ndash;&gt;-->
<!--      </el-dropdown-menu>-->
    </el-dropdown>
  </div>
</div>


</template>

<script>
export default {
  name: "Header",
  data(){
    return{
      truename:JSON.parse(localStorage.getItem("student")).truename
    }
  },
  created() {
    console.log(JSON.parse(localStorage.getItem("student")).truename)
  },
  methods:{
    logout()
    {
     // console.log(7)
      //sessionStorage.removeItem("token")
      sessionStorage.clear()
      localStorage.clear()
      this.$router.push("/login")
      if(sessionStorage.getItem("token"))
        console.log(sessionStorage.getItem("token"),1)
    }
  }
}
</script>

<style scoped>

</style>