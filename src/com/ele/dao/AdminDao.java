package com.ele.dao;

import com.ele.pojo.Admin;

import java.sql.SQLException;

public interface AdminDao {
    public Admin adminLogin(String adminName,String password) throws SQLException;

    public  boolean changePwd(Integer adminId, String newPassword) throws SQLException;


}
