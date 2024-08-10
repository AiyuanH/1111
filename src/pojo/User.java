package pojo;

public class User {
    private Integer id;
    private String user;
    private String password;
    private String address;

    public User() {
    }

    public User(Integer id, String user, String password, String address) {
        this.id = id;
        this.user = user;
        this.password = password;
        this.address = address;
    }

    /**
     * 获取
     * @return id
     * @param id
     */
    public Integer getId(int id) {
        return this.id;
    }

    /**
     * 设置
     * @param id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 获取
     * @return user
     */
    public String getUser() {
        return user;
    }

    /**
     * 设置
     * @param user
     */
    public void setUser(String user) {
        this.user = user;
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
     * @return address
     */
    public String getAddress() {
        return address;
    }

    /**
     * 设置
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    public String toString() {
        return "User{id = " + id + ", user = " + user + ", password = " + password + ", address = " + address + "}";
    }

    //数据库属性名和类的名相同

}
