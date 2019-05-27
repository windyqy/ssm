package com.hyl.biz.service;

import com.lx.pojo.Admin;

import java.util.List;

public interface AdminService {
    public int add(Admin admin);
    public int update(Admin admin);
    public void delete(Admin admin);
    public List<Admin> listone(Admin admin);
}
