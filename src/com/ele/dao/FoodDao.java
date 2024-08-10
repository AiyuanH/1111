package com.ele.dao;

import com.ele.pojo.Food;

import java.sql.SQLException;
import java.util.List;

public interface FoodDao {
    /**
     * 添加食品
     *
     * @return
     */
    public boolean insertFood(Food food) throws SQLException;

    /**
     * 修改食品
     *
     * @return
     */
    public boolean updateFood(Food food) throws SQLException;

    /**
     * 删除食品
     *
     * @return
     */
    public boolean delectFood(Integer businessId, Integer foodId) throws SQLException;

    /**
     * 查询全部食品
     */
    public List<Food> queryFood(Integer businessID) throws SQLException;
}
