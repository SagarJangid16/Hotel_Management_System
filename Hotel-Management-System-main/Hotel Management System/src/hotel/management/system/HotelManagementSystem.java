/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hotel.management.system;

import java.awt.*;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.event.*;


public class HotelManagementSystem extends JFrame implements ActionListener{
    
    HotelManagementSystem(){
        setBounds(100, 100, 1370, 570);
        setLayout(null);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/first.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(0, 0, 1366, 565);
        add(image);
        
        setVisible(true);
        
        JLabel title = new JLabel("HOTEL MANAGEMENT SYSTEM");
        title.setBounds(20, 450, 950, 80);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        title.setForeground(Color.white);
        title.setFont(new Font("Arial Black", Font.PLAIN, 50));
        image.add(title);
        
        JButton next = new JButton("CONTINUE");
        next.setBorder(null);
        next.setBounds(1150, 450, 180, 60);
        next.setBackground(Color.white);
        next.setForeground(Color.black);
        next.addActionListener(this);
        next.setFont(new Font("Arial Black", Font.PLAIN, 24));
        image.add(next);
        
        setVisible(true);
        
        while(true){
            title.setVisible(false);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
            title.setVisible(true);
            try{
                Thread.sleep(500);
            }catch(Exception e){
                e.printStackTrace();
            }
        }
        
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Login();
    } 
    public static void main(String[] args) {
        new HotelManagementSystem();
    }
    
}
