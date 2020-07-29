package com.coderZ.test;

import com.coderZ.dao.CustomerDao;
import com.coderZ.domain.Customer;
import org.junit.Test;

import java.util.List;

/**
 * @author: CodeZ
 * @date: 2020/7/28 8:26 下午
 * @description:
 */
public class CustomerDaoTest {

    CustomerDao customerDao = new CustomerDao();

    @Test
    public void querySingle(){
        String sql = "select * from customer where id = ?";
        Customer customer = customerDao.querySingle(sql, Customer.class,1);
        System.out.println(customer);
    }

    @Test
    public void queryList(){
        String sql = "select * from customer";
        List<Customer> customers = customerDao.queryList(sql, Customer.class);
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }

    @Test
    public void update(){
//        String sql = "insert into customer values(null,?,?,?,?,?)";
//        String sql = "delete from customer where id = 3";
        String sql = "update customer set id = 3 where id = 4 ";
//        int resNum = customerDao.update(sql, "李四", "男", 20, "123123", "123@qq.com");
        int resNum = customerDao.update(sql);
        System.out.println(resNum > 0 ? "OK" : "failed");
    }

    @Test
    public void querySingleValue(){
        String sql = "select name from customer where id = ?";
        Object o = customerDao.querySingleValue(sql, 1);
        System.out.println(o);
    }

}