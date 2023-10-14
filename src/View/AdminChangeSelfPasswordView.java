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

