/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Employee;

import dbconnect.dbconnect;
import java.awt.event.KeyEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;

public class Temp_emp_sal extends javax.swing.JInternalFrame {

    Connection conn=null;
    PreparedStatement pst=null;
    ResultSet rs=null;
    String id=null;
    methods mm=new methods();
    public Temp_emp_sal() {
        initComponents();
        conn=dbconnect.connect();
        show_table();
    }

    private void show_table() //To show the table content
    {
        try {
            String a="select e.EID,e.FName,e.Surname,t.Day_salary,t.OT_charge,t.Salary from empdet e,temp_emp_salary t where e.Type='Temporary' AND e.EID=t.EID and t.Day='"+mm.dates+"'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            etable.setModel(DbUtils.resultSetToTableModel(rs));
        } catch (SQLException ex) {
            System.out.println(ex);
        }
    }
    private void update_sal(String eid,double y,String z)  //To increase and decrease the salary of an employee
    {
        String Eid=eid;
        double value=y;
        String type=z;
        double tot=0;
        try
        {
            String b="select * from empdet where EID='"+Eid+"'";
            pst=conn.prepareStatement(b);
            rs=pst.executeQuery();
            double sal1=0;
            if(rs.next())
            {
                sal1=Double.parseDouble(rs.getString("Salary"));
                if(type.compareTo("add")==0)
                {
                    tot=sal1+value;
                }
                else if(type.compareTo("sub")==0)
                {
                    tot=sal1-value;
                }
                String c="select * from temp_emp_salary where EID='"+Eid+"' and Day='"+mm.dates+"'";
                pst=conn.prepareStatement(c);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    double bon1=Double.parseDouble(rs.getString("Bonus"));
                    double ot1=Double.parseDouble(rs.getString("OT_charge"));
                    double tot_sal=bon1+ot1+tot;
                    try
                    {
                        String a="update empdet set Salary='"+tot+"' where EID='"+Eid+"'";
                        pst=conn.prepareStatement(a);
                        pst.execute();
                        String aa="update temp_emp_salary set Day_salary='"+tot+"',Salary='"+tot_sal+"' where EID='"+Eid+"' and Day='"+mm.dates+"'";
                        pst=conn.prepareStatement(aa);
                        pst.execute();
                        show_table();
                        sal.setText("");
                        
                        basic_sal.setText(Double.toString(tot));
                        totSal.setText(Double.toString(tot_sal));
                        basic_sal.setText(Double.toString(tot));
                        JOptionPane.showMessageDialog(null, "Updated Successfully");
                    } catch(Exception e)
                    {
                        System.out.println(e+"90");
                    }
                }
            }
            else
                JOptionPane.showMessageDialog(null, "Id is wrong");
            
        } catch(SQLException ex)
        {
            System.out.println(ex+"pp");
        }
    }
    private void update_ot(String eid1,double OT,String type,String pos) //To change the OT rate
    {
        String Eid=eid1;
        double ott=OT;
        String Type=type;
        try {
            String a="select * from charges where Type='"+pos+"'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            String a11="select * from temp_emp_salary where EID='"+Eid+"' and Day='"+mm.dates+"'";
            PreparedStatement pst2=conn.prepareStatement(a11);
            ResultSet rs2=pst2.executeQuery();
            if(rs.next()&&rs2.next())
            {
                double tot=Double.parseDouble(rs2.getString("Salary"));
                double x=Double.parseDouble(rs.getString("OtCharge"));
                double y=Double.parseDouble(rs2.getString("OT_charge"));
                double ot_val = 0;
                double ot_am=0,finSal=0;
                if(Type.compareTo("add")==0)
                {
                    ot_am=ott*x;
                    finSal=tot+ot_am;
                    ot_val=y+ot_am;
                }
                else if(Type.compareTo("sub")==0)
                {
                    ot_am=ott*x;
                    finSal=tot-ot_am;
                    ot_val=y-ot_am;
                    if(ot_val<0)
                        ot_val=0;
                    
                }
                String b="update temp_emp_salary set OT_charge='"+ot_val+"',Salary='"+finSal+"' where EID='"+Eid+"' and Day='"+mm.dates+"'";
                PreparedStatement pst1=conn.prepareStatement(b);
                pst1.execute();
                show_table();
                totSal.setText(Double.toString(finSal));
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }
    }
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        etable = new javax.swing.JTable();
        jLabel9 = new javax.swing.JLabel();
        search = new javax.swing.JTextField();
        srch_surname = new javax.swing.JTextField();
        jButton4 = new javax.swing.JButton();
        srch_dep = new javax.swing.JComboBox();
        srch_job = new javax.swing.JComboBox();
        jLabel7 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        eid = new javax.swing.JLabel();
        totSal = new javax.swing.JLabel();
        basic_sal = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        surname = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        sal = new javax.swing.JTextField();
        jButton3 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        ot = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        tid = new javax.swing.JTextField();
        pic = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Temporary Employee Salary");
        setMaximumSize(new java.awt.Dimension(1600, 925));
        setMinimumSize(new java.awt.Dimension(1600, 925));
        setPreferredSize(new java.awt.Dimension(1600, 925));

        jPanel1.setPreferredSize(new java.awt.Dimension(1140, 545));
        jPanel1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        etable.setBorder(javax.swing.BorderFactory.createCompoundBorder());
        etable.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        etable.setModel(new javax.swing.table.DefaultTableModel(
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
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
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
                "EID", "Fname", "Surname", "Basic Salary", "total salary"
            }
        ));
        etable.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        etable.setGridColor(new java.awt.Color(0, 0, 0));
        etable.setSelectionBackground(new java.awt.Color(0, 0, 0));
        etable.setSelectionForeground(new java.awt.Color(204, 204, 204));
        etable.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                etableMouseClicked(evt);
            }
        });
        etable.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                etableKeyPressed(evt);
            }
        });
        jScrollPane1.setViewportView(etable);

        jPanel1.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(127, 415, 1340, 410));

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel9.setText("Surname");
        jPanel1.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(370, 335, 90, 40));

        search.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        search.setToolTipText("");
        jPanel1.add(search, new org.netbeans.lib.awtextra.AbsoluteConstraints(198, 336, 150, 40));

        srch_surname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel1.add(srch_surname, new org.netbeans.lib.awtextra.AbsoluteConstraints(469, 335, 220, 40));

        jButton4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jButton4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/if_icon-ios7-search-strong_211817 (1).png"))); // NOI18N
        jButton4.setText("Search");
        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        jPanel1.add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1170, 330, 130, 40));

        srch_dep.setBackground(new java.awt.Color(240, 240, 240));
        srch_dep.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        srch_dep.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Department", "Event Management", "Customer Management", "Employee Management", "Financial Department", "Inventory Management", "Transport Management", "Restaurant Department", "Maintenance department" }));
        srch_dep.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        srch_dep.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srch_depActionPerformed(evt);
            }
        });
        jPanel1.add(srch_dep, new org.netbeans.lib.awtextra.AbsoluteConstraints(740, 330, 190, 40));

        srch_job.setBackground(new java.awt.Color(240, 240, 240));
        srch_job.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        srch_job.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Job", "Cashier", "Cleaner", "Clerk", "Cook", "Driver", "Photographer", "Receptionist", "Waiter/Waitress", "Accountant", "HR Manager", "Maintenance Supervisor", "Stock Manager", "Transport Manager", "Manager" }));
        srch_job.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        srch_job.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                srch_jobActionPerformed(evt);
            }
        });
        jPanel1.add(srch_job, new org.netbeans.lib.awtextra.AbsoluteConstraints(970, 330, 180, 40));

        jLabel7.setFont(new java.awt.Font("Tahoma", 1, 28)); // NOI18N
        jLabel7.setText("Temporary Employee Salary");
        jPanel1.add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(640, 0, 436, 38));

        jPanel2.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel1.setText("Employee ID");
        jPanel2.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 110, 27));

        eid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(eid, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 20, 170, 27));

        totSal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(totSal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 140, 170, 27));

        basic_sal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(basic_sal, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 100, 170, 27));

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel5.setText("Salary");
        jPanel2.add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 100, 110, 27));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel4.setText("Surname");
        jPanel2.add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 110, 27));

        surname.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel2.add(surname, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 60, 170, 28));

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel3.setText("Total Salary");
        jPanel2.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 140, 110, 27));

        jPanel1.add(jPanel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 90, 330, 190));

        jPanel3.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel16.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel16.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel16.setText("Incrementation / Decrementation");
        jPanel3.add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 5, 236, 27));

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel2.setText("Salary");
        jPanel3.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 60, 90, 40));

        sal.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(sal, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 60, 150, 40));

        jButton3.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/add (1).png"))); // NOI18N
        jButton3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 60, 40, 40));

        jButton2.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/substract.png"))); // NOI18N
        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 60, 40, 40));

        jButton5.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/substract.png"))); // NOI18N
        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 110, 40, 40));

        jButton6.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/add (1).png"))); // NOI18N
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        jPanel3.add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(280, 110, 40, 40));

        ot.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel3.add(ot, new org.netbeans.lib.awtextra.AbsoluteConstraints(116, 110, 150, 40));

        jLabel6.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel6.setText("OT Charge");
        jPanel3.add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 90, 40));

        jPanel1.add(jPanel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(620, 90, 400, 190));

        jPanel4.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(0, 0, 0), 1, true));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel8.setText("Temporary ID");
        jPanel4.add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 30, 120, 40));

        jButton1.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton1.setText("Add to the database");
        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 30, 200, 50));

        jButton7.setFont(new java.awt.Font("Tahoma", 0, 16)); // NOI18N
        jButton7.setText("Remove from database");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        jPanel4.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 100, 200, 50));

        tid.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jPanel4.add(tid, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 110, 120, 36));

        jPanel1.add(jPanel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(1060, 90, 410, 190));

        pic.setBackground(new java.awt.Color(204, 204, 255));
        jPanel1.add(pic, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 100, 100));

        jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/16_2.png"))); // NOI18N
        jPanel1.add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 90, 100, 100));

        jLabel12.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel12.setText("EID");
        jPanel1.add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(147, 336, 40, 40));

        jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/pics/body.jpg"))); // NOI18N
        jPanel1.add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1590, 900));

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

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
       if(sal.getText().compareTo("")!=0)
        {
            if(eid.getText().compareTo("")!=0)
            {
                String Eid=eid.getText();
                double y=Double.parseDouble(sal.getText());
                update_sal(Eid,y,"sub");
            }
            else
                JOptionPane.showMessageDialog(null, "Select an employee");
        }
        else
            JOptionPane.showMessageDialog(null, "Text field is emoty");
    }//GEN-LAST:event_jButton2ActionPerformed

    private void srch_jobActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srch_jobActionPerformed
        String a1=search.getText();
        String a2=srch_surname.getText();
        int a3=srch_dep.getSelectedIndex();
        int a4=srch_job.getSelectedIndex();
        String a5=srch_dep.getSelectedItem().toString();
        String a6=srch_job.getSelectedItem().toString();
        String ta=null;
        if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4==0))
        {
            show_table();
        }
        else
        {
            if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.Position='"+a6+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.Position='"+a6+"' and e.Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.Surname like '"+a2+"%'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.Surname like '"+a2+"%' and e.Position='"+a6+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.Surname like '"+a2+"%' and e.Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.Surname like '"+a2+"%' and e.Department='"+a5+"' and e.Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.EID='"+a1+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.EID='"+a1+"' and e.Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.EID='"+a1+"' and e.Department='"+a5+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.EID='"+a1+"' and e.Position='"+a6+"' and e.Department='"+a5+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.EID='"+a1+"' and e.Surname like '"+a2+"%'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.EID='"+a1+"' and e.Surname like '"+a2+"%' and e.Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.EID='"+a1+"' and e.Surname like '"+a2+"%' and e.Department='"+a5+"'";
            else
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.EID='"+a1+"' and e.Surname like '"+a2+"%' and e.Position='"+a6+"' and e.Department='"+a5+"'";
            
            try
            {
                pst=conn.prepareStatement(ta);
                rs=pst.executeQuery();
                etable.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_srch_jobActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        String a1=search.getText();
        String a2=srch_surname.getText();
        int a3=srch_dep.getSelectedIndex();
        int a4=srch_job.getSelectedIndex();
        String a5=srch_dep.getSelectedItem().toString();
        String a6=srch_job.getSelectedItem().toString();
        String ta=null;
        if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4==0))
        {
            JOptionPane.showMessageDialog(null, "Search fields are empty");
        }
        else
        {
            if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.Position='"+a6+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.Position='"+a6+"' and e.Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.Surname like '"+a2+"%'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.Surname like '"+a2+"%' and e.Position='"+a6+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.Surname like '"+a2+"%' and e.Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.Surname like '"+a2+"%' and e.Department='"+a5+"' and e.Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.EID='"+a1+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.EID='"+a1+"' and e.Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.EID='"+a1+"' and e.Department='"+a5+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.EID='"+a1+"' and e.Position='"+a6+"' and e.Department='"+a5+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.EID='"+a1+"' and e.Surname like '"+a2+"%'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.EID='"+a1+"' and e.Surname like '"+a2+"%' and e.Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.EID='"+a1+"' and e.Surname like '"+a2+"%' and e.Department='"+a5+"'";
            else
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.EID='"+a1+"' and e.Surname like '"+a2+"%' and e.Position='"+a6+"' and e.Department='"+a5+"'";
            
            try
            {
                pst=conn.prepareStatement(ta);
                rs=pst.executeQuery();
                etable.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void etableMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_etableMouseClicked
        int row=etable.getSelectedRow();
        id=etable.getModel().getValueAt(row, 0).toString();
//        String Fname=etable.getModel().getValueAt(row, 1).toString();
//        String Surname=etable.getModel().getValueAt(row, 2).toString();
//        String Salary=etable.getModel().getValueAt(row, 3).toString();
        eid.setText(id);
        String Fname=null;
        String Surname=null;
        double Salary=0;
        double finSal=0;
        try {
            String a="select e.*,t.* from empdet e,temp_emp_salary t where e.EID=t.EID and e.EID='"+id+"'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            if(rs.next())
            {
                Fname=rs.getString("e.FName");
                Surname=rs.getString("e.Surname");
                Salary=Double.parseDouble(rs.getString("t.Day_salary"));
                finSal=Double.parseDouble(rs.getString("t.Salary"));
            }
        } catch(Exception e)
        {
            System.out.println(e);
        }
        totSal.setText(Double.toString(finSal));
        surname.setText(Surname);
        basic_sal.setText(Double.toString(Salary));
        try{
            String a="select Photo from empdet where EID='"+id+"'";
            pst=conn.prepareStatement(a);
            rs=pst.executeQuery();
            if(rs.next())
            {
                if(rs.getBytes("Photo") == null)
                {}
                else 
                {
                    byte[] image=rs.getBytes("Photo");
                    ImageIcon format=new ImageIcon(image);
                    pic.setIcon(format);
                }
            }
        } catch(Exception e){
            System.out.println(e);
        } 
    }//GEN-LAST:event_etableMouseClicked

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if(ot.getText().compareTo("")!=0)
            {
                if(eid.getText().compareTo("")!=0)
                {
                    try {
                        String a="select * from empdet where EID='"+eid.getText()+"'";
                        pst=conn.prepareStatement(a);
                        rs=pst.executeQuery();
                        String pos=null;
                        if(rs.next())
                        {
                            pos=rs.getString("Position");
                        }
                        String eid1=eid.getText();
                        double OT=Double.parseDouble(ot.getText());
                        update_ot(eid1,OT,"sub",pos);
                        ot.setText("");
                        JOptionPane.showMessageDialog(null, "OT record added");
                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "Select an employee");
            }
            else
                JOptionPane.showMessageDialog(null, "Fill OT field");
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        if(sal.getText().compareTo("")!=0)
        {
            if(eid.getText().compareTo("")!=0)
            {
                String Eid=eid.getText();
                double y=Double.parseDouble(sal.getText());
                update_sal(Eid,y,"add");
            }
            else
                JOptionPane.showMessageDialog(null, "Select an employee");
        }
        else
            JOptionPane.showMessageDialog(null, "Text field is emoty");
                
        
    }//GEN-LAST:event_jButton3ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if(ot.getText().compareTo("")!=0)
            {
                if(eid.getText().compareTo("")!=0)
                {
                    try {
                        String a="select * from empdet where EID='"+eid.getText()+"'";
                        pst=conn.prepareStatement(a);
                        rs=pst.executeQuery();
                        String pos=null;
                        if(rs.next())
                        {
                            pos=rs.getString("Position");
                        }
                        String eid1=eid.getText();
                        double OT=Double.parseDouble(ot.getText());
                        update_ot(eid1,OT,"add",pos);
                        ot.setText("");
                        JOptionPane.showMessageDialog(null, "OT record added");
                    } catch (SQLException ex) {
                        System.out.println(ex);
                    }
                }
                else
                    JOptionPane.showMessageDialog(null, "Select an employee");
            }
            else
                JOptionPane.showMessageDialog(null, "Fill OT field");
    }//GEN-LAST:event_jButton6ActionPerformed

    private void srch_depActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_srch_depActionPerformed
        String a1=search.getText();
        String a2=srch_surname.getText();
        int a3=srch_dep.getSelectedIndex();
        int a4=srch_job.getSelectedIndex();
        String a5=srch_dep.getSelectedItem().toString();
        String a6=srch_job.getSelectedItem().toString();
        String ta=null;
        if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4==0))
        {
            show_table();
        }
        else
        {
            if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.Position='"+a6+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.Position='"+a6+"' and e.Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.Surname like '"+a2+"%'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.Surname like '"+a2+"%' and e.Position='"+a6+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.Surname like '"+a2+"%' and e.Department='"+a5+"'";
            else if((a1.compareTo("")==0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.Surname like '"+a2+"%' and e.Department='"+a5+"' and e.Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.EID='"+a1+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3==0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.EID='"+a1+"' and e.Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.EID='"+a1+"' and e.Department='"+a5+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")==0)&&(a3!=0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.EID='"+a1+"' and e.Position='"+a6+"' and e.Department='"+a5+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.EID='"+a1+"' and e.Surname like '"+a2+"%'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3==0)&&(a4!=0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.EID='"+a1+"' and e.Surname like '"+a2+"%' and e.Position='"+a6+"'";
            else if((a1.compareTo("")!=0)&&(a2.compareTo("")!=0)&&(a3!=0)&&(a4==0))
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.EID='"+a1+"' and e.Surname like '"+a2+"%' and e.Department='"+a5+"'";
            else
                ta="select e.EID,e.FName,e.Surname,t.Day_salary,t.Bonus,t.OT_charge,t.Salary,t.Status from empdet e,temp_emp_salary t where e.EID=t.EID and e.type='Temporary' and e.EID='"+a1+"' and e.Surname like '"+a2+"%' and e.Position='"+a6+"' and e.Department='"+a5+"'";
            
            try
            {
                pst=conn.prepareStatement(ta);
                rs=pst.executeQuery();
                etable.setModel(DbUtils.resultSetToTableModel(rs));
            }
            catch(Exception e)
            {
                JOptionPane.showMessageDialog(null, e);
            }
        }
    }//GEN-LAST:event_srch_depActionPerformed

    private void etableKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_etableKeyPressed
        if(evt.getKeyCode()==KeyEvent.VK_UP)
        {
            int row=etable.getSelectedRow();
            id=etable.getModel().getValueAt(row-1, 0).toString();
            String Fname=etable.getModel().getValueAt(row, 1).toString();
            String Surname=etable.getModel().getValueAt(row, 2).toString();
            String Salary=etable.getModel().getValueAt(row, 3).toString();
            eid.setText(id);
            totSal.setText(Fname);
            surname.setText(Surname);
            basic_sal.setText(Salary);
            try{
                String a="select Photo from empdet where EID='"+id+"'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(rs.getBytes("Photo") == null)
                    {}
                    else 
                    {
                        byte[] image=rs.getBytes("Photo");
                        ImageIcon format=new ImageIcon(image);
                        pic.setIcon(format);
                    }
                }
            } catch(Exception e){
                System.out.println(e);
            } 
        }
        else if(evt.getKeyCode()==KeyEvent.VK_DOWN)
        {
            int row=etable.getSelectedRow();
            id=etable.getModel().getValueAt(row+1, 0).toString();
            String Fname=etable.getModel().getValueAt(row, 1).toString();
            String Surname=etable.getModel().getValueAt(row, 2).toString();
            String Salary=etable.getModel().getValueAt(row, 3).toString();
            eid.setText(id);
            totSal.setText(Fname);
            surname.setText(Surname);
            basic_sal.setText(Salary);
            try{
                String a="select Photo from empdet where EID='"+id+"'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(rs.getBytes("Photo") == null)
                    {}
                    else 
                    {
                        byte[] image=rs.getBytes("Photo");
                        ImageIcon format=new ImageIcon(image);
                        pic.setIcon(format);
                    }
                }
            } catch(Exception e){
                System.out.println(e);
            } 
        }
    }//GEN-LAST:event_etableKeyPressed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        String Tid=tid.getText();
        String b=null;
        String c=null;
        if(Tid.compareTo("")==0)
            JOptionPane.showMessageDialog(null, "Select an employee");
        else
            if(JOptionPane.showConfirmDialog(null, "Do you really need to add this record?")==0)
            {
                try {
                    b="select * from empdet where EID='"+Tid+"' and Date='"+mm.dates+"'";
                    pst=conn.prepareStatement(b);
                    rs=pst.executeQuery();
                    if(rs.next())
                    {
                        Double sal=Double.parseDouble(rs.getString("Salary"));
                        c="insert into temp_emp_salary(EID,Day,Day_salary,Salary) values('"+Tid+"','"+mm.dates+"','"+sal+"','"+sal+"')";
                        pst=conn.prepareStatement(c);
                        pst.execute();
                        show_table();
                        tid.setText("");
                    }
                    else
                        JOptionPane.showMessageDialog(null, "Cannot find the data");
                } catch (SQLException ex) {
                    JOptionPane.showMessageDialog(null, ex);
                }
            }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if(tid.getText().compareTo("")==0)
        {
            JOptionPane.showMessageDialog(null, "Search field is empty");
        }
        else
            try {
                String a="select * from temp_emp_salary where EID='"+Integer.parseInt(tid.getText())+"'";
                pst=conn.prepareStatement(a);
                rs=pst.executeQuery();
                if(rs.next())
                {
                    if(JOptionPane.showConfirmDialog(null, "Do you really need to delete?")==0)
                    {
                        String c="delete from temp_emp_salary where EID='"+Integer.parseInt(tid.getText())+"'";
                        pst=conn.prepareStatement(c);
                        pst.execute();
                        show_table();
                        tid.setText("");
                    }
                }
            } catch(Exception e)
            {
                System.out.println(e);
            }
    }//GEN-LAST:event_jButton7ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel basic_sal;
    private javax.swing.JLabel eid;
    private javax.swing.JTable etable;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField ot;
    private javax.swing.JLabel pic;
    private javax.swing.JTextField sal;
    private javax.swing.JTextField search;
    private javax.swing.JComboBox srch_dep;
    private javax.swing.JComboBox srch_job;
    private javax.swing.JTextField srch_surname;
    private javax.swing.JLabel surname;
    private javax.swing.JTextField tid;
    private javax.swing.JLabel totSal;
    // End of variables declaration//GEN-END:variables
}
