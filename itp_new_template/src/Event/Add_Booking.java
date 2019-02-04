/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Event;

import dbconnect.dbconnect;
import java.awt.Color;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.SpinnerDateModel;
import net.proteanit.sql.DbUtils;
import java.util.Calendar;
import javax.swing.JComboBox;
import javax.swing.JSpinner;

/**
 *
 * @author HP™
 */
public class Add_Booking extends javax.swing.JInternalFrame {
    
    PreparedStatement pst=null;
    Connection conn=null;
    ResultSet table=null;
    EventClass ac=new EventClass(dbconnect.connect()); 
    /**
    
     */
    public Add_Booking() {
        initComponents();
        conn=dbconnect.connect();
        this.setBorder(null);
        addCombo();
        addVehicleCombo();
        //////////////////////////////////////////////////////////////////////
        
     ///////////////////////////////////////////////////////////////////////////////////
    }
    ///To get the vehicle id num from the combo box
    public String getIDFromCombo(){
            String pide=null;
        try{
            String row=vehiCombo.getSelectedItem().toString();
            String sq = "SELECT Vehicle_ID FROM wedd_car_detail WHERE Wedd_Car='"+row+"'";
            pst =conn.prepareStatement(sq);
            table = pst.executeQuery();
            if(table.next())
            {
                pide=table.getString("Vehicle_ID");
            }
            
            }catch(Exception e){
                System.out.println(e);
            }
        return pide;
    }
    /////To add  package names to a combo box
    public void addCombo(){
        try
        {
            String Sql = "SELECT  Package_Name FROM fixed_package ";
            this.pst= (com.mysql.jdbc.PreparedStatement) this.conn.prepareStatement(Sql);
            table=pst.executeQuery();
            while(table.next())
            {
                menuS.addItem(table.getString("Package_Name"));
            }
        }
        catch(Exception e){
            System.out.println("Combo Box Loading Error : "+e);
        }
    }
 //////////////To load vehicle Table//////////////////
       public void tableLoadVehicle()
      {  
         
         try{
            String  sq="SELECT *FROM wedd_car_detail";
            pst =conn.prepareStatement(sq);
            table = pst.executeQuery();
            OTHERfacilities.setModel(DbUtils.resultSetToTableModel(table));
         }catch(Exception e){
             
         }
      }
/////////////////////// To  load vehicle booking table/////////        
     public void tableLoadVehicleBooking()
      {  
         
         try{
            String  sq="SELECT *FROM vehicle_booking";
            pst =conn.prepareStatement(sq);
            table = pst.executeQuery();
            OTHERfacilities.setModel(DbUtils.resultSetToTableModel(table));
         }catch(Exception e){
             
         }
      }
         
    
 ////////////////////////////////////To add vehicle names to a combo box////////////////////   
     public void addVehicleCombo(){
        try
        {
            String Sql = "SELECT  Wedd_Car FROM wedd_car_detail ";
            this.pst= (com.mysql.jdbc.PreparedStatement) this.conn.prepareStatement(Sql);
            table=pst.executeQuery();
            while(table.next())
            {
               vehiCombo.addItem(table.getString("Wedd_Car"));
            }
        }
        catch(Exception e){
            System.out.println("Combo Box Loading Error : "+e);
        }
    }

 ///////////////////////////Table load method of fixedPackage///////////////////    
    public void tableLoad (int i){
            int a=i;
            String sq=null;
            Add_Booking s =new Add_Booking();
            String d=getPID();
        try{
            if(a==1){
                sq = "SELECT *FROM fixed_package WHERE Package_ID="+d+"";
                pst =conn.prepareStatement(sq);
                table = pst.executeQuery();
                menuT.setModel(DbUtils.resultSetToTableModel(table));
                }
            
            else{
                sq="SELECT *FROM cus_menu";
                pst =conn.prepareStatement(sq);
                table = pst.executeQuery();
                menuT.setModel(DbUtils.resultSetToTableModel(table));
                }
            }catch(Exception e){
            }
        }
    
          
     
 //////////////////////////////////To get id by using combobox selectted items////////////////    
    public String getPID(){
            String pide=null;
        try{
            String row=menuS.getSelectedItem().toString();
            String sq = "SELECT Package_ID FROM fixed_package WHERE Package_Name='"+row+"'";
            pst =conn.prepareStatement(sq);
            table = pst.executeQuery();
            if(table.next())
            {
                pide=table.getString("Package_ID");
            }
            
            }catch(Exception e){
                System.out.println(e);
            }
        return pide;
    }
//////////////////////////////Table load method of decoration/////////////////
    public void tableLoad()
    {
         try{
                String  sq="SELECT *FROM decoration";
                pst =conn.prepareStatement(sq);
                table = pst.executeQuery();
                menuT2.setModel(DbUtils.resultSetToTableModel(table));
            }catch(Exception e){
             
            }
           
    }
    /////////////////////////////////////////////////////////
     public static boolean ValidatePhone(String input){
         
      return input.charAt(0)== '0' && input.length()== 10; //&& input.matches("[0-9+]");
     }     
    ///////////////////////////////////////////////////// 
      public static boolean ValidateNIC(String input){
         
      return  input.length()== 10 &&input.charAt(9)== 'v';
      }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel8 = new javax.swing.JLabel();
        jPanel1 = new javax.swing.JPanel();
        jLabel28 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jSeparator3 = new javax.swing.JSeparator();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        jScrollPane1 = new javax.swing.JScrollPane();
        menuT = new javax.swing.JTable();
        jScrollPane2 = new javax.swing.JScrollPane();
        menuT2 = new javax.swing.JTable();
        menuS = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel1 = new javax.swing.JLabel();
        subtot = new javax.swing.JLabel();
        jSeparator2 = new javax.swing.JSeparator();
        jLabel3 = new javax.swing.JLabel();
        sc1 = new javax.swing.JCheckBox();
        sc2 = new javax.swing.JCheckBox();
        jLabel4 = new javax.swing.JLabel();
        tot = new javax.swing.JLabel();
        jSeparator5 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        total = new javax.swing.JLabel();
        jSeparator7 = new javax.swing.JSeparator();
        jSeparator8 = new javax.swing.JSeparator();
        jLabel12 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        guestc = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel13 = new javax.swing.JLabel();
        pname = new javax.swing.JLabel();
        rice = new javax.swing.JLabel();
        curry = new javax.swing.JLabel();
        salad = new javax.swing.JLabel();
        dessert = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        C_name = new javax.swing.JTextField();
        C_NIC = new javax.swing.JTextField();
        jLabel20 = new javax.swing.JLabel();
        jLabel21 = new javax.swing.JLabel();
        E_type = new javax.swing.JComboBox<>();
        jLabel22 = new javax.swing.JLabel();
        pid = new javax.swing.JLabel();
        jSeparator9 = new javax.swing.JSeparator();
        jLabel24 = new javax.swing.JLabel();
        jSeparator10 = new javax.swing.JSeparator();
        jLabel26 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        drink = new javax.swing.JLabel();
        deco = new javax.swing.JLabel();
        selectedMenu = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        Total = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        C_contact = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        extra_info = new javax.swing.JTextArea();
        E_Date = new com.toedter.calendar.JDateChooser();
        Date date=new Date();
        SpinnerDateModel sm =new SpinnerDateModel(date,null,null,Calendar.HOUR_OF_DAY);
        E_Time = new javax.swing.JSpinner(sm);
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel17 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        errormessage2 = new javax.swing.JLabel();
        errormessage1 = new javax.swing.JLabel();
        errormessage3 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jSeparator12 = new javax.swing.JSeparator();
        jSeparator11 = new javax.swing.JSeparator();
        jScrollPane4 = new javax.swing.JScrollPane();
        OTHERfacilities = new javax.swing.JTable();
        vehiCombo = new javax.swing.JComboBox<>();
        vehi_date = new com.toedter.calendar.JDateChooser();
        jLabel38 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel34 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        costcounted = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        status = new javax.swing.JLabel();
        avaMSG = new javax.swing.JLabel();
        daycount = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        VehicleBooking = new javax.swing.JButton();
        viewVbooked = new javax.swing.JButton();
        jLabel32 = new javax.swing.JLabel();
        backgroungIMG = new javax.swing.JLabel();

        jLabel8.setText("jLabel8");

        setMinimumSize(new java.awt.Dimension(1600, 920));
        setPreferredSize(new java.awt.Dimension(1600, 920));
        getContentPane().setLayout(null);

        jPanel1.setMinimumSize(new java.awt.Dimension(1600, 890));
        jPanel1.setPreferredSize(new java.awt.Dimension(1600, 890));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel28.setText("Vehicle Booking");
        jPanel1.add(jLabel28, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 660, 140, 20));

        jPanel4.setBackground(new java.awt.Color(255, 255, 255));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        jPanel4.add(jSeparator3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 130, 10));

        menuT.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        menuT.setFillsViewportHeight(true);
        menuT.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuTMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(menuT);

        jTabbedPane1.addTab("Food", jScrollPane1);

        menuT2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        menuT2.setFillsViewportHeight(true);
        menuT2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                menuT2MouseClicked(evt);
            }
        });
        jScrollPane2.setViewportView(menuT2);

        jTabbedPane1.addTab("Decoration", jScrollPane2);

        jPanel4.add(jTabbedPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 10, 850, 220));

        menuS.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Menu Selection", " ", "Custermerised Menu" }));
        menuS.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                menuSActionPerformed(evt);
            }
        });
        jPanel4.add(menuS, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 140, 30));

        jSeparator1.setForeground(new java.awt.Color(255, 255, 255));
        jSeparator1.setOrientation(javax.swing.SwingConstants.VERTICAL);
        jPanel4.add(jSeparator1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1520, 20, 10, 210));

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel1.setText("Sub Total (One Person)");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 20, -1, -1));
        jPanel4.add(subtot, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 20, 130, 20));
        jPanel4.add(jSeparator2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 50, 310, 10));
        jPanel4.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 100, -1, -1));

        sc1.setText("Service Charge  :");
        sc1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sc1MouseClicked(evt);
            }
        });
        jPanel4.add(sc1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 50, -1, -1));

        sc2.setText("Tax     :");
        sc2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                sc2MouseClicked(evt);
            }
        });
        jPanel4.add(sc2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 80, -1, -1));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel4.setText("Total (One Person )");
        jPanel4.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 120, -1, -1));
        jPanel4.add(tot, new org.netbeans.lib.awtextra.AbsoluteConstraints(1300, 120, 140, 30));
        jPanel4.add(jSeparator5, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 150, 320, 10));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel6.setText("Guest Count ");
        jPanel4.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 170, -1, -1));
        jPanel4.add(total, new org.netbeans.lib.awtextra.AbsoluteConstraints(1310, 200, 90, 20));
        jPanel4.add(jSeparator7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 230, 320, 10));
        jPanel4.add(jSeparator8, new org.netbeans.lib.awtextra.AbsoluteConstraints(1080, 250, 320, 10));

        jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Event/images/give-money.png"))); // NOI18N
        jPanel4.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(1480, 190, 50, 40));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel2.setText("Total");
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 200, 60, 20));

        guestc.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                guestcKeyReleased(evt);
            }
        });
        jPanel4.add(guestc, new org.netbeans.lib.awtextra.AbsoluteConstraints(1220, 170, 210, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 20, 1550, 250));

        jPanel3.setBackground(new java.awt.Color(255, 255, 255));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setText(" Menu NO");
        jPanel3.add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 90, -1));

        pname.setFont(new java.awt.Font("Tahoma", 3, 14)); // NOI18N
        pname.setText("Selected Package Name");
        jPanel3.add(pname, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 10, 190, -1));
        jPanel3.add(rice, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 60, 190, 20));
        jPanel3.add(curry, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 90, 190, 20));
        jPanel3.add(salad, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 120, 200, 20));
        jPanel3.add(dessert, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 150, 180, 20));

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel19.setText("Customer Name ");
        jPanel3.add(jLabel19, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 30, 120, 20));

        jButton1.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Event/images/cloud-computing.png"))); // NOI18N
        jButton1.setText("Pick Selected Menu");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 250, 220, 40));

        C_name.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(C_name, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 50, 280, 30));

        C_NIC.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel3.add(C_NIC, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 120, 280, 30));

        jLabel20.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel20.setText("Customer NIC  ");
        jPanel3.add(jLabel20, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 90, -1, 20));

        jLabel21.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel21.setText("Event Ttpe ");
        jPanel3.add(jLabel21, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 160, -1, 20));

        E_type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "------Type---------", "Wedding", "Party" }));
        E_type.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                E_typeActionPerformed(evt);
            }
        });
        jPanel3.add(E_type, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 190, 280, 30));

        jLabel22.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel22.setText("Menu No ");
        jPanel3.add(jLabel22, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 240, -1, 20));
        jPanel3.add(pid, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 200, 20));
        jPanel3.add(jSeparator9, new org.netbeans.lib.awtextra.AbsoluteConstraints(380, 270, 290, 10));

        jLabel24.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel24.setText("Event Date ");
        jPanel3.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 160, -1, 20));
        jPanel3.add(jSeparator10, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 80, 280, 10));

        jLabel26.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel26.setText("Event  Time ");
        jPanel3.add(jLabel26, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 220, -1, 20));

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Event/images/agreement.png"))); // NOI18N
        jButton2.setText("Confirm Booking");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 180, 290, 40));

        jButton3.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Event/images/three-circling-arrows.png"))); // NOI18N
        jButton3.setText("Clear ");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 230, 290, 40));
        jPanel3.add(drink, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 180, 190, 20));
        jPanel3.add(deco, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 210, 180, 30));

        selectedMenu.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        selectedMenu.setMaximumSize(new java.awt.Dimension(5, 5));
        jPanel3.add(selectedMenu, new org.netbeans.lib.awtextra.AbsoluteConstraints(500, 230, 140, 30));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel5.setText("Total ");
        jPanel3.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 50, 40, 20));
        jPanel3.add(Total, new org.netbeans.lib.awtextra.AbsoluteConstraints(940, 50, 80, 20));

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel7.setText("Customer contact Number");
        jPanel3.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 90, -1, 20));

        C_contact.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                C_contactMouseClicked(evt);
            }
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                C_contactMouseReleased(evt);
            }
        });
        C_contact.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                C_contactKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                C_contactKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                C_contactKeyTyped(evt);
            }
        });
        jPanel3.add(C_contact, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 120, 290, 30));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel9.setText(" Extra Information");
        jPanel3.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 50, 110, 20));

        extra_info.setColumns(20);
        extra_info.setRows(5);
        jScrollPane3.setViewportView(extra_info);

        jPanel3.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 80, 290, 80));

        E_Date.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                E_DateMouseClicked(evt);
            }
        });
        E_Date.addInputMethodListener(new java.awt.event.InputMethodListener() {
            public void caretPositionChanged(java.awt.event.InputMethodEvent evt) {
                E_DateCaretPositionChanged(evt);
            }
            public void inputMethodTextChanged(java.awt.event.InputMethodEvent evt) {
            }
        });
        E_Date.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                E_DateKeyReleased(evt);
            }
        });
        jPanel3.add(E_Date, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 190, 290, 30));

        JSpinner.DateEditor de=new JSpinner.DateEditor(E_Time,"HH:mm:ss");
        E_Time.setEditor(de);
        E_Time.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                E_TimeMouseClicked(evt);
            }
        });
        jPanel3.add(E_Time, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 240, 290, 30));

        jLabel14.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel14.setText("Drink");
        jPanel3.add(jLabel14, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 180, 60, 20));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel15.setText("Rice");
        jPanel3.add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 60, 80, 20));

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel16.setText("Curry");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 90, 60, 20));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Salad");
        jPanel3.add(jLabel17, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 120, 60, -1));

        jLabel18.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel18.setText("Dessert");
        jPanel3.add(jLabel18, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 154, 60, 20));
        jPanel3.add(jLabel23, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 10, 140, -1));

        jLabel11.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel11.setText("Decoration");
        jPanel3.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 220, 70, -1));

        errormessage2.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(errormessage2, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 90, 150, 20));

        errormessage1.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(errormessage1, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 90, 130, 20));

        errormessage3.setForeground(new java.awt.Color(255, 0, 0));
        jPanel3.add(errormessage3, new org.netbeans.lib.awtextra.AbsoluteConstraints(910, 170, 110, -1));

        jLabel33.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Event/images/add-button-inside-black-circle.png"))); // NOI18N
        jPanel3.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(1140, 180, -1, -1));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 290, 1550, 300));

        jLabel25.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel25.setText("Other Facilities");
        jPanel1.add(jLabel25, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 620, -1, -1));
        jPanel1.add(jSeparator12, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 650, 140, 10));
        jPanel1.add(jSeparator11, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 690, 150, 10));

        OTHERfacilities.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        jScrollPane4.setViewportView(OTHERfacilities);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 620, 870, 160));

        vehiCombo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                vehiComboActionPerformed(evt);
            }
        });
        jPanel1.add(vehiCombo, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 620, 200, 30));
        jPanel1.add(vehi_date, new org.netbeans.lib.awtextra.AbsoluteConstraints(1250, 660, 200, 30));

        jLabel38.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Event/images/volkswagen-car-side-view.png"))); // NOI18N
        jPanel1.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, -1, -1));

        jLabel27.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel27.setText("Select Vehicle");
        jPanel1.add(jLabel27, new org.netbeans.lib.awtextra.AbsoluteConstraints(1160, 620, 80, 20));

        jPanel5.setBackground(new java.awt.Color(255, 255, 255));
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel34.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel34.setText("Date");
        jPanel5.add(jLabel34, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 60, 60, -1));

        jLabel37.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jLabel37.setText("No Of Days");
        jPanel5.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 170, -1, -1));
        jPanel5.add(costcounted, new org.netbeans.lib.awtextra.AbsoluteConstraints(1390, 210, 90, 30));

        jPanel2.setBackground(new java.awt.Color(255, 255, 255));
        jPanel2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jPanel2MouseClicked(evt);
            }
        });
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setText("Availability");
        jPanel2.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 70, 30));

        status.setText("Status");
        jPanel2.add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(120, 30, 150, 30));

        avaMSG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Event/images/eye.png"))); // NOI18N
        avaMSG.setText(" Click here");
        jPanel2.add(avaMSG, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, -1, 30));

        jPanel5.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 90, 280, -1));

        daycount.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseReleased(java.awt.event.MouseEvent evt) {
                daycountMouseReleased(evt);
            }
        });
        daycount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                daycountActionPerformed(evt);
            }
        });
        jPanel5.add(daycount, new org.netbeans.lib.awtextra.AbsoluteConstraints(1210, 160, 220, 30));

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Event/images/give-money.png"))); // NOI18N
        jButton4.setText("Cost");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 210, 210, 40));

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Event/images/volkswagen-car-side-view.png"))); // NOI18N
        jButton5.setText("View Vehicle Details");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(600, 190, 210, 40));

        VehicleBooking.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        VehicleBooking.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Event/images/cloud-computing.png"))); // NOI18N
        VehicleBooking.setText("get Vehicle");
        VehicleBooking.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                VehicleBookingActionPerformed(evt);
            }
        });
        jPanel5.add(VehicleBooking, new org.netbeans.lib.awtextra.AbsoluteConstraints(810, 190, 220, 40));

        viewVbooked.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        viewVbooked.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Event/images/eye.png"))); // NOI18N
        viewVbooked.setText("    View booking table");
        viewVbooked.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                viewVbookedActionPerformed(evt);
            }
        });
        jPanel5.add(viewVbooked, new org.netbeans.lib.awtextra.AbsoluteConstraints(360, 190, 240, 40));

        jLabel32.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Event/images/volkswagen-car-side-view.png"))); // NOI18N
        jPanel5.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 50, 40, 30));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(30, 610, 1550, 260));

        backgroungIMG.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Event/images/body.jpg"))); // NOI18N
        backgroungIMG.setText("jLabel33");
        backgroungIMG.setMaximumSize(new java.awt.Dimension(1600, 890));
        backgroungIMG.setMinimumSize(new java.awt.Dimension(1600, 890));
        backgroungIMG.setPreferredSize(new java.awt.Dimension(1600, 890));
        jPanel1.add(backgroungIMG, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 1590, 890));

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-10, 0, 1600, 890);

        setBounds(-10, -20, 1600, 920);
    }// </editor-fold>//GEN-END:initComponents

    private void menuSActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_menuSActionPerformed
   
            String p=menuS.getSelectedItem().toString();
        if(p=="Custermerised Menu"){
                tableLoad (2);
                tableLoad();
        }else{
                tableLoad (1);
                tableLoad();
        }
        
    }//GEN-LAST:event_menuSActionPerformed

    private void menuTMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuTMouseClicked
        
        
            if(menuS.getSelectedItem()=="Custermerised Menu"){
       
        try {
             int row=menuT.getSelectedRow();
             String no=menuT.getModel().getValueAt(row, 0).toString();
             String b="select *FROM cus_menu where Entry_ID="+no+"";
             pst=conn.prepareStatement(b);
             table=pst.executeQuery();
            if(table.next())
             {
                pid.setText(no);
                pname.setText("Custermerised Menu");
                rice.setText(table.getString("C_Rice"));
                curry.setText(table.getString("C_Curry"));
                salad.setText(table.getString("C_Salad"));
                dessert.setText(table.getString("C_Dessert"));
             subtot.setText(table.getString("Priceper_Person"));
                drink.setText(table.getString("C_Drink"));
              //deco.setText(table.getString("Item_Name"));
             }
        }catch (SQLException ex) {
             Logger.getLogger(Add_Booking.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
            else{
        
         try {
             
             int row=menuT.getSelectedRow();
             String no=menuT.getModel().getValueAt(row, 0).toString();
             String b="select *from fixed_package where Package_ID='"+no+"'";
             pst=conn.prepareStatement(b);
             table=pst.executeQuery();
             
            if(table.next())
            {
                pid.setText(no);
                pname.setText(table.getString("Package_Name"));
                rice.setText(table.getString("Rice"));
                curry.setText(table.getString("Curry"));
                salad.setText(table.getString("Salad"));
                dessert.setText(table.getString("Dessert"));
                subtot.setText(table.getString("Priceper_Person"));
                drink.setText(table.getString("Drink"));
              //deco.setText(table.getString("Item_Name"));
            }
            } catch (SQLException ex) {
                Logger.getLogger(Add_Booking.class.getName()).log(Level.SEVERE, null, ex);
            }
        
        }                                               
    }//GEN-LAST:event_menuTMouseClicked

    private void sc1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sc1MouseClicked
        // TODO add your handling code here:
        try{
             String subtotal = subtot.getText();
           if(sc1.isSelected()&&!sc2.isSelected()){
                 
                // String subtotal = subtot.getText();
                int subtotal2=Integer.parseInt(subtotal);
                int prec=subtotal2+((subtotal2/100)*10);
                tot.setText(Integer.toString(prec));
          /* }
           else if(sc1.isSelected()){
               int subtotal3=Integer.parseInt(subtotal);
               int result=subtotal3+
               
              */ 
                
             }else{
              // String subtotal = subtot.getText();
                tot.setText(subtotal);
           }
               
       }catch(Exception e){
          System.out.println(e);
           
       }
                                            
    }//GEN-LAST:event_sc1MouseClicked

    private void sc2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_sc2MouseClicked
        // TODO add your handling code here:
        try{
             String subtotal = subtot.getText();
                int subtotal2=Integer.parseInt(subtotal);
                
           if(sc1.isSelected()&& sc2.isSelected()){
                 
                
                int prec=(subtotal2+((subtotal2/100)*10))+((subtotal2/100)*10);
                tot.setText(Integer.toString(prec));
                
          }else if(sc2.isSelected()&&! sc1.isSelected()){
                 
              
                int prec=(subtotal2+((subtotal2/100)*10));
                tot.setText(Integer.toString(prec));
             
               
           }else{
             
                tot.setText(subtotal);
           }
           
      }catch(Exception e){
         System.out.println(e);
      }                                           
    }//GEN-LAST:event_sc2MouseClicked

    private void guestcKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_guestcKeyReleased
        // TODO add your handling code here:
          String guestcount =guestc.getText();
          String totl = tot.getText();
             int tot2=Integer.parseInt(totl);
             int gc=Integer.parseInt(guestcount);
          if(guestcount!="null"){
          int T=(gc*tot2);
          total.setText(Integer.toString(T));
          
        /*  String veh=costcounted.getText();
          int veh2=Integer.parseInt(veh);
          int result=(T+veh2);
          withVehi.setText(Integer.toString(result));*/
           }
    }//GEN-LAST:event_guestcKeyReleased

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        selectedMenu.setText(pid.getText());
        Total.setText(total.getText());
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void menuT2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuT2MouseClicked
        // TODO add your handling code here:
        int row=menuT2.getSelectedRow();
             String no=menuT2.getModel().getValueAt(row, 1).toString();
             deco.setText(no);
    }//GEN-LAST:event_menuT2MouseClicked

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        
       EventClass ab= new EventClass(dbconnect.connect());
        
       String B1 = this.C_name.getText();
       String B2 = this.C_NIC.getText();
       String B3 = this.E_type.getSelectedItem().toString();
       String B4 = this.selectedMenu.getText();
       
       
       DateFormat df1=new SimpleDateFormat("yyyy-MM-dd");
        Date Edate1;
        Edate1=E_Date.getDate();
        String B5=df1.format(Edate1);
        System.out.println(B5);
        
        DateFormat tf=new SimpleDateFormat("HH:mm:ss");
        String B6=tf.format(new Date());
        System.out.println(B6);
       
       
      // String B5 = this.E_Date.getText();
      // String B6 = this.E_Time.getText();
       String B7 = this.Total.getText();
       String B8 = this.C_contact.getText();
       /////////////////////////////////////////////
       // String pvalidate=C_contact.getText();
       
       ///////////////////////////////////////////////////
       String B9 = this.extra_info.getText();
       String B10 = ac.getCurrentDate();
       
         DateFormat checkdate=new SimpleDateFormat("yyyy-MM-dd");
        Date Cdate;
        Cdate=E_Date.getDate();
        String dte=checkdate.format(Cdate);
        System.out.println(dte);
        
        String gcount=guestc.getText();
        System.out.println(gcount);
        
        if(dte.compareTo(ac.getCurrentDate())>0 ){
       
        String q =" INSERT INTO event_booking( Event_Type, Event_Date, Event_Time, Menu_NO,Guest_Count, Total,Booked_Date, Cus_Name, Cus_NIC, Cus_Contact, Extra) VALUES ('"+B3+"','"+B5+"','"+B6+"','"+B4+"',"+gcount+","+ B7 +",'"+B10+"','"+B1+"','"+B2+"',"+B8+",'"+B9+"')";
            
        // String pvalidate=C_contact.getText();
           if(ValidatePhone(B8)==false)
           {
           C_contact.setBackground(Color.red);
           errormessage1.setText("Invalid Date format !!");
           
       }else{
       
        if(ab.addData(q)==true)
        {    
            C_contact.setBackground(Color.WHITE);
            JOptionPane.showMessageDialog(null, "Event Booking Sucess");
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Event Booking Failed");
        }
        
           }
            
        }  
       
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:
        C_name.setText(null);
       C_NIC.setText(null);
       E_type.setSelectedIndex(0);
       selectedMenu.setText(null);
       E_Date.setDate(null);
        Total.setText(null);
       C_contact.setText(null);
       extra_info.setText(null);
      
    }//GEN-LAST:event_jButton3ActionPerformed

    private void E_DateMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_E_DateMouseClicked
        // TODO add your handling code here:
           String pvalidate=C_contact.getText();
           if(ValidatePhone(pvalidate)==false){
           C_contact.setBackground(Color.red);
           JOptionPane.showMessageDialog(null, "Invalid format of Phone Number");
       }
       
      
    }//GEN-LAST:event_E_DateMouseClicked

    private void E_DateKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_E_DateKeyReleased
        // TODO add your handling code here:
          DateFormat df1=new SimpleDateFormat("yyyy-MM-dd");
        Date Edate1;
        Edate1=E_Date.getDate();
        String dte=df1.format(Edate1);
        System.out.println(dte);
        if(dte.compareTo(ac.getCurrentDate())>0 ){
            
           JOptionPane.showMessageDialog(null, "Enter Valid Date"); 
        }
    }//GEN-LAST:event_E_DateKeyReleased

    private void E_DateCaretPositionChanged(java.awt.event.InputMethodEvent evt) {//GEN-FIRST:event_E_DateCaretPositionChanged
        // TODO add your handling code here:
          DateFormat df1=new SimpleDateFormat("yyyy-MM-dd");
        Date Edate1;
        Edate1=E_Date.getDate();
        String dte=df1.format(Edate1);
        System.out.println(dte);
        if(dte.compareTo(ac.getCurrentDate())>0 ){
            
           JOptionPane.showMessageDialog(null, "Enter Valid Date"); 
        }
    }//GEN-LAST:event_E_DateCaretPositionChanged

    private void jPanel2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jPanel2MouseClicked
        // TODO add your handling code here:
        DateFormat df1=new SimpleDateFormat("yyyy-MM-dd");
        Date Edate1;
        Edate1=vehi_date.getDate();
        String CarBookedDate=df1.format(Edate1);
        System.out.println(CarBookedDate);
            String row=vehiCombo.getSelectedItem().toString();
        
        
        String sts=null;
        String sql="SELECT Availability FROM wedd_car_detail WHERE Wedd_Car='"+vehiCombo+"' AND Date='"+ CarBookedDate+"'";
        try {
            pst=conn.prepareStatement(sql);
             table=pst.executeQuery();
             while(table.next()){
                 sts=table.getString("Availability");
             }
        } catch (SQLException ex) {
            Logger.getLogger(Add_Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
        if(sts== null){
            status.setText("NOT available/n sorry");
        }
        else{
           status.setText("available/n"); 
        }
        System.out.println(sts);    
    }//GEN-LAST:event_jPanel2MouseClicked

    private void vehiComboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_vehiComboActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_vehiComboActionPerformed

    private void daycountMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_daycountMouseReleased
        // TODO add your handling code here:
        String count=daycount.getText();
         int Icount=Integer.parseInt(count);
        String sql="SELECT Cost FROM wedd_car_detail WHERE Wedd_Car='"+vehiCombo+"'";
        try {
           
            pst=conn.prepareStatement(sql);
             table=pst.executeQuery();
             while(table.next()){
                 String sts=table.getString("Cost");
                 double Ists=Integer.parseInt(sts);
                 double fcost=(Icount*Ists);
               costcounted.setText(Double.toString(fcost));
             }
        } catch (SQLException ex) {
            Logger.getLogger(Add_Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }//GEN-LAST:event_daycountMouseReleased

    private void VehicleBookingActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_VehicleBookingActionPerformed
        // TODO add your handling code here:
        
       String vid= getIDFromCombo();
       
        DateFormat df1=new SimpleDateFormat("yyyy-MM-dd");
        Date Edate1;
        Edate1=vehi_date.getDate();
        String CarBookedDate=df1.format(Edate1);
        System.out.println(CarBookedDate);
        
         String B1 =costcounted.getText();
       String B2 = daycount.getText();
       String B3 = ac.getCurrentDate();
       String ni=C_NIC.getText();
       
       
      if(ni!= null){
       String q =" INSERT INTO vehicle_booking(Vehicle_ID,Customer_NIC,Cost_Calc,NoOfDays,Reserved_Date,Vbooked_Date) VALUES ('"+vid+"','"+ni+"','"+B1+"','"+B2+"','"+CarBookedDate+"','"+B3+"')";
            
        if(ac.addData(q)==true)
        {
            JOptionPane.showMessageDialog(null, "Data Adding Sucess");
         
        }
        else
        {
            JOptionPane.showMessageDialog(null, "Data Adding Failed");
        }
      }else{
          JOptionPane.showMessageDialog(null, "Customer NIC required!"); 
      }
                                            

    }//GEN-LAST:event_VehicleBookingActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
         String count=daycount.getText();
         int Icount=Integer.parseInt(count);
         String vid3=getIDFromCombo();//ac.getIDFromCombo("Vehicle_ID","wedd_car_detail","Wedd_Car",this.vehiCombo);
          System.out.println(vid3);
        String sql="SELECT Cost FROM wedd_car_detail WHERE Vehicle_ID='"+vid3+"'";
         String sts=null;
        try {
            
            pst=conn.prepareStatement(sql);
             table=pst.executeQuery();
             while(table.next()){
                 sts=table.getString("Cost");
                
             }
             System.out.println(sts);
             double Ists=Integer.parseInt(sts);
                 double fcost=(Icount*Ists);
               costcounted.setText(Double.toString(fcost));
        
        } catch (SQLException ex) {
            Logger.getLogger(Add_Booking.class.getName()).log(Level.SEVERE, null, ex);
        }
          String t=total.getText();
          int veh4=Integer.parseInt(t);
         String veh=costcounted.getText();
          int veh2=Integer.parseInt(veh);
          int result=(veh4+veh2);
          System.out.print("eeeeee");
//         withVehi.setText(Integer.toString(result));
        
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        tableLoadVehicle();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void viewVbookedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewVbookedActionPerformed
        // TODO add your handling code here:
        tableLoadVehicleBooking();
    }//GEN-LAST:event_viewVbookedActionPerformed

    private void E_typeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_E_typeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_E_typeActionPerformed

    private void daycountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_daycountActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_daycountActionPerformed

    private void C_contactMouseReleased(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C_contactMouseReleased
        // TODO add your handling code here:
        
    }//GEN-LAST:event_C_contactMouseReleased

    private void C_contactKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C_contactKeyReleased
        // TODO add your handling code here:
       
      
    }//GEN-LAST:event_C_contactKeyReleased

    private void C_contactKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C_contactKeyTyped
        // TODO add your handling code here:
       
      
         
    }//GEN-LAST:event_C_contactKeyTyped

    private void C_contactKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_C_contactKeyPressed
        // TODO add your handling code here:
       //int key=evt.getKeyLocation();
      // if(key==evt.VK_0&& key<=evt.VK_9||key==evt.VK_NUMPAD0&&key==evt.VK_NUMPAD9 ||key==keyEvent.)
      
    }//GEN-LAST:event_C_contactKeyPressed

    private void C_contactMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_C_contactMouseClicked
        // TODO add your handling code here:
         C_contact.setBackground(Color.WHITE);
         errormessage2.setText(null);
         
         
    }//GEN-LAST:event_C_contactMouseClicked

    private void E_TimeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_E_TimeMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_E_TimeMouseClicked
    

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField C_NIC;
    private javax.swing.JTextField C_contact;
    private javax.swing.JTextField C_name;
    private com.toedter.calendar.JDateChooser E_Date;
    private javax.swing.JSpinner E_Time;
    private javax.swing.JComboBox<String> E_type;
    private javax.swing.JTable OTHERfacilities;
    private javax.swing.JLabel Total;
    private javax.swing.JButton VehicleBooking;
    private javax.swing.JLabel avaMSG;
    private javax.swing.JLabel backgroungIMG;
    private javax.swing.JLabel costcounted;
    private javax.swing.JLabel curry;
    private javax.swing.JTextField daycount;
    private javax.swing.JLabel deco;
    private javax.swing.JLabel dessert;
    private javax.swing.JLabel drink;
    private javax.swing.JLabel errormessage1;
    private javax.swing.JLabel errormessage2;
    private javax.swing.JLabel errormessage3;
    private javax.swing.JTextArea extra_info;
    private javax.swing.JTextField guestc;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JSeparator jSeparator10;
    private javax.swing.JSeparator jSeparator11;
    private javax.swing.JSeparator jSeparator12;
    private javax.swing.JSeparator jSeparator2;
    private javax.swing.JSeparator jSeparator3;
    private javax.swing.JSeparator jSeparator5;
    private javax.swing.JSeparator jSeparator7;
    private javax.swing.JSeparator jSeparator8;
    private javax.swing.JSeparator jSeparator9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JComboBox<String> menuS;
    public javax.swing.JTable menuT;
    private javax.swing.JTable menuT2;
    private javax.swing.JLabel pid;
    private javax.swing.JLabel pname;
    private javax.swing.JLabel rice;
    private javax.swing.JLabel salad;
    private javax.swing.JCheckBox sc1;
    private javax.swing.JCheckBox sc2;
    private javax.swing.JLabel selectedMenu;
    private javax.swing.JLabel status;
    private javax.swing.JLabel subtot;
    private javax.swing.JLabel tot;
    private javax.swing.JLabel total;
    private javax.swing.JComboBox<String> vehiCombo;
    private com.toedter.calendar.JDateChooser vehi_date;
    private javax.swing.JButton viewVbooked;
    // End of variables declaration//GEN-END:variables
}
