/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package maintenancemanagement;

import com.mysql.jdbc.Connection;
import com.sun.glass.events.KeyEvent;
import dbconnect.dbconnect;
import java.awt.Color;
import static java.awt.Color.red;
import static java.awt.Color.white;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import java.util.Date;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Shihan
 */
public class othermaintenance extends javax.swing.JInternalFrame {
    String aa=null;
    Connection con =null;
    PreparedStatement pst =null;
    ResultSet rs = null;
    maintenanceclass m=new maintenanceclass();
   
    public othermaintenance() {
        initComponents();
        con=dbconnect.connect();
        viewtable();
    }
           
    public void viewtable()
    {
         String sqbuild="SELECT * FROM othermaintenance";
            
            try{
                    pst=con.prepareStatement(sqbuild);
                    pst.execute();
                    rs=pst.executeQuery();
                    othrtable.setModel(DbUtils.resultSetToTableModel(rs));
    
            }
            catch(Exception e){
                    JOptionPane.showConfirmDialog(null, e);
            }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        othrtable = new javax.swing.JTable();
        jInternalFrame1 = new javax.swing.JInternalFrame();
        jLabel10 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        entryid1 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        type1 = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        jScrollPane3 = new javax.swing.JScrollPane();
        des1 = new javax.swing.JTextArea();
        jLabel11 = new javax.swing.JLabel();
        amount1 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jScrollPane4 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        updt = new javax.swing.JButton();
        amnt = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        des = new javax.swing.JTextArea();
        jLabel3 = new javax.swing.JLabel();
        type = new javax.swing.JComboBox<>();
        printo = new javax.swing.JButton();
        jLabel9 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 204));
        setMinimumSize(new java.awt.Dimension(1700, 950));
        setPreferredSize(new java.awt.Dimension(1700, 950));
        getContentPane().setLayout(null);

        othrtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "EntryID", "Type", "Descreption", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        othrtable.setRowHeight(30);
        othrtable.setSelectionBackground(new java.awt.Color(0, 0, 0));
        othrtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                othrtableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(othrtable);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(30, 80, 890, 290);

        jInternalFrame1.setBackground(new java.awt.Color(255, 255, 204));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Other Maintenance");

        jLabel6.setText("Entry ID :");

        jLabel7.setText("Type :");

        type1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-------------Select--------------", "Electric", "Furniture", "Plumbing" }));

        jLabel8.setText("Descreption :");

        des1.setColumns(20);
        des1.setRows(5);
        jScrollPane3.setViewportView(des1);

        jLabel11.setText("Amount :");

        jButton2.setText("Add Entry");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "EntryID", "Type", "Descreption", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane4.setViewportView(jTable2);

        javax.swing.GroupLayout jInternalFrame1Layout = new javax.swing.GroupLayout(jInternalFrame1.getContentPane());
        jInternalFrame1.getContentPane().setLayout(jInternalFrame1Layout);
        jInternalFrame1Layout.setHorizontalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addGap(70, 70, 70)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jInternalFrame1Layout.createSequentialGroup()
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame1Layout.createSequentialGroup()
                                .addGap(77, 77, 77)
                                .addComponent(jLabel10))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jInternalFrame1Layout.createSequentialGroup()
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(4, 4, 4)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(type1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(entryid1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGroup(jInternalFrame1Layout.createSequentialGroup()
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jButton2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(amount1, javax.swing.GroupLayout.PREFERRED_SIZE, 202, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(39, 39, 39))
        );
        jInternalFrame1Layout.setVerticalGroup(
            jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel10)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jInternalFrame1Layout.createSequentialGroup()
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jInternalFrame1Layout.createSequentialGroup()
                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(type1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(entryid1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jInternalFrame1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(amount1, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 247, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        getContentPane().add(jInternalFrame1);
        jInternalFrame1.setBounds(546, 264, 0, 0);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/add.png"))); // NOI18N
        jButton1.setText("Add Entry");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1160, 320, 130, 50);

        updt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/update.png"))); // NOI18N
        updt.setText("Update");
        updt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updtActionPerformed(evt);
            }
        });
        getContentPane().add(updt);
        updt.setBounds(1400, 320, 130, 50);

        amnt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        amnt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                amntKeyPressed(evt);
            }
        });
        getContentPane().add(amnt);
        amnt.setBounds(1160, 270, 370, 40);

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("Amount :");
        getContentPane().add(jLabel12);
        jLabel12.setBounds(1030, 270, 120, 25);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Date :");
        getContentPane().add(jLabel5);
        jLabel5.setBounds(1030, 220, 120, 25);
        getContentPane().add(date);
        date.setBounds(1160, 220, 370, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Descreption :");
        getContentPane().add(jLabel4);
        jLabel4.setBounds(1030, 120, 120, 25);

        des.setColumns(20);
        des.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        des.setRows(5);
        jScrollPane2.setViewportView(des);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(1160, 120, 370, 90);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Type :");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(1030, 70, 120, 25);

        type.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        type.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "--------------------------------------Select-------------------------------------", "Electric", "Furniture", "Plumbing" }));
        getContentPane().add(type);
        type.setBounds(1160, 65, 370, 40);

        printo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        printo.setText("Print Other Maintenance Details");
        getContentPane().add(printo);
        printo.setBounds(630, 40, 290, 30);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel9.setText("Other Maintenance Details");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(1030, 20, 370, 30);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Maintenance/Images/body.jpg"))); // NOI18N
        getContentPane().add(jLabel1);
        jLabel1.setBounds(-10, -6, 1600, 880);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String ty=type.getSelectedItem().toString();
        String dscrptn=des.getText();
       
        
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        
        
        String amount=amnt.getText();
        
        if(ty.isEmpty()||df==null||dscrptn.isEmpty()||amount.isEmpty())
        {
           JOptionPane.showMessageDialog(null, "Information Required, Please fill!");
        }
        else{
        int x=JOptionPane.showConfirmDialog(null,"Proceed?");
        if(x==0)
        {
            Date repdate;
            repdate=date.getDate();
            String repdte=df.format(repdate);     
           
            m.addothrmaintenance(ty,dscrptn,repdte,amount);
            
        }
        viewtable();
        type.setSelectedIndex(0);
        des.setText("");
        date.setDate(null);
        amnt.setText("");
        amnt.setBackground(white);
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jButton2ActionPerformed

    private void amntKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_amntKeyPressed
    int key= evt.getKeyCode();//validation
        if((key>=evt.VK_0 && key<=evt.VK_9)||(key>=evt.VK_NUMPAD0 && key<=evt.VK_NUMPAD9)||key==KeyEvent.VK_BACKSPACE){
            amnt.setEditable(true);
            amnt.setBackground(Color.white);   
        }
        else{
            getToolkit().beep();
            amnt.setEditable(false);
            amnt.setBackground(red);
            
        }
    }//GEN-LAST:event_amntKeyPressed

    private void othrtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_othrtableMouseClicked
    try{
        int row=othrtable.getSelectedRow();//select items to the fields
        aa=othrtable.getModel().getValueAt(row, 0).toString();
        String a="select * from othermaintenance where EntryID='"+aa+"'";
        pst=con.prepareStatement(a);
        rs=pst.executeQuery();
        if(rs.next()){
            
            type.setSelectedItem(rs.getString("RepairType"));
            
            des.setText(rs.getString("Descreption"));
            date.setDate(rs.getDate("Date"));
            amnt.setText(rs.getString("Amount"));
        }
        }
                catch(Exception ex)
        {
            System.out.println(ex);
            //Logger.getLogger(vehiclerepair.class.getName()).log(Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_othrtableMouseClicked

    private void updtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updtActionPerformed
        
        String ty=type.getSelectedItem().toString();
        String dscrptn=des.getText();
        
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        

        String amount=amnt.getText(); 

        if(ty.isEmpty()||df==null||dscrptn.isEmpty()||amount.isEmpty())
        {
           JOptionPane.showMessageDialog(null, "Information Required, Please fill!");
        }
        else{
        Date othrdate;
        othrdate=date.getDate();
        String othrdte=df.format(othrdate);
            
        m.updtothrmaintenance(ty,dscrptn,othrdte,amount,aa);

        viewtable();
        type.setSelectedIndex(0);
        des.setText("");
        date.setDate(null);
        amnt.setText("");
        amnt.setBackground(white);
        JOptionPane.showMessageDialog(null, "Entry Updated!");
        }
    }//GEN-LAST:event_updtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amnt;
    private javax.swing.JTextField amount1;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JTextArea des;
    private javax.swing.JTextArea des1;
    private javax.swing.JLabel entryid1;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JInternalFrame jInternalFrame1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JTable jTable2;
    private javax.swing.JTable othrtable;
    private javax.swing.JButton printo;
    private javax.swing.JComboBox<String> type;
    private javax.swing.JComboBox<String> type1;
    private javax.swing.JButton updt;
    // End of variables declaration//GEN-END:variables
}
