package com.tongji.springbootdemo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Calendar;
import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    private Integer id;
    private String title;
    private String content;
    private String author;
    private Calendar date = Calendar.getInstance();
    private Integer like;
    private Integer view;
}
