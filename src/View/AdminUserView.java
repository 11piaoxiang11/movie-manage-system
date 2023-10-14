package View;

import Controller.Select;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class AdminUserView extends JFrame {
    Select select=new Select();

    private final JTable table;
    DefaultTableModel df;

    Object[][] data=select.getUserInfo("");
    String[] header=new String[]{"ID","用户名","用户等级","注册时间","消费金额","消费次数","邮箱"};
    private final JTextField id;
    private final JTextField username;
    private final JTextField userLevel;
    private final JTextField regDate;
    private final JTextField totalAmount;
    private final JTextField consumptionTime;
    private final JTextField email;
    private final JTextField searchUsername;

    public AdminUserView(){
        super("平台用户信息");
        this.setBounds(0,0,935,700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setLayout(null);

        JScrollPane scrollPane=new JScrollPane();
        scrollPane.setBounds(27,321,876,331);
        getContentPane().add(scrollPane);

        table=new JTable();
        df=new DefaultTableModel(data,header);
        table.setModel(df);
        scrollPane.setViewportView(table);
        table.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //鼠标点击
                id.setText(table.getValueAt(table.getSelectedRow(),0).toString());
                username.setText((table.getValueAt(table.getSelectedRow(),1).toString()));
                userLevel.setText((table.getValueAt(table.getSelectedRow(),2).toString()));
                regDate.setText((table.getValueAt(table.getSelectedRow(),3).toString()));
                totalAmount.setText((table.getValueAt(table.getSelectedRow(),4).toString()));
                consumptionTime.setText((table.getValueAt(table.getSelectedRow(),5).toString()));
                email.setText((table.getValueAt(table.getSelectedRow(),6).toString()));

            }

            @Override
            public void mousePressed(MouseEvent e) {

            }

            @Override
            public void mouseReleased(MouseEvent e) {

            }

            @Override
            public void mouseEntered(MouseEvent e) {

            }

            @Override
            public void mouseExited(MouseEvent e) {

            }

        });

        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "用户信息", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(27, 27, 876, 200);
        getContentPane().add(panel);
        panel.setLayout(null);

        JLabel label = new JLabel("id：");
        label.setBounds(32, 30, 75, 18);
        panel.add(label);

        id = new JTextField();
        id.setEditable(false);
        id.setBounds(112, 26, 119, 24);
        panel.add(id);
        id.setColumns(10);

        JLabel label_1 = new JLabel("用户名：");
        label_1.setBounds(257, 30, 75, 18);
        panel.add(label_1);

        username = new JTextField();
        username.setBounds(337, 26, 108, 24);
        panel.add(username);
        username.setColumns(10);

        JLabel label_2_1 = new JLabel("用户级别: ");
        label_2_1.setBounds(550, 67, 70, 18);
        panel.add(label_2_1);

        userLevel = new JTextField();
        userLevel.setBounds(650, 64, 175, 24);
        panel.add(userLevel);
        userLevel.setColumns(10);

        JLabel label_2_2 = new JLabel("注册时间：");
        label_2_2.setBounds(32, 65, 75, 18);
        panel.add(label_2_2);

        regDate= new JTextField();
        regDate.setBounds(112, 61, 171, 24);
        panel.add(regDate);
        regDate.setColumns(10);

        JLabel label_2_3 = new JLabel("消费总金额：");
        label_2_3.setBounds(308, 67, 80, 18);
        panel.add(label_2_3);

        totalAmount = new JTextField();
        totalAmount.setColumns(10);
        totalAmount.setBounds(400, 63, 119, 24);
        panel.add(totalAmount);

        JLabel label_3_1=new JLabel("消费总次数: ");
        label_3_1.setBounds(32,110,80,18);
        panel.add(label_3_1);

        consumptionTime=new JTextField();
        consumptionTime.setColumns(10);
        consumptionTime.setBounds(112,105,119,24);
        panel.add(consumptionTime);

        JLabel label_3_2=new JLabel("邮箱: ");
        label_3_2.setBounds(257,110,40,18);
        panel.add(label_3_2);

        email=new JTextField();
        email.setColumns(10);
        email.setBounds(300,105,119,24);
        panel.add(email);




        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "条件查询", TitledBorder.LEADING, TitledBorder.TOP, null, null));

        panel_1.setBounds(27, 240, 531, 68);
        getContentPane().add(panel_1);

        JLabel label_5 = new JLabel("用户名：");
        panel_1.add(label_5);

        searchUsername = new JTextField();
        panel_1.add(searchUsername);
        searchUsername.setColumns(10);

        JButton searchButton = new JButton("查询");
        panel_1.add(searchButton);
        searchButton.addActionListener(e -> {
            // 处理鼠标点击
            id.setText("");
            username.setText("");
            userLevel.setText("");
            regDate.setText("");
            totalAmount.setText("");
            consumptionTime.setText("");
            email.setText("");
            String username = searchUsername.getText();
            Object[][] data = select.getUserInfo(username);
            df.setDataVector(data, header);
        });

        JPanel panel_2=new JPanel();
        panel_2.setBorder(new TitledBorder(null, "返回上一级", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_2.setBounds(580, 240, 325, 68);
        getContentPane().add(panel_2);

        JButton backButton=new JButton("返回上一级");
        backButton.setBounds(650,280,200,40);
        backButton.addActionListener(e -> {
            new AdminMessageView().setVisible(true);
            dispose();
        });
        panel_2.add(backButton);

    }


}
