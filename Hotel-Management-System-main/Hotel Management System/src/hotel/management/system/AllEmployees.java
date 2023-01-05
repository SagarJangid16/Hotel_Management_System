
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class AllEmployees extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    AllEmployees(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel l1 = new JLabel("Name");
        l1.setBounds(40, 10, 100, 20);
        add(l1);
        
        JLabel l2 = new JLabel("Age");
        l2.setBounds(180, 10, 100, 20);
        add(l2);
        
        JLabel l3 = new JLabel("Gender");
        l3.setBounds(300, 10, 100, 20);
        add(l3);
        
        JLabel l4 = new JLabel("Job");
        l4.setBounds(420, 10, 100, 20);
        add(l4);
        
        JLabel l5 = new JLabel("Salary");
        l5.setBounds(530, 10, 100, 20);
        add(l5);
        
        JLabel l6 = new JLabel("Phone");
        l6.setBounds(650, 10, 100, 20);
        add(l6);
        
        JLabel l7 = new JLabel("Email");
        l7.setBounds(780, 10, 100, 20);
        add(l7);
        
        JLabel l8 = new JLabel("Aadhar No");
        l8.setBounds(900, 10, 100, 20);
        add(l8);
        
        table = new JTable();
        table.setBounds(10, 40, 980, 400);
        add(table);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from new_table");
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
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == back){
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args){
        new AllEmployees();
    }
}
