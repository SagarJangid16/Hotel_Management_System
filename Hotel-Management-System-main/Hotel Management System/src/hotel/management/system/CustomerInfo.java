
package hotel.management.system;


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class CustomerInfo extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    CustomerInfo(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel l1 = new JLabel("ID Type");
        l1.setBounds(40, 10, 100, 20);
        add(l1);
        
        JLabel l2 = new JLabel("ID Number");
        l2.setBounds(150, 10, 100, 20);
        add(l2);
        
        JLabel l3 = new JLabel("Name");
        l3.setBounds(280, 10, 100, 20);
        add(l3);
        
        JLabel l4 = new JLabel("Gender");
        l4.setBounds(410, 10, 100, 20);
        add(l4);
        
        JLabel l5 = new JLabel("Country");
        l5.setBounds(540, 10, 100, 20);
        add(l5);
        
        JLabel l6 = new JLabel("Room Number");
        l6.setBounds(640, 10, 100, 20);
        add(l6);
        
        JLabel l7 = new JLabel("Checkin Time");
        l7.setBounds(760, 10, 100, 20);
        add(l7);
        
        JLabel l8 = new JLabel("Deposit");
        l8.setBounds(900, 10, 100, 20);
        add(l8);
        
        table = new JTable();
        table.setBounds(10, 40, 980, 400);
        add(table);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("BACK");
        back.setBounds(420, 500, 120, 25);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        setBounds(300, 200, 1000, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args){
        new CustomerInfo();
    }
}
