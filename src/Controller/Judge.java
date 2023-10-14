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
