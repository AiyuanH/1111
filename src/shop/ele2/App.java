package shop.ele2;

import shop.ele2.view.AdminView;

import java.util.Scanner;

/**
 * @author 侯博
 * @date 2024/8/9
 */
public class App {
    public static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("***********************欢迎来到********************");
        System.out.println("1管理员登录 \t 2商家登录 \t 3 商家注册 ");
        String op = sc.next();
        switch(op){
            case "1" :
                AdminView.login();
                break;
            case "2" :

                break;
            case "3" :

                break;
        }

    }
}
