/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypharma;

import java.sql.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import javax.swing.*;

/**
 *
 * @author bansa
 */
public class Profile implements ActionListener
{
  JFrame f;
    JLabel l1,l2,l3,l4,l5,l6,l7,l8,l9;
    JTextField t,t1,t2,t3,t4,t5,t7,t9;
    JButton b,b1,b2,b3;

    Profile(int i){}
    
    Profile(){
       f = new JFrame("Owner's Profile");
        f.setBackground(Color.white);
        f.setLayout(null);
f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);
        
        l6=new JLabel();
        l6.setBounds(0,0,900,480);
        l6.setLayout(null);
        ImageIcon img = new ImageIcon(ClassLoader.getSystemResource("mypharma/Images/Profile.jpg"));
        l6.setIcon(img);

        l8 = new JLabel("Owner's Profile");
        l8.setBounds(250,20,500,50);
        l8.setFont(new Font("BELL MT",Font.BOLD,30));
        l8.setForeground(Color.black);
        l6.add(l8);
        f.add(l6);

 
        l1 = new JLabel("Owner ID");
        l1.setBounds(150,70,150,30);
        l1.setFont(new Font("serif",Font.BOLD,20));
        l6.add(l1);

        t1=new JTextField();
        t1.setBounds(350,70,200,30);
        l6.add(t1);

        l2= new JLabel("Shop Name");
        l2.setBounds(150,120,150,30);
        l2.setFont(new Font("serif",Font.BOLD,20));
        l6.add(l2);

        t2=new JTextField();
        t2.setBounds(350,120,200,30);
        l6.add(t2);

        l3= new JLabel("Owner's Name");
        l3.setBounds(150,170,150,30);
        l3.setFont(new Font("serif",Font.BOLD,20));
        l6.add(l3);

        t3=new JTextField();
        t3.setBounds(350,170,200,30);
        l6.add(t3);

        l4= new JLabel("Email Id");
        l4.setBounds(150,220,150,30);
        l4.setFont(new Font("serif",Font.BOLD,20));
        l6.add(l4);

        t4=new JTextField();
        t4.setBounds(350,220,200,30);
        l6.add(t4);

        l5= new JLabel("Contact No.");
        l5.setBounds(150,270,150,30);
        l5.setFont(new Font("serif",Font.BOLD,20));
        l6.add(l5);

        t5=new JTextField();
        t5.setBounds(350,270,200,30);
        l6.add(t5);
        
        l7= new JLabel("Address");
        l7.setBounds(150,320,150,30);
        l7.setFont(new Font("serif",Font.BOLD,20));
        l6.add(l7);

        t7=new JTextField();
        t7.setBounds(350,320,200,30);
        l6.add(t7);
        
        l9= new JLabel("Medicine");
        l9.setBounds(150,370,150,30);
        l9.setFont(new Font("serif",Font.BOLD,20));
        l6.add(l9);
        
        t9=new JTextField();
        t9.setBounds(350,370,200,30);
        l6.add(t9);

        b = new JButton("Submit");
        b.setBackground(Color.BLACK);
        b.setForeground(Color.WHITE);
        b.setBounds(180,420,150,30);
        
        l6.add(b);

        b1=new JButton("Cancel");   
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        b1.setBounds(380,420,150,30);
        
        l6.add(b1);
        
        b.addActionListener(this);
        b1.addActionListener(this);
        
        f.setVisible(true);
        f.setSize(700,500);
        f.setLocation(450,200);
    }

    public void actionPerformed(ActionEvent ae){
        
        String a = t1.getText();
        String bb = t2.getText();
        String c = t3.getText();
        String d = t4.getText();
        String e = t5.getText();
//        String ff = t6.getText();
        String g = t7.getText();
        String h;
        String i=t9.getText();
        h="1";
       
        if(ae.getSource() == b){
            try{
                Conn cc = new Conn();
                String q = "insert into Profile values('"+a+"','"+bb+"','"+c+"','"+d+"','"+e+"','"+g+"','"+h+"','"+i+"');";
                cc.s.executeUpdate(q);
                JOptionPane.showMessageDialog(null,"Details Successfully Inserted");
                f.setVisible(false);
               new Dashboard();
            }catch(Exception ee){
                System.out.println("The error is:"+ee);
            }
        }else if(ae.getSource() == b1){
            f.setVisible(false);
            new Dashboard();
        }
    }
    public static void main(String[ ] arg){
        new Profile();
    }   
}
