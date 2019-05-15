package com.hyl.biz.entity;

import com.hyl.core.model.BaseObj;

import java.util.Date;

public class News extends BaseObj {
    //新闻信息
    private String titie;//新闻主题
    private String content;//新闻内容
    private Date time;//新闻发布的时间
    private String author;//新闻作者

    public String getTitie() {
        return titie;
    }

    public void setTitie(String titie) {
        this.titie = titie;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }


}
