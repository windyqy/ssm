package com.hyl.biz.dao;

import com.hyl.biz.model.Admin;

import java.util.List;

public interface AdminMapper {
    public int adminAdd(Admin admin);

    public int adminUpdate(Admin admin);

    public void adminDelete(Admin admin);

    public List<Admin> adminListOne(Admin admin);
}
