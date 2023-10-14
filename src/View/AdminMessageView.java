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
