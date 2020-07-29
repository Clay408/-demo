package com.T1;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: CodeZ
 * @date: 2020/7/29 9:16 上午
 * @description:
 */
public class UserDao {
    private QueryRunner queryRunner = new QueryRunner();

    //添加用户
    public int addUser(String sql,Object...args){
        Connection conn = JdbcByDruid.getConnection();
        try {
            return queryRunner.update(conn, sql,args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcByDruid.close(conn);
        }
    }

    //修改客户
    public int updateUser(String sql,Object ...args){
        Connection connection = JdbcByDruid.getConnection();
        try {
            return queryRunner.update(connection,sql,args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcByDruid.close(connection);
        }
    }

    //显示所有客户信息
    public List<User> list(){
        Connection conn = JdbcByDruid.getConnection();
        String sql = "select  * from users";
        try {
            return queryRunner.query(conn,sql,new BeanListHandler<User>(User.class));
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcByDruid.close(conn);
        }
    }

    //根据条件查询客户的详细信息
    public User queryUser(String sql,Object...args){
        Connection conn = JdbcByDruid.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanHandler<User>(User.class),args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JdbcByDruid.close(conn);
        }
    }
}