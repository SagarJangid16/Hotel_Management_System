
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class AddRooms extends JFrame implements ActionListener{
    
    JButton addRoom, cancel;
    JTextField tfroomno, setprize;
    JComboBox cleaned, availability, beds;
    
    AddRooms(){
        getContentPane().setBackground(Color.white);
        setTitle("Add Rooms");
        setLayout(null);
        
        JLabel heading = new JLabel("ADD ROOMS");
        heading.setForeground(Color.black);
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);
        
        JLabel lblroomno = new JLabel("ROOM NUMBER");
        lblroomno.setForeground(Color.black);
        lblroomno.setFont(new Font("Tahoma", Font.PLAIN, 14));
        lblroomno.setBounds(60, 80, 120, 30);
        add(lblroomno);
        
        tfroomno = new JTextField();
        tfroomno.setBounds(200, 80, 150, 30);
        tfroomno.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(tfroomno);
        
        JLabel isAvailable = new JLabel("AVAILABLE");
        isAvailable.setForeground(Color.black);
        isAvailable.setFont(new Font("Tahoma", Font.PLAIN, 14));
        isAvailable.setBounds(60, 130, 120, 30);
        add(isAvailable);
        
        String availableOptions[] = {"Available", "Occupied"};
        availability = new JComboBox(availableOptions);
        availability.setBounds(200, 130, 150, 30);
        availability.setBackground(Color.white);
        add(availability);
        
        JLabel cleaningStatus = new JLabel("CLEANING STATUS");
        cleaningStatus.setForeground(Color.black);
        cleaningStatus.setFont(new Font("Tahoma", Font.PLAIN, 14));
        cleaningStatus.setBounds(60, 180, 150, 30);
        add(cleaningStatus);
        
        String cleaningstatus[] = {"Cleaned", "Un-cleaned"};
        cleaned = new JComboBox(cleaningstatus);
        cleaned.setBounds(200, 180, 150, 30);
        cleaned.setBackground(Color.white);
        add(cleaned);
        
        JLabel prize = new JLabel("PRIZE");
        prize.setForeground(Color.black);
        prize.setFont(new Font("Tahoma", Font.PLAIN, 14));
        prize.setBounds(60, 230, 120, 30);
        add(prize);
        
        setprize = new JTextField();
        setprize.setBounds(200, 230, 150, 30);
        setprize.setFont(new Font("Tahoma", Font.PLAIN, 14));
        add(setprize);
        
        JLabel bedType = new JLabel("BED TYPE");
        bedType.setForeground(Color.black);
        bedType.setFont(new Font("Tahoma", Font.PLAIN, 14));
        bedType.setBounds(60, 280, 120, 30);
        add(bedType);
        
        String showbedtype[] = {"Single bed", "Double bed"};
        beds = new JComboBox(showbedtype);
        beds.setBounds(200, 280, 150, 30);
        beds.setBackground(Color.white);
        add(beds);
        
        addRoom = new JButton("ADD ROOM");
        addRoom.setBackground(Color.black);
        addRoom.setForeground(Color.white);
        addRoom.setBounds(60, 350, 120, 30);
        addRoom.addActionListener(this);
        add(addRoom);
        
        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(220, 350, 120, 30);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/twelve.jpg"));
        JLabel image = new JLabel(i1);
        image.setBounds(400, 30, 500, 300);
        add(image);
        
        setBounds(330, 200, 940, 470);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == addRoom){
            
            String roomnumber = tfroomno.getText();
            String available = (String)availability.getSelectedItem();
            String iscleaned = (String)cleaned.getSelectedItem();
            String prize = setprize.getText();
            String bedtype = (String)beds.getSelectedItem();
            
            try{
                Conn con = new Conn();
                
                String str = "insert into room values('"+roomnumber+"', '"+available+"', '"+iscleaned+"', '"+prize+"', '"+bedtype+"')";
               
                con.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null,"New room added successfully....");
                
                setVisible(false);
            }
            catch(Exception e){
                e.printStackTrace();
            }
            
            
        }else if(ae.getSource() == cancel){
            setVisible(false);
        }
    }
    public static void main(String[] args){
        new AddRooms();
    }
}
