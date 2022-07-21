<template>
  <div>
    <template>
      <div class="exam-notice">
        <el-card class="box-card">
          <div slot="header" class="clearfix">
            <h2>我的错题本</h2>
          </div>
          <div class="text">
            <p>一、高于90为优秀，绿色标记</p>
            <p>二、低于60为不合格</p>

          </div>
        </el-card>
      </div>
      <el-table
          :data="tableData"
          style="width: 100%"
          :row-class-name="tableRowClassName">
        <el-table-column
            prop="date"
            label="日期"
            width="180">
        </el-table-column>
        <el-table-column
            prop="name"
            label="姓名"
            width="180">
        </el-table-column>
        <el-table-column
            prop="grade"
            label="成绩">
        </el-table-column>
        <el-table-column label="操作">
          router
          <template slot-scope="scope">
            <el-button @click="router_p">查看错题</el-button>
          </template>
        </el-table-column>
      </el-table>
    </template>



  </div>
</template>

<script>
export default {
  name: "mistake",
  methods: {
    tableRowClassName({row, rowIndex}) {
      if (rowIndex === 1) {
        return 'warning-row';
      } else if (rowIndex === 3) {
        return 'success-row';
      }
      return '';
    },
    router_p(){
      this.$router.push('/mistakebook')
    }

  },
  data() {
    return {
      tableData: [{
        date: '2016-05-02',
        name: '王小虎',
        grade: '80',
      }, {
        date: '2016-05-04',
        name: '王小虎',
        grade: '59'
      }, {
        date: '2016-05-01',
        name: '王小虎',
        grade: '85',
      }, {
        date: '2016-05-03',
        name: '王小虎',
        grade: '92'
      }]
    }
  }
}
</script>
<style>
.el-table .warning-row {
  background: oldlace;
}

.el-table .success-row {
  background: #f0f9eb;
}
</style>


