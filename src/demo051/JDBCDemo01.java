package demo051;

import pojo.User;

import java.sql.*;
import java.util.ArrayList;

public class JDBCDemo01 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {


        //1加载数据库驱动

        Class.forName("com.mysql.jdbc.Driver");
        // 编写连接数据库的URL地址
        String url = "jdbc:mysql://127.0.0.1:3306/hhhhh";

//        2获取数据库连接
        Connection conn = DriverManager.getConnection(url, "root", "123456");
//        3执行sql语句
        Statement statement = conn.createStatement();
        String sql = "select * from t_book";


//        4处理sql结果
        ResultSet resultSet = statement.executeQuery(sql);
        //定义一个list集合默认arraylist
        //封装到list集合中
        ArrayList<User> objects = new ArrayList<>();
        while (resultSet.next()) {
            User user = new User();


//            System.out.print(resultSet.getString("id"));
//            System.out.print(resultSet.getString(2));
//            System.out.print(resultSet.getString(3));
//            System.out.println(resultSet.getString(4));
        }
//        5停止数据服务释放连接
        resultSet.close();
        statement.close();
        conn.close();
        //这三个必须执行因为资源要释放
        //全局变量空指针异常注意
        //垃圾回收线程

    }

}
