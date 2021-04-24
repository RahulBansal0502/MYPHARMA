package mypharma;

import java.util.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;

public class Usignup implements ActionListener {
    JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JTextField t,t1;
    JPasswordField p1,p2;
    JButton b1,b2;

    Usignup(){
        f=new JFrame("User Signup");
        f.setLayout(null);
f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
       l4= new JLabel();
		ImageIcon i1= new ImageIcon(ClassLoader.getSystemResource("mypharma/Images/User_Signup.jpg"));
		 Image i2 =i1.getImage().getScaledInstance(700,500,Image.SCALE_DEFAULT);//For changing size of image
            ImageIcon i3 =new ImageIcon(i2);
            l4 =new JLabel();
            l4.setBounds(0,0,700,450);
            l4.setLayout(null);
            f.add(l4);
            
            JLabel l6 =new JLabel(i3);//Image is converted in icon then we use label
        l6.setBounds(0,0,700,450);
             f.add(l6);
       /*l4= new JLabel();
		l4.setBounds(0,0,1360,750);
		l4.setLayout(null);
		ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("MEDICLIN/Images/User_Signup.jpg"));
		l4.setIcon(i2);
		//l1.setIcon(i1);
		f.add(l4);*/
       
         
        l5 =new JLabel("User Signup");
		l5.setBounds(130,30,500,50);
		l5.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,40));
		l5.setForeground(Color.BLACK);
		l4.add(l5);
        
        l1=new JLabel("User Id");
        l1.setBounds(30, 90, 200, 50);
        l1.setFont(new Font("serif",Font.PLAIN,30));
        l1.setForeground(Color.black);
        l4.add(l1);

        l2=new JLabel("User Name");
        l2.setBounds(30,140 , 200, 50);
        l2.setFont(new Font("serif",Font.PLAIN,30));
        l2.setForeground(Color.black);
        l4.add(l2);

        l2=new JLabel("Password");
        l2.setBounds(30, 190, 300, 50);
        l2.setFont(new Font("serif",Font.PLAIN,30));
        l2.setForeground(Color.black);
        l4.add(l2);

        l2=new JLabel("Confirm Password");
        l2.setBounds(30, 240, 400, 50);
        l2.setFont(new Font("serif",Font.PLAIN,30));
        l2.setForeground(Color.black);
        l4.add(l2);

        t=new JTextField();
        t.setBounds(280, 90, 200, 40);
        l4.add(t);

        t1=new JTextField();
        t1.setBounds(280, 140, 200, 40);
        l4.add(t1);

        p1=new JPasswordField();
        p1.setBounds(280, 190, 200, 40);
        l4.add(p1);

        p2=new JPasswordField();
        p2.setBounds(280, 240, 200, 40);
        l4.add(p2);

        b1=new JButton("Sign-Up");
        b1.setBackground(Color.BLACK);
        b1.setBounds(130,300,150,50);
        b1.setForeground(Color.white);
        b1.setFont(new Font("Arial", Font.BOLD, 20));
        l4.add(b1);

        b1.addActionListener(this);

        b2=new JButton("Cancel");
        b2.setBackground(Color.BLACK);
        b2.setBounds(320,300,150,50);
        b2.setForeground(Color.WHITE);
        b2.setFont(new Font("Arial", Font.BOLD, 20));
        l4.add(b2);

        b2.addActionListener(this);

        f.getContentPane().setBackground(Color.white);
        f.setVisible(true);
        f.setSize(700,500);
        f.setLocation(450,200);

    }

    public static void main(String args[])
    {
        new Usignup();
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        // TODO Auto-generated method stub
        
        String a=t.getText();
        String userName=t1.getText();
        String b=p1.getText();
        String c=p2.getText();

        try {
            if(ae.getSource()==b1)
            {
                if(!(p1.getText().equals(p2.getText())))
                {
                    JOptionPane.showMessageDialog(null,"Passwords does not match");
                }
                else
                {
                   if(t.getText().equals(""))
                   {
                       JOptionPane.showMessageDialog(null, "Please fillup the all required fields.");
                   }
                   if(p1.getText().equals(""))
                           {
                               JOptionPane.showMessageDialog(null, "Please enter the password");
                           }
                   else
                   {
                       Conn C=new Conn();
                    String q="insert into user(userid,password,name) values('"+a+"','"+b+"','"+userName+"');";
                    C.s.executeUpdate(q);
                    JOptionPane.showMessageDialog(null, "Successfully Registered");
                    f.setVisible(false);
                    new Ulogin();
                   }
                }
                        
            }
            else if(ae.getSource()==b2)
            {
                f.setVisible(false);
                new Ulogin();
            }
        } catch (Exception e) {
            //TODO: handle exception
            e.printStackTrace();
        }

    }
}
