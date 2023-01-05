
package hotel.management.system;

import java.awt.Color;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.*;
import java.util.Date;


public class AddCustomer extends JFrame implements ActionListener{
    
    JComboBox comboid;
    JTextField tfnumber, tfname, tfcountry, tfdeposit;
    JRadioButton rbmale, rbfemale;
    Choice croom;
    JLabel checkintime;
    JButton add, back;
    
    AddCustomer(){
        
        getContentPane().setBackground(Color.white);
        setLayout(null);
        
        JLabel text = new JLabel("ADD NEW CUSTOMER");
        text.setBounds(100, 20, 300, 30);
        text.setFont(new Font("Raleway", Font.BOLD, 20));
        add(text);
        
        JLabel lblId = new JLabel("ID TYPE");
        lblId.setBounds(35, 80, 120, 20);
        lblId.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblId);
        
        String[] idtype = new String[]{"Adhar card", "Passport", "PAN card", "Voter-ID", "Driving Licence"};
        comboid = new JComboBox(idtype);
        comboid.setBounds(200, 80, 200, 20);
        comboid.setBackground(Color.WHITE);
        add(comboid);
        
        JLabel idnumber = new JLabel("ID NUMBER");
        idnumber.setBounds(35, 120, 120, 20);
        idnumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(idnumber);
        
        tfnumber = new JTextField();
        tfnumber.setBounds(200, 120, 200, 20);
        tfnumber.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(tfnumber);
        
        JLabel name = new JLabel("CUST NAME");
        name.setBounds(35, 160, 120, 20);
        name.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(name);
        
        tfname = new JTextField();
        tfname.setBounds(200, 160, 200, 20);
        tfname.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(tfname);
        
        JLabel gender = new JLabel("GENDER");
        gender.setBounds(35, 200, 120, 20);
        gender.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(gender);
        
        rbmale = new JRadioButton("MALE");
        rbmale.setBounds(200, 200, 80, 20);
        rbmale.setBackground(Color.white );
        add(rbmale);
        
        rbfemale = new JRadioButton("FEMALE");
        rbfemale.setBounds(300, 200, 80, 20);
        rbfemale.setBackground(Color.white );
        add(rbfemale);
        
        JLabel country = new JLabel("COUNTRY");
        country.setBounds(35, 240, 120, 20);
        country.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(country);
        
        tfcountry = new JTextField();
        tfcountry.setBounds(200, 240, 200, 20);
        tfcountry.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(tfcountry);
        
        JLabel allRoom = new JLabel("ALLOTTED ROOM");
        allRoom.setBounds(35, 280, 120, 20);
        allRoom.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(allRoom);
        
        croom = new Choice();
        
        try{
           Conn c = new Conn();
           String query = "select * from room where available = 'Available'";
           ResultSet rs = c.s.executeQuery(query);
           while(rs.next()){
               croom.add(rs.getString("room_number"));
           }
           
        }catch(Exception e){
            e.printStackTrace();
        }
        
        croom.setBounds(200, 280, 200, 20);
        add(croom);
        
        JLabel time = new JLabel("CHECKIN TIME");
        time.setBounds(35, 320, 120, 20);
        time.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(time);
        
        Date date = new Date();
        
        checkintime = new JLabel("" + date);
        checkintime.setBounds(200, 320, 200, 20);
        checkintime.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(checkintime);
        
        JLabel lblDeposit = new JLabel("DEPOSIT");
        lblDeposit.setBounds(35, 360, 120, 20);
        lblDeposit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(lblDeposit);
        
        tfdeposit = new JTextField();
        tfdeposit.setBounds(200, 360, 200, 20);
        tfdeposit.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(tfdeposit);
        
        add = new JButton("ADD");
        add.setBackground(Color.black);
        add.setForeground(Color.white);
        add.setBounds(120, 430, 100, 30);
        add.addActionListener(this);
        add(add);
        
        back = new JButton("BACK");
        back.setBackground(Color.black);
        back.setForeground(Color.white);
        back.setBounds(250, 430, 100, 30);
        back.addActionListener(this);
        add(back);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/fifth.png"));
        Image i2 = i1.getImage().getScaledInstance(300, 400, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(450, 50, 300, 400);
        add(image);
        
        
        setBounds(300, 200, 800, 550);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == add){
            String id = (String)comboid.getSelectedItem();
            String number = tfnumber.getText();
            String name = tfname.getText();
            String gender = null;
            if(rbmale.isSelected()){
                gender = "Male";
            }else if(rbfemale.isSelected()){
                gender = "Female";
            }
            
            String country = tfcountry.getText();
            String roomNumber = croom.getSelectedItem();
            String checkinTime = checkintime.getText();
            String deposit = tfdeposit.getText();
            
            try{
                Conn c = new Conn();
                
                String query = "insert into customer values('"+id+"', '"+number+"', '"+name+"', '"+gender+"', '"+country+"', '"+roomNumber+"', '"+checkinTime+"', '"+deposit+"')";
                String query2 = "update room set available = 'Occupied' where room_number = '"+roomNumber+"'";
                
                c.s.executeUpdate(query);
                c.s.executeUpdate(query2);
                
                JOptionPane.showMessageDialog(null, "New customer added successfully ..... !");
                
                setVisible(false);
                new Reception();
                
            }catch(Exception ce){
                ce.printStackTrace();
            }
            
        }else if(ae.getSource() == back){
            setVisible(false);
            new Reception();
        }
    }
    
    public static void main(String[] args){
        new AddCustomer();
    }
}
