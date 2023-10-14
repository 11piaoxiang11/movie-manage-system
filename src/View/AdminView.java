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

