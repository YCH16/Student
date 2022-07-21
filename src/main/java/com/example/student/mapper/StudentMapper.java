package com.example.student.mapper;
import com.example.student.controller.dto.StudentDTO;
import com.example.student.controller.dto.Exam;
import com.example.student.controller.dto.major;
import com.example.student.entity.Answer;
import com.example.student.entity.Question;
import com.example.student.entity.Student;
import org.apache.ibatis.annotations.*;

import java.util.List;
@Mapper
public interface StudentMapper {
    @Select("select* from Student")
    List<Student> FindAll();

    @Insert("insert into Student (Sname,Snum,Cnum,PassWord) values(#{sname},#{snum},#{cnum},#{password})")
    int insert(Student student);
    int update(Student student);
    @Select("select* from Student")
    List<StudentDTO> GetInfo();

    @Select("select* from Exam where sname=#{sname}")
    List<Exam> getPaper(String sname);
    @Delete("delete from Exam where date=#{date}")
    boolean deleteExam(String date);

    @Select("select* from subject where mno=#{m} and type=#{type}")
    List<Question> SelectQuestion(int m, int type);
//    @Insert("insert into exam (date,sname,major1,major2,tested) VALUES (#{date},#{snum},#{major1},#{major2},0)")
//    boolean saveExam(String date, String snum, String major1, String major2);
//    @Insert("insert into Paper (snum,date,type,major,title,optiona,optionb,optionc,optiond,optione,f,answer,id) VALUES (#{snum},#{date}," +
//            "#{question.type},#{question.major},#{question.title},#{question.a}," +
//            "#{question.b},#{question.c},#{question.d},#{question.e},#{question.f},#{question.answer},#{question.id})")
//    boolean savepaper(Question question, String date, String snum);
    @Select("select distinct pid,username,mname,time from answer,subject,major where answer.sid=subject.sid and subject.mno=major.mno")
    List<Exam> getExam();
//    @Select("select* from paper where snum=#{snum} and date=#{date}")
//    List<Question> getQuestion(String snum, String date);
    @Update("update student set truename=#{truename},coll=#{coll},gender=#{gender},classname=#{classname},tele=#{tele} where username=#{username}")
    boolean updateInfo(StudentDTO studentDTO);
    @Insert("insert into answer (username,sid,pid,studentkey,time) values(#{username},#{sid},#{pid},#{studentkey},#{time})")
    boolean saveAnswer(Answer answer);
    @Select("select * from major")
    List<major> chooseMajor();
    @Select("select pid from answer where pid=#{paperid}")
    String getPaperid(String paperid);
    @Select("select *from answer,subject where answer.pid=#{pid} and answer.sid=subject.sid")
    List<Question> reviewPaper(String pid);
    @Insert("insert into student (truename,username,coll, gender,classname,tele,password) values(#{truename},#{username},#{coll}, #{gender},#{classname},#{tele},#{password})")
    boolean register(StudentDTO s);
}
