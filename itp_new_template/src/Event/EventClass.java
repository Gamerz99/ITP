/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Event;

import com.mysql.jdbc.Statement;
import static com.sun.java.accessibility.util.AWTEventMonitor.addMouseListener;
import dbconnect.dbconnect;
import java.awt.Color;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JLabel;
import java.lang.*;
import javax.swing.JPanel;
import javax.swing.table.DefaultTableModel;
import net.proteanit.sql.DbUtils;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComboBox;
import javax.swing.JTable;


/**
 * 
 * 
 * 
 *
 * @author HP™
 */
public class EventClass {
     PreparedStatement pst=null;
     Connection conn=dbconnect.connect();
      ResultSet table=null;
      
        ResultSet event=null;
      
     
      
      
      
      //constructor
public EventClass(com.mysql.jdbc.Connection connection)
    {
        this.conn = connection;
    }

  ///////////////////////////////////////////////////////////////////////////    
public boolean addData( String sql)
    {
        try 
        {
            this.pst= (com.mysql.jdbc.PreparedStatement) this.conn.prepareStatement(sql);
           // pst.setString(1, ManufactNo);
            pst.execute();
            }
        catch (Exception e) 
        {
            System.out.println(" booking Error"+e);
            return false;
        }
        return true;
    }
 
 //////////////////////////////////////////////////////////////////////////////////
    public String getCurrentDate(){
         DateFormat df1=new SimpleDateFormat("yyyy-MM-dd");
         Date Edate1=new Date();
         String s=df1.format(Edate1);
        System.out.println(s);  
         return s;
     }
 

    ///////////////////////////////////////////////////////////////////////////////
    public  void ReturnUpcommingEvents(JLabel jlabel,int i)
    {
      
        String s=getCurrentDate();
        String sql = "SELECT Event_Type FROM event_booking WHERE Event_Date>='"+s+"'";
    
         try
        {
           // ArrayList arr=new  ArrayList();
       // arr=null; 
          this.pst= (com.mysql.jdbc.PreparedStatement) this.conn.prepareStatement(sql, ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_UPDATABLE);
         
           event= pst.executeQuery(sql);
        
         //  for(int i=1;i<=3;i++){
          while(event.next()){ 
              
             // arr.add(event.absolute(1));
            
          //String[] x=new String[8];
          if(i==1){
                 event.absolute(1);
                String type=table.getString("Event_Type");
              //   table.close();
                 jlabel.setText(type); 
                 System.out.println(type);
          }else if(i==2){ 
                 event.absolute(2);
                 String type2=event.getString("Event_Type");
                 jlabel.setText(type2); 
                 System.out.println(type2);
                 
          }else if(i==3){  
                   event.absolute(3);
                 String type3=event.getString("Event_Type");
                 jlabel.setText(type3); 
                 System.out.println(type3);
          }
          
                   event.absolute(4);
                 String type4=event.getString("Event_Type");
                 jlabel.setText(type4); 
                 System.out.println(type4);
           
           
           
                 event.absolute(5);
                 String type5=event.getString("Event_Type");
                 event.close();
                 jlabel.setText(type5); 
                 System.out.println(type5);
                   
                 
           
        // String[] sd=type.split("");
          //System.out.println(sd[0]);
                      
         
          
           /* while(table.next())
            {
                jlabel.setText(table.getString("Event_Type"));
                
            }*/
          }
        } 
        catch(Exception e)
        {
            System.out.println("eventupcomming Loading Error : "+e);
        }
        
   } 
    //////////////////////////////////////////////////////////////////////////
    public boolean ViewTable( String sql)
    {
        try 
        {
            this.pst= (com.mysql.jdbc.PreparedStatement) this.conn.prepareStatement(sql);
           // pst.setString(1, ManufactNo);
            pst.execute();
            }
        catch (Exception e) 
        {
            System.out.println(" booking Error"+e);
            return false;
        }
        return true;
    }
 /////////////////////////////////////////////////////////////////////////////////
   public boolean UpdateTable( String sql)
    {
        try 
        {
            this.pst= (com.mysql.jdbc.PreparedStatement) this.conn.prepareStatement(sql);
            pst.execute();
          
            }
        catch (Exception e) 
        {
            System.out.println(" Update Error"+e);
            return false;
        }
        return true;
    } 
   //////////////////////////////////////////////////
     public boolean DeleteValues( String sql,JTable model)
    {
        try 
        {
            this.pst= (com.mysql.jdbc.PreparedStatement) this.conn.prepareStatement(sql);
            pst.execute();
            tableLoadS(model);

            }
        catch (Exception e) 
        {
            System.out.println(" Update Error"+e);
            return false;
        }
        return true;
    }
    /////////////////////////////////////////////
     public void JpanelColor(JPanel jpanel){
         
         jpanel.setBackground(new Color(102,102,102));
         String q="SELECT * FROM offers";
         
     }     
  ///////////////////////////////////////////////      
public void getDeco(JComboBox combo)
    {
        
        
        try
        {
            String Sql = "SELECT  Item_Name FROM decoration ";
            this.pst= (com.mysql.jdbc.PreparedStatement) this.conn.prepareStatement(Sql);
            table=pst.executeQuery();
            while(table.next())
            {
                combo.addItem(table.getString("Item_Name"));
            }
            
        }
        catch(Exception e)
        {
            System.out.println("Combo Box Loading Error : "+e);
        }
        
    }
     
   /////////////////////////////////////////////////////////
public void tableLoadS(JTable model)
      {  
        
         try{
             String q=null;
             int row=model.getSelectedRow();
             String no=model.getModel().getValueAt(row, 0).toString();  
             String q1="SELECT *FROM offers WHERE Offer_ID="+no+"";
             String q2="SELECT *FROM fixed_package WHERE Package_ID="+no+"";
             String q3="SELECT *FROM cus_menu WHERE Entry_ID="+no+"";
             String q4="SELECT *FROM decoration WHERE Item_ID="+no+"";
             //String q3="SELECT *FROM offers WHERE Offer_ID="+no+"";
            // String q4="SELECT *FROM fixed_package WHERE Package_ID="+no+"";
             System.out.println("im done");
            switch(q){
                case "q1" :
            this.pst= (com.mysql.jdbc.PreparedStatement) this.conn.prepareStatement(q1);
            pst.execute(); 
            model.setModel(DbUtils.resultSetToTableModel(table));
            break;
                case "q2" :
                this.pst= (com.mysql.jdbc.PreparedStatement) this.conn.prepareStatement(q2);
            pst.execute(); 
            model.setModel(DbUtils.resultSetToTableModel(table));
            break;
            case "q3" :
                this.pst= (com.mysql.jdbc.PreparedStatement) this.conn.prepareStatement(q3);
            pst.execute(); 
            model.setModel(DbUtils.resultSetToTableModel(table));
            break;
            case "q4" :
                this.pst= (com.mysql.jdbc.PreparedStatement) this.conn.prepareStatement(q4);
            pst.execute(); 
            model.setModel(DbUtils.resultSetToTableModel(table));
            break;
            }
         
         }catch(Exception e){
            System.out.println(e);
         }
      }

//////////////////////////////////
 public String getIDFromCombo(String TcolumnName1,String TableName,String Tid,JComboBox combo){
            String pide=null;
        try{
            String row=combo.getSelectedItem().toString();
            String sq = "SELECT '"+TcolumnName1+"' FROM '"+TableName+"' WHERE '"+Tid+"'='"+row+"'";
            pst =conn.prepareStatement(sq);
            table = pst.executeQuery();
            if(table.next())
            {
                pide=table.getString(TcolumnName1);
            }
            
            }catch(Exception e){
                System.out.println(e);
            }
        return pide;
    }
 
}
       

