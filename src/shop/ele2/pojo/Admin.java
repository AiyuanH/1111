package shop.ele2.pojo;

/**
 * @author 侯博
 * @date 2024/8/9
 */
public class Admin {
    private Integer adminId;
    private String adminName;
    private String password;

    public Admin() {
    }

    public Admin(Integer adminId, String adminName, String password) {
        this.adminId = adminId;
        this.adminName = adminName;
        this.password = password;
    }

    /**
     * 获取
     * @return adminId
     */
    public Integer getAdminId() {
        return adminId;
    }

    /**
     * 设置
     * @param adminId
     */
    public void setAdminId(Integer adminId) {
        this.adminId = adminId;
    }

    /**
     * 获取
     * @return adminName
     */
    public String getAdminName() {
        return adminName;
    }

    /**
     * 设置
     * @param adminName
     */
    public void setAdminName(String adminName) {
        this.adminName = adminName;
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

    public String toString() {
        return "Admin{adminId = " + adminId + ", adminName = " + adminName + ", password = " + password + "}";
    }
}
