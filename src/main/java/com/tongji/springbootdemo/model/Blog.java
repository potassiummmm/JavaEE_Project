package com.tongji.springbootdemo.model;


import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    private Integer id;
    private String title;
    private String content;
    private Date date;
    private Integer like;
    private Integer view;
}
