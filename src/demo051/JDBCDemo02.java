package demo051;

import org.junit.jupiter.api.Test;
import pojo.User;

import java.sql.*;
import java.util.ArrayList;

public class JDBCDemo02 {

    @Test
    public void TextSelect() throws ClassNotFoundException, SQLException {

        //第一步获取数据库驱动
        Class.forName("com.mysql.jdbc.Driver");
        //第二步获取数据
        String url = "jdbc:mysql://127.0.0.1:3306/hhhhh";
        Connection connection = DriverManager.getConnection(url, "root", "123456");
        //第三步给数据添加sql语句
        Statement statement = connection.createStatement();

        String sql = "select * from users ";
        //第四处理sql语句
        ResultSet resultSet = statement.executeQuery(sql);

        ArrayList<User> users = new ArrayList<>();

        while (resultSet.next()) {
            User user = new User();

            resultSet.getString("id");
            resultSet.getString("user");
            resultSet.getString("password");
            resultSet.getString("address");
        }
        //结束资源
        resultSet.close();
        connection.close();
        statement.close();

    }

    @Test
    public void TestInsert() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/hhhhh";
        Connection connection = DriverManager.getConnection(url, "root", "123456");

        Statement statement = connection.createStatement();

        // 定义sql语句
        // String sql = "insert into users values(null , '赵', 'zhasi' ,'东')";
        String sql = "insert into users values (7,'hu','ou','北'), (6,'u','u','a')";
        statement.executeUpdate(sql);

        connection.close();
        // resultSet.close();
        statement.close();

    }

    @Test
    public void TestUpdate() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/hhhhh";
        Connection connection = DriverManager.getConnection(url, "root", "123456");
        Statement statement = connection.createStatement();

        String sql = "update users set user = '刘能' where id = 1";
        //String sql = "delete from users  where id = 2";
        statement.executeUpdate(sql);

        connection.close();
        statement.close();

    }

    @Test
    public void TestDelect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/hhhhh";
        Connection connection = DriverManager.getConnection(url, "root", "123456");
        Statement statement = connection.createStatement();

        //String sql = "delete from users where id = '1'";
        String sql = "delete from users  where id = 2";
        statement.executeUpdate(sql);

        connection.close();
        statement.close();

    }

}
