/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypharma;
import java.awt.*;
import javax.swing.*;

import java.sql.ResultSet;
import java.net.*;
import net.proteanit.sql.DbUtils;
import java.awt.event.*;
import java.lang.*;
import java.lang.Thread;
/**
 *
 * @author bansa
 */
public class OSearch implements ActionListener
{
    JLabel l1,SName,MName,Address,Contact,l2;
    JFrame f;
    JTextField t1,t2;
    JButton show,back;
    JTable table;
    String ownerid;

    OSearch(String id)
    {
        ownerid=id;
        JFrame f=new JFrame("Search Medicine");
        f.setLayout(null);
        f.setTitle("Search Medicine");


        f.setDefaultCloseOperation(f.EXIT_ON_CLOSE);

        l1 =new JLabel("Enter Medicine");
        l1.setBounds(100,40,200,40);
	l1.setFont(new Font("Times New Roman",Font.BOLD,20));
        l1.setForeground(Color.BLACK);
        f.add(l1);

        t1= new JTextField();
        t1.setBounds(300,40,200,40);
        f.add(t1);
        
        l2 =new JLabel("PIN Code");
        l2.setBounds(100,100,200,40);
        l2.setFont(new Font("Times New Roman",Font.BOLD,20));
        l2.setForeground(Color.BLACK);
        f.add(l2);

        t2= new JTextField();
        t2.setBounds(300,100,200,40);
        f.add(t2);
        
        show =new JButton("Show");
        show.setBackground(Color.BLACK);
        show.setForeground(Color.WHITE);
        show.setBounds(200,160,100,40);
        f.add(show);

        show.addActionListener(this);
        
        back =new JButton("Back");
        back.setBackground(Color.BLACK);
        back.setForeground(Color.WHITE);
        back.setBounds(320,160,100,40);
        f.add(back);

        back.addActionListener(this);

        SName = new JLabel("SHOP NAME",SwingConstants.CENTER);
        SName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        SName.setBounds(20,250,100,30);
        f.add(SName);

        SName = new JLabel("SHOP OWNER",SwingConstants.CENTER);
        SName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        SName.setBounds(140,250,100,30);
        f.add(SName);

        SName = new JLabel("CONTACT",SwingConstants.CENTER);
        SName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        SName.setBounds(260,250,150,30);
        f.add(SName);

        SName = new JLabel("ADDRESS",SwingConstants.CENTER);
        SName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        SName.setBounds(430,250,100,30);
        f.add(SName);

        SName = new JLabel("E-mail ID",SwingConstants.CENTER);
        SName.setFont(new Font("Tahoma", Font.PLAIN, 15));
        SName.setBounds(530,250,160,30);
        f.add(SName);

        table = new JTable();
        table.setBackground(Color.white);
        table.setBounds(20, 280, 640, 300);
        f.add(table);

        // f.getContentPane().setBackground(Color.WHITE);
        Color myColor = new Color(250, 250, 110);
        f.getContentPane().setBackground(myColor);
        f.setVisible(true);
        f.setSize(700,500);
        f.setLocation(450,200);
    }

    public void actionPerformed (ActionEvent ae)
    {
        try {
            if(ae.getSource()==show)
            {
                Conn c =new Conn();
                String m = t1.getText();
                String pincode=t2.getText();

                String str="Select shop_name,quantity,cost,contact_no,address From medicine,temp_table Where medicine.medicineid=temp_table.medicineid And medicine.medicine_name='"+m+"' And pincode='"+pincode+"';";
    
                ResultSet rs=c.s.executeQuery(str);
                table.setModel(DbUtils.resultSetToTableModel(rs));
            }
            
            else if(ae.getSource()==back)
            {
                
                new OHome(ownerid);
               // f.setVisible(false);
            }
        } catch (Exception e) {
            e.printStackTrace();
            //TODO: handle exception
        }
    }

    public static void main(String[] args) {
        OSearch obj = new OSearch("sam1234");
    }
}
