package com.ele.Utils;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

public class JDBCUtil {
    //提取出来这个要一直用不能放里面但是还得是静态
    private static final DruidDataSource ds;

    //用静态代码块先加载数据库驱动
    static {
        ds = new DruidDataSource();
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/jdbc_ele");
        ds.setUsername("root");
        ds.setPassword("123456");

    }
    //用来返回这个数据源用来接下来获取链接
    public static DataSource getDataSource(){
        return ds;
    }
    //这个用到的是getConnection不是set
    public static Connection getConnection() throws SQLException {
        return  ds.getConnection();
    }

}
