package com.ele.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.alibaba.druid.pool.DruidDataSource;
import com.ele.Utils.JDBCUtil;
import com.ele.dao.AdminDao;
import com.ele.pojo.Admin;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class AdminDaoImpl implements AdminDao {
    @Override
    public Admin adminLogin(String adminName, String password) throws SQLException {

        //首先调用jdbcutil类中得加载数据库驱动连接池
        Connection conn = JDBCUtil.getConnection();
        //然后输入sql语句
        String sql = "select * from admin where admin_name = ? and password = ?";
        //接下来将sql语句传到数据库连接得preparestament对象防止sql注入
        PreparedStatement stmt = conn.prepareStatement(sql);
        //给占位符赋值
        stmt.setString(1, adminName);
        stmt.setString(2, password);
        //用结果集resultset接受stmt对象并查询
        ResultSet rs = stmt.executeQuery();
        //遍历
        if (rs.next()) {
            Admin admin = new Admin();
            admin.setAdminId(rs.getInt("admin_id"));
            admin.setAdminName(rs.getString("admin_name"));
            admin.setPassword(rs.getString("password"));
            return admin;
        }
        return null;
    }

    @Override
    public boolean changePwd(Integer adminId, String newPassword) throws SQLException {
        DataSource ds = JDBCUtil.getDataSource();
        int x = Db.use(ds).update(
                Entity.create().set("password",newPassword),
                Entity.create("admin").set("admin_id",adminId)
        );
        return x==1?true:false;
    }


}
