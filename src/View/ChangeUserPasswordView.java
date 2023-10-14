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
