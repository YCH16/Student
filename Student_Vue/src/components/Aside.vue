<template>


    <el-menu
        style="width: 200px;min-height: 100vh "
        default-active="user"
        :default-openeds="[4]"
      router

        class="el-menu-vertical-demo"

        background-color="#545c64"
        text-color="#fff"
        active-text-color="#ffd04b">

      <el-menu-item index="home">
       <template #title>首页</template>
        <el-menu-item index="home">首页</el-menu-item>
      </el-menu-item>


      <el-submenu index="1">
        <template slot="title">
<!--          <i class="el-icon-location"></i>-->
          <span>学生个人信息</span>
        </template>
        <el-menu-item-group>
          <template slot="title">基本信息</template>
          <el-menu-item index="stu-inf">查看信息</el-menu-item>
          <el-menu-item index="change-inf">修改信息</el-menu-item>
        </el-menu-item-group>
      </el-submenu>


<!--      <el-submenu index="2">-->
<!--        <template slot="title">-->
<!--          <i class="el-icon-location"></i>-->
<!--          <span>考试平台</span>-->
<!--        </template>-->
<!--        <el-menu-item-group title="专业方向">-->
          <el-menu-item index="choose">在线考试</el-menu-item>
<!--        </el-menu-item-group>-->
<!--        <el-menu-item-group>-->
<!--          <template slot="title">在线考试</template>-->
<!--          <el-menu-item index="exam">在线考试</el-menu-item>-->

<!--        </el-menu-item-group>-->

<!--      </el-submenu>-->

<!--      <el-submenu index="5">-->
<!--        <template slot="title">-->
<!--          <i class="el-icon-location"></i>-->
<!--          <span>我的答卷</span>-->
<!--        </template>-->
<!--        <el-menu-item-group>-->

          <el-menu-item index="mygrade">我的答卷</el-menu-item>

<!--        </el-menu-item-group>-->
<!--      </el-submenu>-->

<!--      <el-menu-item index="3">-->
<!--        <i class="el-icon-menu"></i>-->
<!--        <span slot="title">导航三</span>-->
<!--      </el-menu-item>-->


    </el-menu>

</template>

<script>
export default {
  name: "Aside"
}
</script>

<style scoped>

</style>