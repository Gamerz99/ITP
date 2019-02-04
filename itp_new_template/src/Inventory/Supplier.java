/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Inventory;

import com.mxrck.autocompleter.TextAutoCompleter;
import dbconnect.dbconnect;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import javax.swing.JOptionPane;
import javax.swing.table.JTableHeader;
import net.proteanit.sql.DbUtils;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

/**
 *
 * @author MUNESH
 */
public class Supplier extends javax.swing.JInternalFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;
    Inventory i = new Inventory();

    public Supplier() {
        initComponents();
        con = dbconnect.connect();
        search();
        suppliertable();

        JTableHeader theader = suppliertable.getTableHeader();
        theader.setFont(new Font("Tahoma", Font.BOLD, 14));
    }

    public void suppliertable() {
        try {
            String sql = "SELECT * FROM supplier";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();

            suppliertable.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {

        }
    }

    public void search() {
        TextAutoCompleter text = new TextAutoCompleter(searchbox);

        try {
            String sql = "SELECT FName FROM supplier";
            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            String n;
            while (rs.next()) {
                n = rs.getString("FName");
                text.addItem(n);
            }
        } catch (Exception e) {
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

        jPanel1 = new javax.swing.JPanel();
        idbox = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        fnamebox = new javax.swing.JTextField();
        lnamebox = new javax.swing.JTextField();
        addressline1box = new javax.swing.JTextField();
        addressline2box = new javax.swing.JTextField();
        addresscity = new javax.swing.JTextField();
        acbox = new javax.swing.JTextField();
        contactbox = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        suppliertable = new javax.swing.JTable();
        searchbox = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        bankbox = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();

        setBorder(null);
        setMinimumSize(new java.awt.Dimension(1600, 920));
        setPreferredSize(new java.awt.Dimension(1600, 920));
        getContentPane().setLayout(null);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setLayout(null);

        idbox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(idbox);
        idbox.setBounds(1270, 230, 280, 40);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Bank");
        jPanel1.add(jLabel4);
        jLabel4.setBounds(1100, 600, 39, 22);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("AC Number");
        jPanel1.add(jLabel3);
        jLabel3.setBounds(1100, 550, 90, 22);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("City");
        jPanel1.add(jLabel2);
        jLabel2.setBounds(1100, 500, 30, 22);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Last Name");
        jPanel1.add(jLabel1);
        jLabel1.setBounds(1100, 350, 83, 22);

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("First Name");
        jPanel1.add(jLabel6);
        jLabel6.setBounds(1100, 300, 84, 22);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Supplier ID");
        jPanel1.add(jLabel7);
        jLabel7.setBounds(1100, 250, 88, 22);

        fnamebox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        fnamebox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                fnameboxKeyPressed(evt);
            }
        });
        jPanel1.add(fnamebox);
        fnamebox.setBounds(1270, 280, 300, 40);

        lnamebox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lnamebox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                lnameboxKeyPressed(evt);
            }
        });
        jPanel1.add(lnamebox);
        lnamebox.setBounds(1270, 330, 300, 40);

        addressline1box.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addressline1box.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addressline1boxKeyPressed(evt);
            }
        });
        jPanel1.add(addressline1box);
        addressline1box.setBounds(1270, 380, 300, 40);

        addressline2box.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addressline2box.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addressline2boxActionPerformed(evt);
            }
        });
        addressline2box.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addressline2boxKeyPressed(evt);
            }
        });
        jPanel1.add(addressline2box);
        addressline2box.setBounds(1270, 430, 300, 40);

        addresscity.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        addresscity.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addresscityActionPerformed(evt);
            }
        });
        addresscity.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                addresscityKeyPressed(evt);
            }
        });
        jPanel1.add(addresscity);
        addresscity.setBounds(1270, 480, 300, 40);

        acbox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        acbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acboxActionPerformed(evt);
            }
        });
        acbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                acboxKeyPressed(evt);
            }
        });
        jPanel1.add(acbox);
        acbox.setBounds(1270, 530, 300, 40);

        contactbox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        contactbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                contactboxActionPerformed(evt);
            }
        });
        contactbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                contactboxKeyPressed(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                contactboxKeyTyped(evt);
            }
        });
        jPanel1.add(contactbox);
        contactbox.setBounds(1270, 630, 300, 40);

        jScrollPane1.setBackground(new java.awt.Color(255, 255, 204));
        jScrollPane1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        suppliertable.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        suppliertable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Supplier ID", "First Name", "L Name", "Address Line 1", "Address Line 2", "City", "Account Number", "Contact Number"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.Integer.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.Integer.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        suppliertable.setFillsViewportHeight(true);
        suppliertable.setGridColor(new java.awt.Color(204, 204, 204));
        suppliertable.setRowHeight(30);
        suppliertable.setRowMargin(0);
        suppliertable.setSelectionBackground(new java.awt.Color(51, 51, 51));
        suppliertable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                suppliertableMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(suppliertable);
        if (suppliertable.getColumnModel().getColumnCount() > 0) {
            suppliertable.getColumnModel().getColumn(0).setResizable(false);
            suppliertable.getColumnModel().getColumn(0).setPreferredWidth(80);
            suppliertable.getColumnModel().getColumn(1).setResizable(false);
            suppliertable.getColumnModel().getColumn(1).setPreferredWidth(120);
            suppliertable.getColumnModel().getColumn(2).setResizable(false);
            suppliertable.getColumnModel().getColumn(2).setPreferredWidth(120);
            suppliertable.getColumnModel().getColumn(3).setResizable(false);
            suppliertable.getColumnModel().getColumn(3).setPreferredWidth(170);
            suppliertable.getColumnModel().getColumn(4).setResizable(false);
            suppliertable.getColumnModel().getColumn(4).setPreferredWidth(160);
            suppliertable.getColumnModel().getColumn(5).setResizable(false);
            suppliertable.getColumnModel().getColumn(5).setPreferredWidth(100);
            suppliertable.getColumnModel().getColumn(6).setResizable(false);
            suppliertable.getColumnModel().getColumn(6).setPreferredWidth(180);
            suppliertable.getColumnModel().getColumn(7).setResizable(false);
            suppliertable.getColumnModel().getColumn(7).setPreferredWidth(150);
        }

        jPanel1.add(jScrollPane1);
        jScrollPane1.setBounds(30, 240, 1060, 610);

        searchbox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        searchbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchboxActionPerformed(evt);
            }
        });
        searchbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                searchboxKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                searchboxKeyReleased(evt);
            }
        });
        jPanel1.add(searchbox);
        searchbox.setBounds(310, 160, 370, 40);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Address Line 1");
        jPanel1.add(jLabel5);
        jLabel5.setBounds(1100, 400, 120, 22);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Address Line 2");
        jPanel1.add(jLabel8);
        jLabel8.setBounds(1100, 450, 120, 22);

        jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/textfield300.png"))); // NOI18N
        jLabel9.setText(" ");
        jPanel1.add(jLabel9);
        jLabel9.setBounds(1270, 230, 300, 40);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Contact Number");
        jPanel1.add(jLabel10);
        jLabel10.setBounds(1100, 650, 128, 22);

        bankbox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        bankbox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "People's bank", "Bank of ceylon", "Hatton national bank", "Sampath bank", "Pan asia bank", "Nation trust bank", "DFCC bank", "Comercial bank", "HSBC bank" }));
        bankbox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                bankboxKeyPressed(evt);
            }
        });
        jPanel1.add(bankbox);
        bankbox.setBounds(1270, 580, 300, 40);

        jButton1.setBackground(new java.awt.Color(255, 255, 255));
        jButton1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/update.png"))); // NOI18N
        jButton1.setText("Update");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1);
        jButton1.setBounds(1270, 800, 120, 50);

        jButton2.setBackground(new java.awt.Color(255, 255, 255));
        jButton2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/search.png"))); // NOI18N
        jButton2.setText("Search");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2);
        jButton2.setBounds(710, 150, 120, 50);

        jButton3.setBackground(new java.awt.Color(255, 255, 255));
        jButton3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/delete.png"))); // NOI18N
        jButton3.setText("Delete");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton3);
        jButton3.setBounds(1450, 800, 120, 50);

        jButton4.setBackground(new java.awt.Color(255, 255, 255));
        jButton4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/add.png"))); // NOI18N
        jButton4.setText("Add");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4);
        jButton4.setBounds(1100, 800, 120, 50);

        jButton5.setBackground(new java.awt.Color(255, 255, 255));
        jButton5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/print.png"))); // NOI18N
        jButton5.setText("Print");
        jButton5.setBorder(javax.swing.BorderFactory.createEmptyBorder(1, 1, 1, 1));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton5);
        jButton5.setBounds(970, 150, 120, 50);

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/body.jpg"))); // NOI18N
        jLabel11.setText(" ");
        jPanel1.add(jLabel11);
        jLabel11.setBounds(0, 0, 1600, 890);

        getContentPane().add(jPanel1);
        jPanel1.setBounds(-1, -1, 1600, 890);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void fnameboxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_fnameboxKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            lnamebox.requestFocusInWindow();
        }
        if ((key >= evt.VK_A && key <= evt.VK_Z) || key == KeyEvent.VK_BACK_SPACE || key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_ENTER) {
            fnamebox.setEditable(true);
            fnamebox.setBackground(Color.white);
        } else {
            getToolkit().beep();
            fnamebox.setEditable(false);
            fnamebox.setBackground(Color.LIGHT_GRAY);
        }

    }//GEN-LAST:event_fnameboxKeyPressed

    private void lnameboxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_lnameboxKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            addressline1box.requestFocusInWindow();
        }
        if ((key >= evt.VK_A && key <= evt.VK_Z) || key == KeyEvent.VK_BACK_SPACE || key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_ENTER) {
            lnamebox.setEditable(true);
            lnamebox.setBackground(Color.white);
        } else {
            getToolkit().beep();
            lnamebox.setEditable(false);
            lnamebox.setBackground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_lnameboxKeyPressed

    private void addressline1boxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addressline1boxKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            addressline2box.requestFocusInWindow();
        }
    }//GEN-LAST:event_addressline1boxKeyPressed

    private void addressline2boxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addressline2boxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addressline2boxActionPerformed

    private void addressline2boxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addressline2boxKeyPressed

        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            addresscity.requestFocusInWindow();
        }
    }//GEN-LAST:event_addressline2boxKeyPressed

    private void addresscityActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addresscityActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_addresscityActionPerformed

    private void addresscityKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_addresscityKeyPressed

        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            acbox.requestFocusInWindow();
        }
    }//GEN-LAST:event_addresscityKeyPressed

    private void acboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_acboxActionPerformed

    private void acboxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_acboxKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            bankbox.requestFocusInWindow();
        }
        if ((key >= evt.VK_0 && key <= evt.VK_9) || (key >= evt.VK_NUMPAD0 && key <= evt.VK_NUMPAD9) || key == KeyEvent.VK_BACK_SPACE || key == KeyEvent.VK_SPACE || key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT || key == KeyEvent.VK_ENTER) {
            acbox.setEditable(true);
            acbox.setBackground(Color.white);
        } else {
            getToolkit().beep();
            acbox.setEditable(false);
            acbox.setBackground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_acboxKeyPressed

    private void contactboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_contactboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_contactboxActionPerformed

    private void contactboxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactboxKeyPressed
        int key = evt.getKeyCode();
        if ((key >= evt.VK_0 && key <= evt.VK_9) || (key >= evt.VK_NUMPAD0 && key <= evt.VK_NUMPAD9) || key == KeyEvent.VK_BACK_SPACE || key == KeyEvent.VK_LEFT || key == KeyEvent.VK_RIGHT) {
            contactbox.setEditable(true);
            contactbox.setBackground(Color.white);
        } else {
            getToolkit().beep();
            contactbox.setEditable(false);
            contactbox.setBackground(Color.LIGHT_GRAY);
        }
    }//GEN-LAST:event_contactboxKeyPressed

    private void contactboxKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_contactboxKeyTyped

    }//GEN-LAST:event_contactboxKeyTyped

    private void suppliertableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_suppliertableMouseClicked
        int row = suppliertable.getSelectedRow();

        String supid = suppliertable.getValueAt(row, 0).toString();
        String fname = suppliertable.getValueAt(row, 1).toString();
        String lname = suppliertable.getValueAt(row, 2).toString();
        String address1 = suppliertable.getValueAt(row, 3).toString();
        String address2 = suppliertable.getValueAt(row, 4).toString();
        String city = suppliertable.getValueAt(row, 5).toString();
        String accnum = suppliertable.getValueAt(row, 6).toString();
        String bank = suppliertable.getValueAt(row, 7).toString();
        String contactnum = suppliertable.getValueAt(row, 8).toString();

        idbox.setText(supid);
        fnamebox.setText(fname);
        lnamebox.setText(lname);
        addressline1box.setText(address1);
        addressline2box.setText(address2);
        addresscity.setText(city);
        acbox.setText(accnum);
        bankbox.setSelectedItem(bank);
        contactbox.setText(contactnum);
    }//GEN-LAST:event_suppliertableMouseClicked

    private void searchboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_searchboxActionPerformed

    private void searchboxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyPressed


    }//GEN-LAST:event_searchboxKeyPressed

    private void bankboxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_bankboxKeyPressed
        int key = evt.getKeyCode();
        if (key == KeyEvent.VK_ENTER) {
            contactbox.requestFocusInWindow();
        }
    }//GEN-LAST:event_bankboxKeyPressed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String supid = idbox.getText();
        String fnamae = fnamebox.getText();
        String lname = lnamebox.getText();
        String address1 = addressline1box.getText();
        String address2 = addressline2box.getText();
        String city = addresscity.getText();
        String accnum = acbox.getText();
        String contactnum = contactbox.getText();
        String bank = bankbox.getSelectedItem().toString();
        String senddate = showDate();
        if (supid.isEmpty() || fnamae.isEmpty() || lname.isEmpty() || address1.isEmpty() || address2.isEmpty() || city.isEmpty() || accnum.isEmpty() || contactnum.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please fill details");
        } else {
            if (contactnum.length() == 10) {
                int x = JOptionPane.showConfirmDialog(null, "Do You want confirm");
                if (x == 0) {
                    i.supplieradd(fnamae, lname, address1, address2, city, accnum, bank, contactnum);
                    idbox.setText("");
                    fnamebox.setText("");
                    lnamebox.setText("");
                    addressline1box.setText("");
                    addressline2box.setText("");
                    addresscity.setText("");
                    acbox.setText("");
                    contactbox.setText("");
                    bankbox.setSelectedItem("");
                    suppliertable();
                }
            } else {
                JOptionPane.showMessageDialog(null, "Invalid Details", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String supid = idbox.getText();
        String fnamae = fnamebox.getText();
        String lname = lnamebox.getText();
        String address1 = addressline1box.getText();
        String address2 = addressline2box.getText();
        String city = addresscity.getText();
        String accnum = acbox.getText().toString();
        String contactnum = contactbox.getText();
        String bank = bankbox.getSelectedItem().toString();
        String senddate = showDate();

        if (supid.isEmpty() || fnamae.isEmpty() || lname.isEmpty() || address1.isEmpty() || address2.isEmpty() || city.isEmpty() || accnum.isEmpty() || contactnum.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter valid details");
        } else {
            int x = JOptionPane.showConfirmDialog(null, "Do You want confirm");
            if (x == 0) {
                i.supplierupdate(supid, fnamae, lname, address1, address2, city, accnum, bank, contactnum);
                idbox.setText("");
                fnamebox.setText("");
                lnamebox.setText("");
                addressline1box.setText("");
                addressline2box.setText("");
                addresscity.setText("");
                acbox.setText("");
                contactbox.setText("");
                bankbox.setSelectedItem("");
                suppliertable();
            }
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        String supid = idbox.getText();

        if (supid.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select supplier");
        } else {
            int x = JOptionPane.showConfirmDialog(null, "Do You want confirm");
            if (x == 0) {
                i.supplierdelete(supid);
                idbox.setText("");
                fnamebox.setText("");
                lnamebox.setText("");
                addressline1box.setText("");
                addressline2box.setText("");
                addresscity.setText("");
                acbox.setText("");
                contactbox.setText("");
                bankbox.setSelectedItem("");
                suppliertable();
            }
        }
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String search = searchbox.getText();
        rs = i.suppliersearch(search);
        suppliertable.setModel(DbUtils.resultSetToTableModel(rs));
    }//GEN-LAST:event_jButton2ActionPerformed

    private void searchboxKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_searchboxKeyReleased
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String search = searchbox.getText();
            rs = i.suppliersearch(search);
            suppliertable.setModel(DbUtils.resultSetToTableModel(rs));
        }
    }//GEN-LAST:event_searchboxKeyReleased

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String fname = searchbox.getText();
        if (fname.isEmpty()) {
            try {
                String rep = "C:\\Users\\MUNESH\\Documents\\NetBeansProjects\\itp_new_template\\ireport\\supplier.jrxml";
                JasperReport jr = JasperCompileManager.compileReport(rep);
                JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
                JasperViewer.viewReport(jp);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else {
            try {

                JasperDesign jd = JRXmlLoader.load("C:\\Users\\MUNESH\\Documents\\NetBeansProjects\\itp_new_template\\ireport\\supplier.jrxml");
                String sql = "select * from supplier where FName like '%" + fname + "%'";
                JRDesignQuery n1 = new JRDesignQuery();
                n1.setText(sql);
                jd.setQuery(n1);
                JasperReport jr = JasperCompileManager.compileReport(jd);
                JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
                JasperViewer.viewReport(jp);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    String showDate() {
        java.util.Date d = new java.util.Date();
        SimpleDateFormat s = new SimpleDateFormat("yyyy-MM-dd");
        return (s.format(d));
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    public javax.swing.JTextField acbox;
    public javax.swing.JTextField addresscity;
    public javax.swing.JTextField addressline1box;
    public javax.swing.JTextField addressline2box;
    public javax.swing.JComboBox<String> bankbox;
    public javax.swing.JTextField contactbox;
    public javax.swing.JTextField fnamebox;
    public javax.swing.JLabel idbox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    public javax.swing.JTextField lnamebox;
    private javax.swing.JTextField searchbox;
    private javax.swing.JTable suppliertable;
    // End of variables declaration//GEN-END:variables
}