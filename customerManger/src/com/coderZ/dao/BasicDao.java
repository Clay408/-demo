package com.coderZ.dao;

import com.coderZ.utils.JDBCUtilsByDriud;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @author: CodeZ
 * @date: 2020/7/28 7:52 下午
 * @description:
 */
public class BasicDao<T> {
    private QueryRunner queryRunner = new QueryRunner();

    /**
     * 返回一条记录
     * @param sql 执行的sql语句
     * @param clazz 封装类型
     * @param args sql语句中的参数
     * @return 如果返回null，说明没有查询到，否则就是查询到了
     */
    public T querySingle(String sql,Class<T> clazz,Object...args){
        Connection conn = JDBCUtilsByDriud.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanHandler<T>(clazz),args);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCUtilsByDriud.close(conn);
        }
        return null;
    }

    /**
     * 查询多条记录
     * @param sql
     * @param clazz
     * @param args
     * @return 返回一个List集合，集合中是查询到的所有记录
     */
    public List<T> queryList(String sql,Class<T> clazz,Object...args){
        Connection conn = JDBCUtilsByDriud.getConnection();
        try {
            return queryRunner.query(conn,sql,new BeanListHandler<T>(clazz),args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }finally {
            JDBCUtilsByDriud.close(conn);
        }
    }

    public Object querySingleValue(String sql,Object...args){
        Connection conn = JDBCUtilsByDriud.getConnection();
        try {
            return queryRunner.query(conn,sql,new ScalarHandler(),args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDriud.close(conn);
        }
    }


    /**
     * 增删改
     * @param sql
     * @param args
     * @return
     */
    public int update(String sql,Object...args){
        Connection conn = JDBCUtilsByDriud.getConnection();
        try {
            return queryRunner.update(conn,sql,args);
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            JDBCUtilsByDriud.close(conn);
        }
    }
}