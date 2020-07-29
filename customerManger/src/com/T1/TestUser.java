package com.T1;

import org.junit.Test;

import java.util.Scanner;

/**
 * @author: CodeZ
 * @date: 2020/7/29 10:03 上午
 * @description:
 */
public class TestUser {
    private UserDao userDao = new UserDao();
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new TestUser().add();
    }
    public void add(){
        System.out.print("输入姓名:");
        String name = scanner.next();
        System.out.print("输入邮箱:");
        String email = scanner.next();
        System.out.print("输入生日:");
        String birthday = scanner.next();

        String sql = "insert into users values(null,?,?,?)";
        int resNum = userDao.addUser(sql, name, email, birthday);
        System.out.println(resNum > 0 ? "ok" : "failed");
    }
}