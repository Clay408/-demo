package com.coderZ.dao;

import com.coderZ.domain.Admin;

/**
 * @author: CodeZ
 * @date: 2020/7/29 10:41 上午
 * @description:
 */
public class AdminDao extends BasicDao<Admin> {
    public boolean loginByUsernameAndPwd(String sql,String username, String password) {
        Admin admin = querySingle(sql, Admin.class, username, password);
        return admin == null ? false : true;
    }
}