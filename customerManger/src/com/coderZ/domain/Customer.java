package com.coderZ.domain;

/**
 * @author: CodeZ
 * @date: 2020/7/28 8:16 下午
 * @description:
 */
public class Customer {
    private Integer id;
    private String name;
    private String sex;
    private Integer age;
    private String phone;
    private String email;

    public Customer(Integer id, String name, String sex, Integer age, String phone, String email) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.phone = phone;
        this.email = email;
    }

    public Customer() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return id + "\t" + name + "\t" + sex + "\t" + age + "\t" + phone + "\t" + email;
    }
}