package demo051;

import org.junit.jupiter.api.Test;
import pojo.A;

import java.sql.*;
import java.util.ArrayList;

public class JDBCDemo03 {

    @Test
    public void TestInsert() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/hhhhh";
        Connection connection = DriverManager.getConnection(url, "root", "123456");
        Statement statement = connection.createStatement();

        String sql = "insert into a values ('张三','888888','zhangsan@126.com','1986-10-11',1200),('李四','999999','lisi@126.com','1988-10-23',700),('王五','777777','wangwu@126.com','1990-9-11',2150)";
        //String sql = "delete from users  where id = 2";
        statement.executeUpdate(sql);

        connection.close();
        statement.close();

    }

    @Test
    public void TestUpdate() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/hhhhh";
        Connection connection = DriverManager.getConnection(url, "root", "123456");
        Statement statement = connection.createStatement();
       // Date date = new Date();


        String sql = "update a set birthday =SYSDATE() where name = '张三'";
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

        String sql = "delete from a where name = '王五'";
        //String sql = "delete from users  where id = 2";
        statement.executeUpdate(sql);

        connection.close();
        statement.close();

    }

    @Test
    public void TestSelect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://127.0.0.1:3306/hhhhh";
        Connection connection = DriverManager.getConnection(url, "root", "123456");
        Statement statement = connection.createStatement();

        String sql = "select * from a where birthday > '1987-12-12'";
        //String sql = "delete from users  where id = 2";
        ResultSet resultSet = statement.executeQuery(sql);
        A a = new A();
        ArrayList<A> users = new ArrayList<>();

        while (resultSet.next()){

           // System.out.println(resultSet.getString("name"));
            a.setName(resultSet.getString("name")) ;
            a.setPwd(resultSet.getString("pwd")); ;
            a.setEmail(resultSet.getString("email")); ;
            a.setBirthday(resultSet.getDate("birthday"));
            a.setMoney(resultSet.getInt("money"));
            users.add(a);
            System.out.println();
            System.out.println(users);



        }
        //System.out.println(users);

        resultSet.close();
        connection.close();
        statement.close();

    }

}
