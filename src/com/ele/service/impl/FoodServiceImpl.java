package com.ele.service.impl;

import com.ele.dao.FoodDao;
import com.ele.dao.impl.FoodDaoImpl;
import com.ele.pojo.Food;
import com.ele.service.FoodService;

import java.sql.SQLException;
import java.util.List;

/**
 * @author 侯博
 * @date 2024/8/8
 */
public class FoodServiceImpl implements FoodService {
    private static FoodDao foodDao = new FoodDaoImpl();
    @Override
    public boolean insertFood(Food food) {
        try {
            foodDao.insertFood(food);
            return true;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean updateFood(Food food) throws SQLException {
        foodDao.updateFood(food);
        return true;

    }

    @Override
    public boolean delectFood(Integer businessId,Integer foodId) throws SQLException {
        foodDao.delectFood(businessId,foodId);
        return false;
    }

    @Override
    public List<Food> queryFood(Integer businessId) throws SQLException {
        return foodDao.queryFood(businessId);
    }
}
