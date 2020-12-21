package com.tongji.springbootdemo.model;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    private Integer blogId;
    private Integer authorId;
    private Integer privateIndex;
    private String title;
    private String content;
    private Integer like;
    private Integer view;
    private Date date;

    public String getTitle() {
        return title;
    }

    public String getContent() {
        return content;
    }

    public Integer getBlogId() {
        return blogId;
    }
//    public Calendar getDate() {
//        return date;
//    }
//
//    public static void main(String[] args) {
//        Blog b = new Blog();
//        System.out.println(b.getDate().get(Calendar.YEAR) + "/" + (b.getDate().get(Calendar.MONTH) + 1) + "/" + b.getDate().get(Calendar.DATE));
//
//    }

    public Integer getAuthorId() {
        return authorId;
    }
}
