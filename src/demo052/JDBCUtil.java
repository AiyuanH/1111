package demo052;

import cn.hutool.db.Db;

import java.sql.*;
import java.util.ArrayList;

public class JDBCUtil {


    private static Connection conn;

    static{
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/hhhhh");
            //jdbc.mysql://127.0.0.1:3306/hhhhh错误的
          //  Statement st = conn.createStatement();
           // String sql = "select * from a";
        } catch (ClassNotFoundException| SQLException e) {
            e.printStackTrace();
        }
    }
    /*
     * 提供获取连接的代码
     */
    public static Connection getConnection() throws Exception{
        // 获取连接
        return conn;
    }


    public static void close(Connection conn, Statement st){
   close(conn,st);


    }

    public static void close(Connection conn, Statement st, ResultSet re){
        try {
            if(conn!=null){
                conn.close();
            }
        } catch (SQLException throwables) {
            conn =null;
            throwables.printStackTrace();
        }
        try {
            if(st!=null){
                st.close();
            }
        } catch (SQLException throwables) {
            st =null;
            throwables.printStackTrace();
        }
        try {
            if(re!=null){
                re.close();
            }
        } catch (SQLException throwables) {
            re =null;
            throwables.printStackTrace();
        }


    }

}
