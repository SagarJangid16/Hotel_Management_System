
package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class Department extends JFrame implements ActionListener{
    
    JTable table;
    JButton back;
    
    Department(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        
        JLabel l1 = new JLabel("Department");
        l1.setBounds(150, 10, 100, 20);
        add(l1);
        
        JLabel l2 = new JLabel("Budget");
        l2.setBounds(500, 10, 100, 20);
        add(l2);
        
        table = new JTable();
        table.setBounds(10, 40, 700, 350);
        add(table);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from Department");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }catch(Exception e){
            e.printStackTrace();
        }
        
        back = new JButton("BACK");
        back.setBounds(280, 400, 120, 25);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);
        
        setBounds(200, 200, 700, 480);
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
        new Department();
    }
}
