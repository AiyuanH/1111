package com.ele.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.alibaba.druid.pool.DruidDataSource;
import com.ele.Utils.JDBCUtil;
import com.ele.dao.BusinessDao;
import com.ele.pojo.Business;

import javax.sql.DataSource;
import java.sql.*;
import java.util.List;

public class BusinessDaoImpl implements BusinessDao {

   /* @Override
    public Business businessLogin(String businessName, String password) {
        // 创建一个 DruidDataSource 对象
        DruidDataSource ds = new DruidDataSource();
        // 设置数据库连接的 URL、用户名和密码
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/jdbc_ele");
        ds.setUsername("root");
        ds.setPassword("123456");
        // 设置 MySQL 5.0 JDBC 驱动类名
        ds.setDriverClassName("com.mysql.jdbc.Driver"); // 适用于 MySQL 5.05
        try {
            List<Entity> query = Db.use(ds).query("select * from business where business_name = ? and password = ? ", businessName, password);
            System.out.println(query);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }*/
   @Override
   public Business businessLogin(String businessName, String password) throws ClassNotFoundException, SQLException {
       Class.forName("com.mysql.jdbc.Driver");
       Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc_ele","root","123456");
       String sql = "select * from business where business_name = ? and password = ?";
       PreparedStatement stmt = conn.prepareStatement(sql);
       stmt.setString(1,businessName);

       stmt.setString(2,password);
       ResultSet rs = stmt.executeQuery();
       if(rs.next()){
           // 登录成功
           Business business = new Business();
           // 封装查询到的商家的数据
           business.setBusinessId(rs.getInt("business_id"));
           business.setBusinessName(rs.getString("business_name"));
           business.setPassword(rs.getString("password"));
           business.setBusinessAddress(rs.getString("business_address"));
           business.setBusinessExplain(rs.getString("business_explain"));
           business.setStarPrice(rs.getDouble("star_price"));
           business.setDeliveryPrice(rs.getDouble("delivery_price"));
           return business;
       }else{
           // 登录失败
           return null;
       }
   }

    @Override
    public Boolean businessRegister(Business business) throws SQLException {
//        // 创建一个 DruidDataSource 对象
//        DruidDataSource ds = new DruidDataSource();
//        // 设置数据库连接的 URL、用户名和密码
//        ds.setUrl("jdbc:mysql://127.0.0.1:3306/jdbc_ele");
//        ds.setUsername("root");
//        ds.setPassword("123456");
//        // 设置 MySQL 5.0 JDBC 驱动类名
//        ds.setDriverClassName("com.mysql.jdbc.Driver"); // 适用于 MySQL 5.05
//        try {
//            Db.use(ds).insert(
//                    Entity.create("business")
//                            .set("business_id", business.getBusinessId())
//                            .set("password", business.getPassword())
//                            .set("business_name", business.getBusinessName())
//                            .set("business_address", business.getBusinessAddress())
//                            .set("business_explain", business.getBusinessExplain())
//                            .set("star_price", business.getStarPrice())
//                            .set("delivery_price", business.getDeliveryPrice())
//            );
//            return true;
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
//        return null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        Connection conn = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/jdbc_ele","root","123456");
        String sql = "insert into business values (null , ?, ?, ?, ?, ?, ?)";
        PreparedStatement stmt = null;
        try {
            stmt = conn.prepareStatement(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        stmt.setString(1,business.getPassword());
        stmt.setString(2,business.getBusinessName());
        stmt.setString(3,business.getBusinessAddress());
        stmt.setString(4, business.getBusinessExplain());
        stmt.setDouble(5,business.getStarPrice());
        stmt.setDouble(6,business.getDeliveryPrice());
        // 执行参数
        int update = stmt.executeUpdate();
        if(update > 0){
            return true;
        }else{
            return false;
        }
    }



    @Override
    public Boolean updateBusiness(Business business) {
        // 创建一个 DruidDataSource 对象
        DruidDataSource ds = new DruidDataSource();
        // 设置数据库连接的 URL、用户名和密码
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/jdbc_ele");
        ds.setUsername("root");
        ds.setPassword("123456");
        // 设置 MySQL 5.0 JDBC 驱动类名
        ds.setDriverClassName("com.mysql.jdbc.Driver"); // 适用于 MySQL 5.05
        try {
            Db.use(ds).update(
                    Entity.create()
                            .set("business_id", business.getBusinessId())
                            .set("password", business.getPassword())
                            .set("business_name", business.getBusinessName())
                            .set("business_address", business.getBusinessAddress())
                            .set("business_explain", business.getBusinessExplain())
                            .set("star_price", business.getStarPrice())
                            .set("delivery_price", business.getDeliveryPrice()),
                    Entity.create("business")
                            .set("business_id",business.getBusinessId())


            );
            return true;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public List<Business> businessList() throws SQLException {
        DataSource ds = JDBCUtil.getDataSource();
        List<Business> query = Db.use(ds).query("select * from business",Business.class);
        return query;

    }
    @Override
    public boolean deleteBusinessById(String bussinessID) throws SQLException {
        DataSource ds = JDBCUtil.getDataSource();
        int x = Db.use(ds).del("business","business_id",bussinessID);
        return x==1?true:false;
    }
}
