<template>
<div>
  <template>
    <div class="exam-notice">
      <el-card class="box-card">
        <div slot="header" class="clearfix">
          <h2>我的答卷</h2>
        </div>
        <div class="text">
          <p>点击查看答卷</p>




        </div>
      </el-card>
    </div>
    <el-table :data="tableData" style="width: 100%">
      <el-table-column label="试卷编号" width="180">
        <template slot-scope="scope">
          <span style="margin-left: 10px">{{ scope.row.pid }}</span>
        </template>
      </el-table-column>
      <el-table-column
          label="专业方向"
          width="180">
        <template slot-scope="scope">
<!--          <el-popover trigger="hover" placement="top">-->
            <p>专业一: {{ scope.row.major1 }}</p>
            <p>专业二: {{ scope.row.major2 }}</p>
<!--            <div slot="reference" class="name-wrapper">-->
<!--              <el-tag size="medium">{{ scope.row.sname}}</el-tag>-->
<!--            </div>-->
<!--          </el-popover>-->
        </template>
      </el-table-column>
      <el-table-column
          label="提交时间"
          width="240" >
        <template slot-scope="scope">
          <i class="el-icon-time"></i>
          <span style="margin-left: 10px">{{ scope.row.time }}</span>
        </template>
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button size="mini" @click.native.prevent="review(scope.$index, tableData)"> 查看考卷</el-button>

<!--          <el-button type="danger" plain icon="el-icon-edit-outline" :loading="isDialogSubmiting" size="mini" @click.native.prevent="deleteRow(scope.$index, tableData)">删除</el-button>-->


        </template>
      </el-table-column>
    </el-table>
  </template>



</div>
</template>

<script>
import request from "@/utils/request";

export default {
  name: "mygrade",
  data() {
    return {

      dialogLoading: false,
      isDialogSubmiting: false,
      info: {
        id: '',
      },
      tableData:[]
    }
  },
  created() {
this.load()
  },
  methods: {

    async deleteRow(index, rows){
      const confirmResult = await this.$confirm('此操作将永久删除该数据, 是否继续?', '提示', {
        confirmButtonText: '确定',
        cancelButtonText: '取消',
        type: 'warning',
      }).catch((err) => err);
      if (confirmResult !== 'confirm') {
        return this.$message.info('已取消删除');
      }
      else{
        request.delete("http://localhost:9090/Student/mygrade/"+rows[index].date)
        this.load()
        //rows.splice(index, 1);

        return this.$message.info('删除成功');
      }

      this.getList();
    },
    review(index, rows){
      let pid=rows[index].pid
      localStorage.setItem("r-major1",rows[index].major1)
      localStorage.setItem("r-major2",rows[index].major2)
      request.get("http://localhost:9090/Student/reviewPaper",{params:{pid:pid}}).then(res=>{
        //console.log(res)
        localStorage.setItem("reviewPaper",JSON.stringify(res))
      })
      this.$router.push("/reviewPaper")
    },
load()
{
  let s=JSON.parse(localStorage.getItem("student"))
  request.get("http://localhost:9090/Student/mygrade",{params:{username:s.username}}).then(res=>{
   this.tableData=res
    console.log(res)
  })
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


