<template>
  <div style="padding-left: 10px">
    <el-form ref="form" :model="form" label-width="80px">

      <el-form-item label="姓名">
        <i class="el-icon-s-custom"></i>
        <el-input type="text" v-model="form.truename" style="width: 200px"></el-input>
      </el-form-item>


      <el-form-item label="所属院系">
        <i class="el-icon-s-home"></i>
      <el-input v-model="form.coll" style="width: 200px"></el-input>
    </el-form-item>
      <el-form-item label="所属班级">
        <i class="el-icon-school"></i>
        <el-input v-model="form.classname" style="width: 200px"></el-input>
      </el-form-item>

      <el-form-item label="联系方式">
        <i class="el-icon-user"></i>
        <el-input v-model="form.tele" style="width: 200px"></el-input>
      </el-form-item>

      <el-form-item label="性别">
<!--        <i class="el-icon-male"></i>-->
<!--        <i class="el-icon-female"></i>-->
        <el-select v-model="form.gender" placeholder="请选择性别">
          <el-option label="男" value="男"></el-option>
          <el-option label="女" value="女"></el-option>
        </el-select>
      </el-form-item>

      <el-form-item>
        <el-button type="primary" @click="onSubmit">立即修改</el-button>
        <el-button>取消</el-button>
      </el-form-item>
    </el-form>



  </div>

</template>

<script>
import request from "@/utils/request";

export default {
  name: "change-inf"
  ,
  data() {
    return {

      form:{
        info:"kkk"
      },
   //   info:"kkk"
    }
  },
  methods: {
    onSubmit() {
      let student=JSON.parse(localStorage.getItem("student"))
      if(this.form.truename===null||this.form.coll===null||this.classname===null||this.form.tele===null||this.form.gender===null)
      {
        this.$message.error("请填写完整")
      }
        else
      {
        console.log(this.form,student)
        student.truename = this.form.truename
        student.coll = this.form.coll
        student.classname = this.form.classname
        student.tele = this.form.tele
        student.gender=this.form.gender
        request.post("http://localhost:9090/Student/changeinfo",student).then(res=>{
          if(!res){
            this.$message.error("保存失败")
          }else {
            this.$message.success("保存成功")
            localStorage.setItem("student",JSON.stringify(student))//存储数据
          }
        })
      }
    }
  }
}
</script>

<style scoped>

</style>