package shop.ele2.pojo;

/**
 * @author 侯博
 * @date 2024/8/9
 */
public class Food {
    private Integer foodId;
    private String foodName;
    private String foodExplain;
    private Double foodPrice;
    private Integer businessId;
    private Integer foodStatus;
    private Integer foodStock;

    public Food() {
    }

    public Food(Integer foodId, String foodName, String foodExplain, Double foodPrice, Integer businessId, Integer foodStatus, Integer foodStock) {
        this.foodId = foodId;
        this.foodName = foodName;
        this.foodExplain = foodExplain;
        this.foodPrice = foodPrice;
        this.businessId = businessId;
        this.foodStatus = foodStatus;
        this.foodStock = foodStock;
    }

    /**
     * 获取
     * @return foodId
     */
    public Integer getFoodId() {
        return foodId;
    }

    /**
     * 设置
     * @param foodId
     */
    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    /**
     * 获取
     * @return foodName
     */
    public String getFoodName() {
        return foodName;
    }

    /**
     * 设置
     * @param foodName
     */
    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    /**
     * 获取
     * @return foodExplain
     */
    public String getFoodExplain() {
        return foodExplain;
    }

    /**
     * 设置
     * @param foodExplain
     */
    public void setFoodExplain(String foodExplain) {
        this.foodExplain = foodExplain;
    }

    /**
     * 获取
     * @return foodPrice
     */
    public Double getFoodPrice() {
        return foodPrice;
    }

    /**
     * 设置
     * @param foodPrice
     */
    public void setFoodPrice(Double foodPrice) {
        this.foodPrice = foodPrice;
    }

    /**
     * 获取
     * @return businessId
     */
    public Integer getBusinessId() {
        return businessId;
    }

    /**
     * 设置
     * @param businessId
     */
    public void setBusinessId(Integer businessId) {
        this.businessId = businessId;
    }

    /**
     * 获取
     * @return foodStatus
     */
    public Integer getFoodStatus() {
        return foodStatus;
    }

    /**
     * 设置
     * @param foodStatus
     */
    public void setFoodStatus(Integer foodStatus) {
        this.foodStatus = foodStatus;
    }

    /**
     * 获取
     * @return foodStock
     */
    public Integer getFoodStock() {
        return foodStock;
    }

    /**
     * 设置
     * @param foodStock
     */
    public void setFoodStock(Integer foodStock) {
        this.foodStock = foodStock;
    }

    public String toString() {
        return "Food{foodId = " + foodId + ", foodName = " + foodName + ", foodExplain = " + foodExplain + ", foodPrice = " + foodPrice + ", businessId = " + businessId + ", foodStatus = " + foodStatus + ", foodStock = " + foodStock + "}";
    }
}
