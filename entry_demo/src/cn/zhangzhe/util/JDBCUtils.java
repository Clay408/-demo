package cn.zhangzhe.util;

import com.alibaba.druid.pool.DruidDataSourceFactory;

import javax.sql.DataSource;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

/*
* 数据库连接池的工具类
* */
public class JDBCUtils {
    private static DataSource ds;

    static {
        Properties pro = new Properties();
        try {
            InputStream is = JDBCUtils.class.getClassLoader().getResourceAsStream("druid.properties");
            pro.load(is);
            //初始化连接池对象
            ds = DruidDataSourceFactory.createDataSource(pro);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }

    /*
    * 获取连接池的方法
    * */
    public static DataSource getDataSource(){
        return ds;
    }


    /*
    * 获取连接对象的方法
    * */

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }
}
