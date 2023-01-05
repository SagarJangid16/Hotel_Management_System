package hotel.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

public class SearchRoom extends JFrame implements ActionListener {

    JTable table;
    JButton back, submit;
    JComboBox bedtype;
    JCheckBox available;

    SearchRoom() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel title = new JLabel("Search for Room");
        title.setFont(new Font("Tahoma", Font.PLAIN, 20));
        title.setBounds(400, 30, 400, 30);
        add(title);

        JLabel bedType = new JLabel("Bed Type");
        bedType.setBounds(50, 90, 120, 30);
        bedType.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(bedType);

        String[] beds = new String[]{"Single Bed", "Double Bed"};
        bedtype = new JComboBox(beds);
        bedtype.setBounds(150, 90, 120, 30);
        bedtype.setBackground(Color.white);
        add(bedtype);

        available = new JCheckBox("Only Display Available");
        available.setBounds(650, 90, 200, 30);
        available.setBackground(Color.white);
        add(available);

        JLabel l1 = new JLabel("Room Number");
        l1.setBounds(70, 165, 100, 20);
        add(l1);

        JLabel l2 = new JLabel("Availability");
        l2.setBounds(280, 165, 100, 20);
        add(l2);

        JLabel l3 = new JLabel("Status");
        l3.setBounds(500, 165, 100, 20);
        add(l3);

        JLabel l4 = new JLabel("Price");
        l4.setBounds(720, 165, 100, 20);
        add(l4);

        JLabel l5 = new JLabel("Bed type");
        l5.setBounds(900, 165, 100, 20);
        add(l5);

        table = new JTable();
        table.setBounds(0, 200, 1050, 300);
        add(table);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from room");
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
                String query1 = "select * from room where bed_type = '"+bedtype.getSelectedItem()+"'";
                String query2 = "select * from room where available = 'Available' and bed_type = '"+bedtype.getSelectedItem()+"'";
                ResultSet rs;
                if(available.isSelected()){
                    rs = c.s.executeQuery(query2);
                }else{
                    rs = c.s.executeQuery(query1);
                }
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
        new SearchRoom();
    }
}
