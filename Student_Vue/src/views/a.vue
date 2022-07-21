<template>
  <div style="padding-left: 10px">
    <div style="margin:10px 0 ">
      <el-button type="primary" size="small">添加</el-button>
      <el-button type="primary" size="small">导入</el-button>
      <el-button type="primary" size="small">导出</el-button>
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
          prop="name"
          label="姓名"
      >
      </el-table-column>
      <el-table-column
          prop="address"
          label="地址">
      </el-table-column>
      <el-table-column label="操作">
        <template slot-scope="scope">
          <el-button
              size="mini"
              @click="handleEdit(scope.$index, scope.row)">编辑</el-button>
          <el-popconfirm
              title="这是一段内容确定删除吗？"
          >
            <el-button size="mini" type="danger" slot="reference" @click="handleDelete(scope.$index, scope.row)">删除</el-button>
          </el-popconfirm>

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
// @ is an alias to /src

export default {
  name: 'HomeView',


  data() {
    return {
      search:'',
      currentPage4:1,
      total:10,
      tableData: [{
        date: '2016-05-02',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1518 弄'
      }, {
        date: '2016-05-04',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1517 弄'
      }, {
        date: '2016-05-01',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1519 弄'
      }, {
        date: '2016-05-03',
        name: '王小虎',
        address: '上海市普陀区金沙江路 1516 弄'
      }]
    }
  },
  methods:{
    handleEdit()
    {
    },
    handleDelete(){},
    handleSizeChange(){},
    handleCurrentChange(){},





  }

}
</script>
