<template>
  <el-carousel :interval="4000" type="card" height="300px">

    <el-carousel-item v-for="item in imagebox" :key="item.id">
      <img :src="item.idView" class="image">
    </el-carousel-item>
    <el-card class="box-card">
      <div  class="text item" style="padding-top: 350px ;width: 1000px" >
        {{'一套实现无纸化考试的软件,支持填空、判断、单选、多选,内附800道环境监测试题和60道计算机三级考试试题,可以生成试卷,支持网络考试.全程试卷生成自动、定时结束答题、考生试卷浏览等许多功能.专为各类学校和培训机构提供考试系统，包括自测练习、组织统一考试、开展知识竞赛、布置课外作业或假期作业、智能组卷、答卷评阅与成绩管理等众多功能；也可用于政府机构、企事业单位内部的入职考试、员工考核、内部培训考试等。' }}
      </div>
    </el-card>
<!--    <el-card class="box-card-1" style="width: 400px ; border-radius: 4px;" >-->
<!--      <div style="font-size: 30px">-->
<!--        <i class="el-icon-s-order"></i>-->
<!--        {{'待考总数1'}}-->
<!--        <div>-->
<!--          <el-button @click="show3 = !show3">Click Me</el-button>-->

<!--          <div style="margin-top: 20px; height: 200px;">-->
<!--            <el-collapse-transition>-->
<!--              <div v-show="show3">-->
<!--                <el-button class='transition-box' @click="router_p" >在线考试</el-button>-->
<!--                <el-button class='transition-box'@click="router_m" >题库练习</el-button>-->
<!--              </div>-->
<!--            </el-collapse-transition>-->
<!--          </div>-->
<!--        </div>-->

<!--      </div>-->
<!--    </el-card>-->

  </el-carousel>


</template>
<style >

.el-carousel__item h3 {
  color: #475669;
  font-size: 14px;
  opacity: 0.75;
  line-height: 200px;
  margin: 0;
}

.el-carousel__item:nth-child(2n) {
  background-color: #99a9bf;
}

.el-carousel__item:nth-child(2n+1) {
  background-color: #d3dce6;
}
img{
  /*设置图片宽度和浏览器宽度一致*/
  width:100%;
  height:inherit;
}
.transition-box {
  margin-bottom: 10px;
  width: 120px;
  height: 60px;
  border-radius: 4px;
  background-color: #409EFF;
  text-align: center;
  color: #fff;
  padding: 40px 20px;
  box-sizing: border-box;
  margin-right: 20px;
}

</style>

<script>
export default{
  name:'home',
  data(){
    return {
      show3: true,
      imagebox:[{id:0,idView:require('../assets/pic1.png')},
        {id:1,idView:require('../assets/pic1.png')},
        {id:2,idView:require('../assets/pic1.png')}
      ],

      // 浏览器宽度
      screenWidth :0
    }
  },
  methods:{
    setSize:function () {
      // 通过浏览器宽度(图片宽度)计算高度
      this.bannerHeight = 400 / 1920 * this.screenWidth;
    },
    router_p(){
      this.$router.push('/exam')
    },
    router_m(){
      this.$router.push('/practice')
    }
  },
  mounted() {

    // 首次加载时,需要调用一次
    this.screenWidth =  window.innerWidth;
    this.setSize();
    // 窗口大小发生改变时,调用一次
    window.onresize = () =>{
      this.screenWidth =  window.innerWidth;
      this.setSize();
    }

  }
}

</script>
