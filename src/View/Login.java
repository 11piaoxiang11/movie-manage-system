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
