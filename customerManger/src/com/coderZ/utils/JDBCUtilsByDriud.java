package com.coderZ.utils;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

/**
 * @author: CodeZ
 * @date: 2020/7/28 4:31 下午
 * @description:
 */
public class JDBCUtilsByDriud {

    static DataSource ds;
    static {
        try {
            Properties pro = new Properties();
            InputStream resourceAsStream = JDBCUtilsByDriud.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(resourceAsStream);
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }


    public static Connection getConnection(){
        Connection conn = null;
        try {
            conn = ds.getConnection();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return conn;
    }

    public static void close(Connection conn){
        try {
            if (conn != null){
                conn.close();
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }

}