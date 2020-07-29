package com.coderZ.service;

import com.coderZ.dao.CustomerDao;
import com.coderZ.domain.Customer;

import java.util.List;

/**
 * @author: CodeZ
 * @date: 2020/7/28 8:39 下午
 * @description:
 */
public class CustomerService {
    CustomerDao customerDao = new CustomerDao();


    /**
     * 获得客户列表
     *
     * @return 返回客户列表
     */
    public List<Customer> getList() {
        String sql = "select * from customer";
        return customerDao.queryList(sql, Customer.class);
    }

    /**
     * 添加客户
     * @param customer
     * @return
     */
    public boolean add(Customer customer) {
        String sql = "insert into customer values(null,?,?,?,?,?)";
        int resNum = customerDao.update(sql, customer.getName(), customer.getSex(), customer.getAge(), customer.getPhone(), customer.getEmail());
        return resNum > 0;
    }

    /**
     * 修改客户
     */
    public boolean update(int id, String name, String sex, int age, String phone, String email) {
        String sql = "update customer set name=?,sex=?,age=?,phone=?,email=? where id = ?";
        int resNum = customerDao.update(sql, name, sex, age, phone, email, id);
        return resNum > 0;
    }

    /**
     * 按id查询指定客户
     *
     * @param id
     * @return
     */
    public Customer queryCus(int id) {
        String sql = "select * from customer where id = ?";
        return customerDao.querySingle(sql, Customer.class,id);
    }

    public boolean deleteCus(int id) {
        String sql = "delete from customer where id = ?";
        int resNum = customerDao.update(sql, id);
        return resNum > 0;
    }

}