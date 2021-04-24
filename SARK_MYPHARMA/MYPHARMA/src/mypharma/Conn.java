/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mypharma;
import java.sql.*;//To connect with my sql

/**
 * 
 *
 * @author bansa
 */
public class Conn {
   public Connection c;
   public  Statement s;
    
    public Conn()
    {
        try
        {
            // Class.forName("com.mysql.cj.jdbc.Driver");
            c=DriverManager.getConnection("jdbc:mysql:///mypharma","root","");       
            s=c.createStatement();
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
    }
    
    
    
}
