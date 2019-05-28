package com.hyl.biz.dao;

import com.hyl.biz.model.User;

import java.util.List;

public interface UserMapper {
    public List<User> userListOne(User user);

    public int userAdd(User user);

    public int userUpdate(User user);

    public void userDelete(User user);
}
