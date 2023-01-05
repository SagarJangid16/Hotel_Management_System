
package hotel.management.system;

import java.awt.Color;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


public class AddEmployee extends JFrame implements ActionListener{
    JTextField tfname, tfage, tfsalary, tfcontactno, tfemail, tfadharno;
    JRadioButton rbmale, rbfemale;
    JButton submit;
    JComboBox cjob;
    AddEmployee(){
        setLayout(null);
        
        JLabel name = new JLabel("NAME");
        name.setBounds(60, 30, 120, 30); 
        name.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(name);
        
        tfname = new JTextField();
        tfname.setFont(new Font("Arial",Font.PLAIN, 15));
        tfname.setBounds(180, 30, 170, 30);
        add(tfname);
        setVisible(true);
        
        JLabel age = new JLabel("AGE");
        age.setBounds(60, 80, 120, 30); 
        age.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(age);
        
        tfage = new JTextField();
        tfage.setFont(new Font("Arial",Font.PLAIN, 15));
        tfage.setBounds(180, 80, 170, 30);
        add(tfage);
        
        JLabel gender = new JLabel("GENDER");
        gender.setBounds(60, 130, 120, 30); 
        gender.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(gender);
        
        rbmale = new JRadioButton("MALE");
        rbmale.setFont(new Font("Arial",Font.PLAIN, 15));
        rbmale.setBounds(180, 130, 70, 30);
        add(rbmale);
        
        rbfemale = new JRadioButton("FEMALE");
        rbfemale.setFont(new Font("Arial",Font.PLAIN, 15));
        rbfemale.setBounds(270, 130, 90, 30);
        add(rbfemale);
        
        ButtonGroup gb = new ButtonGroup();
        gb.add(rbmale);
        gb.add(rbfemale);
        
        JLabel jobtype = new JLabel("JOB TYPE");
        jobtype.setBounds(60, 180, 120, 30); 
        jobtype.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(jobtype);
        
        String[] str = {"Front Desk Clerks", "Porters", "Housekeeping", "Kitchen Staff", "Room Service", "Chefs", "Drivers", "Waiter/Waitress", "Manager", "Accountant"};
        cjob = new JComboBox(str);
        cjob.setBackground(Color.white);
        cjob.setBounds(180, 180, 170, 30);
        add(cjob);
        
        JLabel salary = new JLabel("SALARY");
        salary.setBounds(60, 230, 120, 30); 
        salary.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(salary);
        
        tfsalary = new JTextField();
        tfsalary.setFont(new Font("Arial",Font.PLAIN, 15));
        tfsalary.setBounds(180, 230, 170, 30);
        add(tfsalary);
        
        JLabel contactno = new JLabel("CONTACT NO.");
        contactno.setBounds(60, 280, 120, 30); 
        contactno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(contactno);
        
        tfcontactno = new JTextField();
        tfcontactno.setFont(new Font("Arial",Font.PLAIN, 15));
        tfcontactno.setBounds(180, 280, 170, 30);
        add(tfcontactno);
        
        JLabel email = new JLabel("EMAIL ID");
        email.setBounds(60, 330, 120, 30); 
        email.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(email);
        
        tfemail = new JTextField();
        tfemail.setFont(new Font("Arial",Font.PLAIN, 15));
        tfemail.setBounds(180, 330, 170, 30);
        add(tfemail);
        
        JLabel adharno = new JLabel("ADHAR ID NO");
        adharno.setBounds(60, 380, 120, 30); 
        adharno.setFont(new Font("Tahoma", Font.PLAIN, 16));
        add(adharno);
        
        tfadharno = new JTextField();
        tfadharno.setFont(new Font("Arial",Font.PLAIN, 15));
        tfadharno.setBounds(180, 380, 170, 30);
        add(tfadharno);
        
        submit = new JButton("SUBMIT");
        submit.setBackground(Color.black);
        submit.setForeground(Color.white);
        submit.setBounds(370, 440, 120, 30);
        submit.addActionListener(this);
        add(submit);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/tenth.jpg"));
        Image i2 = i1.getImage().getScaledInstance(450, 510, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(380, 60, 450, 450);
        add(image);
        
        getContentPane().setBackground(Color.white);
        setBounds(350, 200, 850, 540);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);
        
    }
    
    public void actionPerformed(ActionEvent ae){
        String name = tfname.getText();
        String age = tfage.getText();
        String salary = tfsalary.getText();
        String phone = tfcontactno.getText();
        String email = tfemail.getText();
        String adhar = tfadharno.getText();
        
        String gender = null;
        
        if(rbmale.isSelected()){
            gender = "Male";
        }else if(rbfemale.isSelected()){
            gender = "Female";
        }
        String job = (String)cjob.getSelectedItem();
        
        try{
            Conn c = new Conn();
            
            String query = "insert into new_table values('" + name + "', '" + age + "', '" + gender + "', '" + job + "', '" + salary + "', '" + phone + "', '" + email + "', '" + adhar + "')";
            c.s.executeUpdate(query);
            
            JOptionPane.showMessageDialog(null, "Employee added successfully");
            
            setVisible(false);
        }catch(Exception ce){
            ce.printStackTrace();
        }
    }
    public static void main(String[] args){
        new AddEmployee();
    }
}
