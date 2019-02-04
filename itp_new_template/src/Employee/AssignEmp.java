
package Employee;

import dbconnect.dbconnect;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class AssignEmp extends javax.swing.JInternalFrame {
    int row=-1;
    int row1=-1;
    int row11=-1;
    String dat=null;
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    String tid=null;
    String evid=null;
    String EID=null;
    methods mm=new methods();
    public AssignEmp() {
        initComponents();
        conn=dbconnect.connect();
        show_tab1();
    }
    private void show_tab1()
    {
        try {
            String a="select * from event_booking where Event_Date>'"+mm.dates+"' order by Event_Date DESC";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            table1.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        table1 = new javax.swing.JTable();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        table2 = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane4 = new javax.swing.JScrollPane();
        temp_emp = new javax.swing.JTextArea();
        jButton2 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jScrollPane5 = new javax.swing.JScrollPane();
        table3 = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1595, 893));
        setMinimumSize(new java.awt.Dimension(1595, 893));
        setPreferredSize(new java.awt.Dimension(1595, 893));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setPreferredSize(new java.awt.Dimension(1140, 545));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        table1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        table1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "EventID", "Type", "Date", "Session", "NoOfGuests", "Tempory Employee"
            }
        ));
        table1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table1.setGridColor(new java.awt.Color(0, 0, 0));
        table1.setSelectionBackground(new java.awt.Color(0, 0, 0));
        table1.setSelectionForeground(new java.awt.Color(204, 204, 204));
        table1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table1MouseClicked(evt);
            }
        });
        table1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                table1KeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(table1);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 90, 940, 170));

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel1.setText("Unavailable Employees");
        jPanel1.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(648, 300, 290, 40));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Assign Employees");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 590, 210, 60));

        table2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        table2.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "EID", "Fname", "Surname", "Department", "Job"
            }
        ));
        table2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        table2.setGridColor(new java.awt.Color(0, 0, 0));
        table2.setSelectionBackground(new java.awt.Color(0, 0, 0));
        table2.setSelectionForeground(new java.awt.Color(204, 204, 204));
        table2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table2MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                table2MouseEntered(evt);
            }
        });
        table2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                table2KeyPressed(evt);
            }
        });
        jScrollPane2.setViewportView(table2);

        jPanel1.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 340, 1360, 181));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel2.setText("Assign Temporary Employees to events");
        jPanel1.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(622, 0, 492, 40));

        temp_emp.setColumns(20);
        temp_emp.setRows(5);
        jScrollPane4.setViewportView(temp_emp);

        jPanel1.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1120, 90, 370, 174));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Clear");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(1000, 680, 210, 60));

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 24)); // NOI18N
        jLabel3.setText("Temporary Employees");
        jPanel1.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(340, 550, 290, 40));

        table3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        table3.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null},
                {null, null, null, null, null, null}
            },
            new String [] {
                "EID", "FName", "Surname", "Department", "Position", "ContactNo"
            }
        ));
        table3.setGridColor(new java.awt.Color(0, 0, 0));
        table3.setSelectionBackground(new java.awt.Color(0, 0, 0));
        table3.setSelectionForeground(new java.awt.Color(204, 204, 204));
        table3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                table3MouseClicked(evt);
            }
        });
        jScrollPane5.setViewportView(table3);

        jPanel1.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 590, 700, 230));

        jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/body.jpg"))); // NOI18N
        jLabel4.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jLabel4MouseClicked(evt);
            }
        });
        jPanel1.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1580, 870));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1580, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 866, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(row11!=-1)
        {
            String temp=tid;
            try {
                String c="select Temp from event_booking where Event_Date='"+dat+"' and Booking_ID='"+evid+"'";
                pst=conn.prepareStatement(c);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    temp=tid+","+rs.getString("Temp");
                }
                String a="update event_booking set Temp='"+temp+"' where Booking_ID='"+evid+"'";
                pst=conn.prepareStatement(a);
                pst.execute();
                JOptionPane.showMessageDialog(null, "Added Succesfully");
                //eid.setText("");
                String b="update absentees set status='y' where EID='"+EID+"'";
                pst=conn.prepareStatement(b);
                pst.execute();
                show_tab1();
                
            } catch(Exception e)
            {
                System.out.println(e);
            }
        }     
        else
            JOptionPane.showMessageDialog(null, "Select a temporary employee");
    }//GEN-LAST:event_jButton1ActionPerformed

    private void table1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table1MouseClicked
        try {
            row=table1.getSelectedRow();
            dat=table1.getModel().getValueAt(row, 2).toString();
            String evid=table1.getModel().getValueAt(row, 0).toString();
            String a="select e.EID,e.FName,e.Surname,e.Department,e.Position from empdet e,absentees a where e.EID=a.EID and a.Date='"+dat+"' and a.status='n'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            table2.setModel(DbUtils.resultSetToTableModel(rs));
            String b="select * from event_booking where Booking_ID='"+evid+"'";
            pst=conn.prepareStatement(b);
            rs=pst.executeQuery();
            if(rs.next())
            {
                String t=rs.getString("Temp");
                temp_emp.setText(t);
                
            }
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
    }//GEN-LAST:event_table1MouseClicked

    private void table2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseClicked
        try {
            if(row!=-1)
            {
                row1=table2.getSelectedRow();
                String pos=table2.getModel().getValueAt(row1, 4).toString();
                EID=table2.getModel().getValueAt(row1, 0).toString();
                String a="select EID,FName,Surname,Department,Position,ContactNo from empdet where type='Temporary' and Position='"+pos+"'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                table3.setModel(DbUtils.resultSetToTableModel(rs));
            }
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_table2MouseClicked

    private void table1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table1KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_UP||evt.getKeyCode()==KeyEvent.VK_DOWN)
        {
            try {
                row=table1.getSelectedRow();
                dat=table1.getModel().getValueAt(row, 2).toString();
                String evid=table1.getModel().getValueAt(row, 0).toString();
                String a="select e.EID,e.FName,e.Surname,e.Department,e.Position from empdet e,absentees a where e.EID=a.EID and a.Date='"+dat+"' and a.status='n'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                table2.setModel(DbUtils.resultSetToTableModel(rs));
                String b="select * from event_booking where Booking_ID='"+evid+"'";
                pst=conn.prepareStatement(b);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    String t=rs.getString("Temp");
                    temp_emp.setText(t);

                }
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_table1KeyPressed

    private void table2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_table2KeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_UP||evt.getKeyCode()==KeyEvent.VK_DOWN)
        {
            try {
                if(row!=-1)
                {
                    row1=table2.getSelectedRow();
                    String pos=table2.getModel().getValueAt(row1, 4).toString();
                    EID=table2.getModel().getValueAt(row1, 0).toString();
                    String a="select EID,FName,Surname,Department,Position,ContactNo from empdet where type='Temporary' and Position='"+pos+"'";
                    pst=conn.prepareStatement(a);
                    rs=pst.executeQuery();
                    table3.setModel(DbUtils.resultSetToTableModel(rs));
                }
            } catch (SQLException ex) {
                System.out.println(ex);
            }
        }
    }//GEN-LAST:event_table2KeyPressed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        temp_emp.setText("");
        table1.clearSelection();
        table2.clearSelection();
        table3.clearSelection();
    }//GEN-LAST:event_jButton2ActionPerformed

    private void table2MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table2MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_table2MouseEntered

    private void table3MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_table3MouseClicked
        if(row1!=-1)
        {
            row11=table3.getSelectedRow();
            tid=table3.getModel().getValueAt(row11, 0).toString();
        }
    }//GEN-LAST:event_table3MouseClicked

    private void jLabel4MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jLabel4MouseClicked
        table1.clearSelection();
        table2.clearSelection();
        table3.clearSelection();
    }//GEN-LAST:event_jLabel4MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JTable table1;
    private javax.swing.JTable table2;
    private javax.swing.JTable table3;
    private javax.swing.JTextArea temp_emp;
    // End of variables declaration//GEN-END:variables
}
