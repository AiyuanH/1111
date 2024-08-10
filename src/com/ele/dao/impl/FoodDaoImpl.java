package com.ele.dao.impl;

import cn.hutool.db.Db;
import cn.hutool.db.Entity;
import com.ele.Utils.JDBCUtil;
import com.ele.dao.FoodDao;
import com.ele.pojo.Food;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public class FoodDaoImpl implements FoodDao {


    /**
     * 添加食物
     *
     * @param food
     * @return
     */
    @Override
    public boolean insertFood(Food food) throws SQLException {
        DataSource ds = JDBCUtil.getDataSource();//添加功能
        int x = Db.use(ds).execute("insert into food values (null,?,?,?,?,?,?)",
                food.getFoodName(), food.getFoodExplain(), food.getFoodPrice()
                , food.getBusinessId(), food.getFoodStatus(), food.getFoodStock());
        return x == 1 ? true : false;

//        try {
//            Db.use(ds).insert(
//                    Entity.create("food")
//                    .set("food_id",food.getFoodId())
//                    .set("food_name", food.getFoodName())
//                    .set("food_explain", food.getFoodExplain())
//                    .set("food_prive", food.getFoodPrice())
//                    .set("bussiness_id", food.getBusinessId())
//            );
//
//        } catch (SQLException throwables) {
//            throwables.printStackTrace();
//        }
    }

    /**
     * 修改食物
     *
     * @param food
     * @return
     */
    @Override
    public boolean updateFood(Food food) throws SQLException {

        DataSource ds = JDBCUtil.getDataSource();
        //添加功能
        int x = Db.use(ds).update(
                Entity.create()
                        .set("food_id", food.getFoodId())
                        .set("food_name", food.getFoodName())
                        .set("food_price", food.getFoodPrice())
                        .set("business_id", food.getBusinessId())
                        .set("food_status", food.getFoodStatus())
                        .set("food_stock", food.getFoodStock()),
                Entity.create("food").set("food_id", food.getFoodId())
        );
        // return null;
        return x == 1 ? true : true;
    }


    /**
         * 删除食物
         *
         * @param
         * @return
         */

        @Override
        public boolean delectFood (Integer businessId, Integer foodId) throws SQLException {
        DataSource ds = JDBCUtil.getDataSource();
        int x = Db.use(ds).del("food", "food_id", foodId);
        return x == 1 ? true : false;
    }


        /**
         * 查全部食物
         *
         * @return
         */
        @Override
        public List<Food> queryFood (Integer businessId) throws SQLException {
        DataSource ds = JDBCUtil.getDataSource();
        List<Food> result = Db.use(ds).query("select * from food ", Food.class);

        return result;
    }
    }
