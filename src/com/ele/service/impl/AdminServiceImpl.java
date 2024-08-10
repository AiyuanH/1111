package com.ele.service.impl;

import com.ele.dao.AdminDao;
import com.ele.dao.impl.AdminDaoImpl;
import com.ele.pojo.Admin;
import com.ele.service.AdminService;

import java.sql.SQLException;

public class AdminServiceImpl implements AdminService {
    //通过创建对象的方式来调用数据层的接口和实现类这里用到了多态父类的引用指向子类得方法
    private AdminDao adminDao = new AdminDaoImpl();



    @Override
    public Admin adminLogin(String adminName, String password) {
        //业务层得要对dao层的数据进行管理目前只有抛出异常你要哪个该学怎样去调用dao层的数据
        try {
            return  this.adminDao.adminLogin(adminName,password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return null;
    }

    @Override
    public boolean changePwd(Integer adminId, String newPassword) {
        try {
            return adminDao.changePwd(adminId,newPassword);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

}
