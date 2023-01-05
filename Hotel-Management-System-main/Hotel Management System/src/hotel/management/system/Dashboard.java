package hotel.management.system;


import java.awt.*;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*;


public class Dashboard extends JFrame implements ActionListener{
    
    JMenuItem reception, addEmployee, addRooms, addDrivers;
    
    Dashboard(){
        setBounds(0, 0, 1560, 820);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/third.jpg"));
        Image i2 = i1.getImage().getScaledInstance(1560, 820, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(0, 0, 1560, 820);
        add(label);
        JLabel text = new JLabel("SK GROUP WELCOME'S YOU");
        text.setBounds(400, 80, 1000, 100);
        text.setFont(new Font("Cooper Black", Font.PLAIN, 50));
        text.setForeground(Color.white);
        label.add(text);
        
        JMenuBar mb = new JMenuBar();
        mb.setBounds(0, 0, 1560, 20);
        label.add(mb);
        
        JMenu hotel = new JMenu("HOTEL MANAGEMENT");
        hotel.setForeground(Color.red);
        mb.add(hotel);
        
        reception = new JMenuItem("RECEPTION");
        reception.addActionListener(this);
        hotel.add(reception);
        
        JMenu admin = new JMenu("ADMIN");
        admin.setForeground(Color.blue);
        mb.add(admin);
        
        addEmployee = new JMenuItem("ADD EMPLOYEE");
        addEmployee.addActionListener(this);
        admin.add(addEmployee);
        
        addRooms = new JMenuItem("ADD ROOMS");
        addRooms.addActionListener(this);
        admin.add(addRooms);
        
        addDrivers = new JMenuItem("ADD DRIVERS");
        addDrivers.addActionListener(this);
        admin.add(addDrivers);
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addEmployee){
            new AddEmployee();
        }else if(ae.getSource() == addRooms){
            new AddRooms();
        }else if(ae.getSource() == addDrivers){
            new AddDriver();
        }else if(ae.getSource() == reception){
            new Reception();
        }
    }
    public static void main(String[] args){
        new Dashboard();
    }
}
