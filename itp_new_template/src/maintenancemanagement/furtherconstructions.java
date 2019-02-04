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
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

/**
 *
 * @author Shihan
 */
public class furtherconstructions extends javax.swing.JInternalFrame {
    String aa=null;
    Connection con =null;
    PreparedStatement pst =null;
    ResultSet rs = null;
    maintenanceclass m=new maintenanceclass();
    
    public furtherconstructions() {
        initComponents();
        con=dbconnect.connect();
        viewtable();
    }

public void viewtable()
    {
         String sqbuild="SELECT * FROM furtherconstructions";
            
            try{
                    pst=con.prepareStatement(sqbuild);
                    pst.execute();
                    rs=pst.executeQuery();
                    frthrtable.setModel(DbUtils.resultSetToTableModel(rs));
    
            }
            catch(Exception e){
                   
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

        jScrollPane3 = new javax.swing.JScrollPane();
        frthrtable = new javax.swing.JTable();
        jLabel3 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        des = new javax.swing.JTextArea();
        jLabel1 = new javax.swing.JLabel();
        date = new com.toedter.calendar.JDateChooser();
        jLabel19 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        bldr = new javax.swing.JTextArea();
        jLabel17 = new javax.swing.JLabel();
        amnt = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        printfc = new javax.swing.JButton();
        updt = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 204));
        setMinimumSize(new java.awt.Dimension(1920, 1080));
        setPreferredSize(new java.awt.Dimension(1920, 1080));
        getContentPane().setLayout(null);

        frthrtable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "EntryID", "Descreption", "Date", "Builder Details", "Amount"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Object.class, java.lang.Float.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        frthrtable.setRowHeight(30);
        frthrtable.setSelectionBackground(new java.awt.Color(0, 0, 0));
        frthrtable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                frthrtableMouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(frthrtable);

        getContentPane().add(jScrollPane3);
        jScrollPane3.setBounds(30, 60, 890, 350);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 24)); // NOI18N
        jLabel3.setText("Further Construction Details");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(1060, 12, 350, 30);

        jLabel18.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel18.setText("Descreption :");
        getContentPane().add(jLabel18);
        jLabel18.setBounds(1060, 70, 120, 25);

        des.setColumns(20);
        des.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        des.setRows(5);
        jScrollPane2.setViewportView(des);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(1200, 70, 330, 81);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Date");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(1060, 160, 120, 25);
        getContentPane().add(date);
        date.setBounds(1200, 160, 330, 40);

        jLabel19.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel19.setText("Builder Details :");
        getContentPane().add(jLabel19);
        jLabel19.setBounds(1060, 210, 130, 25);

        bldr.setColumns(20);
        bldr.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        bldr.setRows(5);
        bldr.setMinimumSize(new java.awt.Dimension(204, 79));
        jScrollPane1.setViewportView(bldr);

        getContentPane().add(jScrollPane1);
        jScrollPane1.setBounds(1200, 210, 330, 81);

        jLabel17.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel17.setText("Amount :");
        getContentPane().add(jLabel17);
        jLabel17.setBounds(1060, 300, 120, 26);

        amnt.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        amnt.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                amntKeyPressed(evt);
            }
        });
        getContentPane().add(amnt);
        amnt.setBounds(1200, 300, 330, 40);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/add.png"))); // NOI18N
        jButton1.setText("Add Entry");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(1200, 350, 130, 50);

        printfc.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        printfc.setText("Print Further Construction Details");
        getContentPane().add(printfc);
        printfc.setBounds(610, 10, 310, 40);

        updt.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        updt.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/update.png"))); // NOI18N
        updt.setText("Update");
        updt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                updtActionPerformed(evt);
            }
        });
        getContentPane().add(updt);
        updt.setBounds(1400, 350, 130, 50);

        jLabel2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Maintenance/Images/body.jpg"))); // NOI18N
        getContentPane().add(jLabel2);
        jLabel2.setBounds(-10, 0, 1920, 920);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String dscrptn=des.getText();
        
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        
        
        String bldrdtls=bldr.getText();
        String amount=amnt.getText();
        
        if(dscrptn.isEmpty()||df==null||bldrdtls.isEmpty()||amount.isEmpty())
        {
           JOptionPane.showMessageDialog(null, "Information Required, Please fill!");
        }
        else{
        int x=JOptionPane.showConfirmDialog(null,"Proceed?");
        if(x==0)
        {
            Date frthr;
            frthr=date.getDate();
            String frthrcns=df.format(frthr);
            m.frthradd(dscrptn,frthrcns,bldrdtls,amount);
        }
        viewtable();
        des.setText("");
        date.setDate(null);
        bldr.setText("");
        amnt.setText("");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

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

    private void frthrtableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_frthrtableMouseClicked
    try{
        int row=frthrtable.getSelectedRow();//select items to the fields
        aa=frthrtable.getModel().getValueAt(row, 0).toString();
        String a="select * from furtherconstructions where EntryID='"+aa+"'";
        pst=con.prepareStatement(a);
        rs=pst.executeQuery();
        if(rs.next()){
            des.setText(rs.getString("Descreption"));
            
            date.setDate(rs.getDate("Date"));
            bldr.setText(rs.getString("BuilderDetails"));
            amnt.setText(rs.getString("Amount"));
        }
        }
                catch(Exception ex)
        {
            System.out.println(ex);
            //Logger.getLogger(vehiclerepair.class.getName()).log(Level.SEVERE,null,ex);
        }
    }//GEN-LAST:event_frthrtableMouseClicked

    private void updtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_updtActionPerformed
        String dscrptn=des.getText();       
        
        DateFormat df=new SimpleDateFormat("yyyy-MM-dd");
        
        String bldrdtls=bldr.getText();
        
        String amount=amnt.getText();
        
        if(dscrptn.isEmpty()||df==null||bldrdtls.isEmpty()||amount.isEmpty())
        {
           JOptionPane.showMessageDialog(null, "Information Required, Please fill!");
        }
        else{
        
        Date frthrdate;
        frthrdate=date.getDate();
        String frthrdte=df.format(frthrdate);
        m.frthrupdt(dscrptn,frthrdte,bldrdtls,amount,aa);  
//            
            viewtable();
            des.setText("");
            
            bldr.setText("");
            date.setDate(null);
            amnt.setText("");
            JOptionPane.showMessageDialog(null, "Entry Updated!");
        }
    }//GEN-LAST:event_updtActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField amnt;
    private javax.swing.JTextArea bldr;
    private com.toedter.calendar.JDateChooser date;
    private javax.swing.JTextArea des;
    private javax.swing.JTable frthrtable;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JButton printfc;
    private javax.swing.JButton updt;
    // End of variables declaration//GEN-END:variables
}
