package Resturant;

import dbconnect.dbconnect;
import java.awt.Color;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import java.util.GregorianCalendar;
import net.proteanit.sql.DbUtils;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sulakshana
 */
public class kot extends javax.swing.JInternalFrame {

    /**
     * Creates new form kot
     */
            Connection conn = null;
  PreparedStatement pst = null;
  
  ResultSet rs = null;   //get data base data and save all data in re variable

  
    public kot() {
        initComponents();
        
        
        
         conn = dbconnect.connect();//connect to Db when page is open
        tableload();//load table


    
    }
  public void tableload()//mrthod for gat data nto table
    {
        try {
               String sql = "SELECT ItemCode,ItemName,qty,TableNo FROM kot_orders";  //get values from table viewitemlist
        pst=conn.prepareStatement(sql); 
        
      rs=  pst.executeQuery();  //to eexecute Query and result save in rs 
      
  //       table123.setModel(DbUtils.resultSetToTableModel(rs));

      
      
      
      
        } catch (Exception e) 
            
   
        {
System.out.println("HEllo");            
        }
           
        
    }
   public String currentday() {
        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int yr = cal.get(Calendar.YEAR);
        int day = cal.get(Calendar.DAY_OF_MONTH);

        return (yr + "-" + (month + 1) + "-" + day);

    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jComboBox1 = new javax.swing.JComboBox();
        waitername1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        kotno12 = new javax.swing.JTextField();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        jLabel3 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1600, 900));
        setPreferredSize(new java.awt.Dimension(1600, 900));
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        getContentPane().add(jComboBox1, new org.netbeans.lib.awtextra.AbsoluteConstraints(870, 80, 90, 30));
        getContentPane().add(waitername1, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 90, 170, 27));

        jLabel6.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel6.setText("Waiter Name");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 50, 180, 27));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton1.setText("Add Items");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(610, 160, 170, 40));

        jLabel2.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel2.setText("KOT No");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 60, 120, 27));

        jLabel1.setFont(new java.awt.Font("Comic Sans MS", 1, 24)); // NOI18N
        jLabel1.setText("Table No");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 40, 120, 27));

        jLabel5.setFont(new java.awt.Font("PMingLiU-ExtB", 0, 30)); // NOI18N
        jLabel5.setText("KOT Order");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(650, 20, 190, -1));
        getContentPane().add(kotno12, new org.netbeans.lib.awtextra.AbsoluteConstraints(40, 90, 80, 27));

        jDesktopPane1.setPreferredSize(new java.awt.Dimension(750, 400));

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 710, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 350, Short.MAX_VALUE)
        );

        getContentPane().add(jDesktopPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 220, 710, 350));

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/body.jpg"))); // NOI18N
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1590, 870));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
//       String a1=cusname12.getText();
        String a2=waitername1.getText();
        //String a3=tableno.getText();
        String a3=jComboBox1.getSelectedItem().toString();
        jDesktopPane1.removeAll();
       kotOrderItemAdd kot__ = new kotOrderItemAdd(a2,a3);
       jDesktopPane1.add(kot__).setVisible(true);
       
       
       tableload();//load table
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    public javax.swing.JTextField kotno12;
    public javax.swing.JTextField waitername1;
    // End of variables declaration//GEN-END:variables
}
