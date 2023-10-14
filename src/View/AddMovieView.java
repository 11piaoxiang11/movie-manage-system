package View;

import Controller.Update;

import javax.swing.*;

public class AddMovieView extends JFrame {
    private final JTextField movieName;
    private final JTextField director;
    private final JTextField starring;
    private final JTextField movieType;
    private final JTextField movieTime;
    private final JTextField session;
    private final JTextField room;
    private final JTextField price;

    public AddMovieView(){
        super("增加影片");
        Update update=new Update();
        this.setBounds(0,0,500,500);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setLayout(null);


        //电影名
        JLabel label_1 = new JLabel("电影名：");
        label_1.setBounds(120, 30, 75, 18);
        getContentPane().add(label_1);
        movieName = new JTextField();
        movieName.setBounds(220, 26, 108, 24);
        getContentPane().add(movieName);
        movieName.setColumns(10);

        //场次
        JLabel label_2 =new JLabel("场次:");
        label_2.setBounds(120,70,50,18);
        getContentPane().add(label_2);
        session=new JTextField();
        session.setBounds(220,70,50,24);
        getContentPane().add(session);
        session.setColumns(10);

        //演播厅
        JLabel label_3 =new JLabel("演播厅:");
        label_3.setBounds(120,110,50,18);
        getContentPane().add(label_3);
        room=new JTextField();
        room.setBounds(220,110,50,24);
        getContentPane().add(room);
        room.setColumns(10);

        //导演
        JLabel label_4 = new JLabel("导演: ");
        label_4.setBounds(120, 150, 70, 18);
        getContentPane().add(label_4);
        director = new JTextField();
        director.setBounds(220, 150, 175, 24);
        getContentPane().add(director);
        director.setColumns(10);

        //主演
        JLabel label_5 = new JLabel("主演：");
        label_5.setBounds(120, 190, 75, 18);
        getContentPane().add(label_5);
        starring= new JTextField();
        starring.setBounds(220, 190, 171, 24);
        getContentPane().add(starring);
        starring.setColumns(10);

        //电影类型
        JLabel label_6 = new JLabel("电影类型：");
        label_6.setBounds(120, 230, 80, 18);
        getContentPane().add(label_6);
        movieType = new JTextField();
        movieType.setColumns(10);
        movieType.setBounds(220, 230, 119, 24);
        getContentPane().add(movieType);

        //电影时长
        JLabel label_7 =new JLabel("电影时长: ");
        label_7.setBounds(120,270,80,18);
        getContentPane().add(label_7);
        movieTime=new JTextField();
        movieTime.setColumns(10);
        movieTime.setBounds(220,270,119,24);
        getContentPane().add(movieTime);

        //票价
        JLabel label_8 =new JLabel("票价: ");
        label_8.setBounds(120,310,50,18);
        getContentPane().add(label_8);
        price=new JTextField();
        price.setColumns(10);
        price.setBounds(220,310,60,24);
        getContentPane().add(price);


        //增加
        JButton addButton=new JButton("增加");
        addButton.setBounds(120,360,80,30);
        addButton.addActionListener(e -> {
            String sql="INSERT INTO movie(movieName,director,starring,type,time,session,room,price)"
                    +"Values('"+movieName.getText()+"','"+director.getText()+
                    "','"+starring.getText()+"','"+movieType.getText()+
                    "','"+movieTime.getText()+"','"+session.getText()+
                    "','"+room.getText()+"','"+price.getText()+"')";
            if(update.addData(sql)){
                JOptionPane.showMessageDialog(null,"增加成功");
            }else {
                JOptionPane.showMessageDialog(null, "增加失败");
            }

        });
        getContentPane().add(addButton);

        //重置
        JButton regButton=new JButton("重置");
        regButton.setBounds(300,360,80,30);
        regButton.addActionListener(e -> {
            movieName.setText("");
            director.setText("");
            starring.setText("");
            movieType.setText("");
            movieTime.setText("");
            session.setText("");
            room.setText("");
            price.setText("");
        });
        getContentPane().add(regButton);

    }


}
