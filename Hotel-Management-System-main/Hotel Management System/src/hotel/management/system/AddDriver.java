
package hotel.management.system;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;


public class AddDriver extends JFrame implements ActionListener{
    
    JButton adddriver, cancel;
    JTextField tfname, tfbrand, tfage, tfmodel, tflocation;
    JComboBox gendercombo , availcombo;
    
    AddDriver(){
        getContentPane().setBackground(Color.white);
        setTitle("Add Rooms");
        setLayout(null);
        
        JLabel heading = new JLabel("ADD DRIVER");
        heading.setForeground(Color.black);
        heading.setFont(new Font("Tahoma", Font.BOLD, 18));
        heading.setBounds(150, 20, 200, 20);
        add(heading);
        
        JLabel lblname = new JLabel("NAME");
        lblname.setForeground(Color.black);
        lblname.setFont(new Font("Tahoma", Font.PLAIN, 12));
        lblname.setBounds(60, 60, 120, 20);
        add(lblname);
        
        tfname = new JTextField();
        tfname.setBounds(200, 60, 150, 20);
        tfname.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(tfname);
        
        JLabel age = new JLabel("AGE");
        age.setForeground(Color.black);
        age.setFont(new Font("Tahoma", Font.PLAIN, 12));
        age.setBounds(60, 100, 120, 20);
        add(age);
        
        tfage = new JTextField();
        tfage.setBounds(200, 100, 150, 20);
        tfage.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(tfage);
        
        JLabel gender = new JLabel("GENDER");
        gender.setForeground(Color.black);
        gender.setFont(new Font("Tahoma", Font.PLAIN, 12));
        gender.setBounds(60, 145, 150, 10);
        add(gender);
        
        String cleaningstatus[] = {"Male", "Female"};
        gendercombo = new JComboBox(cleaningstatus);
        gendercombo.setBounds(200, 140, 150, 20);
        gendercombo.setBackground(Color.white);
        add(gendercombo);
        
        JLabel brand = new JLabel("CAR BRAND");
        brand.setForeground(Color.black);
        brand.setFont(new Font("Tahoma", Font.PLAIN, 12));
        brand.setBounds(60, 180, 120, 20);
        add(brand);
        
        tfbrand = new JTextField();
        tfbrand.setBounds(200, 180, 150, 20);
        tfbrand.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(tfbrand);
        
        JLabel model = new JLabel("MODEL");
        model.setForeground(Color.black);
        model.setFont(new Font("Tahoma", Font.PLAIN, 12));
        model.setBounds(60, 220, 120, 20);
        add(model);
        
        tfmodel = new JTextField();
        tfmodel.setBounds(200, 220, 150, 20);
        tfmodel.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(tfmodel);
        
        JLabel available = new JLabel("AVAILABLE");
        available.setForeground(Color.black);
        available.setFont(new Font("Tahoma", Font.PLAIN, 12));
        available.setBounds(60, 265, 120, 20);
        add(available);
        
        String isavailable[] = {"Available", "Un-available"};
        availcombo = new JComboBox(isavailable);
        availcombo.setBounds(200, 265, 150, 20);
        availcombo.setBackground(Color.white);
        add(availcombo);
        
        JLabel location = new JLabel("LOCATION");
        location.setForeground(Color.black);
        location.setFont(new Font("Tahoma", Font.PLAIN, 12));
        location.setBounds(60, 310, 120, 20);
        add(location);
        
        tflocation = new JTextField();
        tflocation.setBounds(200, 310, 150, 20);
        tflocation.setFont(new Font("Tahoma", Font.PLAIN, 12));
        add(tflocation);
        
        adddriver = new JButton("ADD DRIVER");
        adddriver.setBackground(Color.black);
        adddriver.setForeground(Color.white);
        adddriver.setBounds(60, 360, 120, 20);
        adddriver.addActionListener(this);
        add(adddriver);
        
        cancel = new JButton("CANCEL");
        cancel.setBackground(Color.black);
        cancel.setForeground(Color.white);
        cancel.setBounds(220, 360, 120, 20);
        cancel.addActionListener(this);
        add(cancel);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/eleven.jpg"));
        Image i2 = i1.getImage().getScaledInstance(500, 300, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(400, 30, 470, 300);
        add(image);
        
        setBounds(300, 200, 930, 470);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == adddriver){
            
            String name = tfname.getText();
            String age = tfage.getText();
            String gender = (String)gendercombo.getSelectedItem();
            String company = tfbrand.getText();
            String model = tfmodel.getText();
            String available = (String)availcombo.getSelectedItem();
            String location = tflocation.getText();
            
            
            try{
                Conn con = new Conn();
                
                String str = "insert into driver values('"+name+"', '"+age+"', '"+gender+"', '"+company+"', '"+model+"', '"+available+"', '"+location+"')";
               
                con.s.executeUpdate(str);
                
                JOptionPane.showMessageDialog(null,"New driver added successfully....");
                
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
        new AddDriver();
    }
}
