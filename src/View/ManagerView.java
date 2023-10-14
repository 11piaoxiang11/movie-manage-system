package View;

import Controller.Select;
import Controller.Update;

import javax.swing.*;
import javax.swing.border.TitledBorder;
import javax.swing.table.DefaultTableModel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class ManagerView extends JFrame {
    Select select=new Select();

    private final JTable table;
    DefaultTableModel df;

    Object[][] data=select.getMovieInfo("");
    String[] header=new String[]{"ID","电影名","导演","主演","电影类型","电影时长","场次","演播厅","价格"};
    private final JTextField id;
    private final JTextField movieName;
    private final JTextField director;
    private final JTextField starring;
    private final JTextField movieType;
    private final JTextField movieTime;
    private final JTextField session;
    private final JTextField room;
    private final JTextField price;
    private final JTextField searchMovieName;


    public ManagerView(){
        super("平台影片信息");
        Update update=new Update();
        this.setBounds(0,0,935,700);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

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
                movieName.setText((table.getValueAt(table.getSelectedRow(),1).toString()));
                director.setText((table.getValueAt(table.getSelectedRow(),2).toString()));
                starring.setText((table.getValueAt(table.getSelectedRow(),3).toString()));
                movieType.setText((table.getValueAt(table.getSelectedRow(),4).toString()));
                movieTime.setText((table.getValueAt(table.getSelectedRow(),5).toString()));
                session.setText((table.getValueAt(table.getSelectedRow(),6).toString()));
                room.setText((table.getValueAt(table.getSelectedRow(),7).toString()));
                price.setText((table.getValueAt(table.getSelectedRow(),8).toString()));
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
        //影片信息类框架
        JPanel panel = new JPanel();
        panel.setBorder(new TitledBorder(null, "影片信息", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel.setBounds(27, 27, 876, 200);
        getContentPane().add(panel);
        panel.setLayout(null);

        //id
        JLabel label = new JLabel("id：");
        label.setBounds(32, 30, 75, 18);
        panel.add(label);
        id = new JTextField();
        id.setEditable(false);
        id.setBounds(112, 26, 119, 24);
        panel.add(id);
        id.setColumns(10);

        //电影名
        JLabel label_1 = new JLabel("电影名：");
        label_1.setBounds(257, 30, 75, 18);
        panel.add(label_1);
        movieName = new JTextField();
        movieName.setBounds(337, 26, 108, 24);
        panel.add(movieName);
        movieName.setColumns(10);

        //场次
        JLabel label_1_2 =new JLabel("场次:");
        label_1_2.setBounds(500,30,50,18);
        panel.add(label_1_2);
        session=new JTextField();
        session.setBounds(560,26,50,24);
        panel.add(session);
        session.setColumns(10);

        //演播厅
        JLabel label_1_3 =new JLabel("演播厅:");
        label_1_3.setBounds(650,30,50,18);
        panel.add(label_1_3);
        room=new JTextField();
        room.setBounds(720,26,50,24);
        panel.add(room);
        room.setColumns(10);

        //导演
        JLabel label_2_1 = new JLabel("导演: ");
        label_2_1.setBounds(550, 67, 70, 18);
        panel.add(label_2_1);
        director = new JTextField();
        director.setBounds(650, 64, 175, 24);
        panel.add(director);
        director.setColumns(10);

        //主演
        JLabel label_2_2 = new JLabel("主演：");
        label_2_2.setBounds(32, 65, 75, 18);
        panel.add(label_2_2);
        starring= new JTextField();
        starring.setBounds(112, 61, 171, 24);
        panel.add(starring);
        starring.setColumns(10);

        //电影类型
        JLabel label_2_3 = new JLabel("电影类型：");
        label_2_3.setBounds(308, 67, 80, 18);
        panel.add(label_2_3);
        movieType = new JTextField();
        movieType.setColumns(10);
        movieType.setBounds(400, 63, 119, 24);
        panel.add(movieType);

        //电影时长
        JLabel label_3_1=new JLabel("电影时长: ");
        label_3_1.setBounds(32,110,80,18);
        panel.add(label_3_1);
        movieTime=new JTextField();
        movieTime.setColumns(10);
        movieTime.setBounds(112,105,119,24);
        panel.add(movieTime);

        //票价
        JLabel label_3_2=new JLabel("票价: ");
        label_3_2.setBounds(300,110,50,18);
        panel.add(label_3_2);
        price=new JTextField();
        price.setColumns(10);
        price.setBounds(350,105,60,24);
        panel.add(price);



        //查询框架
        JPanel panel_1 = new JPanel();
        panel_1.setBorder(new TitledBorder(null, "条件查询", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_1.setBounds(27, 240, 531, 68);
        getContentPane().add(panel_1);
        JLabel label_5 = new JLabel("电影名：");
        panel_1.add(label_5);
        searchMovieName = new JTextField();
        panel_1.add(searchMovieName);
        searchMovieName.setColumns(10);
        JButton searchButton = new JButton("查询");
        panel_1.add(searchButton);
        searchButton.addActionListener(e -> {
            // 处理鼠标点击
            id.setText("");
            movieName.setText("");
            director.setText("");
            starring.setText("");
            movieType.setText("");
            movieTime.setText("");
            session.setText("");
            room.setText("");
            price.setText("");
            String movieName = searchMovieName.getText();
            Object[][] data = select.getMovieInfo(movieName);
            df.setDataVector(data, header);
        });

        //退出登录框架
        JPanel panel_2=new JPanel();
        panel_2.setBorder(new TitledBorder(null, "退出登录", TitledBorder.LEADING, TitledBorder.TOP, null, null));
        panel_2.setBounds(580, 240, 325, 68);
        getContentPane().add(panel_2);
        JButton backButton=new JButton("退出登录");
        backButton.setBounds(600,280,50,40);
        backButton.addActionListener(e -> {
            new Login().setVisible(true);
            dispose();
        });
        panel_2.add(backButton);

        //新增影片,修改信息功能
        JPanel panel_3=new JPanel();
        panel_3.setBorder(new TitledBorder(null,"其他功能",TitledBorder.LEADING,TitledBorder.TOP,null,null));
        panel_3.setBounds(500,110,300,68);
        panel.add(panel_3);
        JButton button_1=new JButton("新增影片");
        button_1.setBounds(550,130,100,25);
        panel_3.add(button_1);
        button_1.addActionListener(e -> new AddMovieView().setVisible(true));
        JButton button_2=new JButton("修改信息");
        button_2.setBounds(700,130,100,25);
        panel_3.add(button_2);
        button_2.addActionListener(e -> {
            String sql="UPDATE movie SET movieName='"+movieName.getText()+"',director='"+director.getText()+
                    "',starring='"+starring.getText()+"',type='"+movieType.getText()+
                    "',time='"+movieTime.getText()+"',session='"+session.getText()+
                    "',room='"+room.getText()+"',price='"+price.getText()+"' WHERE id='"+id.getText()+"'";
            if(update.addData(sql)){
                JOptionPane.showMessageDialog(null,"修改成功");
                Object[][] data=select.getMovieInfo("");
                df.setDataVector(data,header);
            }else{
                JOptionPane.showMessageDialog(null,"修改失败");
            }
        });
    }




}
