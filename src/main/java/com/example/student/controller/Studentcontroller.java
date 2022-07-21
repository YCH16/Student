package com.example.student.controller;

import com.example.student.controller.dto.StudentDTO;
import com.example.student.entity.chooseMajor;
import com.example.student.controller.dto.Exam;
import com.example.student.controller.dto.major;
import com.example.student.entity.Answer;
import com.example.student.entity.Question;
import com.example.student.entity.Student;
import com.example.student.mapper.StudentMapper;
import com.example.student.service.StudentService;
import org.apache.ibatis.annotations.Insert;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin
@RestController
@RequestMapping("/Student")
public class Studentcontroller {
    @Autowired
    private StudentMapper studentMapper;
    @Autowired
    private StudentService studentService;
    @GetMapping
    public List<Student> index(){
        return studentMapper.FindAll();
    }
    @PostMapping
    public int save(@RequestBody Student student)
    {
        return studentService.save(student);
    }
    @PostMapping("/login")
    public StudentDTO login(@RequestBody StudentDTO studentDTO)
    {

       return studentService.login(studentDTO);
    }
    @GetMapping("/mygrade")
    public List<Exam> getPaper(@RequestParam(defaultValue = "") String username){
        return studentService.getPaper(username);
    }
    @DeleteMapping("/mygrade/{date}")
    public boolean deleteExam(@PathVariable String date){
        return studentMapper.deleteExam(date);
    }
    @PostMapping("/choose")
    public List<Question> choose(@RequestBody chooseMajor choosemajor)
    {
        return studentService.choose(choosemajor);
    }
    @GetMapping("/exam")
    public List<Exam> getExam() {
        return studentMapper.getExam();
    }
//    @GetMapping("/paper")
//    public List<Question> getQuestion(@RequestParam(defaultValue ="")String snum,@RequestParam(defaultValue = "")String date)
//    {
//        return studentMapper.getQuestion(snum,date);
//    }
    @PostMapping("/changeinfo")
    public boolean changeInfo(@RequestBody StudentDTO studentDTO)
    {
        return studentMapper.updateInfo(studentDTO);
    }

   @PostMapping("/saveanswer")
    public boolean saveAnswer(@RequestBody Answer answer)
    {
        return studentMapper.saveAnswer(answer);
    }
    @GetMapping("/choosemajor")
    public List<major> chooseMajor()
    {
        return studentMapper.chooseMajor();
    }
    @GetMapping("/getpid")
    public Answer getpid(){
        return studentService.getPid();
    }
    @GetMapping("/reviewPaper")
    public List<Question> reviewPaper(@RequestParam(defaultValue = "") String pid){
        return studentMapper.reviewPaper(pid);
    }
    @PostMapping("/regist")
    public boolean register(@RequestBody StudentDTO studentDTO)
    {
        return studentService.register(studentDTO);
    }
}
