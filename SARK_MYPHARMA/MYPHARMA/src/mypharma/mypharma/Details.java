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
public class Details implements ActionListener {
    
    JFrame l4;
    JButton b1,b2;
    JTextField t;
    JPasswordField p1,p2; 
    JLabel l1,I,l2;
    JTable table;
   
     Details(int n){

        l4 = new JFrame("Details");
        l4.setBounds(400,190,700,500);
        l4.setVisible(true);
        l4.setLayout(null);
        l4.setDefaultCloseOperation(l4.HIDE_ON_CLOSE);
        
        l1=new JLabel("Welcome to MYPHARMA");
        l1.setBounds(180,10,1000,60);
        l1.setFont(new Font("Times New ROMAN",Font.BOLD,30));
        l4.add(l1);

        b2=new JButton("Back");
        b2.setBounds(460,80,200,40);
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.white);
        b2.setFont(new Font("Arial", Font.BOLD, 20));
        l4.add(b2);
        b2.addActionListener(this);

        String srnumb = "1";

        JLabel shopname =new JLabel("Shop Name");
       shopname.setFont(new Font("Tahoma",Font.PLAIN,13));
       shopname.setBounds(135,155,120,14);
       l4.add(shopname);

       JLabel phonenumber =new JLabel("Phone Number");
       phonenumber.setFont(new Font("Tahoma",Font.PLAIN,13));
       phonenumber.setBounds(300,155,120,14);
       l4.add(phonenumber);

       JLabel address =new JLabel("Shop address");
       address.setFont(new Font("Tahoma",Font.PLAIN,13));
       address.setBounds(470,155,126,14);
       l4.add(address);

        table=new JTable();
        table.setBackground(Color.WHITE);
        table.setBounds(50,180,600,250);
        l4.add(table);

        try{
            Conn c= new Conn();
            String str ="select Shop_Name,Contact_NO,Address from Profile where SR_NO = '"+srnumb+"';";
            ResultSet rs = c.s.executeQuery(str);
            table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(SQLException e)
        {
            e.printStackTrace();
        }
        l4.getContentPane().setBackground(Color.YELLOW);
        l4.setVisible(true);
        l4.setSize(700,500);
        l4.setLocation(450,200);

    }
    public void actionPerformed(ActionEvent e)
    {
        try{
            
        if(e.getSource()==b2)
        {
        l4.setVisible(false);
        new Front();
        }
        }
        catch (Exception ee) {
            //TODO: handle exception
            ee.printStackTrace();
        }
    }
    public static void main(String[] args)
    {
        new Details(1);
    }
}