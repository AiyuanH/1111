package com.ele.service;

import com.ele.pojo.Business;

import java.sql.SQLException;
import java.util.List;

public interface BusinessService {
    public Business businessLogin(String businessName, String password);
    //修改时会由一个id的问题
    public Boolean businessRegister(Business business);
    public Boolean updateBusiness(Business business);

    public List<Business> businessList() throws SQLException;
    public boolean deleteBusinessById(String bussinessID) throws SQLException;
}
