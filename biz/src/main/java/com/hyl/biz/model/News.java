package com.hyl.biz.model;

import java.sql.Date;

public class News extends BaseModel {
    private String id;
    private String titie;
    private String content;
    private Date time;
    private String author;
    private String img_url;

    public String getid() {
        return id;
    }

    public void setid(String id) {
        this.id = id;
    }

    public String gettitie() {
        return titie;
    }

    public void settitie(String titie) {
        this.titie = titie;
    }

    public String getcontent() {
        return content;
    }

    public void setcontent(String content) {
        this.content = content;
    }

    public Date gettime() {
        return time;
    }

    public void settime(Date time) {
        this.time = time;
    }

    public String getauthor() {
        return author;
    }

    public void setauthor(String author) {
        this.author = author;
    }

    public String getimg_url() {
        return img_url;
    }

    public void setimg_url(String img_url) {
        this.img_url = img_url;
    }
}
