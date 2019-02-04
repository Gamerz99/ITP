/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import dbconnect.dbconnect;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Calendar;
import javax.swing.JOptionPane;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JRDesignQuery;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;

public class Gen_Reports extends javax.swing.JInternalFrame {
    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    int year=Calendar.getInstance().get(Calendar.YEAR);
    int monthOld=Calendar.getInstance().get(Calendar.MONTH)+1;
    String month=null;
    public Gen_Reports() {
        initComponents();
        conn=dbconnect.connect();
        getMonth();
    }
    private void getMonth()
    {
        if(monthOld<10)
        {
            month="0"+monthOld;
        }
        else
            month=Integer.toString(monthOld);
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        eid1 = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        month1 = new javax.swing.JComboBox();
        jLabel9 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        month2 = new javax.swing.JComboBox();
        jButton4 = new javax.swing.JButton();
        eid2 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jButton5 = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jButton6 = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jButton9 = new javax.swing.JButton();
        jButton11 = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jButton10 = new javax.swing.JButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        eid3 = new javax.swing.JTextField();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        month3 = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setMaximumSize(new java.awt.Dimension(1600, 925));
        setMinimumSize(new java.awt.Dimension(1600, 925));
        setPreferredSize(new java.awt.Dimension(1600, 925));

        jPanel1.setPreferredSize(new java.awt.Dimension(1140, 545));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Attendance", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 20), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Employee ID");
        jPanel4.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 50, 110, 27));

        eid1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel4.add(eid1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 50, 150, 27));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton1.setText("Click");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(250, 90, 150, 31));

        month1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        month1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        jPanel4.add(month1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 130, 31));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel4.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 90, 60, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel4.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(520, 50, 60, 27));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton2.setText("Report of this employee");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 141, 240, 40));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton3.setText("Generate a full report");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 80, 261, 50));

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("Half Days");
        jPanel4.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 90, 90, 30));

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel10.setText("Full Days");
        jPanel4.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 50, 90, 30));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(187, 94, 1180, 210));

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Permanant Employee Salary", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 20), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        month2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        month2.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        jPanel5.add(month2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 130, 31));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setText("Report of this employee");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 90, 230, 31));

        eid2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jPanel5.add(eid2, new org.netbeans.lib.awtextra.AbsoluteConstraints(210, 40, 160, 30));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel5.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 40, 150, 27));

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton5.setText("Click");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 90, 130, 32));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Employee ID");
        jPanel5.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 42, 110, 27));

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton6.setText("Generate a full report");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel5.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 50, 261, 50));

        jPanel1.add(jPanel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 340, 1180, 150));

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Employee Details", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 20), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton9.setText("Permanant");
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(121, 52, 310, 50));

        jButton11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton11.setText("Tempoarary");
        jButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton11ActionPerformed(evt);
            }
        });
        jPanel6.add(jButton11, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 50, 290, 50));

        jPanel1.add(jPanel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 700, 1180, 140));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel7.setText("Generating Reports");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(727, 0, 280, 34));

        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(new javax.swing.border.MatteBorder(null), "Temporary Employee Salary", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Arial Black", 1, 20), new java.awt.Color(0, 0, 0))); // NOI18N
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jButton10.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton10.setText("Generate a full report ");
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(770, 50, 261, 50));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Employee ID");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 42, 120, 27));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 40, 150, 27));

        eid3.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        jPanel2.add(eid3, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 40, 150, 30));

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton7.setText("Report of this employee");
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(400, 90, 220, 40));

        jButton8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton8.setText("Click");
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        jPanel2.add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(244, 90, 130, 40));

        month3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        month3.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Select Month", "January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December" }));
        jPanel2.add(month3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 90, 140, 40));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(190, 510, 1180, 160));

        jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/body.jpg"))); // NOI18N
        jPanel1.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1590, 900));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 1590, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 900, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String Eid=eid1.getText();
        if(Eid.compareTo("")!=0)
        {
            int mo=month1.getSelectedIndex();
            try {
                String a=null;
                String b=null;
                if(mo==0)
                {
                    a="select count(Date) as abc from attendance where EID='"+Eid+"' and Date like '"+year+"-"+month+"%' and Status='f'";
                    b="select count(Date) as abc from attendance where EID='"+Eid+"' and Date like '"+year+"-"+month+"%' and Status='h'";
                }
                else if(mo>0&&mo<10)
                {
                    a="select count(Date) as abc from attendance where EID='"+Eid+"' and Date like '"+year+"-0"+mo+"%' and Status='f'";
                    b="select count(Date) as abc from attendance where EID='"+Eid+"' and Date like '"+year+"-0"+mo+"%' and Status='h'";
                }
                else if(mo>9)
                {
                    a="select count(Date) as abc from attendance where EID='"+Eid+"' and Date like '"+year+"-"+mo+"%' and Status='f'";
                    b="select count(Date) as abc from attendance where EID='"+Eid+"' and Date like '"+year+"-"+mo+"%' and Status='h'";
                }
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    String show=rs.getString("abc");
                    jLabel2.setText(show);
                }
                pst=conn.prepareStatement(b);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    String show=rs.getString("abc");
                    jLabel9.setText(show);
                }
            } catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Employee ID field is empty");
        
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        String Eid=eid2.getText();
        if(Eid.compareTo("")!=0)
        {
            int mo=month2.getSelectedIndex();
            try {
                String a=null;
                if(mo==0)
                {
                    a="select Tot_salary from perm_emp_salary where EID='"+Eid+"' and Month like '"+year+"-"+monthOld+"%'";
                }
                else
                {
                    a="select Tot_salary from perm_emp_salary where EID='"+Eid+"' and Month like '"+year+"-"+mo+"%'";
                }
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    String show=rs.getString("Tot_salary");
                    jLabel4.setText(show);
                }
            } catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Employee ID field is empty");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        String Eid=eid1.getText();
        if(Eid.compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Give an employee ID");
        else
        {
            try {
                JasperDesign jd=JRXmlLoader.load("C:\\Users\\MUNESH\\Documents\\NetBeansProjects\\itp_new_template\\ireport\\Attendance.jrxml");
                String sql="select * from attendance where EID='"+Eid+"'";
                JRDesignQuery n1=new JRDesignQuery();
                n1.setText(sql);
                jd.setQuery(n1);
                JasperReport jr=JasperCompileManager.compileReport(jd);
                JasperPrint jp=JasperFillManager.fillReport(jr, null,conn);
                JasperViewer.viewReport(jp);
            } catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String Eid=eid2.getText();
        if(Eid==null)
            JOptionPane.showMessageDialog(null, "Give an employee ID");
        else
        {
            try {
                JasperDesign jd=JRXmlLoader.load("C:\\Users\\MUNESH\\Documents\\NetBeansProjects\\itp_new_template\\ireport\\Attendance.jrxml");
                String sql="select * from perm_emp_salary where EID='"+Eid+"'";
                JRDesignQuery n1=new JRDesignQuery();
                n1.setText(sql);
                jd.setQuery(n1);
                JasperReport jr=JasperCompileManager.compileReport(jd);
                JasperPrint jp=JasperFillManager.fillReport(jr, null,conn);
                JasperViewer.viewReport(jp);
            } catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        try {
            String rep="C:\\Users\\MUNESH\\Documents\\NetBeansProjects\\itp_new_template\\ireport\\Attendance.jrxml";
            JasperReport jr=JasperCompileManager.compileReport(rep);
            JasperPrint jp=JasperFillManager.fillReport(jr,null,conn);
            JasperViewer.viewReport(jp);
        } catch (JRException ex) {
            System.out.println(ex);
        }
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        try {
            String rep="C:\\Users\\MUNESH\\Documents\\NetBeansProjects\\itp_new_template\\ireport\\PermEmpSal.jrxml";
            JasperReport jr=JasperCompileManager.compileReport(rep);
            JasperPrint jp=JasperFillManager.fillReport(jr,null,conn);
            JasperViewer.viewReport(jp);
        } catch (JRException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        try {
            String rep="C:\\Users\\MUNESH\\Documents\\NetBeansProjects\\itp_new_template\\ireport\\TempEmpSal.jrxml";
            JasperReport jr=JasperCompileManager.compileReport(rep);
            JasperPrint jp=JasperFillManager.fillReport(jr,null,conn);
            JasperViewer.viewReport(jp);
        } catch (JRException ex) {
            System.out.println(ex);
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        try {
            JasperDesign jd=JRXmlLoader.load("C:\\Users\\MUNESH\\Documents\\NetBeansProjects\\itp_new_template\\ireport\\Empdet.jrxml");
            String sql="select * from empdet where type='Permanant'";
            JRDesignQuery n1=new JRDesignQuery();
            n1.setText(sql);
            jd.setQuery(n1);
            JasperReport jr=JasperCompileManager.compileReport(jd);
            JasperPrint jp=JasperFillManager.fillReport(jr, null,conn);
            JasperViewer.viewReport(jp);
        } catch(Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        String Eid=eid3.getText();
        if(Eid==null)
            JOptionPane.showMessageDialog(null, "Give an employee ID");
        else
        {
            try {
                JasperDesign jd=JRXmlLoader.load("C:\\Users\\MUNESH\\Documents\\NetBeansProjects\\itp_new_template\\ireport\\TempEmpSal.jrxml");
                String sql="select * from temp_emp_salary where EID='"+Eid+"'";
                JRDesignQuery n1=new JRDesignQuery();
                n1.setText(sql);
                jd.setQuery(n1);
                JasperReport jr=JasperCompileManager.compileReport(jd);
                JasperPrint jp=JasperFillManager.fillReport(jr, null,conn);
                JasperViewer.viewReport(jp);
            } catch(Exception e)
            {
                System.out.println(e);
            }
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        String Eid=eid3.getText();
        if(Eid.compareTo("")!=0)
        {
            int mo=month3.getSelectedIndex();
            try {
                String a=null;
                if(mo==0)
                {
                    a="select Tot_salary from temp_emp_salary where EID='"+Eid+"' and Month like '"+year+"-"+monthOld+"%'";
                }
                else
                {
                    a="select Tot_salary from temp_emp_salary where EID='"+Eid+"' and Month like '"+year+"-"+mo+"%'";
                }
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    String show=rs.getString("Tot_salary");
                    jLabel6.setText(show);
                }
            } catch(Exception e)
            {
                System.out.println(e);
            }
        }
        else
            JOptionPane.showMessageDialog(null, "Employee ID field is empty");
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
        try {
            JasperDesign jd=JRXmlLoader.load("C:\\Users\\MUNESH\\Documents\\NetBeansProjects\\itp_new_template\\ireport\\Empdet.jrxml");
            String sql="select * from empdet where type='Temporary'";
            JRDesignQuery n1=new JRDesignQuery();
            n1.setText(sql);
            jd.setQuery(n1);
            JasperReport jr=JasperCompileManager.compileReport(jd);
            JasperPrint jp=JasperFillManager.fillReport(jr, null,conn);
            JasperViewer.viewReport(jp);
        } catch(Exception e) {
            System.out.println(e);
        }
    }//GEN-LAST:event_jButton11ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField eid1;
    private javax.swing.JTextField eid2;
    private javax.swing.JTextField eid3;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton11;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
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
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JComboBox month1;
    private javax.swing.JComboBox month2;
    private javax.swing.JComboBox month3;
    // End of variables declaration//GEN-END:variables
}
