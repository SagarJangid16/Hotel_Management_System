
package hotel.management.system;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.*; 

public class Reception extends JFrame implements ActionListener{
    
    JButton newCust, rooms, department, allEmployee, managerInfo, allCust, searchRoom, update, roomStatus, pickUp, logout, checkout;
    Reception(){
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        newCust = new JButton("ADD NEW CUSTOMER");
        newCust.setBackground(Color.black);
        newCust.setForeground(Color.white);
        newCust.setBounds(10, 30, 200, 30);
        newCust.addActionListener(this);
        add(newCust); 
        
        rooms = new JButton("ROOMS");
        rooms.setBackground(Color.black);
        rooms.setForeground(Color.white);
        rooms.setBounds(10, 70, 200, 30);
        rooms.addActionListener(this);
        add(rooms); 
        
        department = new JButton("DEPARTMENT");
        department.setBackground(Color.black);
        department.setForeground(Color.white);
        department.setBounds(10, 110, 200, 30);
        department.addActionListener(this);
        add(department);
        
        allEmployee = new JButton("ALL EMPLOYEE");
        allEmployee.setBackground(Color.black);
        allEmployee.setForeground(Color.white);
        allEmployee.setBounds(10, 150, 200, 30);
        allEmployee.addActionListener(this);
        add(allEmployee); 
        
        allCust = new JButton("CUSTOMER DETAILS");
        allCust.setBackground(Color.black);
        allCust.setForeground(Color.white);
        allCust.setBounds(10, 190, 200, 30);
        allCust.addActionListener(this);
        add(allCust); 
        
        managerInfo = new JButton("MANAGER'S DETAILS");
        managerInfo.setBackground(Color.black);
        managerInfo.setForeground(Color.white);
        managerInfo.setBounds(10, 230, 200, 30);
        managerInfo.addActionListener(this);
        add(managerInfo); 
        
        checkout = new JButton("CHECKOUT");
        checkout.setBackground(Color.black);
        checkout.setForeground(Color.white);
        checkout.setBounds(10, 270, 200, 30);
        checkout.addActionListener(this);
        add(checkout); 
        
        update = new JButton("UPDATE STATUS");
        update.setBackground(Color.black);
        update.setForeground(Color.white);
        update.setBounds(10, 310, 200, 30);
        update.addActionListener(this);
        add(update);
        
        roomStatus = new JButton("UPDATE ROOM STATUS");
        roomStatus.setBackground(Color.black);
        roomStatus.setForeground(Color.white);
        roomStatus.setBounds(10, 350, 200, 30);
        roomStatus.addActionListener(this);
        add(roomStatus);
        
        pickUp = new JButton("PICK-UP SERVICE");
        pickUp.setBackground(Color.black);
        pickUp.setForeground(Color.white);
        pickUp.setBounds(10, 390, 200, 30);
        pickUp.addActionListener(this);
        add(pickUp); 
        
        searchRoom = new JButton("SEARCH ROOM");
        searchRoom.setBackground(Color.black);
        searchRoom.setForeground(Color.white);
        searchRoom.setBounds(10, 430, 200, 30);
        searchRoom.addActionListener(this); 
        add(searchRoom); 
        
        logout = new JButton("LOGOUT");
        logout.setBackground(Color.black);
        logout.setForeground(Color.white);
        logout.setBounds(10, 470, 200, 30);
        logout.addActionListener(this);
        add(logout);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fourth.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(250, 30, 500, 470);
        add(image);
        
        setBounds(350, 200, 800, 570);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    @Override
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == newCust){
            setVisible(false);
            new AddCustomer();
        }else if(ae.getSource() == rooms){
            setVisible(false);
            new Rooms();
        }else if(ae.getSource() == department){
            setVisible(false);
            new Department();
        }else if(ae.getSource() == allEmployee){
            setVisible(false);
            new AllEmployees();
        }
        else if(ae.getSource() == managerInfo){
            setVisible(false);
            new ManagerInfo();
        }
        else if(ae.getSource() == allCust){
            setVisible(false);
            new CustomerInfo();
        }
        else if(ae.getSource() == searchRoom){
            setVisible(false);
            new SearchRoom();
        }
        else if(ae.getSource() == update){
            setVisible(false);
            new UpdateCheck();
        }
        else if(ae.getSource() == roomStatus){
            setVisible(false);
            new UpdateRoom();
        }
        else if(ae.getSource() == pickUp){
            setVisible(false);
            new PickUp();
        }else if(ae.getSource() == checkout){
            setVisible(false);
            new CheckOut();
        }else if(ae.getSource() == logout){
            setVisible(false);
            System.exit(0);
        }
    }
    public static void main(String[] args){
        new Reception();
    }
}
