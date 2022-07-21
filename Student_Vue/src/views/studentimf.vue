<template>
  <div>
    <el-card>
      <el-descriptions class="margin-top" title="我的信息" :column="2" border>


        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-user"></i>
            学号
          </template>
          {{ student.username }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-s-custom"></i>
            姓名
          </template>
          {{ student.truename }}
        </el-descriptions-item>
        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-male"></i>
            <i class="el-icon-female"></i>
            性别
          </template>
          <el-tag size="small">{{ student.gender }}</el-tag>
        </el-descriptions-item>

        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-mobile-phone"></i>
            手机号码
          </template>
          {{ student.tele }}
        </el-descriptions-item>

        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-school"></i>
            所属院系
          </template>
          {{ student.coll }}
        </el-descriptions-item>

        <el-descriptions-item>
          <template slot="label">
            <i class="el-icon-department"></i>
            班级
          </template>
          {{ student.classname }}
        </el-descriptions-item>


      </el-descriptions>
    </el-card>
  </div>


</template>

<script>
//import { userInfo } from "@/api/user.js";
export default {
  name: "Info",
  data() {
    return {

   student:localStorage.getItem("student") ? JSON.parse(localStorage.getItem("student")):{}

    };
  },
  mounted() {
    //this.load();
    this.kkk()
  },
  methods: {
    kkk() {


      console.log(localStorage.getItem("student") ? JSON.parse(localStorage.getItem("student")):{})
    },
  },
};

</script>

<style scoped>
.img {
  width: 80px;
  height: 80px;
}
</style>

