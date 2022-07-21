<template>
  <div>
  <div class="register_header">
    <h2 style="padding-top:10px;padding-left: 20px;color: white">在线考试系统注册用户</h2>
  </div>
  <div class="register_container">
    <el-form :model="form" label-width="120px">
      <el-form-item label="姓名:">
        <el-input v-model="form.truename" autocomplete="off" placeholder="请输入姓名" clearable/>
      </el-form-item>
      <el-form-item label="电话:">
        <el-input v-model="form.tele" autocomplete="off" placeholder="请输入电话" clearable/>
      </el-form-item>
      <el-form-item label="性别:">
        <el-radio-group v-model="form.gender">
          <el-radio label="男" size="large">男</el-radio>
          <el-radio label="女" size="large">女</el-radio>
        </el-radio-group>
      </el-form-item>
      <el-form-item label="账号:">
        <el-input v-model="form.username" autocomplete="off" placeholder="请输入账号" clearable/>
      </el-form-item>
      <el-form-item label="密码:">
        <el-input v-model="form.password" autocomplete="off" type="password" placeholder="请输入密码" clearable show-password/>
      </el-form-item>
      <el-form-item label="专业:">
        <el-select v-model="form.coll" placeholder="请选择专业" clearable>
        <el-option
            v-for="item in allColl"
            :key="item.coll"
            :label="item.coll"
            :value="item.coll"
        />
        </el-select>
      </el-form-item>
      <el-form-item label="班级:">
        <el-input v-model="form.classname" autocomplete="off" placeholder="请输入班级" clearable/>
      </el-form-item>
      <el-form-item>
       <el-button size="large" type="danger" style="width: 200px" @click="reset">重置</el-button>
        <el-button size="large" type="success" style="width: 200px" @click="regist">注册</el-button>
      </el-form-item>
    </el-form>
  </div>
  </div>
</template>

<script>
import request from "@/utils/request";
export default {
  name: "Register",
  data(){
    return{
      form:{
       username:'',
       truename:'',
       tele:'',
       coll:'',
        gender:'',
        password:'',
        classname:'',
      },
      allColl:[{
        coll:'',
      }]
    }
  },
  created() {
    this.loadColl();
  },
  methods:{
    reset(){
      this.form={};
    },
    regist(){
     request.post("http://localhost:9090/Student/regist",this.form).then(res=>{
       if(!res){
         this.$message.error("用户名已被注册")
       }else {
         this.$message.success("注册成功")
         this.$router.push("/login")
       }
      })
    },
    loadColl(){
      request.get('http://localhost:9090/Student/choosemajor')
          .then((res)=>{
            console.log(res);
            for(let i=0;i<res.length;i++){
              this.allColl.push({coll:res[i].mname});
            }
          })
    }
  }
}
</script>

<style scoped>
.register_header{
  background-color:cornflowerblue;
  height: 60px;
  box-shadow: 0 0 20px gray;
}
.register_container{
  margin-top: 50px;
  width: 60%;
  margin-left: 15%;
}
</style>