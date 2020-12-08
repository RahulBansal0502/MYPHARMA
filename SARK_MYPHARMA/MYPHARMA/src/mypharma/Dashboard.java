/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypharma;

/**
 *
 * @author bansa
 */
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.*;
import java.lang.Thread;
import java.net.*;

public class Dashboard extends JFrame implements ActionListener 
{
    JLabel l1, l2,l4,id,l5,l6,l7;
    JButton b1, b2, b3,b4;
    Dashboard()
    {
        super("Owner's Dashboard");
        
    //     super("MYPHARMA:A PHARMACY FOR ALL YOUR NEEDS");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("mypharma/Images/Dashboard.jpg"));//Image resource
        Image i2 =i1.getImage().getScaledInstance(700,500,Image.SCALE_DEFAULT);//For changing size of image
        ImageIcon i3 =new ImageIcon(i2);
        l1 =new JLabel();
        l1.setBounds(0,0,700,500);
        l1.setLayout(null);
         add(l1);
      
       JLabel l4 =new JLabel(i3);//Image is converted in icon then we use label
        l4.setBounds(0,0,1360,800);
             add(l4);
             
             
             
      /*
        b1 = new JButton("View Medicines");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);*/
       
        b2 = new JButton("Details");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("Owner's Profile");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        b4 = new JButton("Exit");
        b4.setBackground(Color.BLACK);
        b4.setForeground(Color.WHITE);
        
        
        
        
      /* b1.setFont(new Font("Arial", Font.BOLD, 20));
       b1.setBounds(25,100,200,30);
       b1.addActionListener(this);*/

       b2.setFont(new Font("Arial", Font.BOLD, 20));
       b2.setBounds(25,150,200,30);
       b2.addActionListener(this);

       b3.setFont(new Font("Aial", Font.BOLD, 20));
       b3.setBounds(25,100,200,30);
       b3.addActionListener(this);
       
     b4.setFont(new Font("Aial", Font.BOLD, 20));
       b4.setBounds(25,200,200,30);
       b4.addActionListener(this);
        
        l6 =new JLabel("Dashboard");
        l6.setBounds(25,20,2000,60);
        l6.setFont(new Font("BELL MT",Font.PLAIN,50));
        l6.setForeground(Color.CYAN);
        l1.add(l6);
       
       // l1.add(b1);
        l1.add(b2);
        l1.add(b3);
        l1.add(b4);
       
       
        //add(id);
        
        getContentPane().setBackground(Color.GRAY);
        setVisible(true);
        setSize(700,500);
        setLocation(450,200);//Location axis means when the dialog box opens what is its dimensions on main screen
       
    }
            
                 
        
    //@Override
          public void actionPerformed (ActionEvent ae)
            {
                
                if(ae.getSource()==b2)
                {
                    setVisible(false);
                     new OHome(1);
                }
                else if(ae.getSource()==b3)
                {
                    setVisible(false);
                     new Profile();
                }
               
                else if(ae.getSource()==b4)
                {
                    setVisible(false);
                   //new Front();
                }
                
            }
        
        
        
        
    
    

    
    
    
    public static void main (String[] arg)
{
        //  Front f = new
        Dashboard d = new Dashboard();
}
}
        
