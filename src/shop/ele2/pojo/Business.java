package shop.ele2.pojo;

/**
 * @author 侯博
 * @date 2024/8/9
 */
public class Business {
    private Integer businessId;
    private String password;
    private String businessName;
    private String businessAddress;
    private String businessExplain;
    private Double starPrice;
    private Double deliveryPrice;


    public Business() {
    }

    public Business(Integer businessId, String password, String businessName, String businessAddress, String businessExplain, Double starPrice, Double deliveryPrice) {
        this.businessId = businessId;
        this.password = password;
        this.businessName = businessName;
        this.businessAddress = businessAddress;
        this.businessExplain = businessExplain;
        this.starPrice = starPrice;
        this.deliveryPrice = deliveryPrice;
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
     * @return password
     */
    public String getPassword() {
        return password;
    }

    /**
     * 设置
     * @param password
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 获取
     * @return businessName
     */
    public String getBusinessName() {
        return businessName;
    }

    /**
     * 设置
     * @param businessName
     */
    public void setBusinessName(String businessName) {
        this.businessName = businessName;
    }

    /**
     * 获取
     * @return businessAddress
     */
    public String getBusinessAddress() {
        return businessAddress;
    }

    /**
     * 设置
     * @param businessAddress
     */
    public void setBusinessAddress(String businessAddress) {
        this.businessAddress = businessAddress;
    }

    /**
     * 获取
     * @return businessExplain
     */
    public String getBusinessExplain() {
        return businessExplain;
    }

    /**
     * 设置
     * @param businessExplain
     */
    public void setBusinessExplain(String businessExplain) {
        this.businessExplain = businessExplain;
    }

    /**
     * 获取
     * @return starPrice
     */
    public Double getStarPrice() {
        return starPrice;
    }

    /**
     * 设置
     * @param starPrice
     */
    public void setStarPrice(Double starPrice) {
        this.starPrice = starPrice;
    }

    /**
     * 获取
     * @return deliveryPrice
     */
    public Double getDeliveryPrice() {
        return deliveryPrice;
    }

    /**
     * 设置
     * @param deliveryPrice
     */
    public void setDeliveryPrice(Double deliveryPrice) {
        this.deliveryPrice = deliveryPrice;
    }

    public String toString() {
        return "Business{businessId = " + businessId + ", password = " + password + ", businessName = " + businessName + ", businessAddress = " + businessAddress + ", businessExplain = " + businessExplain + ", starPrice = " + starPrice + ", deliveryPrice = " + deliveryPrice + "}";
    }
}
