package shop.ele2.view;

import com.ele.dao.AdminDao;
import com.ele.service.AdminService;
import shop.ele2.pojo.Admin;

import java.util.Scanner;

/**
 * @author 侯博
 * @date 2024/8/9
 */
public class AdminView {
public static Scanner sc = new Scanner(System.in);
    private static AdminDao adminService;

  //  public static
    /**
     * 管理员登陆界面
     */
    public static void login() {
        //先判断输入的账号密码是否正确
        System.out.println("输入账号");
        String adminName = sc.next();
        System.out.println("输入密码");
        String password =sc.next();
        //Admin admin = adminService.adminLogin(adminName,password);




    }
}
