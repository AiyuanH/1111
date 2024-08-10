package com.ele.service.impl;

import cn.hutool.db.Db;
import com.ele.Utils.JDBCUtil;
import com.ele.dao.BusinessDao;
import com.ele.dao.impl.BusinessDaoImpl;
import com.ele.pojo.Business;
import com.ele.service.BusinessService;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;

public class BusinessServiceImpl implements BusinessService {
    private BusinessDao  businessDao = new BusinessDaoImpl();

    /**
     * 商家登录
     * @param businessName
     * @param password
     * @return
     */
    @Override
    public Business businessLogin(String businessName, String password) {
        try{
            Business business = businessDao.businessLogin(businessName, password);
            return  business;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 商家注册
     * @param business
     * @return
     */

    @Override
    public Boolean businessRegister(Business business) {
        try{
            Boolean b = businessDao.businessRegister(business);
            return b;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 更新商家数据
     * @param business
     * @return
     */

    @Override
    public Boolean updateBusiness(Business business) {
        try{
            Boolean b = businessDao.updateBusiness(business);
            return b;
        }catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 查询商家列表
     * @return
     */
    @Override
    public List<Business> businessList() throws SQLException {
        return this.businessDao.businessList();
    }

    @Override
    public boolean deleteBusinessById(String bussinessID) throws SQLException {
        return this.businessDao.deleteBusinessById(bussinessID);
    }
    /**
     *
     */
}
