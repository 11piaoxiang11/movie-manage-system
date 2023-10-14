package Bean;

import java.io.Serial;
import java.io.Serializable;

public class Users implements Serializable {
    @Serial
    private static final long serialVersionUID=1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 密码
     */
    private String password;

    /**
     * 用户等级
     */
    private String UserLevel;

    /**
     * 注册时间
     */
    private String registrationTime;

    /**
     * 累计消费金额
     */
    private String spendAmount;

    /**
     * 累计消费次数
     */
    private Integer times;

    /**
     * 用户邮箱
     */
    private String email;


    public Users() {
    }

    public Users(Integer id, String userName, String password,
                 String registrationTime, String spendAmount,
                 Integer times, String email) {
        super();
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.registrationTime = registrationTime;
        this.spendAmount = spendAmount;
        this.times = times;
        this.email = email;
    }

    public Users( Integer id, String userName, String password, String UserLevel, String registrationTime, String spendAmount, Integer times, String email) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.UserLevel = UserLevel;
        this.registrationTime = registrationTime;
        this.spendAmount = spendAmount;
        this.times = times;
        this.email = email;
    }

    /**
     * 获取
     * @return id
     */
    public Integer getId() {
        return id;
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
     * @return userName
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 设置
     * @param userName
     */
    public void setUserName(String userName) {
        this.userName = userName;
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
     * @return registrationTime
     */
    public String getRegistrationTime() {
        return registrationTime;
    }

    /**
     * 设置
     * @param registrationTime
     */
    public void setRegistrationTime(String registrationTime) {
        this.registrationTime = registrationTime;
    }

    /**
     * 获取
     * @return spendAmount
     */
    public String getSpendAmount() {
        return spendAmount;
    }

    /**
     * 设置
     * @param spendAmount
     */
    public void setSpendAmount(String spendAmount) {
        this.spendAmount = spendAmount;
    }

    /**
     * 获取
     * @return times
     */
    public Integer getTimes() {
        return times;
    }

    /**
     * 设置
     * @param times
     */
    public void setTimes(Integer times) {
        this.times = times;
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

    public String toString() {
        return "Users{serialVersionUID = " + serialVersionUID + ", id = " + id + ", userName = " + userName + ", password = " + password + ", registrationTime = " + registrationTime + ", spendAmount = " + spendAmount + ", times = " + times + ", email = " + email + "}";
    }

    /**
     * 获取
     * @return UserLevel
     */
    public String getUserLevel() {
        return UserLevel;
    }

    /**
     * 设置
     * @param UserLevel
     */
    public void setUserLevel(String UserLevel) {
        this.UserLevel = UserLevel;
    }
}
