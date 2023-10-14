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
