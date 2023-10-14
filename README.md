# 影院管理系统

(GUI MySQL Java)

(大二上写的屎山,别看,要脸)

总结:根据这个项目掌握了

1.GUI的常见功能的使用

2.SQL语句的简单使用

3.面向对象思想

4.理解了条理清晰的重要性(刚开始写了一个太乱了,写到中间根本写不下去了,只能推倒重来)

5.复习了一些Java的知识



可以优化或未实现的功能:

1.购票功能并未完全实现

2.界面太过冗余,其实可以合并很多,减少代码量

3.实现功能也可以单独创建包,单独实现,使其更加条理

等等太多太多



啊啊啊,发现了一个新的错误,控制类最好不要新建对象



![](E:\study\编程项目\Movie Manage System Plus\image\总图.png)



## 1.数据库(MySQL)

### 1.1admin

```mysql
create table admin
(
    username varchar(30) null,
    password varchar(30) null
);
```



### 1.2manager

```mysql
create table manager
(
    id       int auto_increment
        primary key,
    username varchar(30) null,
    password varchar(30) null
);

```



### 1.3movie

```mysql
create table movie
(
    id        int auto_increment
        primary key,
    movieName varchar(30) null,
    director  varchar(30) null,
    starring  varchar(30) null,
    type      varchar(30) null,
    time      varchar(30) null,
    session   varchar(30) null,
    room      varchar(30) null,
    price     varchar(30) null
);

```



### 1.4payment

```mysql
create table payment
(
    id            int auto_increment
        primary key,
    userName      varchar(30) null,
    paymentAmount varchar(30) null,
    movieName     varchar(30) null,
    times         varchar(30) null,
    room          varchar(30) null,
    tickingTime   date        null,
    count         varchar(30) null
);
```



### 1.5paymentImp

```mysql
create table paymentimp
(
    id            int auto_increment
        primary key,
    userName      varchar(30) null,
    paymentAmount varchar(30) null,
    movieName     varchar(30) null,
    times         varchar(30) null,
    room          varchar(30) null,
    tickingTime   date        null,
    count         varchar(30) null
);
```



### 1.6reception

```mysql
create table reception
(
    username varchar(30) null,
    password varchar(30) null
);
```



### 1.7user

```mysql
create table user
(
    id              int auto_increment
        primary key,
    username        varchar(30) null,
    password        varchar(30) null,
    userlevel       varchar(30) null,
    regdate         date        null,
    totalamount     int         null,
    consumptionTime int         null,
    userEmail       varchar(30) null
);
```



## 2.Java

### 2.1Java文件显示

<img src="E:\study\编程项目\Movie Manage System Plus\image\java文件1.png" alt="java文件1" style="zoom:33%;" />

<img src="E:\study\编程项目\Movie Manage System Plus\image\java文件2.png" alt="java文件2" style="zoom:38%;" />



### 2.2Bean包(存放实际类)

用于存放实际实现实际存在的东西:如管理员,用户,电影等



#### 2.2.1admin

```java
package Bean;

import java.io.Serial;
import java.io.Serializable;

public class Admin implements Serializable {
    @Serial
    private static final long serialVersionUID= 1L;

    /**
     * 编号
     */
    private Integer id;

    /**
     * 账户
     */
    private String userName;

    /**
     * 密码
     */
    private String password;


    public Admin() {
    }

    public Admin( Integer id, String userName, String password) {
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
        return "Admin{serialVersionUID = " + serialVersionUID + ", id = " + id + ", userName = " + userName + ", password = " + password + "}";
    }
}

```

#### 2.2.2manager

```java
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

```

#### 2.2.3movie

```java
package Bean;

import java.io.Serial;
import java.io.Serializable;

public class Movie implements Serializable {
    @Serial
    private static final long serialVersionUID=1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 电影名
     */
    private String name;

    /**
     * 导演
     */
    private String director;

    /**
     * 主演
     */
    private String starring;

    /**
     * 类型
     */
    private String movieType;

    /**
     * 时长
     */
    private String movieTime;

    /**
     * 场次
     */
    private String session;

    /**
     * 演播厅
     */
    private String room;

    /**
     * 价格
     */
    private String price;


    public Movie() {
    }

    public Movie(Integer id, String name, String director, String starring, String movieType, String movieTime) {
        super();
        this.id = id;
        this.name = name;
        this.director = director;
        this.starring = starring;
        this.movieType = movieType;
        this.movieTime = movieTime;
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
     * @return director
     */
    public String getDirector() {
        return director;
    }

    /**
     * 设置
     * @param director
     */
    public void setDirector(String director) {
        this.director = director;
    }

    /**
     * 获取
     * @return starring
     */
    public String getStarring() {
        return starring;
    }

    /**
     * 设置
     * @param starring
     */
    public void setStarring(String starring) {
        this.starring = starring;
    }

    /**
     * 获取
     * @return movieType
     */
    public String getMovieType() {
        return movieType;
    }

    /**
     * 设置
     * @param movieType
     */
    public void setMovieType(String movieType) {
        this.movieType = movieType;
    }

    /**
     * 获取
     * @return movieTime
     */
    public String getMovieTime() {
        return movieTime;
    }

    /**
     * 设置
     * @param movieTime
     */
    public void setMovieTime(String movieTime) {
        this.movieTime = movieTime;
    }

    public String toString() {
        return "Movie{serialVersionUID = " + serialVersionUID + ", id = " + id + ", name = " + name + ", director = " + director + ", starring = " + starring + ", movieType = " + movieType + ", movieTime = " + movieTime + "}";
    }

    /**
     * 获取
     * @return session
     */
    public String getSession() {
        return session;
    }

    /**
     * 设置
     * @param session
     */
    public void setSession(String session) {
        this.session = session;
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
     * @return price
     */
    public String getPrice() {
        return price;
    }

    /**
     * 设置
     * @param price
     */
    public void setPrice(String price) {
        this.price = price;
    }
}

```



#### 2.2.4payment(支付类)

```java
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

```



#### 2.2.5paymentImp(支付实现类)

```java
package Bean;

import java.io.Serial;
import java.io.Serializable;

/*
    支付信息实现类
*/
public class PaymentImp implements Serializable {
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
    private String times;

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


    public PaymentImp() {
    }

    public PaymentImp(Integer id, String userName,
                      String PaymentAmount, String movieName,
                      String times, String tickingTime) {
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
    public String getTimes() {
        return times;
    }

    /**
     * 设置
     * @param times
     */
    public void setTimes(String times) {
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
        return "PaymentImp{serialVersionUID = " + serialVersionUID + ", id = " + id + ", userName = " + userName + ", PaymentAmount = " + PaymentAmount + ", movieName = " + movieName + ", times = " + times + ", tickingTime = " + tickingTime + "}";
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

```



#### 2.2.6Reception(前台类)

```java
package Bean;

import java.io.Serial;
import java.io.Serializable;

public class Reception implements Serializable {
    @Serial
    private static final long serialVersionUID=1L;

    /**
     * id
     */
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;


    public Reception() {
    }

    public Reception(Integer id, String username, String password) {
        super();
        this.id = id;
        this.username = username;
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
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * 设置
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
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
        return "Reception{serialVersionUID = " + serialVersionUID + ", id = " + id + ", username = " + username + ", password = " + password + "}";
    }
}

```



#### 2.2.7Users

```java
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

```



### 2.3Controller包(数据库交互控制包)

#### 2.3.1Select(查询类)

此类用于进行数据库的查询

```java
package Controller;

import Bean.Movie;
import Bean.PaymentImp;
import Bean.Users;
import Dao.DbConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Objects;


/**
 * 查询类
 */

public class Select {

    //用于登录查询
    public boolean loginSelect(String sql){
        try{
            Connection connection= DbConnection.getConnection();
            ResultSet resultSet= DbConnection.query(sql);
            assert resultSet != null;
            if(resultSet.next()){
                return true;
            }

            DbConnection.close(resultSet,null,connection);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return false;
    }


    // 查询全部管理员用户信息
    public Object[][] getUserInfo(String username) {
        String sql = null;
        if (username.equals("")) {
            sql = "SELECT * FROM user";
        } else {
            sql = "SELECT * FROM user WHERE username='" + username + "'";
        }
        Connection conn = DbConnection.getConnection();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        ArrayList<Users> list = new ArrayList<Users>();
        try {
            stmt = (PreparedStatement) conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while (rs.next()) {
                Users users = new Users();
                users.setId(rs.getInt(1));
                users.setUserName(rs.getString(2));
                users.setUserLevel(rs.getString(4));
                users.setRegistrationTime(rs.getString(5));
                users.setSpendAmount(rs.getString(6));
                users.setTimes(Integer.valueOf(rs.getString(7)));
                users.setEmail(rs.getString(8));
                list.add(users);
            }
        } catch (SQLException e1) {
            e1.printStackTrace();
        } finally {
            try {
                DbConnection.close(rs, stmt, conn);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        Object[][] objects = new Object[list.size()][9];
        for (int i = 0; i < list.size(); i++) {
            objects[i][0] = list.get(i).getId();
            objects[i][1] = list.get(i).getUserName();
            objects[i][2] = list.get(i).getUserLevel();
            objects[i][3] = list.get(i).getRegistrationTime();
            objects[i][4] = list.get(i).getSpendAmount();
            objects[i][5] = list.get(i).getTimes();
            objects[i][6] = list.get(i).getEmail();
        }
        return objects;
    }

    //查询所有影片信息
    public Object[][] getMovieInfo(String movieName){
        String sql=null;
        if(movieName.equals("")) {
            sql = "SELECT * FROM movie";
        }else {
            sql="SELECT * FROM movie WHERE movieName='"+movieName+"'";
        }
        Connection connection=DbConnection.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<Movie> list=new ArrayList<>();

        try{
            stmt=(PreparedStatement) connection.prepareStatement(sql);
            rs=stmt.executeQuery();
            while(rs.next()){
                Movie movie=new Movie();
                movie.setId(rs.getInt(1));
                movie.setName(rs.getString(2));
                movie.setDirector(rs.getString(3));
                movie.setStarring(rs.getString(4));
                movie.setMovieType(rs.getString(5));
                movie.setMovieTime(rs.getString(6));
                movie.setSession(rs.getString(7));
                movie.setRoom(rs.getString(8));
                movie.setPrice(rs.getString(9));
                list.add(movie);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                DbConnection.close(rs,stmt,connection);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        Object[][] objects=new Object[list.size()][9];
        for(int i=0;i<list.size();i++){
            objects[i][0] = list.get(i).getId();
            objects[i][1] = list.get(i).getName();
            objects[i][2] = list.get(i).getDirector();
            objects[i][3] = list.get(i).getStarring();
            objects[i][4] = list.get(i).getMovieType();
            objects[i][5] = list.get(i).getMovieTime();
            objects[i][6]=list.get(i).getSession();
            objects[i][7]=list.get(i).getRoom();
            objects[i][8]=list.get(i).getPrice();
        }
        return objects;
    }

    //用于查询用户订单
    public Object[][] getPaymentInfo(String userName,String movieName){
        String sql=null;
        if(movieName.equals("")) {
            sql = "SELECT * FROM paymentImp WHERE userName='"+userName+"'";
        }else {
            sql="SELECT * FROM paymentImp WHERE movieName='"+movieName+"'AND userName='"+userName+"'";
        }
        Connection connection=DbConnection.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        ArrayList<PaymentImp> list=new ArrayList<>();

        try{
            stmt=(PreparedStatement) connection.prepareStatement(sql);
            rs=stmt.executeQuery();
            while(rs.next()){
                PaymentImp paymentImp=new PaymentImp();
                paymentImp.setId(rs.getInt(1));
                paymentImp.setUserName(rs.getString(2));
                paymentImp.setPaymentAmount(rs.getString(3));
                paymentImp.setMovieName(rs.getString(4));
                paymentImp.setTimes(rs.getString(5));
                paymentImp.setRoom(rs.getString(6));
                paymentImp.setTickingTime(rs.getString(7));
                paymentImp.setCount(rs.getString(8));
                list.add(paymentImp);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }finally{
            try{
                DbConnection.close(rs,stmt,connection);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        Object[][] objects=new Object[list.size()][8];
        for(int i=0;i<list.size();i++){
            objects[i][0] = list.get(i).getId();
            objects[i][1] = list.get(i).getUserName();
            objects[i][2] = list.get(i).getPaymentAmount();
            objects[i][3] = list.get(i).getMovieName();
            objects[i][4] = list.get(i).getTimes();
            objects[i][5] = list.get(i).getRoom();
            objects[i][6]=list.get(i).getTickingTime();
            objects[i][7]=list.get(i).getCount();
        }
        return objects;
    }

    //用于查询用户级别
    public double getUserLevelInfo(String userName){
        String sql="SELECT * FROM user WHERE userName='"+userName+"'";
        Connection connection=DbConnection.getConnection();
        PreparedStatement stmt=null;
        ResultSet rs=null;
        double res=1.0;
        try{
            stmt=connection.prepareStatement(sql);
            rs=stmt.executeQuery();
            while(rs.next()){
                String userLevel=rs.getString(4);
                if(userLevel.equals("金牌用户")) res=0.8;
                if(userLevel.equals("银牌用户")) res=0.9;
            }
        }catch (SQLException e){
            e.printStackTrace();
        }finally {
            try {
                DbConnection.close(rs,stmt,connection);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return res;
    }


}

```



#### 2.3.2Judge(判断类)

用于判断传输的sql语句类型

```java
package Controller;

import View.*;

import javax.swing.*;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Judge {
    private final Select select=new Select();
    private final Update update=new Update();

    public Judge() {
    }

    public void judgeAdmin(String username, String password, Login login){
        if(username.equals("")||password.equals("")){
            JOptionPane.showMessageDialog(null,"账户名或密码未填写");
        }else{
            String sql="select COUNT(*) from admin where username='"+username+"'and password='"+password+"'";
                boolean res = select.loginSelect(sql);
                if(res){
                    //登录成功,进入管理员界面
                    JOptionPane.showMessageDialog(null,"登录成功,欢迎使用!");
                    new AdminView().setVisible(true);
                    login.dispose();
                }else{
                    //登录失败
                    System.out.println("登陆失败");
                }

        }
    }

    public void judgeUsers(String username,String password,Login login){
        if(username.equals("")||password.equals("")){
            JOptionPane.showMessageDialog(null,"账户名或密码未填写");
        }else{
            String sql="select COUNT(*) from user where username='"+username+"'and password='"+password+"'";
            boolean res = select.loginSelect(sql);
            if(res){
                //登录成功,进入用户界面
                JOptionPane.showMessageDialog(null,"登录成功,欢迎使用!");
                new UserView(username).setVisible(true);
                login.dispose();
            }else{
                //登录失败
                JOptionPane.showMessageDialog(null,"登陆失败,请检查用户名和密码是否正确");
            }

        }
    }

    public void judgeReception(String username,String password,Login login){
        if(username.equals("")||password.equals("")){
            JOptionPane.showMessageDialog(null,"账户名或密码未填写");
        }else{
            String sql="select COUNT(*) from Reception where username='"+username+"'and password='"+password+"'";
            boolean res = select.loginSelect(sql);
            if(res){
                //登录成功,进入前台界面
                JOptionPane.showMessageDialog(null,"登录成功,欢迎使用!");
                new ReceptionView().setVisible(true);
                login.dispose();
            }else{
                //登录失败
                JOptionPane.showMessageDialog(null,"登陆失败,请检查用户名和密码是否正确");
            }

        }
    }

    public void judgeManager(String username,String password,Login login){
        if(username.equals("")||password.equals("")){
            JOptionPane.showMessageDialog(null,"账户名或密码未填写");
        }else{
            String sql="select COUNT(*) from Manager where username='"+username+"'and password='"+password+"'";
            boolean res = select.loginSelect(sql);
            if(res){
                //登录成功,进入经理界面
                JOptionPane.showMessageDialog(null,"登录成功,欢迎使用!");
                new ManagerView().setVisible(true);
                login.dispose();
            }else{
                //登录失败
                JOptionPane.showMessageDialog(null,"登陆失败,请检查用户名和密码是否正确");
            }

        }
    }

    //判断管理员是否修改了自己的密码
    public void judgeAdminPassword(String username,String curPassword,String changePassword){
        if(username.equals("")||curPassword.equals("")||changePassword.equals("")){
            JOptionPane.showMessageDialog(null,"账户名或密码未填写");
        }else{
            String UpdateSql="UPDATE admin SET password='"+changePassword+"'WHERE username='"+username+"'AND password='"+curPassword+"'";
            update.addData(UpdateSql);
            JOptionPane.showMessageDialog(null,"修改成功!");
        }
    }

    //判断管理员是否修改了用户密码
    public void judgeAdminUserPassword(String username,String password){
        if(username.equals("")||password.equals("")){
            JOptionPane.showMessageDialog(null,"账户名不正确");
        }else{
            String UpdateSql="UPDATE user SET password='"+password+"'WHERE username='"+username+"'";
            update.addData(UpdateSql);
            JOptionPane.showMessageDialog(null,"修改成功!");
        }
    }

    //判断管理员是否删除了用户
    public void judgeDeleteUser(String username){
        if(username.equals("")){
            JOptionPane.showMessageDialog(null,"账户名不正确");
        }else{
            String deleteSql="DELETE FROM user WHERE username='"+username+"'";
            update.addData(deleteSql);
            JOptionPane.showMessageDialog(null,"删除成功!");
        }
    }

    //判断是否注册成功
    public void judgeRegister(String username,String password,String email){
        if(username.equals("")||password.equals("")||email.equals("")){
            JOptionPane.showMessageDialog(null,"输入不正确,不允许为空");
        }else{
            Date date=new Date();
            String nowTime=new SimpleDateFormat("yyyy-MM-dd").format(date);

            String sql="INSERT INTO user(username,password,userLevel,regDate,totalAmount,consumptionTime,userEmail)" +
                    "Values('"+username+"','"+password+"','"+"铜牌用户"+"','"+nowTime+"','"+"0"+"','"+"0"+"','"+email+"')";
            boolean result=update.addData(sql);
            if(result){
                JOptionPane.showMessageDialog(null,"注册成功,请重新登录");
                new Login().setVisible(true);
            }else{
                JOptionPane.showMessageDialog(null,"注册失败,请重新注册");
                new RegisterUserView().setVisible(true);
            }
        }
    }

}

```



#### 2.3.3Update(增删改查类)

增删改查的sql语句

```java
package Controller;

import Dao.DbConnection;

import java.sql.Connection;

/**
 * 增删改查类
 */

public class Update {

    //用于新增信息
    public boolean addData(String sql){
        try{
            Connection connection=DbConnection.getConnection();
            int res=DbConnection.updateInfo(sql);
            if(res!=0) return true;
            DbConnection.close(null,null,connection);
        }catch (Exception e){
            throw new RuntimeException(e);
        }
        return false;
    }



}

```



### 2.4Dao包(数据库连接工具包)

#### 2.4.1Dbconnection(数据库连接类)

用于数据库连接

```java
package Dao;

import javax.swing.*;
import java.sql.*;


/**
 * 数据库连接类
 */


public class DbConnection {
    // 驱动类的类名
    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";
    // 连接数据的URL路径
    private static final String URL = "jdbc:mysql://localhost:3306/movieSystemPlus";
    // 数据库登录账号
    private static final String USER = "root";
    // 数据库登录密码
    private static final String PASSWORD = "123456";

    // 加载驱动
    static {
        try {
            Class.forName(DRIVER);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    // 获取数据库连接
    public static Connection getConnection() {
        try {
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    // 查询
    public static ResultSet query(String sql) {
        // 获取连接
        Connection connection = getConnection();
        PreparedStatement psd;
        try {
            psd = connection.prepareStatement(sql);
            return psd.executeQuery();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "执行语句出错\n" + e.toString());
            e.printStackTrace();
        }
        return null;
    }



    // 增、删、改、查
    public static int updateInfo(String sql) {
        // 获取连接
        Connection connection = getConnection();
        try {
            PreparedStatement psd = connection.prepareStatement(sql);
            return psd.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "执行语句出错\n" + e.toString());
            e.printStackTrace();
        }
        return 0;
    }

    // 关闭连接
    public static void close(ResultSet rs, PreparedStatement stmt, Connection conn) throws Exception {
        try {
            if (rs != null) {
                rs.close();
            }
            if (stmt != null) {
                stmt.cancel();
            }
            if (conn != null) {
                conn.close();
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new Exception();
        }
    }
}

```



### 2.5Test包(测试包)

##### 2.5.1main

用于主程序运行

```java
package Test;

import View.Login;

/**
 * 运行入口
 */


public class Main {
    public static void main(String[] args) {
        new Login().setVisible(true);
    }
}
```



### 2.6View(界面包)

#### 2.6.1AddMovieView

```java
package View;

import Controller.Update;

import javax.swing.*;

public class AddMovieView extends JFrame {
    private final JTextField movieName;
    private final JTextField director;
    private final JTextField starring;
    private final JTextField movieType;
    private final JTextField movieTime;
    private final JTextField session;
    private final JTextField room;
    private final JTextField price;

    public AddMovieView(){
        super("增加影片");
        Update update=new Update();
        this.setBounds(0,0,500,500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setLayout(null);


        //电影名
        JLabel label_1 = new JLabel("电影名：");
        label_1.setBounds(120, 30, 75, 18);
        getContentPane().add(label_1);
        movieName = new JTextField();
        movieName.setBounds(220, 26, 108, 24);
        getContentPane().add(movieName);
        movieName.setColumns(10);

        //场次
        JLabel label_2 =new JLabel("场次:");
        label_2.setBounds(120,70,50,18);
        getContentPane().add(label_2);
        session=new JTextField();
        session.setBounds(220,70,50,24);
        getContentPane().add(session);
        session.setColumns(10);

        //演播厅
        JLabel label_3 =new JLabel("演播厅:");
        label_3.setBounds(120,110,50,18);
        getContentPane().add(label_3);
        room=new JTextField();
        room.setBounds(220,110,50,24);
        getContentPane().add(room);
        room.setColumns(10);

        //导演
        JLabel label_4 = new JLabel("导演: ");
        label_4.setBounds(120, 150, 70, 18);
        getContentPane().add(label_4);
        director = new JTextField();
        director.setBounds(220, 150, 175, 24);
        getContentPane().add(director);
        director.setColumns(10);

        //主演
        JLabel label_5 = new JLabel("主演：");
        label_5.setBounds(120, 190, 75, 18);
        getContentPane().add(label_5);
        starring= new JTextField();
        starring.setBounds(220, 190, 171, 24);
        getContentPane().add(starring);
        starring.setColumns(10);

        //电影类型
        JLabel label_6 = new JLabel("电影类型：");
        label_6.setBounds(120, 230, 80, 18);
        getContentPane().add(label_6);
        movieType = new JTextField();
        movieType.setColumns(10);
        movieType.setBounds(220, 230, 119, 24);
        getContentPane().add(movieType);

        //电影时长
        JLabel label_7 =new JLabel("电影时长: ");
        label_7.setBounds(120,270,80,18);
        getContentPane().add(label_7);
        movieTime=new JTextField();
        movieTime.setColumns(10);
        movieTime.setBounds(220,270,119,24);
        getContentPane().add(movieTime);

        //票价
        JLabel label_8 =new JLabel("票价: ");
        label_8.setBounds(120,310,50,18);
        getContentPane().add(label_8);
        price=new JTextField();
        price.setColumns(10);
        price.setBounds(220,310,60,24);
        getContentPane().add(price);


        //增加
        JButton addButton=new JButton("增加");
        addButton.setBounds(120,360,80,30);
        addButton.addActionListener(e -> {
            String sql="INSERT INTO movie(movieName,director,starring,type,time,session,room,price)"
                    +"Values('"+movieName.getText()+"','"+director.getText()+
                    "','"+starring.getText()+"','"+movieType.getText()+
                    "','"+movieTime.getText()+"','"+session.getText()+
                    "','"+room.getText()+"','"+price.getText()+"')";
            if(update.addData(sql)){
                JOptionPane.showMessageDialog(null,"增加成功");
            }else {
                JOptionPane.showMessageDialog(null, "增加失败");
            }

        });
        getContentPane().add(addButton);

        //重置
        JButton regButton=new JButton("重置");
        regButton.setBounds(300,360,80,30);
        regButton.addActionListener(e -> {
            movieName.setText("");
            director.setText("");
            starring.setText("");
            movieType.setText("");
            movieTime.setText("");
            session.setText("");
            room.setText("");
            price.setText("");
        });
        getContentPane().add(regButton);

    }


}

```



#### 2.6.2.AdminChangeSelfPasswordView

```java
package View;

import Controller.Judge;

import javax.swing.*;

public class AdminChangeSelfPasswordView extends JFrame {
    private final JTextField username;
    private final JTextField curPassword;
    private final JTextField changePassword;

    public AdminChangeSelfPasswordView(){
        super("修改管理员密码");
        this.setBounds(0,0,600,350);
        //窗口居中
        this.setLocationRelativeTo(null);
        //窗口不能改变大小
        this.setResizable(false);
        //窗口关闭
        getContentPane().setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //账户
        JLabel usernameText=new JLabel("账号:");
        usernameText.setBounds(100,70,72,18);
        getContentPane().add(usernameText);

        username=new JTextField();
        username.setBounds(250,67,203,24);
        getContentPane().add(username);
        username.setColumns(10);

        //当前密码
        JLabel passwordText_1=new JLabel("当前密码:");
        passwordText_1.setBounds(100,135,72,18);
        getContentPane().add(passwordText_1);

        curPassword=new JTextField();
        curPassword.setBounds(250,135,203,24);
        getContentPane().add(curPassword);
        curPassword.setColumns(10);

        //修改后的密码
        JLabel passwordText_2=new JLabel("修改后密码:");
        passwordText_2.setBounds(100,200,72,18);
        getContentPane().add(passwordText_2);

        changePassword=new JTextField();
        changePassword.setBounds(250,200,203,24);
        getContentPane().add(changePassword);
        changePassword.setColumns(10);

        JButton changePasswordButton=new JButton("修改");
        changePasswordButton.addActionListener(e -> {
            String uname=username.getText();
            String curPwd=curPassword.getText();
            String changePwd=changePassword.getText();

            new Judge().judgeAdminPassword(uname,curPwd,changePwd);
        });
        changePasswordButton.setBounds(150,250,113,27);
        getContentPane().add(changePasswordButton);

        JButton regButton=new JButton("重置");
        regButton.addActionListener(e -> {
            username.setText("");
            curPassword.setText("");
            changePassword.setText("");

        });
        regButton.setBounds(300,250,113,27);
        getContentPane().add(regButton);

        JButton backButton=new JButton("返回上一级");
        backButton.addActionListener(e -> {
            new AdminPasswordView().setVisible(true);
            dispose();
        });
        backButton.setBounds(0,0,100,25);
        getContentPane().add(backButton);
    }


}
```



#### 2.6.3AdminMessageView

```java
package View;


import javax.swing.*;
import java.awt.*;

public class AdminMessageView extends JFrame {
    public AdminMessageView(){
        super("信息管理--管理员后台");
        getContentPane().setFont(new Font("宋体", Font.PLAIN, 35));
        this.setBounds(0, 0, 600, 400);
        // 居中显示
        this.setLocationRelativeTo(null);
        // 窗口不可变
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblxxx = new JLabel("用户管理");
        lblxxx.setFont(new Font("宋体", Font.PLAIN, 35));
        lblxxx.setBounds(200, 35, 600, 91);
        panel.add(lblxxx);

        JButton button = new JButton("列出所有用户信息");
        button.setFont(new Font("宋体", Font.BOLD, 20));
        button.setBounds(60, 150, 200, 59);
        button.addActionListener(e -> {
            new AdminUserView().setVisible(true);
            dispose();
        });
        panel.add(button);

        JButton button_1 = new JButton("删除用户信息");
        button_1.setFont(new Font("宋体", Font.BOLD, 20));
        button_1.setBounds(300, 150, 200, 59);
        button_1.addActionListener(e -> {
            new DeleteUsersMessageView().setVisible(true);
            dispose();
        });
        panel.add(button_1);

        JButton button_2 =new JButton("查询用户信息");
        button_2.setFont(new Font("宋体",Font.BOLD,20));
        button_2.setBounds(60,250,200,59);
        button_2.addActionListener(e -> {
            new AdminUserView().setVisible(true);
            dispose();
        });
        panel.add(button_2);

        JButton button_3 = new JButton("返回上一级");
        button_3.setFont(new Font("宋体", Font.BOLD, 20));
        button_3.setBounds(300, 250, 200, 59);
        button_3.addActionListener(e -> {
            new AdminView().setVisible(true);
            dispose();
        });
        panel.add(button_3);

        getContentPane().add(panel);
    }


}

```



#### 2.6.4AdminPasswordView

```java
package View;


import javax.swing.*;
import java.awt.*;

public class AdminPasswordView extends JFrame {
    public AdminPasswordView(){
        super("密码管理--管理员后台");
        getContentPane().setFont(new Font("宋体",Font.PLAIN,35));
        this.setBounds(0,0,760,300);
        // 居中显示
        this.setLocationRelativeTo(null);
        // 窗口不可变
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblxxx = new JLabel("你好,管理员,这是密码管理界面");
        lblxxx.setFont(new Font("宋体", Font.PLAIN, 35));
        lblxxx.setBounds(120, 35, 726, 91);
        panel.add(lblxxx);

        JButton button = new JButton("修改自身密码");
        button.setFont(new Font("宋体", Font.BOLD, 20));
        button.setBounds(80, 150, 166, 59);
        button.addActionListener(e -> {
            new AdminChangeSelfPasswordView().setVisible(true);
            dispose();
        });
        panel.add(button);

        JButton button_1 = new JButton("重置用户密码");
        button_1.setFont(new Font("宋体", Font.BOLD, 20));
        button_1.setBounds(292, 150, 166, 59);
        button_1.addActionListener(e -> {
            new ChangeUserPasswordView("admin").setVisible(true);
            dispose();
        });
        panel.add(button_1);

        JButton button_2 = new JButton("返回上一级");
        button_2.setFont(new Font("宋体", Font.BOLD, 20));
        button_2.setBounds(515, 150, 166, 59);
        button_2.addActionListener(e -> {
            new AdminView().setVisible(true);
            dispose();
        });
        panel.add(button_2);

        getContentPane().add(panel);

    }


}

```



#### 2.6.5AdminUserView

```java
package View;

import Controller.Select;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AdminUserView extends JFrame {
    Select select=new Select();

    private final JTable table;
    DefaultTableModel df;

    Object[][] data=select.getUserInfo("");
    String[] header=new String[]{"ID","用户名","用户等级","注册时间","消费金额","消费次数","邮箱"};
    private final JTextField id;
    private final JTextField username;
    private final JTextField userLevel;
    private final JTextField regDate;
    private final JTextField totalAmount;
    private final JTextField consumptionTime;
    private final JTextField email;
    private final JTextField searchUsername;

    public AdminUserView(){
        super("平台用户信息");
        this.setBounds(0,0,935,700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setLayout(null);

        JScrollPane scrollPane=new JScrollPane();
        scrollPane.setBounds(27,321,876,331);
        getContentPane().add(scrollPane);

        table=new JTable();
        df=new DefaultTableModel(data,header);
        table.setModel(df);
        scrollPane.setViewportView(table);
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //鼠标点击
                id.setText(table.getValueAt(table.getSelectedRow(),0).toString());
                username.setText((table.getValueAt(table.getSelectedRow(),1).toString()));
                userLevel.setText((table.getValueAt(table.getSelectedRow(),2).toString()));
                regDate.setText((table.getValueAt(table.getSelectedRow(),3).toString()));
                totalAmount.setText((table.getValueAt(table.getSelectedRow(),4).toString()));
                consumptionTime.setText((table.getValueAt(table.getSelectedRow(),5).toString()));
                email.setText((table.getValueAt(table.getSelectedRow(),6).toString()));

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "用户信息", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(27, 27, 876, 200);
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel label = new JLabel("id：");
        label.setBounds(32, 30, 75, 18);
        panel.add(label);

        id = new JTextField();
        id.setEditable(false);
        id.setBounds(112, 26, 119, 24);
        panel.add(id);
        id.setColumns(10);

        JLabel label_1 = new JLabel("用户名：");
        label_1.setBounds(257, 30, 75, 18);
        panel.add(label_1);

        username = new JTextField();
        username.setBounds(337, 26, 108, 24);
        panel.add(username);
        username.setColumns(10);

        JLabel label_2_1 = new JLabel("用户级别: ");
        label_2_1.setBounds(550, 67, 70, 18);
        panel.add(label_2_1);

        userLevel = new JTextField();
        userLevel.setBounds(650, 64, 175, 24);
        panel.add(userLevel);
        userLevel.setColumns(10);

        JLabel label_2_2 = new JLabel("注册时间：");
        label_2_2.setBounds(32, 65, 75, 18);
        panel.add(label_2_2);

        regDate= new JTextField();
        regDate.setBounds(112, 61, 171, 24);
        panel.add(regDate);
        regDate.setColumns(10);

        JLabel label_2_3 = new JLabel("消费总金额：");
        label_2_3.setBounds(308, 67, 80, 18);
        panel.add(label_2_3);

        totalAmount = new JTextField();
        totalAmount.setColumns(10);
        totalAmount.setBounds(400, 63, 119, 24);
        panel.add(totalAmount);

        JLabel label_3_1=new JLabel("消费总次数: ");
        label_3_1.setBounds(32,110,80,18);
        panel.add(label_3_1);

        consumptionTime=new JTextField();
        consumptionTime.setColumns(10);
        consumptionTime.setBounds(112,105,119,24);
        panel.add(consumptionTime);

        JLabel label_3_2=new JLabel("邮箱: ");
        label_3_2.setBounds(257,110,40,18);
        panel.add(label_3_2);

        email=new JTextField();
        email.setColumns(10);
        email.setBounds(300,105,119,24);
        panel.add(email);




        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "条件查询", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        panel_1.setBounds(27, 240, 531, 68);
        getContentPane().add(panel_1);

        JLabel label_5 = new JLabel("用户名：");
        panel_1.add(label_5);

        searchUsername = new JTextField();
        panel_1.add(searchUsername);
        searchUsername.setColumns(10);

        JButton searchButton = new JButton("查询");
        panel_1.add(searchButton);
        searchButton.addActionListener(e -> {
            // 处理鼠标点击
            id.setText("");
            username.setText("");
            userLevel.setText("");
            regDate.setText("");
            totalAmount.setText("");
            consumptionTime.setText("");
            email.setText("");
            String username = searchUsername.getText();
            Object[][] data = select.getUserInfo(username);
            df.setDataVector(data, header);
        });

        JPanel panel_2=new JPanel();
        panel_2.setBorder(new TitledBorder(null, "返回上一级", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_2.setBounds(580, 240, 325, 68);
        getContentPane().add(panel_2);

        JButton backButton=new JButton("返回上一级");
        backButton.setBounds(650,280,200,40);
        backButton.addActionListener(e -> {
            new AdminMessageView().setVisible(true);
            dispose();
        });
        panel_2.add(backButton);

    }


}

```



#### 2.6.6AdminView

```java
package View;

import javax.swing.*;
import java.awt.*;

public class AdminView extends JFrame {

    public AdminView() {
        super("影院管理系统--管理员后台");
        getContentPane().setFont(new Font("宋体", Font.PLAIN, 35));
        this.setBounds(0, 0, 760, 300);
        // 居中显示
        this.setLocationRelativeTo(null);
        // 窗口不可变
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        JPanel panel = new JPanel();
        panel.setLayout(null);

        JLabel lblxxx = new JLabel("你好,管理员,欢迎来到影院管理系统");
        lblxxx.setFont(new Font("宋体", Font.PLAIN, 35));
        lblxxx.setBounds(80, 35, 726, 91);
        panel.add(lblxxx);

        JButton button = new JButton("密码管理");
        button.setFont(new Font("宋体", Font.BOLD, 20));
        button.setBounds(80, 150, 166, 59);
        button.addActionListener(e -> {
            new AdminPasswordView().setVisible(true);
            dispose();
        });
        panel.add(button);

        JButton button_1 = new JButton("用户信息管理");
        button_1.setFont(new Font("宋体", Font.BOLD, 20));
        button_1.setBounds(292, 150, 166, 59);
        button_1.addActionListener(e -> {
            new AdminMessageView().setVisible(true);
            dispose();
        });
        panel.add(button_1);

        JButton button_2 = new JButton("退出登录");
        button_2.setFont(new Font("宋体", Font.BOLD, 20));
        button_2.setBounds(515, 150, 166, 59);
        button_2.addActionListener(e -> {
            new Login().setVisible(true);
            dispose();
        });
        panel.add(button_2);

        getContentPane().add(panel);


    }
}


```



#### 2.6.7ChangeUserPasswordView

```java
package View;

import Controller.Judge;

import javax.swing.*;

public class ChangeUserPasswordView extends JFrame {
    private final JTextField username;
    private final JTextField password;

    public ChangeUserPasswordView(String identity){
        super("修改用户密码");
        this.setBounds(0,0,600,350);
        //居中
        this.setLocationRelativeTo(null);
        //窗口大小不能改变
        this.setResizable(false);
        //窗口关闭
        getContentPane().setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //账户
        JLabel usernameText=new JLabel("账号:");
        usernameText.setBounds(142,70,72,18);
        getContentPane().add(usernameText);

        username=new JTextField();
        username.setBounds(228,67,203,24);
        getContentPane().add(username);
        username.setColumns(10);

        //密码
        JLabel passwordText=new JLabel("密码:");
        passwordText.setBounds(142,135,72,18);
        getContentPane().add(passwordText);

        password=new JTextField();
        password.setBounds(228,135,203,24);
        getContentPane().add(password);
        password.setColumns(10);

        JButton changeButton=new JButton("修改");
        changeButton.addActionListener(e -> {
            String uname=username.getText();
            String pwd=password.getText();
            new Judge().judgeAdminUserPassword(uname,pwd);
        });
        changeButton.setBounds(142,228,113,27);
        getContentPane().add(changeButton);


        JButton regButton=new JButton("重置");
        regButton.addActionListener(e -> {
            username.setText("");
            password.setText("");

        });
        regButton.setBounds(318,228,113,27);
        getContentPane().add(regButton);

        JButton backButton=new JButton("返回上一级");
        backButton.addActionListener(e -> {
            if(identity.equals("admin")){
                new AdminPasswordView().setVisible(true);
                dispose();
            }else if(identity.equals("user")){
                dispose();
            }
        });
        backButton.setBounds(0,0,100,25);
        getContentPane().add(backButton);
    }

}

```



#### 2.6.8DeleteUsersMessageView



```java
package View;

import Controller.Judge;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteUsersMessageView extends JFrame {
    private JTextField username;

    public DeleteUsersMessageView(){
        super("删除用户信息");
        this.setBounds(0,0,600,350);
        //居中
        this.setLocationRelativeTo(null);
        //窗口不能随便改变大小
        this.setResizable(false);
        //窗口关闭
        getContentPane().setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //账户
        JLabel usernameText=new JLabel("账号:");
        usernameText.setBounds(100,120,72,18);
        getContentPane().add(usernameText);

        username=new JTextField();
        username.setBounds(250,120,203,24);
        getContentPane().add(username);
        username.setColumns(10);

        JButton changePasswordButton=new JButton("删除用户");
        changePasswordButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String uname=username.getText();
                new Judge().judgeDeleteUser(uname);
            }
        });
        changePasswordButton.setBounds(150,250,113,27);
        getContentPane().add(changePasswordButton);

        JButton regButton=new JButton("重置");
        regButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username.setText("");
            }
        });
        regButton.setBounds(300,250,113,27);
        getContentPane().add(regButton);

        JButton backButton=new JButton("返回上一级");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new AdminMessageView().setVisible(true);
                dispose();
            }
        });
        backButton.setBounds(0,0,100,25);
        getContentPane().add(backButton);
    }


}

```



2.6.9GetTicketsView

```java
package View;

import javax.swing.*;

public class GetTicketsView extends JFrame {

    public GetTicketsView(String id,String userName,String paymentAmount,String movieName,String times,String rooms,String TickingTime,String count){
        super("取票界面");
        this.setBounds(0,0,500,600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setLayout(null);
        JLabel id1 = new JLabel("订单号:   " + id);
        id1.setBounds(110,110,250,20);
        JLabel userName1 = new JLabel("用户名:  " + userName);
        userName1.setBounds(110,150,250,20);
        JLabel paymentAmount1 = new JLabel("支付金额: " + paymentAmount);
        paymentAmount1.setBounds(110,190,250,20);
        JLabel movieName1 = new JLabel("电影名称:  " + movieName);
        movieName1.setBounds(110,230,250,20);
        JLabel times1 = new JLabel("场次:  " + times);
        times1.setBounds(110,270,250,20);
        JLabel rooms1 = new JLabel("演播厅:   " + rooms);
        rooms1.setBounds(110,310,250,20);
        JLabel tickingTime = new JLabel("购票时间:   " + TickingTime);
        tickingTime.setBounds(110,350,250,20);
        JLabel count1 = new JLabel("购票数:   " + count);
        count1.setBounds(110,390,250,20);
        getContentPane().add(id1);
        getContentPane().add(userName1);
        getContentPane().add(paymentAmount1);
        getContentPane().add(movieName1);
        getContentPane().add(times1);
        getContentPane().add(rooms1);
        getContentPane().add(tickingTime);
        getContentPane().add(count1);


    }

}

```



#### 2.6.9Login

```java
package View;


import Controller.Judge;

import javax.swing.*;

import java.util.Objects;

public class Login extends JFrame {
    private final JTextField username;
    private final JTextField password;
    JComboBox roleComboBox;

    public Login(){
        super("用户登录");
        this.setBounds(0,0,600,350);
        //窗口居中
        this.setLocationRelativeTo(null);
        //使窗口不能改变大小
        this.setResizable(false);
        //窗口关闭按钮执行的操作
        getContentPane().setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //账户
        JLabel usernameText=new JLabel("账号:");
        usernameText.setBounds(142,70,72,18);
        getContentPane().add(usernameText);

        username=new JTextField();
        username.setBounds(228,67,203,24);
        getContentPane().add(username);
        username.setColumns(10);

        //密码
        JLabel passwordText=new JLabel("密码:");
        passwordText.setBounds(142,135,72,18);
        getContentPane().add(passwordText);

        password=new JTextField();
        password.setBounds(228,135,203,24);
        getContentPane().add(password);
        password.setColumns(10);


        JButton logButton=new JButton("登录");
        logButton.addActionListener(e -> {
            String uname=username.getText();
            String pwd=password.getText();
            String selectedRole = (String) roleComboBox.getSelectedItem();
            switch (Objects.requireNonNull(selectedRole)) {
                // 进入管理员界面
                case "管理员" -> new Judge().judgeAdmin(uname,pwd, Login.this);
                // 进入经理界面
                case "经理" -> new Judge().judgeManager(uname,pwd,Login.this);
                // 进入前台界面
                case "前台" -> new Judge().judgeReception(uname,pwd,Login.this);
                // 进入用户界面
                case "用户" -> new Judge().judgeUsers(uname,pwd,Login.this);
            }

        });
        logButton.setBounds(142,228,113,27);
        getContentPane().add(logButton);

        JButton regButton=new JButton("重置");
        regButton.addActionListener(e -> {
            username.setText("");
            password.setText("");

        });
        regButton.setBounds(318,228,113,27);
        getContentPane().add(regButton);

        JButton registerButton=new JButton("注册");
        registerButton.addActionListener(e -> {
            new RegisterUserView().setVisible(true);
            dispose();
        });

        registerButton.setBounds(140,190,65,20);
        getContentPane().add(registerButton);

        JLabel roleLabel=new JLabel("请选择身份:");
        roleLabel.setBounds(240,180,100,27);
        getContentPane().add(roleLabel);

        roleComboBox=new JComboBox<>(new String[]{"用户","前台","经理","管理员"});
        roleComboBox.setBounds(340,180,100,27);
        getContentPane().add(roleComboBox);


    }

}

```



#### 2.9.10ManagerView

```java
package View;

import Controller.Select;
import Controller.Update;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ManagerView extends JFrame {
    Select select=new Select();

    private final JTable table;
    DefaultTableModel df;

    Object[][] data=select.getMovieInfo("");
    String[] header=new String[]{"ID","电影名","导演","主演","电影类型","电影时长","场次","演播厅","价格"};
    private final JTextField id;
    private final JTextField movieName;
    private final JTextField director;
    private final JTextField starring;
    private final JTextField movieType;
    private final JTextField movieTime;
    private final JTextField session;
    private final JTextField room;
    private final JTextField price;
    private final JTextField searchMovieName;


    public ManagerView(){
        super("平台影片信息");
        Update update=new Update();
        this.setBounds(0,0,935,700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JScrollPane scrollPane=new JScrollPane();
        scrollPane.setBounds(27,321,876,331);
        getContentPane().add(scrollPane);

        table=new JTable();
        df=new DefaultTableModel(data,header);
        table.setModel(df);
        scrollPane.setViewportView(table);
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //鼠标点击
                id.setText(table.getValueAt(table.getSelectedRow(),0).toString());
                movieName.setText((table.getValueAt(table.getSelectedRow(),1).toString()));
                director.setText((table.getValueAt(table.getSelectedRow(),2).toString()));
                starring.setText((table.getValueAt(table.getSelectedRow(),3).toString()));
                movieType.setText((table.getValueAt(table.getSelectedRow(),4).toString()));
                movieTime.setText((table.getValueAt(table.getSelectedRow(),5).toString()));
                session.setText((table.getValueAt(table.getSelectedRow(),6).toString()));
                room.setText((table.getValueAt(table.getSelectedRow(),7).toString()));
                price.setText((table.getValueAt(table.getSelectedRow(),8).toString()));
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        //影片信息类框架
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "影片信息", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(27, 27, 876, 200);
        getContentPane().add(panel);
        panel.setLayout(null);

        //id
        JLabel label = new JLabel("id：");
        label.setBounds(32, 30, 75, 18);
        panel.add(label);
        id = new JTextField();
        id.setEditable(false);
        id.setBounds(112, 26, 119, 24);
        panel.add(id);
        id.setColumns(10);

        //电影名
        JLabel label_1 = new JLabel("电影名：");
        label_1.setBounds(257, 30, 75, 18);
        panel.add(label_1);
        movieName = new JTextField();
        movieName.setBounds(337, 26, 108, 24);
        panel.add(movieName);
        movieName.setColumns(10);

        //场次
        JLabel label_1_2 =new JLabel("场次:");
        label_1_2.setBounds(500,30,50,18);
        panel.add(label_1_2);
        session=new JTextField();
        session.setBounds(560,26,50,24);
        panel.add(session);
        session.setColumns(10);

        //演播厅
        JLabel label_1_3 =new JLabel("演播厅:");
        label_1_3.setBounds(650,30,50,18);
        panel.add(label_1_3);
        room=new JTextField();
        room.setBounds(720,26,50,24);
        panel.add(room);
        room.setColumns(10);

        //导演
        JLabel label_2_1 = new JLabel("导演: ");
        label_2_1.setBounds(550, 67, 70, 18);
        panel.add(label_2_1);
        director = new JTextField();
        director.setBounds(650, 64, 175, 24);
        panel.add(director);
        director.setColumns(10);

        //主演
        JLabel label_2_2 = new JLabel("主演：");
        label_2_2.setBounds(32, 65, 75, 18);
        panel.add(label_2_2);
        starring= new JTextField();
        starring.setBounds(112, 61, 171, 24);
        panel.add(starring);
        starring.setColumns(10);

        //电影类型
        JLabel label_2_3 = new JLabel("电影类型：");
        label_2_3.setBounds(308, 67, 80, 18);
        panel.add(label_2_3);
        movieType = new JTextField();
        movieType.setColumns(10);
        movieType.setBounds(400, 63, 119, 24);
        panel.add(movieType);

        //电影时长
        JLabel label_3_1=new JLabel("电影时长: ");
        label_3_1.setBounds(32,110,80,18);
        panel.add(label_3_1);
        movieTime=new JTextField();
        movieTime.setColumns(10);
        movieTime.setBounds(112,105,119,24);
        panel.add(movieTime);

        //票价
        JLabel label_3_2=new JLabel("票价: ");
        label_3_2.setBounds(300,110,50,18);
        panel.add(label_3_2);
        price=new JTextField();
        price.setColumns(10);
        price.setBounds(350,105,60,24);
        panel.add(price);



        //查询框架
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "条件查询", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setBounds(27, 240, 531, 68);
        getContentPane().add(panel_1);
        JLabel label_5 = new JLabel("电影名：");
        panel_1.add(label_5);
        searchMovieName = new JTextField();
        panel_1.add(searchMovieName);
        searchMovieName.setColumns(10);
        JButton searchButton = new JButton("查询");
        panel_1.add(searchButton);
        searchButton.addActionListener(e -> {
            // 处理鼠标点击
            id.setText("");
            movieName.setText("");
            director.setText("");
            starring.setText("");
            movieType.setText("");
            movieTime.setText("");
            session.setText("");
            room.setText("");
            price.setText("");
            String movieName = searchMovieName.getText();
            Object[][] data = select.getMovieInfo(movieName);
            df.setDataVector(data, header);
        });

        //退出登录框架
        JPanel panel_2=new JPanel();
        panel_2.setBorder(new TitledBorder(null, "退出登录", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_2.setBounds(580, 240, 325, 68);
        getContentPane().add(panel_2);
        JButton backButton=new JButton("退出登录");
        backButton.setBounds(600,280,50,40);
        backButton.addActionListener(e -> {
            new Login().setVisible(true);
            dispose();
        });
        panel_2.add(backButton);

        //新增影片,修改信息功能
        JPanel panel_3=new JPanel();
        panel_3.setBorder(new TitledBorder(null,"其他功能",TitledBorder.LEADING,TitledBorder.TOP,null,null));
        panel_3.setBounds(500,110,300,68);
        panel.add(panel_3);
        JButton button_1=new JButton("新增影片");
        button_1.setBounds(550,130,100,25);
        panel_3.add(button_1);
        button_1.addActionListener(e -> new AddMovieView().setVisible(true));
        JButton button_2=new JButton("修改信息");
        button_2.setBounds(700,130,100,25);
        panel_3.add(button_2);
        button_2.addActionListener(e -> {
            String sql="UPDATE movie SET movieName='"+movieName.getText()+"',director='"+director.getText()+
                    "',starring='"+starring.getText()+"',type='"+movieType.getText()+
                    "',time='"+movieTime.getText()+"',session='"+session.getText()+
                    "',room='"+room.getText()+"',price='"+price.getText()+"' WHERE id='"+id.getText()+"'";
            if(update.addData(sql)){
                JOptionPane.showMessageDialog(null,"修改成功");
                Object[][] data=select.getMovieInfo("");
                df.setDataVector(data,header);
            }else{
                JOptionPane.showMessageDialog(null,"修改失败");
            }
        });
    }




}

```



#### 2.9.11OrderView

```java
package View;

import Controller.Select;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class OrderView extends JFrame {
    Select select=new Select();

    private final JTable table;
    DefaultTableModel df;
    String[] header=new String[]{"订单号","用户名","支付金额","电影名称","场次","演播厅","时间","票数"};


    private final JTextField id;
    private final JTextField username;
    private final JTextField paymentAmount;
    private final JTextField movieName;
    private final JTextField times;
    private final JTextField room;
    private final JTextField tickingTime;
    private final JTextField count;
    private final JTextField searchMovieName;


    public OrderView(String userName){
        super("历史订单");
        this.setBounds(0,0,935,700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setLayout(null);

        JScrollPane scrollPane=new JScrollPane();
        scrollPane.setBounds(27,321,876,331);
        getContentPane().add(scrollPane);

        Object[][] data=select.getPaymentInfo(userName,"");
        table=new JTable();
        df=new DefaultTableModel(data,header);
        table.setModel(df);
        scrollPane.setViewportView(table);
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //鼠标点击
                id.setText(table.getValueAt(table.getSelectedRow(),0).toString());
                username.setText(table.getValueAt(table.getSelectedRow(),1).toString());
                paymentAmount.setText(table.getValueAt(table.getSelectedRow(),2).toString());
                movieName.setText(table.getValueAt(table.getSelectedRow(),3).toString());
                times.setText(table.getValueAt(table.getSelectedRow(),4).toString());
                room.setText(table.getValueAt(table.getSelectedRow(),5).toString());
                tickingTime.setText(table.getValueAt(table.getSelectedRow(),6).toString());
                count.setText(table.getValueAt(table.getSelectedRow(),7).toString());
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });


        //订单信息类框架
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "影片信息", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(27, 27, 876, 200);
        getContentPane().add(panel);
        panel.setLayout(null);

        //id
        JLabel label = new JLabel("id：");
        label.setBounds(32, 30, 75, 18);
        panel.add(label);
        id = new JTextField();
        id.setEditable(false);
        id.setBounds(112, 26, 119, 24);
        panel.add(id);
        id.setColumns(10);

        //用户名
        JLabel label_1 = new JLabel("用户名：");
        label_1.setBounds(257, 30, 75, 18);
        panel.add(label_1);
        username = new JTextField();
        username.setBounds(337, 26, 108, 24);
        panel.add(username);
        username.setColumns(10);

        //演播厅
        JLabel label_1_2 =new JLabel("演播厅:");
        label_1_2.setBounds(500,30,50,18);
        panel.add(label_1_2);
        room=new JTextField();
        room.setBounds(560,26,50,24);
        panel.add(room);
        room.setColumns(3);

        //场次
        JLabel label_1_3 =new JLabel("场次:");
        label_1_3.setBounds(650,30,50,18);
        panel.add(label_1_3);
        times=new JTextField();
        times.setBounds(720,26,50,24);
        panel.add(times);
        times.setColumns(3);

        //支付金额
        JLabel label_2_1 = new JLabel("支付金额: ");
        label_2_1.setBounds(550, 67, 70, 18);
        panel.add(label_2_1);
        paymentAmount = new JTextField();
        paymentAmount.setBounds(650, 64, 100, 24);
        panel.add(paymentAmount);
        paymentAmount.setColumns(6);

        //时间
        JLabel label_2_2 = new JLabel("时间：");
        label_2_2.setBounds(32, 65, 75, 18);
        panel.add(label_2_2);
        tickingTime= new JTextField();
        tickingTime.setBounds(112, 61, 171, 24);
        panel.add(tickingTime);
        tickingTime.setColumns(10);

        //票数
        JLabel label_2_3 = new JLabel("票数：");
        label_2_3.setBounds(308, 67, 80, 18);
        panel.add(label_2_3);
        count = new JTextField();
        count.setColumns(10);
        count.setBounds(400, 63, 119, 24);
        panel.add(count);

        //电影名
        JLabel label_3_1=new JLabel("电影时长: ");
        label_3_1.setBounds(32,110,80,18);
        panel.add(label_3_1);
        movieName=new JTextField();
        movieName.setColumns(10);
        movieName.setBounds(112,105,119,24);
        panel.add(movieName);


        //查询框架
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "条件查询", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setBounds(27, 240, 531, 68);
        getContentPane().add(panel_1);
        JLabel label_5 = new JLabel("电影名：");
        panel_1.add(label_5);
        searchMovieName = new JTextField();
        panel_1.add(searchMovieName);
        searchMovieName.setColumns(10);
        JButton searchButton = new JButton("查询");
        panel_1.add(searchButton);
        searchButton.addActionListener(e -> {
            // 处理鼠标点击
            id.setText("");
            username.setText("");
            paymentAmount.setText("");
            movieName.setText("");
            times.setText("");
            room.setText("");
            tickingTime.setText("");
            count.setText("");
            String movieName = searchMovieName.getText();
            Object[][] data1 = select.getPaymentInfo(userName,movieName);
            df.setDataVector(data1, header);
        });

        //取票框架
        JPanel panel_2=new JPanel();
        panel_2.setBorder(new TitledBorder(null, "取票", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_2.setBounds(580, 240, 325, 68);
        getContentPane().add(panel_2);
        JButton backButton=new JButton("取票");
        backButton.setBounds(600,280,50,40);
        backButton.addActionListener(e -> new GetTicketsView(id.getText(),userName,paymentAmount.getText(),movieName.getText(), times.getText(),room.getText(),tickingTime.getText(), count.getText()).setVisible(true));
        panel_2.add(backButton);


    }

}

```



2.9.12ReceptionView

```java
package View;

import Controller.Select;
import Controller.Update;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ReceptionView extends JFrame {
    Select select=new Select();

    private final JTable table;
    DefaultTableModel df;

    Object[][] data=select.getMovieInfo("");
    String[] header=new String[]{"ID","电影名","导演","主演","电影类型","电影时长","场次","演播厅","价格"};
    private final JTextField id;
    private final JTextField movieName;
    private final JTextField director;
    private final JTextField starring;
    private final JTextField movieType;
    private final JTextField movieTime;
    private final JTextField session;
    private final JTextField room;
    private final JTextField price;
    private final JTextField userName;
    private final JTextField tickets;
    private final JTextField searchMovieName;


    public ReceptionView(){
        super("平台影片信息");
        Update update=new Update();
        this.setBounds(0,0,935,700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JScrollPane scrollPane=new JScrollPane();
        scrollPane.setBounds(27,321,876,331);
        getContentPane().add(scrollPane);

        table=new JTable();
        df=new DefaultTableModel(data,header);
        table.setModel(df);
        scrollPane.setViewportView(table);
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //鼠标点击
                id.setText(table.getValueAt(table.getSelectedRow(),0).toString());
                movieName.setText((table.getValueAt(table.getSelectedRow(),1).toString()));
                director.setText((table.getValueAt(table.getSelectedRow(),2).toString()));
                starring.setText((table.getValueAt(table.getSelectedRow(),3).toString()));
                movieType.setText((table.getValueAt(table.getSelectedRow(),4).toString()));
                movieTime.setText((table.getValueAt(table.getSelectedRow(),5).toString()));
                session.setText((table.getValueAt(table.getSelectedRow(),6).toString()));
                room.setText((table.getValueAt(table.getSelectedRow(),7).toString()));
                price.setText((table.getValueAt(table.getSelectedRow(),8).toString()));
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        //影片信息类框架
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "影片信息", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(27, 27, 876, 200);
        getContentPane().add(panel);
        panel.setLayout(null);

        //id
        JLabel label = new JLabel("id：");
        label.setBounds(32, 30, 75, 18);
        panel.add(label);
        id = new JTextField();
        id.setEditable(false);
        id.setBounds(112, 26, 119, 24);
        panel.add(id);
        id.setColumns(10);

        //电影名
        JLabel label_1 = new JLabel("电影名：");
        label_1.setBounds(257, 30, 75, 18);
        panel.add(label_1);
        movieName = new JTextField();
        movieName.setEditable(false);
        movieName.setBounds(337, 26, 108, 24);
        panel.add(movieName);
        movieName.setColumns(10);

        //场次
        JLabel label_1_2 =new JLabel("场次:");
        label_1_2.setBounds(500,30,50,18);
        panel.add(label_1_2);
        session=new JTextField();
        session.setEditable(false);
        session.setBounds(560,26,50,24);
        panel.add(session);
        session.setColumns(10);

        //演播厅
        JLabel label_1_3 =new JLabel("演播厅:");
        label_1_3.setBounds(650,30,50,18);
        panel.add(label_1_3);
        room=new JTextField();
        room.setEditable(false);
        room.setBounds(720,26,50,24);
        panel.add(room);
        room.setColumns(10);

        //导演
        JLabel label_2_1 = new JLabel("导演: ");
        label_2_1.setBounds(550, 67, 70, 18);
        panel.add(label_2_1);
        director = new JTextField();
        director.setEditable(false);
        director.setBounds(650, 64, 175, 24);
        panel.add(director);
        director.setColumns(10);

        //主演
        JLabel label_2_2 = new JLabel("主演：");
        label_2_2.setBounds(32, 65, 75, 18);
        panel.add(label_2_2);
        starring= new JTextField();
        starring.setEditable(false);
        starring.setBounds(112, 61, 171, 24);
        panel.add(starring);
        starring.setColumns(10);

        //电影类型
        JLabel label_2_3 = new JLabel("电影类型：");
        label_2_3.setBounds(308, 67, 80, 18);
        panel.add(label_2_3);
        movieType = new JTextField();
        movieType.setEditable(false);
        movieType.setColumns(10);
        movieType.setBounds(400, 63, 119, 24);
        panel.add(movieType);

        //电影时长
        JLabel label_3_1=new JLabel("电影时长: ");
        label_3_1.setBounds(32,110,80,18);
        panel.add(label_3_1);
        movieTime=new JTextField();
        movieTime.setEditable(false);
        movieTime.setColumns(10);
        movieTime.setBounds(112,105,119,24);
        panel.add(movieTime);

        //票价
        JLabel label_3_2=new JLabel("票价: ");
        label_3_2.setBounds(300,110,50,18);
        panel.add(label_3_2);
        price=new JTextField();
        price.setEditable(false);
        price.setColumns(10);
        price.setBounds(350,105,60,24);
        panel.add(price);



        //查询框架
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "条件查询", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setBounds(27, 240, 531, 68);
        getContentPane().add(panel_1);
        JLabel label_5 = new JLabel("电影名：");
        panel_1.add(label_5);
        searchMovieName = new JTextField();
        panel_1.add(searchMovieName);
        searchMovieName.setColumns(10);
        JButton searchButton = new JButton("查询");
        panel_1.add(searchButton);
        searchButton.addActionListener(e -> {
            // 处理鼠标点击
            id.setText("");
            movieName.setText("");
            director.setText("");
            starring.setText("");
            movieType.setText("");
            movieTime.setText("");
            session.setText("");
            room.setText("");
            price.setText("");
            String movieName = searchMovieName.getText();
            Object[][] data = select.getMovieInfo(movieName);
            df.setDataVector(data, header);
        });

        //退出登录框架
        JPanel panel_2=new JPanel();
        panel_2.setBorder(new TitledBorder(null, "退出登录", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_2.setBounds(580, 240, 325, 68);
        getContentPane().add(panel_2);
        JButton backButton=new JButton("退出登录");
        backButton.setBounds(600,280,50,40);
        backButton.addActionListener(e -> {
            new Login().setVisible(true);
            dispose();
        });
        panel_2.add(backButton);

        //售票
        JPanel panel_3=new JPanel();
        panel_3.setBorder(new TitledBorder(null,"售票",TitledBorder.LEADING,TitledBorder.TOP,null,null));
        panel_3.setBounds(450,110,400,68);
        panel.add(panel_3);
        //用户名
        JLabel userLabel=new JLabel("用户名: ");
        panel_3.add(userLabel);
        userName=new JTextField();
        userName.setColumns(10);
        panel_3.add(userName);
        //票数
        JLabel countLabel=new JLabel("票数: ");
        panel_3.add(countLabel);
        tickets=new JTextField();
        tickets.setColumns(3);
        panel_3.add(tickets);

        JButton saleButton =new JButton("售票");
        saleButton.setBounds(550,130,40,25);
        panel_3.add(saleButton);
        saleButton.addActionListener(e -> {
            double discount = select.getUserLevelInfo(userName.getText());
            double temp = Double.parseDouble(price.getText()) * discount * Double.parseDouble(tickets.getText());
            String mPrice = Double.toString(temp);
            Date date = new Date();
            String nowTime = new SimpleDateFormat("yyyy-MM-dd").format(date);
            String sql = "INSERT INTO payment(paymentAmount,userName,movieName,times,room,tickingTime,count)"
                    + "Values('" + mPrice + "','" + userName.getText() + "','" + movieName.getText() + "','" + session.getText()
                    + "','" + room.getText() + "','" + nowTime +"','"+tickets.getText()+"')";
            if (update.addData(sql)) {
                JOptionPane.showMessageDialog(null, "生成订单成功");
            } else {
                JOptionPane.showMessageDialog(null, "生成订单失败");
            }
            int res = JOptionPane.showConfirmDialog(null, "请确定是否已经付款", "确认", JOptionPane.OK_CANCEL_OPTION);
            if (res == 0) {
                sql = "INSERT INTO paymentImp(paymentAmount,userName,movieName,times,room,tickingTime,count)"
                        + "Values('" + mPrice + "','" + userName.getText()+ "','" + movieName.getText() + "','" + session.getText()
                        + "','" + room.getText() + "','" + nowTime +"','"+tickets.getText()+"')";
                if (update.addData(sql)) {
                    JOptionPane.showMessageDialog(null, "订单支付成功");
                } else {
                    JOptionPane.showMessageDialog(null, "订单支付失败");
                }
            } else {
                JOptionPane.showMessageDialog(null, "订单并未支付");
            }



        });

    }

}

```



#### 2.9.12RegisterUserView

```java
package View;

import Controller.Judge;
import Controller.Update;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegisterUserView extends JFrame{
    private JTextField username;
    private JTextField password;
    private JTextField curPassword;
    private JTextField email;


    public RegisterUserView(){
        super("用户注册");
        Update update=new Update();
        this.setBounds(0,0,400,450);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setLayout(null);

        JLabel usernameText=new JLabel("用户名: ");
        usernameText.setBounds(50,70,80,30);
        getContentPane().add(usernameText);

        username=new JTextField();
        username.setBounds(140,72,180,25);
        getContentPane().add(username);
        username.setColumns(10);

        JLabel passwordText =new JLabel("密码: ");
        passwordText.setBounds(50,120,80,30);
        getContentPane().add(passwordText);

        password=new JTextField();
        password.setBounds(140,122,180,25);
        getContentPane().add(password);
        password.setColumns(10);

        JLabel curPasswordText =new JLabel("确认密码: ");
        curPasswordText.setBounds(50,170,80,30);
        getContentPane().add(curPasswordText);

        curPassword=new JTextField();
        curPassword.setBounds(140,172,180,25);
        getContentPane().add(curPassword);
        curPassword.setColumns(10);

        JLabel emailText =new JLabel("邮箱: ");
        emailText.setBounds(50,220,80,30);
        getContentPane().add(emailText);

        email=new JTextField();
        email.setBounds(140,222,180,25);
        getContentPane().add(email);
        email.setColumns(10);

        JButton regButton=new JButton("注册");
        regButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String uname=username.getText();
                String pwd=password.getText();
                String curPwd=curPassword.getText();
                String mail=email.getText();

                //判断两次密码是否对应
                if(pwd.equals(curPwd)){
                    new Judge().judgeRegister(uname,pwd,mail);
                    dispose();
                }else{
                    JOptionPane.showMessageDialog(null,"请再次确认密码!");
                }
            }
        });
        regButton.setBounds(100,300,80,30);
        getContentPane().add(regButton);

        JButton backButton=new JButton("重置");
        backButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                username.setText("");
                password.setText("");
                curPassword.setText("");
                email.setText("");
            }
        });
        backButton.setBounds(220,300,80,30);
        getContentPane().add(backButton);

    }


}

```



2.9.13UserView

```java
package View;

import Controller.Select;
import Controller.Update;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.text.SimpleDateFormat;
import java.util.Date;

public class UserView extends JFrame {
    Select select = new Select();

    private final JTable table;
    DefaultTableModel df;

    Object[][] data = select.getMovieInfo("");
    String[] header = new String[]{"ID", "电影名", "导演", "主演", "电影类型", "电影时长", "场次", "演播厅", "价格"};
    private final JTextField id;
    private final JTextField movieName;
    private final JTextField director;
    private final JTextField starring;
    private final JTextField movieType;
    private final JTextField movieTime;
    private final JTextField session;
    private final JTextField room;
    private final JTextField price;
    private final JTextField tickets;
    private final JTextField searchMovieName;

    public UserView(String userName) {
        super("用户界面");
        Update update = new Update();
        this.setBounds(0, 0, 935, 700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBounds(27, 321, 876, 331);
        getContentPane().add(scrollPane);

        table = new JTable();
        df = new DefaultTableModel(data, header);
        table.setModel(df);
        scrollPane.setViewportView(table);
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //鼠标点击
                id.setText(table.getValueAt(table.getSelectedRow(), 0).toString());
                movieName.setText((table.getValueAt(table.getSelectedRow(), 1).toString()));
                director.setText((table.getValueAt(table.getSelectedRow(), 2).toString()));
                starring.setText((table.getValueAt(table.getSelectedRow(), 3).toString()));
                movieType.setText((table.getValueAt(table.getSelectedRow(), 4).toString()));
                movieTime.setText((table.getValueAt(table.getSelectedRow(), 5).toString()));
                session.setText((table.getValueAt(table.getSelectedRow(), 6).toString()));
                room.setText((table.getValueAt(table.getSelectedRow(), 7).toString()));
                price.setText((table.getValueAt(table.getSelectedRow(), 8).toString()));
            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }
        });
        //影片信息类框架
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "影片信息", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(27, 27, 876, 200);
        getContentPane().add(panel);
        panel.setLayout(null);

        //id
        JLabel label = new JLabel("id：");
        label.setBounds(32, 30, 75, 18);
        panel.add(label);
        id = new JTextField();
        id.setEditable(false);
        id.setBounds(112, 26, 119, 24);
        panel.add(id);
        id.setColumns(10);

        //电影名
        JLabel label_1 = new JLabel("电影名：");
        label_1.setBounds(257, 30, 75, 18);
        panel.add(label_1);
        movieName = new JTextField();
        movieName.setEditable(false);
        movieName.setBounds(337, 26, 108, 24);
        panel.add(movieName);
        movieName.setColumns(10);

        //场次
        JLabel label_1_2 = new JLabel("场次:");
        label_1_2.setBounds(500, 30, 50, 18);
        panel.add(label_1_2);
        session = new JTextField();
        session.setEditable(false);
        session.setBounds(560, 26, 50, 24);
        panel.add(session);
        session.setColumns(10);

        //演播厅
        JLabel label_1_3 = new JLabel("演播厅:");
        label_1_3.setBounds(650, 30, 50, 18);
        panel.add(label_1_3);
        room = new JTextField();
        room.setEditable(false);
        room.setBounds(720, 26, 50, 24);
        panel.add(room);
        room.setColumns(10);

        //导演
        JLabel label_2_1 = new JLabel("导演: ");
        label_2_1.setBounds(550, 67, 70, 18);
        panel.add(label_2_1);
        director = new JTextField();
        director.setEditable(false);
        director.setBounds(650, 64, 175, 24);
        panel.add(director);
        director.setColumns(10);

        //主演
        JLabel label_2_2 = new JLabel("主演：");
        label_2_2.setBounds(32, 65, 75, 18);
        panel.add(label_2_2);
        starring = new JTextField();
        starring.setEditable(false);
        starring.setBounds(112, 61, 171, 24);
        panel.add(starring);
        starring.setColumns(10);

        //电影类型
        JLabel label_2_3 = new JLabel("电影类型：");
        label_2_3.setBounds(308, 67, 80, 18);
        panel.add(label_2_3);
        movieType = new JTextField();
        movieType.setEditable(false);
        movieType.setColumns(10);
        movieType.setBounds(400, 63, 119, 24);
        panel.add(movieType);

        //电影时长
        JLabel label_3_1 = new JLabel("电影时长: ");
        label_3_1.setBounds(32, 110, 80, 18);
        panel.add(label_3_1);
        movieTime = new JTextField();
        movieTime.setEditable(false);
        movieTime.setColumns(10);
        movieTime.setBounds(112, 105, 119, 24);
        panel.add(movieTime);

        //票价
        JLabel label_3_2 = new JLabel("票价: ");
        label_3_2.setBounds(300, 110, 50, 18);
        panel.add(label_3_2);
        price = new JTextField();
        price.setEditable(false);
        price.setColumns(10);
        price.setBounds(350, 105, 60, 24);
        panel.add(price);


        //查询框架
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "条件查询", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setBounds(27, 240, 531, 68);
        getContentPane().add(panel_1);
        JLabel label_5 = new JLabel("电影名：");
        panel_1.add(label_5);
        searchMovieName = new JTextField();
        panel_1.add(searchMovieName);
        searchMovieName.setColumns(10);
        JButton searchButton = new JButton("查询");
        panel_1.add(searchButton);
        searchButton.addActionListener(e -> {
            // 处理鼠标点击
            id.setText("");
            movieName.setText("");
            director.setText("");
            starring.setText("");
            movieType.setText("");
            movieTime.setText("");
            session.setText("");
            room.setText("");
            price.setText("");
            String movieName = searchMovieName.getText();
            Object[][] data = select.getMovieInfo(movieName);
            df.setDataVector(data, header);
        });

        //账户管理框架
        JPanel panel_2 = new JPanel();
        panel_2.setBorder(new TitledBorder(null, "账户管理", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_2.setBounds(580, 240, 325, 68);
        getContentPane().add(panel_2);
        //退出登录
        JButton backButton = new JButton("退出登录");
        backButton.addActionListener(e -> {
            new Login().setVisible(true);
            dispose();
        });
        panel_2.add(backButton);
        //修改密码
        JButton changePasswordButton=new JButton("修改密码");
        changePasswordButton.addActionListener(e -> new ChangeUserPasswordView("user").setVisible(true));
        panel_2.add(changePasswordButton);

        //售票
        JPanel panel_3 = new JPanel();
        panel_3.setBorder(new TitledBorder(null, "购票服务", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_3.setBounds(450, 110, 400, 68);
        panel.add(panel_3);
        //票数
        JLabel countLabel = new JLabel("票数: ");
        panel_3.add(countLabel);
        tickets = new JTextField();
        tickets.setColumns(3);
        panel_3.add(tickets);
        JButton saleButton = new JButton("买票");
        saleButton.setBounds(550, 130, 40, 25);
        panel_3.add(saleButton);
        saleButton.addActionListener(e -> {
            double discount = select.getUserLevelInfo(userName);
            double temp = Double.parseDouble(price.getText()) * discount * Double.parseDouble(tickets.getText());
            String mPrice = Double.toString(temp);
            Date date = new Date();
            String nowTime = new SimpleDateFormat("yyyy-MM-dd").format(date);
            String sql = "INSERT INTO payment(paymentAmount,userName,movieName,times,room,tickingTime,count)"
                    + "Values('" + mPrice + "','" + userName + "','" + movieName.getText() + "','" + session.getText()
                    + "','" + room.getText() + "','" + nowTime +"','"+tickets.getText()+"')";
            if (update.addData(sql)) {
                JOptionPane.showMessageDialog(null, "生成订单成功");
            } else {
                JOptionPane.showMessageDialog(null, "生成订单失败");
            }
            int res = JOptionPane.showConfirmDialog(null, "请确定是否已经付款", "确认", JOptionPane.OK_CANCEL_OPTION);
            if (res == 0) {
                sql = "INSERT INTO paymentImp(paymentAmount,userName,movieName,times,room,tickingTime,count)"
                        + "Values('" + mPrice + "','" + userName+ "','" + movieName.getText() + "','" + session.getText()
                        + "','" + room.getText() + "','" + nowTime +"','"+tickets.getText()+"')";
                if (update.addData(sql)) {
                    JOptionPane.showMessageDialog(null, "订单支付成功");
                } else {
                    JOptionPane.showMessageDialog(null, "订单支付失败");
                }
            } else {
                JOptionPane.showMessageDialog(null, "订单并未支付");
            }


        });
        //查看订单并取票
        JButton checkButton=new JButton("查看历史订单并取票");
        panel_3.add(checkButton);
        checkButton.addActionListener(e -> new OrderView(userName).setVisible(true));

    }

}

```

