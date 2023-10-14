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
