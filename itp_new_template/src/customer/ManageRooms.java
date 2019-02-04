/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package customer;

import com.sun.glass.events.KeyEvent;
import dbconnect.dbconnect;
import java.awt.Color;
import java.awt.HeadlessException;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
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
 * @author DELL
 */
public class ManageRooms extends javax.swing.JInternalFrame {

    Connection con = null;
    PreparedStatement pst = null;
    ResultSet rs = null;

    customer c = new customer();

    public ManageRooms() {
        initComponents();

        con = dbconnect.connect();

        tableload();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton2 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        jTable2 = new javax.swing.JTable();
        jComboBox2 = new javax.swing.JComboBox();
        searchbox2 = new javax.swing.JTextField();
        searchbox = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jLabel10 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        roomnobox = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        typebox = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        pricebox = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        conditionbox = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        locationbox = new javax.swing.JComboBox();
        jButton5 = new javax.swing.JButton();
        filebox = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        jDesktopPane1 = new javax.swing.JDesktopPane();
        imagebox = new javax.swing.JLabel();
        idbox = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();

        setMinimumSize(new java.awt.Dimension(1600, 920));
        setPreferredSize(new java.awt.Dimension(1600, 920));
        setVerifyInputWhenFocusTarget(false);
        getContentPane().setLayout(null);

        jButton2.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/customer/images/clear.png"))); // NOI18N
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2);
        jButton2.setBounds(770, 710, 140, 50);

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
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
        jTable2.setFillsViewportHeight(true);
        jTable2.setRowHeight(30);
        jTable2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                jTable2MouseEntered(evt);
            }
        });
        jScrollPane2.setViewportView(jTable2);

        getContentPane().add(jScrollPane2);
        jScrollPane2.setBounds(30, 200, 880, 320);

        jComboBox2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jComboBox2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select  search  type", "RoomID", "RoomNo", "RoomType", "RoomPrice" }));
        getContentPane().add(jComboBox2);
        jComboBox2.setBounds(30, 130, 190, 40);

        searchbox2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(searchbox2);
        searchbox2.setBounds(240, 130, 270, 40);

        searchbox.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        searchbox.setIcon(new javax.swing.ImageIcon(getClass().getResource("/customer/images/search.png"))); // NOI18N
        searchbox.setText("Search");
        searchbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchboxActionPerformed(evt);
            }
        });
        getContentPane().add(searchbox);
        searchbox.setBounds(530, 120, 140, 50);

        jButton7.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/customer/images/delete.png"))); // NOI18N
        jButton7.setText("Delete");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7);
        jButton7.setBounds(570, 710, 140, 50);

        jLabel10.setFont(new java.awt.Font("Tahoma", 1, 25)); // NOI18N
        jLabel10.setText("Manage   Rooms.");
        getContentPane().add(jLabel10);
        jLabel10.setBounds(660, 20, 450, 29);

        jButton6.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/customer/images/update.png"))); // NOI18N
        jButton6.setText("Update");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6);
        jButton6.setBounds(380, 710, 140, 50);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel7.setText("Room  No");
        getContentPane().add(jLabel7);
        jLabel7.setBounds(970, 220, 101, 40);

        roomnobox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(roomnobox);
        roomnobox.setBounds(1140, 230, 410, 40);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Room  Type");
        getContentPane().add(jLabel8);
        jLabel8.setBounds(970, 290, 101, 40);

        typebox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        typebox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select  Room type", "Single", "Double" }));
        typebox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                typeboxActionPerformed(evt);
            }
        });
        getContentPane().add(typebox);
        typebox.setBounds(1140, 300, 410, 40);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Room  Price");
        getContentPane().add(jLabel9);
        jLabel9.setBounds(970, 360, 101, 40);

        pricebox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        pricebox.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                priceboxKeyPressed(evt);
            }
        });
        getContentPane().add(pricebox);
        pricebox.setBounds(1140, 370, 410, 40);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Condition");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(970, 440, 101, 40);

        conditionbox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        conditionbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select the condition", "A/C", "Non A/C" }));
        conditionbox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                conditionboxActionPerformed(evt);
            }
        });
        getContentPane().add(conditionbox);
        conditionbox.setBounds(1140, 440, 410, 40);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Location");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(970, 510, 101, 40);

        locationbox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        locationbox.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select the Location", "1st Floor", "2nd Floor", "3rd Floor" }));
        getContentPane().add(locationbox);
        locationbox.setBounds(1140, 510, 410, 40);

        jButton5.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/customer/images/document-with-paperclip.png"))); // NOI18N
        jButton5.setText("Attach Image");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5);
        jButton5.setBounds(930, 590, 200, 40);

        filebox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(filebox);
        filebox.setBounds(1140, 590, 410, 40);

        jButton4.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/customer/images/add.png"))); // NOI18N
        jButton4.setText("Insert");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4);
        jButton4.setBounds(1410, 680, 140, 50);

        imagebox.setText("jLabel3");

        jDesktopPane1.setLayer(imagebox, javax.swing.JLayeredPane.DEFAULT_LAYER);

        javax.swing.GroupLayout jDesktopPane1Layout = new javax.swing.GroupLayout(jDesktopPane1);
        jDesktopPane1.setLayout(jDesktopPane1Layout);
        jDesktopPane1Layout.setHorizontalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(imagebox, javax.swing.GroupLayout.DEFAULT_SIZE, 320, Short.MAX_VALUE)
        );
        jDesktopPane1Layout.setVerticalGroup(
            jDesktopPane1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jDesktopPane1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(imagebox, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        getContentPane().add(jDesktopPane1);
        jDesktopPane1.setBounds(40, 580, 320, 180);

        idbox.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        getContentPane().add(idbox);
        idbox.setBounds(970, 150, 101, 40);

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/print.png"))); // NOI18N
        jButton1.setText("Print");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1);
        jButton1.setBounds(790, 120, 120, 50);

        jLabel3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Inventory/imgs/body.jpg"))); // NOI18N
        jLabel3.setText(" ");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(0, 0, 1590, 880);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    public void tableload() {
        try {
            String sql;
            sql = "SELECT * FROM room";

            pst = con.prepareStatement(sql);
            rs = pst.executeQuery();
            //jTable1.setModel(DbUtils.resultSetToTableModel(rs));

            jTable2.setModel(DbUtils.resultSetToTableModel(rs));

        } catch (Exception e) {
            // jTable1.setModel(DbUtils.resultSetToTableModel(rs));
        }
    }

    public void clear() {
        idbox.setText("");
        roomnobox.setText("");
        typebox.setSelectedIndex(0);
        pricebox.setText("");
        conditionbox.setSelectedIndex(0);
        locationbox.setSelectedIndex(0);
        filebox.setText("");

        tableload();
    }


    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        clear();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jTable2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseClicked

        int r = jTable2.getSelectedRow();

        String roomid = jTable2.getValueAt(r, 0).toString();
        String roomno = jTable2.getValueAt(r, 1).toString();
        String type = jTable2.getValueAt(r, 2).toString();
        String price = jTable2.getValueAt(r, 3).toString();
        String Condition = jTable2.getValueAt(r, 4).toString();
        String location = jTable2.getValueAt(r, 5).toString();
        String image = jTable2.getValueAt(r, 7).toString();
        System.out.print(location);
        idbox.setText(roomid);
        roomnobox.setText(roomno);
        typebox.setSelectedItem(type);
        pricebox.setText(price);
        conditionbox.setSelectedItem(Condition);
        locationbox.setSelectedItem(location);

        filebox.setText(image);

        try {
            String id = idbox.getText();

            String sql2 = "select image from room where RoomID='" + roomid + "'";
            pst = con.prepareStatement(sql2);
            rs = pst.executeQuery();

            if (rs.next()) {
                byte[] imagedata = rs.getBytes("image");
                format = new ImageIcon(imagedata);
                imagebox.setIcon(format);
            } else {
            }

        } catch (Exception e) {
            System.out.println(e);
        }

    }//GEN-LAST:event_jTable2MouseClicked

    private void searchboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchboxActionPerformed
        int typeno = jComboBox2.getSelectedIndex();
        String type = "";
        String key = searchbox2.getText();

        switch (typeno) {
            case 0:
                type = "";
                break;

            case 1:
                type = "RoomID";
                break;

            case 2:
                type = "RoomNo";
                break;

            case 3:
                type = "Type";
                break;

            case 4:
                type = "Price";
                break;

            case 5:
                type = "Roomcondition";
                break;

            case 6:
                type = "Location";
                break;
        }

        rs = c.Roomsearch(type, key);

        jTable2.setModel(DbUtils.resultSetToTableModel(rs));

    }//GEN-LAST:event_searchboxActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        int x = JOptionPane.showConfirmDialog(null, "Do You want to delete ?", "Delete", JOptionPane.YES_NO_OPTION);

        if (x == 0) {
            String id = idbox.getText();
            String sql = "DELETE from room where RoomID='" + id + "'";

            try {
                pst = con.prepareStatement(sql);
                pst.execute();

                JOptionPane.showMessageDialog(this, "Successfully deleted");

                //load table
                tableload();

            } catch (SQLException | HeadlessException e) {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed

        //update
        int x = JOptionPane.showConfirmDialog(null, "Do You want to update ?", "Update", JOptionPane.YES_NO_OPTION);
        if (x == 0) {
            String roomid = idbox.getText();
            String roomno = roomnobox.getText();
            String type = typebox.getSelectedItem().toString();
            String price = pricebox.getText();
            String Condition = conditionbox.getSelectedItem().toString();
            String location = locationbox.getSelectedItem().toString();

            try {
                String sql = "UPDATE room set RoomNo=?,Type=?,Price=?,RoomCondition=?,Location=?,image=? where RoomID=?";

                pst = con.prepareStatement(sql);

                pst.setString(1, roomno);
                pst.setString(2, type);
                pst.setString(3, price);
                pst.setString(4, Condition);
                pst.setString(5, location);
                pst.setBytes(6, room_image);
                pst.setString(7, roomid);

                pst.execute();

                tableload();

                JOptionPane.showMessageDialog(this, "Successfully Updated");

                clear();

            } catch (SQLException | HeadlessException e) {
                Logger.getLogger(ManageRooms.class.getName()).log(Level.SEVERE, null, e);

                System.out.println(e);
            }
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void conditionboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_conditionboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_conditionboxActionPerformed

    private void typeboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_typeboxActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_typeboxActionPerformed

    private void priceboxKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_priceboxKeyPressed
        int key = evt.getKeyCode();
        if ((key >= evt.VK_0 && key <= evt.VK_9) || (key >= evt.VK_NUMPAD0 && key <= evt.VK_NUMPAD9) || key == KeyEvent.VK_BACKSPACE) {

            pricebox.setEditable(true);
            pricebox.setBackground(Color.white);
        } else {
            pricebox.setEditable(false);
            pricebox.setBackground(Color.red);
        }
    }//GEN-LAST:event_priceboxKeyPressed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed

        JFileChooser chooser = new JFileChooser();
        chooser.showOpenDialog(null);
        File f = chooser.getSelectedFile();
        filename = f.getAbsolutePath();

        filebox.setText(filename);

        try {
            File image = new File(filename);
            FileInputStream fis = new FileInputStream(image);
            ByteArrayOutputStream bos = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            for (int readNum; (readNum = fis.read(buf)) != -1;) {

                bos.write(buf, 0, readNum);
            }
            room_image = bos.toByteArray();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed

        //insert
        // String roomid = idbox.getText();
        String roomno = roomnobox.getText();
        String type = typebox.getSelectedItem().toString();
        String price = pricebox.getText();
        String condition = conditionbox.getSelectedItem().toString();
        String location = locationbox.getSelectedItem().toString();
        if (roomno.isEmpty() || type.isEmpty() || price.isEmpty() || condition.isEmpty() || location.isEmpty()) {
            JOptionPane.showMessageDialog(this, "Please fill details");
        } else {
            try {
                String sql = "INSERT INTO room (RoomNo,Type,Price,RoomCondition,Location,status,image) values (?,?,?,?,?,?,?)";

                pst = con.prepareStatement(sql);

                // pst.setString(1,roomid);
                pst.setString(1, roomno);
                pst.setString(2, type);
                pst.setString(3, price);
                pst.setString(4, condition);
                pst.setString(5, location);
                pst.setString(6, "Free");
                pst.setBytes(7, room_image);

                pst.execute();

                tableload();

                JOptionPane.showMessageDialog(this, "Successfully Registered");

                clear();

            } catch (SQLException ex) {
                JOptionPane.showMessageDialog(this, ex);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jTable2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_jTable2MouseEntered

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String fname = searchbox2.getText();
        if (fname.isEmpty()) {
            try {
                String rep = "C:\\Users\\MUNESH\\Documents\\NetBeansProjects\\itp_new_template\\ireport\\rooms.jrxml";
                JasperReport jr = JasperCompileManager.compileReport(rep);
                JasperPrint jp = JasperFillManager.fillReport(jr, null, con);
                JasperViewer.viewReport(jp);
            } catch (JRException ex) {
                JOptionPane.showMessageDialog(null, ex);
            }
        } else {
            try {

                JasperDesign jd = JRXmlLoader.load("C:\\Users\\MUNESH\\Documents\\NetBeansProjects\\itp_new_template\\ireport\\rooms.jrxml");
                String sql = "select * from room where RoomNo like '%" + fname + "%'";
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
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox conditionbox;
    private javax.swing.JTextField filebox;
    private javax.swing.JLabel idbox;
    private javax.swing.JLabel imagebox;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JComboBox jComboBox2;
    private javax.swing.JDesktopPane jDesktopPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JTable jTable2;
    private javax.swing.JComboBox locationbox;
    private javax.swing.JTextField pricebox;
    private javax.swing.JTextField roomnobox;
    private javax.swing.JButton searchbox;
    private javax.swing.JTextField searchbox2;
    private javax.swing.JComboBox typebox;
    // End of variables declaration//GEN-END:variables

    private ImageIcon format = null;

    String filename = null;
    int s = 0;
    byte[] room_image = null;

}