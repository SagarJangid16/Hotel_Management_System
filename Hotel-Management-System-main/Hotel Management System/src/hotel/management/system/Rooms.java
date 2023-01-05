
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Rooms extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    Rooms(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eight.jpg"));
        Image i2 = i1.getImage().getScaledInstance(600, 600, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(500, 0, 600, 600);
        add(image);
        
        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(10, 10, 100, 20);
        add(l1);
        
        JLabel l2 = new JLabel("Availability");
        l2.setBounds(120, 10, 100, 20);
        add(l2);
        
        JLabel l3 = new JLabel("Status");
        l3.setBounds(230, 10, 100, 20);
        add(l3);
        
        JLabel l4 = new JLabel("Price");
        l4.setBounds(330, 10, 100, 20);
        add(l4);
        
        JLabel l5 = new JLabel("Bed type");
        l5.setBounds(410, 10, 100, 20);
        add(l5);
        
        table = new JTable();
        table.setBounds(10, 40, 480, 400);
        add(table);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("BACK");
        back.setBounds(170, 500, 120, 25);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        setBounds(300, 200, 1050, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args){
        new Rooms();
    }
}
