package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class PickUp extends JFrame implements ActionListener {

    JTable table;
    JButton back, submit;
    Choice typeofcar;

    PickUp() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel title = new JLabel("Pickup Service ");
        title.setFont(new Font("Tahoma", Font.PLAIN, 20));
        title.setBounds(420, 30, 400, 30);
        add(title);

        JLabel bedType = new JLabel("Type of Car");
        bedType.setBounds(50, 85, 120, 30);
        bedType.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(bedType);

        typeofcar = new Choice();
        typeofcar.setBounds(170, 90, 120, 30);
        typeofcar.setBackground(Color.white);
        add(typeofcar);
        
        try{
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            while(rs.next()){
                typeofcar.add(rs.getString("brand"));
            }
        }catch(Exception e){
            e.printStackTrace();
        }

        JLabel l1 = new JLabel("Name");
        l1.setBounds(70, 165, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Age");
        l2.setBounds(200, 165, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Gender");
        l3.setBounds(350, 165, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Car Brand");
        l4.setBounds(500, 165, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Car type");
        l5.setBounds(650, 165, 100, 20);
        add(l5);
        
        JLabel l6 = new JLabel("Availability");
        l6.setBounds(790, 165, 100, 20);
        add(l6);
        
        JLabel l7 = new JLabel("Location");
        l7.setBounds(930, 165, 100, 20);
        add(l7);

        table = new JTable();
        table.setBounds(10, 200, 1040, 300);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from driver");
            table.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        submit = new JButton("SUBMIT");
        submit.setBounds(300, 500, 120, 25);
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.addActionListener(this);
        add(submit);
        
        back = new JButton("BACK");
        back.setBounds(500, 500, 120, 25);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        setBounds(300, 200, 1050, 600);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {
            try{
                Conn c = new Conn();
                String query = "select * from driver where brand = '"+typeofcar.getSelectedItem()+"'";
                ResultSet rs = c.s.executeQuery(query);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else{
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new PickUp();
    }
}
