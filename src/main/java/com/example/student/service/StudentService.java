package com.example.student.service;

import com.example.student.controller.dto.StudentDTO;
import com.example.student.controller.dto.Exam;
import com.example.student.entity.Answer;
import com.example.student.entity.chooseMajor;
import com.example.student.entity.Question;
import com.example.student.entity.Student;
import com.example.student.mapper.StudentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;
import java.util.ArrayList;
import java.util.List;

@Service
public class StudentService {
    @Autowired
    private StudentMapper studentMapper;

    public int  save(Student student){
        if(student.getSnum()!=null&&student.getSname()!=null)
            return studentMapper.insert(student);
        else return studentMapper.update(student);
    }

    public StudentDTO login(StudentDTO studentDTO) {
        String studentnumber=studentDTO.getUsername();
        String password=studentDTO.getPassword();
        List<StudentDTO> s=studentMapper.GetInfo();
       // List<StudentDTO> s=studentMapper.GetInfo();
        StudentDTO resault=new StudentDTO();
        for(StudentDTO studentDTO1:s)
        if(password.equals(studentDTO1.getPassword())&&studentDTO1.getUsername().equals(studentnumber))
        {
      resault=studentDTO1;
      resault.setToken(true);
        }
        return resault;
    }

    public List<Question> choose(chooseMajor choosemajor) {
        int major1=choosemajor.getMajor1();
        int major2=choosemajor.getMajor2();
        List<Question> paper=new ArrayList<>();
        List<Integer> major=new ArrayList<>();
        major.add(major1);major.add(major2);
        for(int type=1;type<=4;type++)
            for(int m:major)
            {
                List<Question> questions=studentMapper.SelectQuestion(m,type);
                paper.addAll(getQuestion(questions,2));
            }

   return paper;
    }
    public List<Question> getQuestion(List<Question> q,int number)
    {
     List<Question> questions=new ArrayList<>();
     List<Integer> numList=RandomList(q.size(),number);
     for(Integer index : numList)
     {
         questions.add(q.get(index));
     }
     return questions;
    }
    public List<Integer> RandomList(int number,int size)
    {
        List<Integer> list=new ArrayList<>();
        List<Integer> randomList=new ArrayList<>();
        Random r=new Random();
        for(int i=0;i<number;i++)
            list.add(i);
        for(int i=0;i<size;i++)
        {
            int index=r.nextInt(number-i);
            randomList.add(list.get(index));
            list.remove(index);
        }
        return randomList;
    }
    public static void main(String[] args) {

    }

    public Answer getPid() {
        Answer answer=new Answer();
                Random r=new Random();
        String paperid="";
        do {
            paperid = String.valueOf(r.nextInt(9000) + 1000);
        }while( studentMapper.getPaperid(paperid) != null);
        SimpleDateFormat formatter= new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date = formatter.format(new Date(System.currentTimeMillis()));
        answer.setPid(paperid);
        answer.setTime(date);
        return answer;
    }

    public List<Exam> getPaper(String username) {
        List<Exam> list=studentMapper.getExam();
        List<Exam> exams1=new ArrayList<>();
        List<Exam> exams=new ArrayList<>();
        for(Exam exam:list)
        {
        if(exam.getUsername().equals(username))
            exams1.add(exam);
        }
        for(Exam exam:exams1)
        {
            exam.setMajor1(exam.getMname());
            for(Exam exam1:exams1)
                if(exam.getPid().equals(exam1.getPid())&&!exam.getMname().equals(exam1.getMname()))
                {
            exam.setMajor2(exam1.getMname());
            break;
                }
            boolean add=true;
            for(Exam exam1:exams)
                if(exam1.getPid().equals(exam.getPid()))add=false;
            if(add) exams.add(exam);
        }
        return exams;
    }

    public boolean register(StudentDTO studentDTO) {
        List<StudentDTO> s=studentMapper.GetInfo();
        boolean registed=false;
        for(StudentDTO studentDTO1:s)
            if(studentDTO.getUsername().equals(studentDTO1.getUsername()))
                 registed=true;
        if(registed)return false;
        else return studentMapper.register(studentDTO);
    }
}
