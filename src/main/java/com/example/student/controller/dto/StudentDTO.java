package com.example.student.controller.dto;

import lombok.Data;

@Data
public class StudentDTO {
    private String truename;
    private String gender;//性别
    private String coll;//院系
    private String classname;//班级号
    private String password;
    private String username;//
    private String tele;
    private boolean token=false;

}
