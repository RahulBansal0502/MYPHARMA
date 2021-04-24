/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypharma;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.lang.*;
import java.lang.Thread;
import java.net.*;
/**
 *
 * @author bansa
 */
public class Front extends JFrame implements ActionListener 
{
    //JFrame j= new JFrame();
    JLabel l1, l2,l4,id,l5,l6,l7;
    JButton b1, b2, b3;
     
    Front()
    {
        ////This is for above 
    	 super("MYPHARMA:A PHARMACY FOR ALL YOUR NEEDS");
      setDefaultCloseOperation(EXIT_ON_CLOSE);
        
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("mypharma/Images/Front.jpg"));//Image resource
        Image i2 =i1.getImage().getScaledInstance(700,500,Image.SCALE_DEFAULT);//For changing size of image
        ImageIcon i3 =new ImageIcon(i2);
        l1 =new JLabel();
        l1.setBounds(0,0,700,500);
        l1.setLayout(null);
         add(l1);
      
       JLabel l4 =new JLabel(i3);//Image is converted in icon then we use label
        l4.setBounds(0,0,1360,800);
             add(l4);
             
             
             
        b1 = new JButton("User");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
       
        b2 = new JButton("Owner");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("View Details ");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        
       b1.setFont(new Font("Arial", Font.BOLD, 20));
       b1.setBounds(400,350,100,30);
       b1.addActionListener(this);

       b2.setFont(new Font("Arial", Font.BOLD, 20));
       b2.setBounds(550,350,100,30);
       b2.addActionListener(this);

       b3.setFont(new Font("Aial", Font.BOLD, 20));
       b3.setBounds(400,400,250,30);
       b3.addActionListener(this);
        
        
        
        l2 =new JLabel("WELCOME TO MYPHARMA");
        l2.setBounds(25,0,2000,120);
        l2.setFont(new Font("BELL MT",Font.BOLD,45));
        l2.setForeground(Color.WHITE);
        l1.add(l2);
        
        l5 =new JLabel("MYPHARMA");
        l5.setBounds(365,230,400,40);
        l5.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,50));
        l5.setForeground(Color.WHITE);
        l1.add(l5);
        
        l6 =new JLabel("A PHARMACY FOR ALL YOUR NEEDS");
        l6.setBounds(330,280,2000,20);
        l6.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        l6.setForeground(Color.CYAN);
        l1.add(l6);
       
        l1.add(b1);
        l1.add(b2);
        l1.add(b3);
       
        l7 =new JLabel("SARK...");
        l7.setBounds(600,440,200,20);
        l7.setFont(new Font("TIMES NEW ROMAN",Font.PLAIN,20));
        l7.setForeground(Color.WHITE);
        l1.add(l7);
        //add(id);
        
        getContentPane().setBackground(Color.GRAY);
        setVisible(true);
        setSize(700,500);
        setLocation(450,200);//Location axis means when the dialog box opens what is its dimensions on main screen
        
        while(true) //This whole loop is for the animation that is pop up on frame
        {
            l2.setVisible(false);//label that we have to po up
            try
            {
                Thread.sleep(500); //this time is in milliseconds 1000=1s
            }
            catch(Exception e){}
            l2.setVisible(true);
            try
            {
                Thread.sleep(500);
                
            }
            catch(Exception e){}
            
        }
    }
            
                 
        
    //@Override
          public void actionPerformed (ActionEvent ae)
            {
                
                if(ae.getSource()==b1)
                {
                    setVisible(false);
                     new Ulogin();
                }
                else if(ae.getSource()==b2)
                {
                    setVisible(false);
                     new Ologin();
                }
                else if(ae.getSource()==b3)
                {
                    setVisible(false);
                     new Details(1);
                }
                
            }
        
        
        
        
    
    

public static void main (String[] arg)
{
        //  Front f = new
        Front k = new Front();
}
}

    