package com.ele;

import com.ele.view.AdminView;
import com.ele.view.BusinessView;

import java.sql.SQLException;
import java.util.Scanner;

public class EleApp {
    private static BusinessView businessView = new BusinessView();
    private static AdminView adminView = new AdminView();

    /**
     * 入口程序
     */
    public static void main(String[] args) throws SQLException {
        System.out.println("********************登录系统**********************");
        Scanner sc = new Scanner(System.in);
        while (true){
            System.out.println("登陆方式：1管理员登录 \t 2商家登录 \t 3商家注册 \t 4退出");
            String op = sc.next();
            switch (op) {
                case "1":
                    //管理员登录
                    adminView.login();
                    break;
                case "2":
                    //商户登录
                    businessView.login();
                    break;
                case "3":
                    //调用商家注册功能
                    businessView.register();
                    break;
                case "4":
                    //别用System.exit(0);
                    System.out.println("退出");
                    break;
                default:
                    System.out.println("输入错误重新输入");
                    break;
            }
        }
    }
}
