package Bean;

import java.io.Serial;
import java.io.Serializable;

public class Manager implements Serializable {
    @Serial
    private static final long serialVersionUID=1l;

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


    public Manager() {
    }

    public Manager(Integer id, String userName, String password) {
        super();
        this.id = id;
        this.userName = userName;
        this.password = password;
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

    public String toString() {
        return "Manager{serialVersionUID = " + serialVersionUID + ", id = " + id + ", userName = " + userName + ", password = " + password + "}";
    }
}
