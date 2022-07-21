<template>
  <el-container style="width: 100%; height: 100%">
    <el-header style="height: 80px">
    </el-header>
    <el-main class="exam_content">
      <div class="title">{{ userAnswer.exam.title }}</div>
      <div class="subject">专业:{{ major }}</div>
      <div
          v-for="(question, index) in questions"
          :key="question.id"
      >
        <!--单选-->
        <div v-if="question.type ===1" class="question_box">
          <p class="stem">{{ index + 1 }}. {{ question.content }}</p>

<!--          <el-radio-group v-model="answers[index].content">-->
            <div>
              <el-radio :label="'b'" style="margin: 10px 0;margin-left: 20px"
              >{{"A"}}.{{question.optiona}}</el-radio>
            </div>
              <div>
            <el-radio :label="'b'" style="margin: 10px 0;margin-left: 20px"
            >{{"B"}}.{{question.optionb}}</el-radio>
              </div>
              <div>
            <el-radio :label="'c'" style="margin: 10px 0;margin-left: 20px"
            >{{"C"}}.{{question.optionc}}</el-radio>
              </div>
              <div>
            <el-radio :label="'d'" style="margin: 10px 0;margin-left: 20px"
            >{{"D"}}.{{question.optiond}}</el-radio>
              </div>
<!--          </el-radio-group>-->

          <!--多选-->
          <div style="margin-top: 20px;font-size: 14px">
            我的答案：{{question.studentkey}}
          </div>
        </div>
        <div v-else-if="question.type ===2" class="question_box">
          <p class="stem">{{ index + 1 }}. {{ question.content }}</p>

<!--          <el-checkbox-group v-model="answers[index].scontent">-->
            <div>
            <el-checkbox :label="'a'" style="margin: 10px 0 ;margin-left: 20px"
            >{{"A"}}.{{question.optiona}}</el-checkbox>
            </div>
            <div>
            <el-checkbox :label="'b'" style="margin: 10px 0;margin-left: 20px"
            >{{"B"}}.{{question.optionb}}</el-checkbox>
            </div>
            <div>
            <el-checkbox :label="'c'" style="margin: 10px 0;margin-left: 20px"
            >{{"C"}}.{{question.optionc}}</el-checkbox>
            </div>
            <div>
            <el-checkbox :label="'d'" style="margin: 10px 0;margin-left: 20px"
            >{{"D"}}.{{question.optiond}}</el-checkbox>
            </div>
            <div>
            <el-checkbox :label="'e'" style="margin: 10px 0;margin-left: 20px"
            >{{"E"}}.{{question.optione}}</el-checkbox>
            </div>
          <div style="margin-top: 20px;font-size: 14px">
            我的答案：{{question.studentkey}}
          </div>
<!--          </el-checkbox-group>-->


        </div>
<!--判断-->
        <div v-else-if="question.type ===3" class="question_box">
          <p class="stem">{{ index + 1 }}. {{ question.content }}</p>

            <el-radio :label="'对'"
            >对</el-radio>
            <el-radio :label="'错'"
            >错</el-radio>
<!--          </el-radio-group>-->
          <div style="margin-top: 20px;font-size: 14px">
            我的答案：{{question.studentkey}}
          </div>

        </div>

        <div v-else-if="question.type === 4" class="question_box">
          <p class="stem">{{ index + 1 }}. {{ question.content }}</p>
          <div style="margin-top: 20px;font-size: 14px">
            我的答案：{{question.studentkey}}
          </div>
        </div>
      </div>
    </el-main
    >
  </el-container>
</template>

<script>

import request from "@/utils/request";

export default {
  name: "reviewPaper",

  data() {
    return {
      ans: [],

      title: "软件工程",
      examStartTime: "",
      examTotleTime: 60,
      date: new Date(), //当前日期
      restTime: {h: 0, m: 0, s: 0},
      submited: false,
      questions: [],
      major:"",
      userAnswer: {
        id: "",
        textId: "",
        examPaperId: "",
        subjectId: "",
        userId: "",
        examId: "",
        status: "",
        text: {},
        user: {},
        exam: {title: " "},
        examPaper: {questinos: [{name: " "}]},
        subject: {name: " "},
        major: ""
      },
      answers: []
    }
  },
  created() {
    this.load()
  },
  methods: {

   load() {
      this.major=localStorage.getItem("r-major1")+"-"+localStorage.getItem("r-major2")
     this.questions=JSON.parse(localStorage.getItem("reviewPaper"))
     console.log(this.questions)
     let student=JSON.parse(localStorage.getItem("student"))
     // console.log(this.questions)


    },

  }
};
</script>

<style scoped>
.exam_content {
  width: 100%;
  height: 90%;
  background-color: #eedeb0;
}
.title {
  text-align: center;
  font-size: 40px;
  padding: 10px 10px;
}
.subject {
  text-align: center;
  font-size: 20px;
  padding: 10px 10px;
}
.question_box {
  width: 80%;
  padding: 20px 20px;
  border: solid 1px #d9b611;
  margin: 10px auto;
  border-radius: 5px;
}
.el-header {
  background-color: #eacd76;
  color: #333;
  text-align: left;
  line-height: 60px;
  width: 100%;
  -webkit-box-shadow: 0 0 2px #000;
  box-shadow: 0 0 2px #000;
  padding: 0;
}

.foot .el-button--primary {
  color: #fff;
  background-color: #f0c239;
  border-color: #d9b611;
}
.foot {
  width: 0%;
  padding: 20px 20px;
  margin: 10px auto;
  border-radius: 5px;
}

</style>