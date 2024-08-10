package com.ele.test;

import com.ele.dao.BusinessDao;
import com.ele.dao.impl.BusinessDaoImpl;
import com.ele.dao.impl.FoodDaoImpl;
import com.ele.pojo.Business;
import com.ele.pojo.Food;
import org.junit.jupiter.api.Test;

import java.sql.SQLException;

public class TestBusiness {
    @Test
    public void TestLogin() throws SQLException, ClassNotFoundException {
        BusinessDaoImpl businessDao = new BusinessDaoImpl();
        Business business = businessDao.businessLogin("沙县小吃", "123456");
      //  if (business != null) {
            System.out.println(business);
//        }else{
//            System.out.println("账号或密码错误");
//        }
    }

    @Test
    public void TestRegister() {
        BusinessDaoImpl businessDao = new BusinessDaoImpl();
        Business business = new Business();
        business.setBusinessId(2);
        business.setBusinessExplain("好吃");
        business.setBusinessAddress("东巴到");
        business.setBusinessName("hhhh");
        business.setStarPrice(5.0);
        business.setPassword("1234567");
        business.setDeliveryPrice(6.0);
        boolean a = false;
        try {
            a = businessDao.businessRegister(business);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        if (a) {
            System.out.println("插入成功");
        } else {
            System.out.println("插入失败");
        }
    }

        @Test
        public void TestUpdate(){
            BusinessDaoImpl businessDao = new BusinessDaoImpl();
            Business business = new Business();
            business.setBusinessId(6);
            business.setBusinessExplain("吃");
            business.setBusinessAddress("到hhhhhhh");
            business.setBusinessName("hh");
            business.setStarPrice(7777.0);
            business.setPassword("1234567");
            business.setDeliveryPrice(88.0);
            boolean a = businessDao.updateBusiness(business);
            if(a){
                System.out.println("修改成功");
            }else{
                System.out.println("修改失败");
            }
    }
//
//    @Test
//    public void TestInsterFood() {
//        FoodDaoImpl foodDao = new FoodDaoImpl();
//        Food food = new Food();
//        food.getFoodId(111);
//        food.setFoodName("面包");
//        food.setFoodExplain("好吃不贵");
//        food.setFoodPrice(12.0);
//        food.setBusinessId(12);
//
//        foodDao.insertFood(food);
//        System.out.println(food);
//        //boolean a = false;
////        try {
////            a = foodDao.insertFood(food);
////        } catch (SQLException throwables) {
////            throwables.printStackTrace();
////        }
////        if (a) {
////            System.out.println("插入成功");
////        } else {
////            System.out.println("插入失败");
////        }
//    }



}
