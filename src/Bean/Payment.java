package Bean;

import java.io.Serial;
import java.io.Serializable;

/*
    支付信息类
 */


public class Payment implements Serializable {
    @Serial
    private static final long serialVersionUID=1L;

    /**
     *订单号
     */
    private Integer id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 支付金额
     */
    private String PaymentAmount;

    /**
     * 片名
     */
    private String movieName;

    /**
     * 场次
     */
    private Integer times;

    /**
     * 演播厅
     */
    private String room;

    /**
     * 购票时间
     */
    private String tickingTime;

    /**
     * 购票数
     */
    private String count;

    public Payment() {
    }

    public Payment(Integer id, String userName, String PaymentAmount,
                   String movieName, Integer times, String tickingTime) {
        super();
        this.id = id;
        this.userName = userName;
        this.PaymentAmount = PaymentAmount;
        this.movieName = movieName;
        this.times = times;
        this.tickingTime = tickingTime;
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
     * @return PaymentAmount
     */
    public String getPaymentAmount() {
        return PaymentAmount;
    }

    /**
     * 设置
     * @param PaymentAmount
     */
    public void setPaymentAmount(String PaymentAmount) {
        this.PaymentAmount = PaymentAmount;
    }

    /**
     * 获取
     * @return movieName
     */
    public String getMovieName() {
        return movieName;
    }

    /**
     * 设置
     * @param movieName
     */
    public void setMovieName(String movieName) {
        this.movieName = movieName;
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
     * @return tickingTime
     */
    public String getTickingTime() {
        return tickingTime;
    }

    /**
     * 设置
     * @param tickingTime
     */
    public void setTickingTime(String tickingTime) {
        this.tickingTime = tickingTime;
    }

    public String toString() {
        return "Payment{serialVersionUID = " + serialVersionUID + ", id = " + id + ", userName = " + userName + ", PaymentAmount = " + PaymentAmount + ", movieName = " + movieName + ", times = " + times + ", tickingTime = " + tickingTime + "}";
    }

    /**
     * 获取
     * @return room
     */
    public String getRoom() {
        return room;
    }

    /**
     * 设置
     * @param room
     */
    public void setRoom(String room) {
        this.room = room;
    }

    /**
     * 获取
     * @return count
     */
    public String getCount() {
        return count;
    }

    /**
     * 设置
     * @param count
     */
    public void setCount(String count) {
        this.count = count;
    }
}
