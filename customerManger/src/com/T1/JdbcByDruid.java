package com.T1;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author: CodeZ
 * @date: 2020/7/29 9:05 上午
 * @description:
 */
public class JdbcByDruid {
    private static DataSource ds;

    static {
        try {
            Properties pro = new Properties();
            InputStream rs = JdbcByDruid.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(rs);

            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        try {
            return ds.getConnection();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static void close(Connection con){
        try {
            if (con!=null){
                con.close();
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }
}