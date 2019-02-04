package Resturant;


import java.sql.Connection;
import java.sql.DriverManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sulakshana
 */
public class dbconnect {
    
     
    public static Connection connect()//
    { 
        
        Connection conn = null;
        
        try{
            Class.forName("com.mysql.jdbc.Driver");
            conn = (Connection) DriverManager.getConnection("jdbc:mysql://localhost:3306/mystore","root","");     //database location with username & password
            
            
            
        } 
        
        catch(Exception e)
            
        {
            
           System.out.println(e); 
        }
       
        
        
        return conn;
    }
    
    
}
