package shop.ele2.util;

import com.alibaba.druid.pool.DruidDataSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author 侯博
 * @date 2024/8/9
 */
public class Util {
    private static final DruidDataSource ds;

    static {
        ds = new DruidDataSource();
        ds.setUsername("123456");
        ds.setPassword("root");
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/jdbc_ele");
        ds.setDriverClassName("com.mysql.jdbc.Driver");
    }

    public static DataSource getDataSource() {
        //用来返回datasource  对象ds
        return ds;
    }

    public static Connection getConnection() throws SQLException {
        return ds.getConnection();
    }

}
