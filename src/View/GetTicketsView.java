package View;

import javax.swing.*;

public class GetTicketsView extends JFrame {

    public GetTicketsView(String id,String userName,String paymentAmount,String movieName,String times,String rooms,String TickingTime,String count){
        super("取票界面");
        this.setBounds(0,0,500,600);
        this.setLocationRelativeTo(null);
        this.setResizable(false);
        getContentPane().setLayout(null);
        JLabel id1 = new JLabel("订单号:   " + id);
        id1.setBounds(110,110,250,20);
        JLabel userName1 = new JLabel("用户名:  " + userName);
        userName1.setBounds(110,150,250,20);
        JLabel paymentAmount1 = new JLabel("支付金额: " + paymentAmount);
        paymentAmount1.setBounds(110,190,250,20);
        JLabel movieName1 = new JLabel("电影名称:  " + movieName);
        movieName1.setBounds(110,230,250,20);
        JLabel times1 = new JLabel("场次:  " + times);
        times1.setBounds(110,270,250,20);
        JLabel rooms1 = new JLabel("演播厅:   " + rooms);
        rooms1.setBounds(110,310,250,20);
        JLabel tickingTime = new JLabel("购票时间:   " + TickingTime);
        tickingTime.setBounds(110,350,250,20);
        JLabel count1 = new JLabel("购票数:   " + count);
        count1.setBounds(110,390,250,20);
        getContentPane().add(id1);
        getContentPane().add(userName1);
        getContentPane().add(paymentAmount1);
        getContentPane().add(movieName1);
        getContentPane().add(times1);
        getContentPane().add(rooms1);
        getContentPane().add(tickingTime);
        getContentPane().add(count1);





    }


}
