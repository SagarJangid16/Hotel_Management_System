/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hotel.management.system;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;


public class Login extends JFrame implements ActionListener{
    JTextField username;
    JPasswordField password;
    JButton login, cancel;
    
    Login(){
        getContentPane().setBackground(Color.WHITE);
        
        setLayout(null);
        
        JLabel user = new JLabel("USERNAME : ");
        user.setBounds(20, 40, 100, 30);
        add(user);
        
        username = new JTextField();
        username.setBounds(110, 40, 200, 30);
        add(username);
        
        JLabel pass = new JLabel("PASSWORD : ");
        pass.setBounds(20, 90, 100, 30);
        add(pass);
        
        password = new JPasswordField();
        password.setBounds(110, 90, 200, 30);
        add(password);
        
        login = new JButton("LOGIN");
        login.setBounds(20, 160, 120, 30);
        login.setBackground(Color.black);
        login.setForeground(Color.white);
        login.addActionListener(this);
        add(login);
        
        cancel = new JButton("CANCEL");
        cancel.setBounds(200, 160, 120, 30);
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/second.jpg"));
        Image i2 = i1.getImage().getScaledInstance(180, 200, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(300, 10, 200, 200);
        add(image);
        
        
        setBounds(600, 250, 500, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == login){
            
            try{
                Conn c = new Conn();
                String user = username.getText();
                String pass = password.getText();
                String query = "select * from login where username = '" + user + "' and password = '" + pass + "'";
                ResultSet rs = c.s.executeQuery(query);
                
                if(rs.next()){
                    new Dashboard().setVisible(true);
                    setVisible(false);
                }
                else{
                    JOptionPane.showConfirmDialog(null, "Invalid username or password");
                    setVisible(false);
                            
                }
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new Login();
    }
}
    

