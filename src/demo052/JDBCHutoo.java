package demo052;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.alibaba.druid.pool.DruidDataSource;
import org.junit.jupiter.api.Test;
import pojo.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.List;

public class JDBCHutoo {
    @Test
    public void HutoolQuery() throws Exception {
//        Connection conn = JDBCUtil.getConnection();
//        PreparedStatement preparedStatement = conn.prepareStatement("");
//使用hutool的包里面的数据库语言DruidDateSource来创建对象
        //创建一个对象hutool包中用来操控数据库的对象
        DruidDataSource ds = new DruidDataSource();
        //用ds对象调用url，username，password set是用来获取对象的get是用来输出对象的
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/hhhhh");
        ds.setUsername("root");
        ds.setPassword("123456");
        //数据库连接完成后接下来该弄数据库驱动
        //使用setDriverClassName来获取数据库驱动
        ds.setDriverClassName("com.mysql.jdbc.Driver");
        //接下来输入SQL语句但是u这个工具类呢很牛逼他可以不用sql语句调用sql语句其实还是sql语句
        //Entity这是一个翻译过来是实体还有形就是这个工具类的一个类用来记录传进来的参数并且有两个参数一个是sql语句一个是
        //参数id
        //sql: 一个 SQL 查询字符串。此查询应返回一行数据。例如："SELECT * FROM users WHERE id = ?"。
        //params: SQL 查询中的参数。这些参数将依次替换 SQL 查询中的问号 (?) 占位符。如果查询中没有参数，则可以省略此参数。

        List<Entity> entitiy =Db.use(ds).findAll("users");
        System.out.println(entitiy);
//        Entity entity = Db.use(ds).queryOne("select * from users where id = ?", 1);
//
//        //System.out.println(entity.getStr("id"));
//        if (entity != null) {
//            System.out.println("ID: " + entity.getInt("id"));
//            System.out.println("Name: " + entity.getStr("user"));
//            //System.out.println("Email: " + entity.getStr("email"));
//        } else {
//            System.out.println("No user found with the specified ID.");
//        }
    }
    @Test
    public void HutoolInsert() throws Exception {
        // 创建一个 DruidDataSource 对象
        DruidDataSource ds = new DruidDataSource();
        // 设置数据库连接的 URL、用户名和密码
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/hhhhh");
        ds.setUsername("root");
        ds.setPassword("123456");
        // 设置 MySQL 5.0 JDBC 驱动类名
        ds.setDriverClassName("com.mysql.jdbc.Driver"); // 适用于 MySQL 5.0
        // 执行插入
        //注意事项
        //列定义: 确保表中的列定义允许你插入的数据。例如，如果 id 列是 NOT NULL 并且没有默认值，你需要提供一个有效的值。
        //默认值和自增列: 对于有默认值或自增属性的列，你可以在插入操作中省略它们。
        //数据验证: 在实际插入之前，确保你的数据符合表结构和约束条件，以避免插入失败
        Db.use(ds).insert(Entity.create("users")
                .set("id", 776)
                .set("user", "456")
                .set("password", "77898")
                .set("address", "hh456a"));
        //System.out.println(entity);
        //NOT NULL 列: 必须提供值。
        //自增列: 不需要提供值，数据库会自动生成。
        //可选列: 可以省略，数据库将使用默认值或 NULL。
        Db.use(ds).insert(Entity.create("users").set("id", 9)
                .set("user", "3")
                .set("password", "8")
                .set("address", "h456a"));
    }
    @Test
    public void HutoolUpdate() throws Exception {
        // 创建一个 DruidDataSource 对象
        DruidDataSource ds = new DruidDataSource();
        // 设置数据库连接的 URL、用户名和密码
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/hhhhh");
        ds.setUsername("root");
        ds.setPassword("123456");
        // 设置 MySQL 5.0 JDBC 驱动类名
        ds.setDriverClassName("com.mysql.jdbc.Driver"); // 适用于 MySQL 5.0

        // 执行
//        Db.use(ds).insert(Entity.create("users").set("id",776)
//                .set("user","456")
//                .set("password","77898")
//                .set("address","hh456a"));
        //第一个参数是要改成什么第二个参数是那个表的那个值
        Db.use(ds).update(
                Entity.create().set("user", "hhha"),
                Entity.create("users").set("user", "u")
        );
    }
    @Test
    public void HutoolDelect() throws Exception {
        // 创建一个 DruidDataSource 对象
        DruidDataSource ds = new DruidDataSource();
        // 设置数据库连接的 URL、用户名和密码
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/hhhhh");
        ds.setUsername("root");
        ds.setPassword("123456");
        // 设置 MySQL 5.0 JDBC 驱动类名
        ds.setDriverClassName("com.mysql.jdbc.Driver"); // 适用于 MySQL 5.0

        Db.use(ds).del(
                Entity.create("users").set("user", "hu")
        );
    }
}
