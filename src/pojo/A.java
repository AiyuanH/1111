package pojo;

import java.util.Date;

public class A {
    private String name;
    private String pwd;
    private String email;
    private Date birthday;
    private Integer money;

    public A() {
    }

    public A(String name, String pwd, String email, Date birthday, Integer money) {
        this.name = name;
        this.pwd = pwd;
        this.email = email;
        this.birthday = birthday;
        this.money = money;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return pwd
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 设置
     * @param pwd
     */
    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    /**
     * 获取
     * @return email
     */
    public String getEmail() {
        return email;
    }

    /**
     * 设置
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * 获取
     * @return birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    /**
     * 设置
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    /**
     * 获取
     * @return money
     */
    public Integer getMoney() {
        return money;
    }

    /**
     * 设置
     * @param money
     */
    public void setMoney(Integer money) {
        this.money = money;
    }

    public String toString() {
        return "A{name = " + name + ", pwd = " + pwd + ", email = " + email + ", birthday = " + birthday + ", money = " + money + "}";
    }
}
