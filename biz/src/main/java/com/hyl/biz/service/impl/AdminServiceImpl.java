package com.hyl.biz.service.impl;

import com.hyl.biz.dao.AdminMapper;
import com.hyl.biz.model.Admin;
import com.hyl.biz.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminMapper adminMapper;

    public int add(Admin admin) {
        return adminMapper.adminAdd(admin);
    }

    public int update(Admin admin) {
        return adminMapper.adminUpdate(admin);
    }

    public void delete(Admin admin) {
        adminMapper.adminDelete(admin);
    }

    public List<Admin> listone(Admin admin) {
        return adminMapper.adminListOne(admin);
    }
}
