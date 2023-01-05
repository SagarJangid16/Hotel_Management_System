package hotel.management.system;

import java.awt.Color;
import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

public class UpdateCheck extends JFrame implements ActionListener {

    Choice ccustomer;
    JTextField tfroom, tfname, tfcheckin, tfdeposit, tfpending;
    JButton check, update, back;

    UpdateCheck() {
        getContentPane().setBackground(Color.white);
        setLayout(null);

        JLabel text = new JLabel("Update Status");
        text.setFont(new Font("Tahoma", Font.PLAIN, 20));
        text.setBounds(120, 20, 150, 30);
        text.setForeground(Color.blue);
        add(text);

        JLabel custId = new JLabel("Customer ID");
        custId.setBounds(30, 80, 100, 20);
        add(custId);

        ccustomer = new Choice();
        ccustomer.setBounds(200, 80, 150, 25);
        add(ccustomer);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("select * from customer");
            while (rs.next()) {
                ccustomer.add(rs.getString("number"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        JLabel lblroom = new JLabel("Room Number");
        lblroom.setBounds(30, 120, 100, 20);
        add(lblroom);

        tfroom = new JTextField();
        tfroom.setBounds(200, 120, 150, 20);
        add(tfroom);

        JLabel lblname = new JLabel("Cust. Name");
        lblname.setBounds(30, 160, 100, 20);
        add(lblname);

        tfname = new JTextField();
        tfname.setBounds(200, 160, 150, 20);
        add(tfname);

        JLabel lblcheckin = new JLabel("Checkin Time");
        lblcheckin.setBounds(30, 200, 100, 20);
        add(lblcheckin);

        tfcheckin = new JTextField();
        tfcheckin.setBounds(200, 200, 170, 20);
        add(tfcheckin);

        JLabel lbldeposit = new JLabel("Amount Paid");
        lbldeposit.setBounds(30, 240, 100, 20);
        add(lbldeposit);

        tfdeposit = new JTextField();
        tfdeposit.setBounds(200, 240, 150, 20);
        add(tfdeposit);

        JLabel lblpending = new JLabel("Amount Pending");
        lblpending.setBounds(30, 280, 100, 20);
        add(lblpending);

        tfpending = new JTextField();
        tfpending.setBounds(200, 280, 150, 20);
        add(tfpending);

        check = new JButton("CHECK");
        check.setBounds(30, 340, 100, 20);
        check.setBackground(Color.black);
        check.setForeground(Color.white);
        check.addActionListener(this);
        add(check);

        update = new JButton("UPDATE");
        update.setBounds(230, 340, 100, 20);
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.addActionListener(this);
        add(update);

        back = new JButton("BACK");
        back.setBounds(130, 385, 100, 20);
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/nine.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 50, 500, 300);
        add(image);

        setBounds(300, 200, 980, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == check) {
            String id = ccustomer.getSelectedItem();
            String query = "select * from customer where number = '" + id + "'";
            try {
                Conn c = new Conn();
                ResultSet rs = c.s.executeQuery(query);
                while (rs.next()) {
                    tfroom.setText(rs.getString("room"));
                    tfname.setText(rs.getString("name"));
                    tfcheckin.setText(rs.getString("checkinTime"));
                    tfdeposit.setText(rs.getString("deposit"));
                }
                ResultSet rs2 = c.s.executeQuery("select * from room where room_number = '" + tfroom.getText() + "'");
                while (rs2.next()) {
                    String price = rs2.getString("prize");
                    int amountPaid = Integer.parseInt(price) - Integer.parseInt(tfdeposit.getText());
                    tfpending.setText("" + amountPaid);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (ae.getSource() == update) {
            String roomNumber = tfroom.getText();
            String name = tfname.getText();
            String checkintime = tfcheckin.getText();
            String paid = tfdeposit.getText();
//            String pending = tfpending.getText();

            try {
                Conn c = new Conn();
                c.s.executeUpdate("update customer set room = '" + roomNumber + "', name = '" + name + "', checkintime = '" + checkintime + "', deposit ='" + paid + "' where room = '"+roomNumber+"'");
                JOptionPane.showMessageDialog(null, "Data updated successfully");

                setVisible(false);
                new Reception();
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else {
            setVisible(false);
            new Reception();
        }
    }

    public static void main(String[] args) {
        new UpdateCheck();
    }
}
