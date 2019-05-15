package com.hyl.biz.entity;

import com.hyl.core.model.BaseObj;

public class Admin extends BaseObj {
    //管理员
    private String nickname;//管理员昵称
    private String pass;//管理员密码
    private String name;//管理员姓名
    private String number;//管理员手机号码

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    private String avatar;//管理员头像
}
