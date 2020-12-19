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
    private Integer blogId;
    private String title;
    private String content;
    private String author;
    private Calendar date = Calendar.getInstance();
    private Integer like;
    private Integer view;


//    public static void main(String[] args) {
//        Blog b = new Blog();
//        System.out.println(b.getDate().get(Calendar.YEAR) + "/" + (b.getDate().get(Calendar.MONTH) + 1) + "/" + b.getDate().get(Calendar.DATE));
//    }

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
        Blog b = new Blog();
        System.out.println(b.getDate().get(Calendar.YEAR) + "/" + (b.getDate().get(Calendar.MONTH) + 1) + "/" + b.getDate().get(Calendar.DATE));

    }

}
