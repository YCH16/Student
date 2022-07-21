package com.example.student.entity;

import lombok.Data;

@Data
public class Question {
    private int sid;
    private int mno;
    private  int type;
    private String content;
    private String optiona;
    private String optionb;
    private String optionc;
    private String optiond;
    private String optione;
    private String studentkey;

}
