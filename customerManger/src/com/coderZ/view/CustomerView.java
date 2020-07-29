package com.coderZ.view;

import com.coderZ.domain.Customer;
import com.coderZ.service.AdminService;
import com.coderZ.service.CustomerService;
import com.coderZ.utils.CMUtility;

import java.util.List;
import java.util.Scanner;

/**
 * @author: CodeZ
 * @date: 2020/7/28 9:00 下午
 * @description:
 */
public class CustomerView {
    private CustomerService customerService = new CustomerService();
    private AdminService adminService = new AdminService();
    private boolean flag = true;
    private Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        new CustomerView().mainMenu();
    }

    public void mainMenu() {
       while (flag){
           if (loginCheck()){
               String key = "";
               while (flag) {
                   System.out.println("-----------------客户信息管理软件-----------------");
                   System.out.println("\t\t\t1 添 加 客 户");
                   System.out.println("\t\t\t2 修 改 客 户");
                   System.out.println("\t\t\t3 删 除 客 户");
                   System.out.println("\t\t\t4 客 户 列 表");
                   System.out.println("\t\t\t5 查 询 客 户");
                   System.out.println("\t\t\t6 退      出");
                   System.out.print("请选择(1-6)：");
                   key = scanner.next();
                   switch (key) {
                       case "1":
                           System.out.println("----添加客户----");
                           addCustomer();
                           break;
                       case "2":
                           System.out.println("----修改客户----");
                           modify();
                           break;
                       case "3":
                           System.out.println("----删除客户----");
                           delete();
                           break;
                       case "4":
                           System.out.println("----客户列表----");
                           list();
                           break;
                       case "5":
                           System.out.println("----查询客户----");
                           queryCus();
                           break;
                       case "6":
                           System.out.println("----退    出----");
                           flag = false;
                           break;
                   }
               }
           }else {
               System.out.println("用户名或密码错误，重新登录");
               continue;
           }
       }
    }

    //登陆验证
    private boolean loginCheck(){
        System.out.print("输入用户名:");
        String username = CMUtility.readString(32, null);
        System.out.print("输入密码:");
        String password = CMUtility.readString(32, null);
        return adminService.login(username,password);
    }

    //显示所有客户信息
    private void list() {
        List<Customer> list = customerService.getList();
        System.out.println("---------------------客户列表---------------------");
        System.out.println("id\t姓名\t性别\t电话\t邮箱");
        for (Customer customer : list) {
            System.out.println(customer);
        }
        System.out.println("---------------------展示完毕---------------------");
    }

    //添加客户
    private void addCustomer() {
        System.out.println("---------------------添加客户---------------------");
        System.out.println("姓名:");
        String name = CMUtility.readString(8);
        System.out.println("性别:");
        String sex = CMUtility.readString(1, "男");
        System.out.println("年龄:");
        int age = CMUtility.readInt();
        System.out.println("电话");
        String phone = CMUtility.readString(12);
        System.out.println("邮箱:");
        String email = CMUtility.readString(16);

        Customer customer = new Customer(0, name, sex, age, phone, email);
        boolean res = customerService.add(customer);
        if (res) {
            System.out.println("添加成功");
        } else {
            System.out.println("添加失败");
        }
    }

    //修改客户
    private void modify() {
        System.out.println(" ---------------------修改客户---------------------");
        System.out.println("请选择待修改客户编号(-1退出)：");
        int id = CMUtility.readInt();//接收输入
        if (id == -1) {//判断输入选项
            System.out.println("取消修改");
            return;
        } else {
            Customer customer = customerService.queryCus(id);
            if (customer != null) {
                System.out.printf("姓名(%s):", customer.getName());
                String name = CMUtility.readString(8, customer.getName());

                System.out.printf("性别(%s):", customer.getSex());
                String sex = CMUtility.readString(10, customer.getSex());

                System.out.printf("年龄(%s):", customer.getAge());
                int age = CMUtility.readInt(customer.getAge());

                System.out.printf("电话(%s):", customer.getPhone());
                String phone = CMUtility.readString(12, customer.getPhone());

                System.out.printf("邮箱(%s):", customer.getEmail());
                String email = CMUtility.readString(16, customer.getEmail());

                boolean res = customerService.update(id, name, sex, age, phone, email);
                if (res) {
                    System.out.println("---------------------修改完成---------------------");
                }else {
                    System.out.println("---------------------修改失败---------------------");
                }
            } else {
                System.out.println("---------------------查无此人---------------------");
            }
        }
    }

    //删除客户
    private void delete(){
        System.out.println("\t\t请选择(1-5)：");
        System.out.println("---------------------删除客户---------------------");
        System.out.println("输入删除客户的ID");
        int delId = CMUtility.readInt();
        if (delId == -1) {
            System.out.println("---------------------取消删除---------------------");
            return;
        }
        System.out.println("确认是否删除(Y/N)：");
        char choice = CMUtility.readConfirmSelection();
        if (choice == 'Y') {
            if (customerService.deleteCus(delId)) {
                System.out.println("---------------------删除完成---------------------");
            } else {
                System.out.println("---------------------删除失败---------------------");
            }
        } else if (choice == 'N') {
            System.out.println("---------------------取消删除---------------------");
        }
    }

    private void queryCus(){
        System.out.println("---------------------查询客户---------------------");
        System.out.println("输入要查询的客户ID(-1取消查询):");
        int id = CMUtility.readInt();
        if (id == -1){
            System.out.println("---------------------取消查询---------------------");
            return;
        }
        Customer customer = customerService.queryCus(id);
        if (customer == null){
            System.out.println("---------------------不存在该客户---------------------");
            return;
        }
        System.out.print("编号\t\t姓名\t\t性别\t\t年龄\t\t电话\t\t邮箱\n");
        System.out.println(customer);
        System.out.println("---------------------打印完成---------------------");
    }
}