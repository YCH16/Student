<template>
  <el-container style="width: 100%; height: 100%">
    <el-header style="height: 80px">
      <span style="">
        剩余:{{
          restTime.h + " 时 " + restTime.m + " 分 " + restTime.s + " 秒 "
        }}
      </span>
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

          <el-radio-group v-model="answers[index].content">
            <div>
            <el-radio :label="'a'" style="margin: 10px 0 ;margin-left: 20px"
            >{{question.optiona}}</el-radio>
            </div>
              <div>
            <el-radio :label="'b'" style="margin: 10px 0;margin-left: 20px"
            >{{question.optionb}}</el-radio>
              </div>
              <div>
            <el-radio :label="'c'" style="margin: 10px 0;margin-left: 20px"
            >{{question.optionc}}</el-radio>
              </div>
              <div>
            <el-radio :label="'d'" style="margin: 10px 0;margin-left: 20px"
            >{{question.optiond}}</el-radio>
              </div>
          </el-radio-group>

          <!--多选-->
        </div>
        <div v-else-if="question.type ===2" class="question_box">
          <p class="stem">{{ index + 1 }}. {{ question.content }}</p>

          <el-checkbox-group v-model="answers[index].content">
            <div>
            <el-checkbox :label="'a'" style="margin: 10px 0 ;margin-left: 20px"
            >{{question.optiona}}</el-checkbox>
            </div>
            <div>
            <el-checkbox :label="'b'" style="margin: 10px 0;margin-left: 20px"
            >{{question.optionb}}</el-checkbox>
            </div>
            <div>
            <el-checkbox :label="'c'" style="margin: 10px 0;margin-left: 20px"
            >{{question.optionc}}</el-checkbox>
            </div>
            <div>
            <el-checkbox :label="'d'" style="margin: 10px 0;margin-left: 20px"
            >{{question.optiond}}</el-checkbox>
            </div>
            <div>
            <el-checkbox :label="'e'" style="margin: 10px 0;margin-left: 20px"
            >{{question.optione}}</el-checkbox>
            </div>
          </el-checkbox-group>


        </div>
<!--判断-->
        <div v-else-if="question.type ===3" class="question_box">
          <p class="stem">{{ index + 1 }}. {{ question.content }}</p>

          <el-radio-group v-model="answers[index].content">
            <el-radio :label="'对'"
            >对</el-radio>
            <el-radio :label="'错'"
            >错</el-radio>
          </el-radio-group>


        </div>
        <!--天空-->
        <div v-else-if="question.type ===5" class="question_box">
          <p class="stem">{{ index + 1 }}. {{ question.content }}</p>
          <el-input type="textarea" placeholder="答案请用空格隔开" v-model="answers[index].content">

          </el-input>
        </div>
<!--简答-->
        <div v-else-if="question.type === 4" class="question_box">
          <p class="stem">{{ index + 1 }}. {{ question.content }}</p>
          <el-input type="textarea" v-model="answers[index].content" placeholder="请输入答案">

          </el-input>
        </div>
      </div>
      <div class="foot">
        <el-button type="primary" @click="submit()">交卷</el-button>
      </div> </el-main
    >
  </el-container>
</template>

<script>

import request from "@/utils/request";

export default {
  name: "examstart",

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
  methods: {
      f(num)
       {
       if(num==1)return "计算机"
        else if(num==2) return "软件工程"
        },
   getUserAnswer() {
      this.major=localStorage.getItem("major1")+"-"+localStorage.getItem("major2")
     this.questions=JSON.parse(localStorage.getItem("paper"))
     let student=JSON.parse(localStorage.getItem("student"))
     // console.log(this.questions)
            this.questions.forEach((question, index) => {
              if (question.type === 1) {
                this.answers[index] = {
                  username: student.username,
                  sid:question.sid,
                  type:question.type,
                  content: "",
                  studentkey:"",
                  time:""

                };
              } else if (question.type === 2) {
                this.answers[index] = {
                  username: student.username,
                  sid:question.sid,
                  content: [],
                  type:question.type,
                  studentkey:"",
                  time:""
                };
              } else if (question.type === 3) {
                this.answers[index] = {
                  username: student.username,
                  sid:question.sid,
                  content: "",
                  type:question.type,
                  studentkey:"",
                  time:""
                };
              }  else if (question.type === 4) {
                this.answers[index] = {
                  username: student.username,
                  sid:question.sid,
                  content: "",
                  type:question.type,
                  studentkey:"",
                  time:""
                };
              }
            });

    },
    submit(){
     let time="";let pid="";
      request.get("http://localhost:9090/Student/getpid").then(res=>{
        time=res.time
        pid=res.pid
       // console.log(res)
        this.answers.forEach((answer,index)=>
        {
          answer.time=time
          answer.pid=pid
          if(answer.type==2){
            answer.content.forEach((s,index)=>{
              // console.log(s)
              answer.studentkey+=s
            })
          }
          else answer.studentkey=answer.content
          //console.log(answer)
          request.post("http://localhost:9090/Student/saveanswer",answer).then(res=> {
            if(!res)this.$message.error("交卷失败！")
          })
        })
        this.$message.success("交卷成功！")
        this.$router.push("/mygrade")
      })

    }
  },
  mounted() {
    this.userAnswer.id = this.$route.params.userAnswerId;
    this.getUserAnswer();

    this.examStartTime = new Date();
    var _this = this;
    this.timer = setInterval(() => {
      _this.date = new Date();
      let time =
          _this.examTotleTime * 60 * 1000 -
          (_this.date.getTime() - _this.examStartTime.getTime());
      _this.restTime.h = parseInt(time / 1000 / 60 / 60);
      _this.restTime.m = parseInt(time / 1000 / 60);
      _this.restTime.s = parseInt((time % (1000 * 60)) / 1000);
      if (time <= 0 && _this.userAnswer.status === 0) {
        _this.submited = true;
        _this.submit();
      }
    }, 1000);
  },
  destroyed() {
    this.submit();
  },
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