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
