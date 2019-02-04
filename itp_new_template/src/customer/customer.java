/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import dbconnect.dbconnect;
import java.awt.HeadlessException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author DELL
 */
public class customer {
    Connection con;
    PreparedStatement pst=null;
    ResultSet rs = null;

    public customer() {
       
        this.con = dbconnect.connect();
        
    }
    
   public ResultSet customersearch(String type,String key){
       
       String sql ="select * from cust_reg where "+type+" like '"+key+"%'";
        try {

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();        

        } catch (SQLException | HeadlessException e) {
            
        }
        return rs; 
   }
   
    public ResultSet Roomsearch(String type,String key){
        
        String sql ="select * from room where "+type+" like '"+key+"%'";
        try {

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

        } catch (SQLException | HeadlessException e) {
            
        }
         return rs; 
        }
    
     public ResultSet Paymentsearch(String type,String key){
     
         String sql = "select * from payment_handle where " + type + " like '" + key + "%'";
         try {

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

        } catch (SQLException | HeadlessException e) {
            
        }
          return rs; 
        }
  
     public ResultSet Reservationsearch(String type,String key){
     
        String sql ="select * from booking where "+type+" like '"+key+"%'";
        try {

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
           
        } catch (SQLException | HeadlessException e) {
            
        }
        return rs; 
        }
   
      public ResultSet Remaindersearch(String type,String key){
      
        String sql ="select * from reminder where "+type+" like '"+key+"%' ";
        System.out.println(sql);
        try {
            con = dbconnect.connect();
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

        } catch (Exception e) {
        }
         return rs; 
      }
     
}
