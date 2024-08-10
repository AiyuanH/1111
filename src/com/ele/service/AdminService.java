package com.ele.service;

import com.ele.pojo.Admin;

public interface AdminService {
    public Admin adminLogin(String adminName, String password);
    public boolean changePwd(Integer adminId,String newPassword);
}
