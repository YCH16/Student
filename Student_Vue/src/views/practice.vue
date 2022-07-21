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
    <div style="margin:10px 0">
      <el-input v-model="search" placeholder="请输入内容" style="width: 20%" size="small"></el-input>
      <el-button type="primary" style="margin: 5px" size="small">查询</el-button>
    </div>

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
          prop="subject"
          label="考试科目"
      >
      </el-table-column>
      <el-table-column
          prop="deadline"
          label=“截止日期”>
      </el-table-column>
      <el-table-column label="操作">
        router
        <template slot-scope="scope">
          <el-button @click="router_p">开始考试</el-button>
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
export default {
  name: "practice",
  data() {
    return {
      search:'',
      currentPage4:1,
      total:10,
      tableData: [{
        date: '2020.5.1',
        subject: '高等数学',
        deadline: '2020.5.2'
      },
        {
          date: '2020.5.1',
          subject: '概率统计',
          deadline: '2020.5.2'
        }]
    }
  },
  methods:{

    handleSizeChange(){},
    handleCurrentChange(){},
    router_p(){
      this.$router.push('/examstart')
    }




  }
}
</script>

<style scoped>

</style>