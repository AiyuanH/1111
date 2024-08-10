package com.ele.dao;

import com.ele.pojo.Business;

import java.sql.SQLException;
import java.util.List;

public interface BusinessDao {
    /**
     * 商家登陆的功能
     * @param businessName
     * @param password
     * @return
     */
    public Business businessLogin(String businessName,String password) throws ClassNotFoundException, SQLException;
//修改时会由一个id的问题
    public Boolean businessRegister(Business business) throws SQLException;
    public Boolean updateBusiness(Business business);
    public List<Business> businessList() throws SQLException;
    public boolean deleteBusinessById(String bussinessID) throws SQLException;
}
