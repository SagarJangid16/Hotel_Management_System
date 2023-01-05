package hotel.management.system;

import java.awt.Color;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;
import java.sql.*;
import java.util.Date;

public class CheckOut extends JFrame implements ActionListener{

    Choice cid;
    JLabel lblroomnumber, lblCheckin, lblCheckout;
    JButton checkout, back;

    CheckOut() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel heading = new JLabel("Checkout");
        heading.setBounds(100, 20, 100, 30);
        heading.setForeground(Color.blue);
        heading.setFont(new Font("Tahoma", Font.PLAIN, 20));
        add(heading);

        JLabel lblid = new JLabel("Customer ID");
        lblid.setBounds(30, 75, 100, 30);
        add(lblid);

        cid = new Choice();
        cid.setBounds(150, 80, 120, 30);
        add(cid);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tick.png"));
        Image i2 = i1.getImage().getScaledInstance(20, 20, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(280, 80, 20, 20);
        add(image);

        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30, 120, 100, 30);
        add(lblroom);

        lblroomnumber = new JLabel();
        lblroomnumber.setBounds(150, 120, 100, 30);
        add(lblroomnumber);

        JLabel lblcheckintime = new JLabel("Checkin time");
        lblcheckintime.setBounds(30, 170, 100, 30);
        add(lblcheckintime);

        lblCheckin = new JLabel();
        lblCheckin.setBounds(150, 170, 100, 30);
        add(lblCheckin);

        JLabel lblcheckouttime = new JLabel("Checkout time");
        lblcheckouttime.setBounds(30, 220, 100, 30);
        add(lblcheckouttime);

        Date date = new Date();

        lblCheckout = new JLabel("" + date);
        lblCheckout.setBounds(150, 220, 200, 30);
        add(lblCheckout);
        
        checkout = new JButton("Checkout");
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        checkout.setBounds(40, 270, 100, 30);
        checkout.addActionListener(this);
        add(checkout);
        
        back = new JButton("Back");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(200, 270, 100, 30);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/sixth.jpg"));
        Image i5 = i4.getImage().getScaledInstance(400, 250, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel image1 = new JLabel(i6);
        image1.setBounds(350, 50, 400, 250);
        add(image1);
        
        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                cid.add(rs.getString("number"));
                lblroomnumber.setText(rs.getString("room"));
                lblCheckin.setText(rs.getString("checkinTime"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        setVisible(true);
        setBounds(300, 200, 800, 400);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == checkout){
            String query1 = "delete from customer where number = '"+cid+"'";
            String query2 = "update room set available = 'Available' where room_number = '"+lblroomnumber.getText()+"'";
            
            try{
                Conn c = new Conn();
                
                c.s.executeUpdate(query1);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "Checkout successful");
                setVisible(false);
                new Reception();
            }catch(Exception e){
                e.printStackTrace();
            }
            
        }else if(ae.getSource() == back){
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new CheckOut();
    }
}
