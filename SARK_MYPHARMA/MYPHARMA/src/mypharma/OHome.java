/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypharma;
import net.proteanit.sql.DbUtils;
import java.net.*;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
/**
 *
 * @author bansa
 */
public class OHome implements ActionListener
{
     JFrame l4;
    JButton b1,b2,b3;
    JTextField t;
    JPasswordField p1,p2; 
    JLabel l1;
    JTable table;
    String ownerid;

    OHome(String id){

        ownerid=id;
        l4 = new JFrame("Home");
        l4.setBounds(400,190,700,500);
        l4.setVisible(true);
        l4.setLayout(null);
        l4.setDefaultCloseOperation(l4.HIDE_ON_CLOSE);

       
        
        l1=new JLabel("Welcome to MyPharma");
        l1.setBounds(180,10,1000,60);
        l1.setFont(new Font("Times New Roman",Font.BOLD,30));
        l4.add(l1);
        
        b1=new JButton("Search Medicine");
        b1.setBounds(30,80,200,40);
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.white);
        b1.setFont(new Font("Arial", Font.BOLD,20));
        l4.add(b1);
        b1.addActionListener(this);
        
        b3=new JButton("Back");
        b3.setBounds(460,80,200,40);
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.white);
        b3.setFont(new Font("Arial", Font.BOLD,20));
        l4.add(b3);
        b3.addActionListener(this);

        String srnumb = "1";

        JLabel shopname =new JLabel("Shop Name");
       shopname.setFont(new Font("Tahoma",Font.PLAIN,13));
       shopname.setBounds(100,155,120,14);
      l4.add(shopname);

       JLabel phonenumber =new JLabel("Phone Number");
       phonenumber.setFont(new Font("Tahoma",Font.PLAIN,13));
       phonenumber.setBounds(255,155,120,14);
     l4.add(phonenumber);

       JLabel address =new JLabel("Shop address");
       address.setFont(new Font("Tahoma",Font.PLAIN,13));
       address.setBounds(460,155,126,14);
       l4.add(address);

        table=new JTable();
        table.setBackground(Color.WHITE);
        table.setBounds(50,180,600,250);
       l4.add(table);

        try{
            Conn c= new Conn();
            String str ="select shop_name,contact_no,address from shop;";
            ResultSet rs = c.s.executeQuery(str);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
       Color myColor = new Color(250, 250, 110);
        l4.getContentPane().setBackground(myColor);
        l4.setVisible(true);
        l4.setSize(700,500);
        l4.setLocation(450,200);

    }
    public void actionPerformed(ActionEvent e)
    {
        try{
            if(e.getSource()==b1)
            {
                l4.setVisible(false);
                new OSearch(ownerid);
            }
           else if(e.getSource()==b3)
           {
               l4.setVisible(false);
               new Dashboard(ownerid);
           }
               
        
        }
        catch (Exception ee) {
            //TODO: handle exception
            ee.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        new OHome("sam1234");
    }
}
