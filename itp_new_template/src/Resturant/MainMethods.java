package Resturant;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sulakshana
 */
public class MainMethods {
    Connection conn=DBconnectionNew.connect();
    PreparedStatement pst=null;
    ResultSet rs=null;
    
    public void addmenu(String namefeild,String discriptionfeild,String pricefeild)
    {
        try{

                        String DB = "INSERT INTO menu (Name,Discription,Price) values('" +namefeild+ "'  , '" +discriptionfeild+ "' , '" +pricefeild+ "'  )";//concat method//in java  to input values to a db
                        pst=conn.prepareStatement(DB);
                        pst.execute();
                        //load table after every insert
                        //tableload();//load table

                    }
                    catch(Exception x )
                    {
                        // JOptionPane.showMessageDialog(null, "Error");
                    }
    }

    
    
    
    
    
    
}
