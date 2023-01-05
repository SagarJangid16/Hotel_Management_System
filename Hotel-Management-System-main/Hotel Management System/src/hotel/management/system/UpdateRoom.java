
package hotel.management.system;

import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;


public class UpdateRoom extends JFrame implements ActionListener{
    
    Choice ccustomer;
    JTextField tfroom, tfavailable, tfcleaningstatus, tfdeposit, tfpending;
    JButton check, update, back; 
    
    UpdateRoom(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("Update Room Status");
        text.setFont(new Font("Tahoma", Font.PLAIN, 25));
        text.setBounds(80, 20, 250, 30);
        text.setForeground(Color.blue);
        add(text);
        
        JLabel custId = new JLabel("Customer ID");
        custId.setFont(new Font("Tahoma", Font.PLAIN, 14));
        custId.setBounds(30, 95, 100, 30);
        add(custId);
        
        ccustomer = new Choice();
        ccustomer.setBounds(200,100,150,30);
        add(ccustomer);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while(rs.next()){
                ccustomer.add(rs.getString("number"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        
        JLabel lblroom = new JLabel("Room Number");
        lblroom.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblroom.setBounds(30, 150, 100, 30);
        add(lblroom);
        
        tfroom = new JTextField();
        tfroom.setBounds(200, 150, 150, 30);
        add(tfroom);
        
        JLabel lblname = new JLabel("Availabilty");
        lblname.setBounds(30, 200, 100, 30);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblname);
        
        tfavailable = new JTextField();
        tfavailable.setBounds(200, 200, 150, 30);
        add(tfavailable);
        
        JLabel lblstatus = new JLabel("Cleaning Status");
        lblstatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblstatus.setBounds(30, 250, 100, 30);
        add(lblstatus);
        
        tfcleaningstatus = new JTextField();
        tfcleaningstatus.setBounds(200, 250, 150, 30);
        add(tfcleaningstatus);
        
        check = new JButton("CHECK");
        check.setBounds(30, 340, 100, 30);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.addActionListener(this);
        add(check);
        
        update = new JButton("UPDATE");
        update.setBounds(230, 340, 100, 30);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);
        
        back = new JButton("BACK");
        back.setBounds(130, 395, 100, 30);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/seventh.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 350, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 50, 500, 350);
        add(image);
        
        setBounds(300, 200, 980, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
        
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == check){
            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where number = '"+id+"'";
            try{
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while(rs.next()){
                    tfroom.setText(rs.getString("room"));
                }
                ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '"+tfroom.getText()+"'");
                while(rs2.next()){
                   tfavailable.setText(rs2.getString("available"));
                   tfcleaningstatus.setText(rs2.getString("is_cleaned"));
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }else if(ae.getSource() == update){
            String roomNumber = tfroom.getText();
            String availability = tfavailable.getText();
            String number = ccustomer.getSelectedItem();
            String status = tfcleaningstatus.getText();

            
            try{
                Conn c = new Conn();
                c.s.executeUpdate("update room set available = '"+availability+"', is_cleaned = '"+status+"' where room_number = '"+roomNumber+"'");
                JOptionPane.showMessageDialog(null, "Data updated successfully");
                
                setVisible(false);
                new Reception();
            }catch(Exception e){
                e.printStackTrace();
            }
        }else{
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args){
        new UpdateRoom();
    }
}
