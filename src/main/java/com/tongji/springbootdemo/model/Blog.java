package com.tongji.springbootdemo.model;


import com.tongji.springbootdemo.service.impl.MdToHtmlImpl;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
public class Blog {
    private Integer blogId;
    private Integer authorId;
    private String authorNickname;
    private Integer privateIndex;
    private String title;
    private String content;
    private Integer like;
    private Integer view;
    private Integer star;
    private Timestamp date;
    
    public Integer getStar() {
        return star;
    }
    
    public void setStar(Integer star) {
        this.star = star;
    }
    
    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Integer getAuthorId() {
        return authorId;
    }

    public void setAuthorId(Integer authorId) {
        this.authorId = authorId;
    }

    public String getAuthorNickname() {
        return authorNickname;
    }

    public void setAuthorNickname(String authorNickname) {
        this.authorNickname = authorNickname;
    }

    public Integer getPrivateIndex() {
        return privateIndex;
    }

    public void setPrivateIndex(Integer privateIndex) {
        this.privateIndex = privateIndex;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        MdToHtmlImpl mdToHtml = new MdToHtmlImpl();
        return mdToHtml.convert(content);
    }

    public String getPlainContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Integer getLike() {
        return like;
    }

    public void setLike(Integer like) {
        this.like = like;
    }

    public Integer getView() {
        return view;
    }

    public void setView(Integer view) {
        this.view = view;
    }

    public Timestamp getDate() {
        return date;
    }

    public String getFormattedTime() {
        long interval = System.currentTimeMillis() - date.getTime();
        StringBuilder sb = new StringBuilder();
        if(interval < 1000 * 60){
            sb.append("just now");
        }
        else if (interval < 1000 * 3600) {
            sb.append(interval / 60000);
            if(interval < 120000){
                sb.append(" minute ago");
            }
            else{
                sb.append(" minutes ago");
            }
        }
        else if (interval < 1000 * 3600 * 24) {
            sb.append(interval / 3600000);
            if(interval < 7200000){
                sb.append(" hour ago");
            }
            else{
                sb.append(" hours ago");
            }
        }
        else{
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH mm");
            sb.append(dateFormat.format(date));
        }
        return sb.toString();
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }
}
