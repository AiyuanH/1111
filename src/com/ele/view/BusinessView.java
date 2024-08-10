package com.ele.view;

import cn.hutool.crypto.SecureUtil;
import com.ele.pojo.Business;
import com.ele.pojo.Food;
import com.ele.service.BusinessService;
import com.ele.service.FoodService;
import com.ele.service.impl.BusinessServiceImpl;
import com.ele.service.impl.FoodServiceImpl;
import sun.text.resources.cldr.om.FormatData_om;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class BusinessView {

    //静态设置成方便操作多次调用

    private static Scanner sc = new Scanner(System.in);
    private static BusinessService businessService = new BusinessServiceImpl();
    private static FoodService foodService = new FoodServiceImpl();
    /**
     * 商家登录界面
     */
    public static void login() throws SQLException {
        System.out.println("输入账号");
        String businessName = sc.next();

        System.out.println("输入密码");
        String password = sc.next();

        //对密码进行加密处理
        password = SecureUtil.md5(password + businessName);
        Business business = businessService.businessLogin(businessName, password);

        if (business == null) {
            System.out.println("账号或密码错误");
        } else {
            System.out.println("欢迎" + business.getBusinessName());
            while (true) {
                System.out.println("请选择操作：1 添加食品 \t " +
                        "2 查询食品列表 \t 3 修改食品 " +
                        "4 删除食品  \t  5 修改商家信息" +
                        "6 查询商家信息 \t  7退出");
                String op = sc.next();
                switch (op) {
                    case "1":
                        //添加食品需要食品id和商户id
                        System.out.println("添加食品");
                        insertFood(business.getBusinessId());
                        break;
                    case "2":
                        //查询商户得视频列表需要传商户id和食品id
                        System.out.println("查询食品列表");
                        queryFood(business.getBusinessId());
                        break;
                    case "3":
                        //修改商户信息
                        System.out.println("修改食品");
                       updateFood(business.getBusinessId());
                        break;
                    case "4":
                        //删除食品通过id
                        System.out.println("删除食品");
                        delectFood(business.getBusinessId());
                        break;
                    case "5":
                        //修改商户信息
                        System.out.println("修改商家信息");
                        updateBusiness(business);
                        break;
                    case "6":
                        //查询商家信息
                        System.out.println("查询商家信息");
                        System.out.println(business);
                        break;
                    case "7":
                        System.out.println("退出");
                        return;
                    default:
                        System.out.println("重新输入");
                        break;
                }
            }
        }


    }

    /**
     * 删除食品
     * @param businessId
     * @throws SQLException
     */
    private static void delectFood(Integer businessId) throws SQLException {
        System.out.println("输入删除食品id");
        Integer foodId = sc.nextInt();

        boolean b= foodService.delectFood(businessId,foodId);
    }

    /**
     * 修改食品
     * @param businessId
     * @throws SQLException
     */
    private static void updateFood(Integer businessId) throws SQLException {
        System.out.println("选择食物id");
        String foodId = sc.next();
        System.out.println("修改食物名称");
        String foodName = sc.next();
        System.out.println("修改食物介绍");
        String foodExplain = sc.next();
        System.out.println("修改食物价格");
        String foodPrice = sc.next();
        System.out.println("修改食物状态：1上架2下架");
        String foodStatus = sc.next();
        System.out.println("修改食物状态:");
        String foodStock = sc.next();


        Food food = new Food();


        //获取信息
        food.setFoodId(Integer.valueOf(foodId));
        food.setFoodName(foodName);
        food.setFoodExplain(foodExplain);
        food.setFoodPrice(Double.valueOf(foodPrice));
        food.setBusinessId(businessId);
        food.setFoodStatus(Integer.valueOf(foodStatus));
        food.setFoodStock(Integer.valueOf(foodStock));


        boolean b= foodService.updateFood(food);
        if (b) {
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }

    }

    /**
     * 查食品列表
     * @param businessId
     * @throws SQLException
     */
    private static void queryFood(Integer businessId) throws SQLException {
        List<Food> foods = foodService.queryFood(businessId);
        foods.forEach(item->{
            System.out.println(item);
        });
    }


    private static void insertFood(Integer businessId) {
        System.out.println("输入食物名称");
        String foodName = sc.next();
        System.out.println("输入食物介绍");
        String foodExplain = sc.next();
        System.out.println("输入食物价格");
        String foodPrice = sc.next();
        System.out.println("输入食物状态：1上架2下架");
        String foodStatus = sc.next();
        System.out.println("输入食物状态:");
        String foodStock = sc.next();

//将数据封装一个food对象
        Food food = new Food();
        //获取信息
        //food.setFoodId(foodId);
        food.setFoodName(foodName);
        food.setFoodExplain(foodExplain);
        food.setFoodPrice(Double.valueOf(foodPrice));
        food.setBusinessId(businessId);
        food.setFoodStatus(Integer.valueOf(foodStatus));
        food.setFoodStock(Integer.valueOf(foodStock));

        boolean b= foodService.insertFood(food);
        if (b) {
            System.out.println("添加成功");
        }else{
            System.out.println("添加失败");
        }

    }

    /**
     * 修改商家得信息界面
     * @param business
     */
    public static void updateBusiness(Business business) {
        System.out.println("商家的原始数据：" + business);
        System.out.println("请输入账号：");
        String businessName = sc.next();
        System.out.println("请输入密码：");
        String password = sc.next();
        System.out.println("请输入地址：");
        String businessAddress = sc.next();
        System.out.println("请输入介绍：");
        String businessExplain = sc.next();
        System.out.println("请输入起送费：");
        String starPrice = sc.next();
        System.out.println("请输入配送费：");
        String deliveryPrice = sc.next();
        business.setBusinessName(businessName);
        password = SecureUtil.md5(password + businessName);
        business.setPassword(password);

        business.setBusinessAddress(businessAddress);
        business.setBusinessExplain(businessExplain);
        business.setStarPrice(Double.valueOf(starPrice));
        business.setDeliveryPrice(Double.valueOf(deliveryPrice));
        Boolean b = businessService.updateBusiness(business);
        if(b){
            System.out.println("修改成功");
        }else{
            System.out.println("修改失败");
        }
    }


    /**
     * 商家注册界面
     */
    public void register(){
        System.out.println("请输入账号：");
        String businessName = sc.next();
        System.out.println("请输入密码：");
        String password = sc.next();
        System.out.println("请输入地址：");
        String businessAddress = sc.next();
        System.out.println("请输入介绍：");
        String businessExplain = sc.next();
        System.out.println("请输入起送费：");
        String starPrice = sc.next();
        System.out.println("请输入配送费：");
        String deliveryPrice = sc.next();
        Business business = new Business();
        // 再这里对密码进行加密处理
        password = SecureUtil.md5(password + businessName);
        business.setPassword(password);
        business.setBusinessName(businessName);
        business.setBusinessAddress(businessAddress);
        business.setBusinessExplain(businessExplain);
        business.setStarPrice(Double.valueOf(starPrice));
        business.setDeliveryPrice(Double.valueOf(deliveryPrice));
        Boolean b = businessService.businessRegister(business);
        if(b){
            System.out.println("注册成功");
        }else{
            System.out.println("注册失败");
        }
    }


}
