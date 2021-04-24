package mypharma;

import java.awt.*;
import javax.swing.*;
import java.sql.*;
import java.awt.event.*;

class Ulogin extends JFrame implements ActionListener 
{
	
	//JFrame f;
	JLabel l1,l2,l3,l4;
	JButton b1,b2,b3;
	JTextField t1;
	JPasswordField p1;
	
	Ulogin()
	{
            super("User Login/Signup");
        setDefaultCloseOperation(EXIT_ON_CLOSE);
		/*f=new JFrame("User Login/Signup");
		f.setBackground(Color.GRAY);
		f.setForeground(Color.BLACK);*/
		
		l1= new JLabel();
		l1.setBounds(0,0,1360,750);
		l1.setLayout(null);
		ImageIcon i2 = new ImageIcon(ClassLoader.getSystemResource("mypharma/Images/Cons.jpg"));
		l1.setIcon(i2);
		add(l1);
		
		l2 =new JLabel("User Login");
		l2.setBounds(420,190,500,50);
		l2.setFont(new Font("Arial Rounded MT Bold",Font.BOLD,40));
		l2.setForeground(Color.BLACK);
		l1.add(l2);
		
		l3 =new JLabel("User ID");
		l3.setBounds(400,250,100,40);
		l3.setFont(new Font("serif",Font.BOLD,20));
		l3.setForeground(Color.BLACK);
		l1.add(l3);
		
		t1= new JTextField();
		t1.setBounds(500,250,185,30);
		l1.add(t1);
		
		l4 =new JLabel("Password");
		l4.setBounds(400,300,100,30);
		l4.setFont(new Font("serif",Font.BOLD,20));
		l4.setForeground(Color.BLACK);
		l1.add(l4);
		
		p1= new JPasswordField();
		p1.setBounds(500,300,185,30);
		l1.add(p1);
		
		b1=new JButton("New User");
		b1.setFont(new Font("Arial", Font.BOLD, 20));
		b1.setBounds(400,350,150,40);
		b1.addActionListener(this);
		b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        l1.add(b1);
        
        b2=new JButton("Cancel");
		b2.setFont(new Font("Arial", Font.BOLD, 20));
		b2.setBounds(580,350,100,40);
		b2.addActionListener(this);
		b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        l1.add(b2);
		
	b3 = new JButton("Login");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);	
        b3.setFont(new Font("Aial", Font.BOLD, 20));
        b3.setBounds(400,400,280,40);
        l1.add(b3);
      b3.addActionListener(this);
		setVisible(true);
		setSize(700,500);
		setLocation(450,200);
        }
	
        public void actionPerformed (ActionEvent ae)
        {
            try
            {
                Conn c2 =new Conn();
                String m = t1.getText();
                String l = p1.getText();
                
                String n = "Select * from user where userid='"+m+"' and password='"+l+"'";
                
                ResultSet ra =c2.s.executeQuery(n);
                if(ae.getSource()==b1)
                {
                    new Usignup();
                    //setVisible(true);
                    setVisible(false);
                }
                else if(ae.getSource()==b3)
                {
                if(ra.next())
                {
                    JOptionPane.showMessageDialog(null, "Login Successfully");
                    
                    setVisible(false);
                    new UDashboard(m);
                    //setVisible(true);
                
                }
                else
                {
                    JOptionPane.showMessageDialog(null,"Inavalid Login");
                   // setVisible(false);
                }
                }
                //else 
               else if(ae.getSource()==b2)
                {
                    
                    //new Front().setVisible(true);
                    setVisible(false);
                   new Front();
                }
                
            } catch(Exception e)
            {
                e.printStackTrace();
            }
                
        
	
	}

		
		public static void main (String[] arg)
		{
			Ulogin U=new Ulogin();
		}
		
		
		
}
	
	
	


