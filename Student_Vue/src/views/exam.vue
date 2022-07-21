<template>
  <div style="padding-left: 10px">

    <div class="exam-notice">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <h2>考试须知</h2>
        </div>
        <div class="text">
          <p>一、考试为在线考试，有时间限制</p>
          <p>二、考试期间不得离开考试页面，否则离开两次将自动交卷</p>
          <p>三、考试请独立思考，不得与他人交流</p>
          <p>四、若还没开考，请耐心等待</p>
        </div>
      </el-card>
    </div>
    <!--search--->


    <el-table
        :data="tableData"
        border
        style="width: 100%">
      <el-table-column
          prop="date"
          label="日期"
      >
      </el-table-column>
      <el-table-column
          prop="major1"
          label="专业方向1"
      >
      </el-table-column>
      <el-table-column
          prop="major2"
          label=专业方向2>
      </el-table-column>
      <el-table-column label="操作">
        router
        <template slot-scope="scope">
         <el-button @click="router_p(scope.$index,tableData)">开始考试</el-button>
        </template>
      </el-table-column>
    </el-table>
    <div style="margin: 10px 0">
      <el-pagination
          @size-change="handleSizeChange"
          @current-change="handleCurrentChange"
          :current-page="currentPage4"
          :page-sizes="[5, 10, 20]"
          :page-size="10"
          layout="total, sizes, prev, pager, next, jumper"
          :total="total">
      </el-pagination>

    </div>
  </div>



</template>


<script>
import request from "@/utils/request";

export default {
  name: "exam",
  data() {
    return {
      search:'',
      currentPage4:1,
      total:10,
      tableData:[]

    }
  },
created() {
    this.load()
},
  methods:{
load(){
  request.get("http://localhost:9090/Student/exam").then(res=>{
    this.tableData=res
   // console.log(res)
  })
},
    handleSizeChange(){},
    handleCurrentChange(){},

    router_p(index,tableData){
  let snum= JSON.parse(localStorage.getItem("student")).snum

      let date=tableData[index].date

       request.get("http://localhost:9090/Student/paper",{params:{date:date, snum:snum}}).then(res=>{
         localStorage.setItem("paper",JSON.stringify(res))
         console.log(res)
       })
      this.$router.push('/examstart')
    }




  }
}
</script>

<style scoped>

</style>