<template>

  <div>
    <el-card class="box-card">
      <div >
        <i class="el-icon-plus"></i>
        {{"选择你所学习的专业方向"}}
      </div>
    </el-card>

    <div style="margin-top: 20px">

<div id="app">
  <el-checkbox v-for="(major,index) in majors"
              v-model="form[index]" style="margin: 20px;"  border>{{major.mname}}</el-checkbox>
</div>

      <el-row>

        <el-button type="primary" plain style="margin: auto ;margin-top: 20px;margin-left: 500px" @click="choose">开始考试</el-button>
      </el-row>
    </div>
    <el-card class="box-card">
      <div style="margin-top: 20px" >
        <i class="el-icon-star-on"></i>
        {{"选择完专业后，将生成试卷，需要到在线考试页面开始测试"}}
      </div>
    </el-card>


    </div>

</template>

<script>
import request from "@/utils/request";

export default {
  name: "choose",
  created() {
    this.load()
  },
  data () {
    return {
permissions:[],
form:[], majors:[],
      choosemajor:{}
    };
  },
  methods:{

    load(){
      request.get("http://localhost:9090/Student/choosemajor").then(res=> {
        this.majors = res;
        this.majors.forEach((major,index)=>{
          this.form[index]=false
        })
      })
    },
    choose(){
      let major1="";let major2=""; let err=false;
      let i=0
      //console.log(this.majors)
      this.majors.forEach((major,index)=>{
        if(this.form[index]==true)
          if(major1===""){major1=major.mno;localStorage.setItem("major1",major.mname)}
        else if(major2===""){major2=major.mno;localStorage.setItem("major2",major.mname)}
        else err=true;
      })
      if(major1===""||major2==="")//挑选专业过少
      {
        this.$message.error("请挑选两个专业")
        return 0;
      }
      if(err)this.$message.error("最多只能选择两个专业")
      let username=JSON.parse(localStorage.getItem("student")).username
      this.choosemajor.major1=major1
      this.choosemajor.major2=major2
      localStorage.setItem("choosemajor",JSON.stringify(this.choosemajor))
     let choosemajor= JSON.parse(localStorage.getItem("choosemajor"))
      console.log(choosemajor)
     // this.choosemajor.username=username
      //console.log(this.choosemajor)
      request.post("http://localhost:9090/Student/choose",choosemajor).then(res=>{
          //console.log(major1,major2)
        console.log(res)
        localStorage.setItem("paper",JSON.stringify(res))
        if(!res) this.$message.error("组卷失败！")
        else {
          this.$message.success("组卷成功！");
          localStorage.setItem("selected",'true')
          this.$router.push("/examstart")
        }
      })

    }
  }

}
</script>

<style scoped>

</style>