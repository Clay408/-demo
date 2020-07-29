package com.coderZ.service;

import com.coderZ.dao.AdminDao;

/**
 * @author: CodeZ
 * @date: 2020/7/29 10:48 上午
 * @description:
 */
public class AdminService {
    AdminDao adminDao = new AdminDao();

    //登陆验证
    public boolean login(String username,String password){
        String sql = "select * from admin where username=? and password=?";
        return adminDao.loginByUsernameAndPwd(sql,username,password);
    }
}