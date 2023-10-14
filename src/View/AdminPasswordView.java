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
