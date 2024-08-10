package com.ele.view;

import com.ele.dao.AdminDao;
import com.ele.pojo.Admin;
import com.ele.pojo.Business;
import com.ele.service.AdminService;
import com.ele.service.BusinessService;
import com.ele.service.impl.AdminServiceImpl;
import com.ele.service.impl.BusinessServiceImpl;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class AdminView {
//因为要输出所以静态化输出私有化
    private static Scanner sc = new Scanner(System.in);
    private static AdminService adminService = new AdminServiceImpl();
    private static BusinessService businessService = new BusinessServiceImpl();


    //公共方法登录由主函数调用
    public void login() throws SQLException {
        System.out.println("请输入管理员账号");
        String adminName = sc.next();
        System.out.println("请输入管理员密码");
        String password = sc.next();
        //调用service层得方法用来进行账号密码得判断
        Admin admin  = adminService.adminLogin(adminName,password);
        //接下来开始判段
        if(admin ==null){
            System.out.println("账号或者密码错误");
        }else{
            System.out.println("欢迎管理：" + admin.getAdminName());
            while(true){
                System.out.println("请选择操作符 " +
                        "1查询所有商家， " +
                        "2删除商家 ，" +
                        "3修改密码 ，" +
                        "4退出");
                String op = sc.next();
                switch(op){
                    case "1":
                        //查询所有商家
                        printBusinessList();
                        break;
                    case "2":
                        //删除商家通过business_id
                        delectBusiness();
                        break;
                    case "3":
                        //修改密码
                        System.out.println("输入新密码");
                        String newPassword = sc.next();
                        changePwd(admin.getAdminId(),newPassword);
                        break;
                    case "4":
                        //商家
                        return;
                    default:
                        //商家
                        break;
                }

            }

        }

    }

    /**
     * 修改管理员的密码
     * @param password
     * @param adminId
     */


    /**
     * 删除商家信息
     */
    private void delectBusiness() {


    }

    /**
     * 查询商家列表
     * @throws SQLException
     */
    private void printBusinessList() throws SQLException {
        List<Business> business = businessService.businessList() ;
        for (Business bussiness: business) {
            System.out.println(business);
        }


    }
    private void changePwd(Integer adminId, String newPassword){
        boolean b = adminService.changePwd(adminId, newPassword);
        if (b){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }

}
