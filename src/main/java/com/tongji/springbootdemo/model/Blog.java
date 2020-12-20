package com.tongji.springbootdemo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    private Integer blogId;
    private String title;
    private String content;
    private String author;
    private Calendar date = Calendar.getInstance();
    private Integer like;
    private Integer view;


    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Integer getId() {
        return blogId;
    }
    public Calendar getDate() {
        return date;
    }

    public static void main(String[] args) {
        DateFormat d = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.ENGLISH);
        Date dateTest =new Date();
        System.out.println(d.format(dateTest));
    }

    public String getAuthor() {
        return author;
    }
}
