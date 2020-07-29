package com.T1;

import java.util.Date;

/**
 * @author: CodeZ
 * @date: 2020/7/29 9:12 上午
 * @description:
 */
public class User {
    private int id;
    private String name;
    private String email;
    private Date birthday;

    public User(int id, String name, String email, Date birthday) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.birthday = birthday;
    }

    public User() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    @Override
    public String toString() {
        return id + "_" + name + "_" + email  + "_" + birthday;
    }
}